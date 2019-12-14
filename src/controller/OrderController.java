package controller;

import java.io.IOException;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.Cart;
import model.CartItem;
import model.User;
import service.CartItemService;
import service.CartService;
import service.UserService;
import service.impl.CartServiceImpl;
import service.impl.CartServiceItemImpl;
import service.impl.UserServiceImpl;
import tools.SendMail;
import util.RandomUUID;

@WebServlet(urlPatterns = "/member/order")
public class OrderController extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	UserService userService = new UserServiceImpl();
	CartService cartService = new CartServiceImpl();
	CartItemService cartItemService = new CartServiceItemImpl();
	long time = System.currentTimeMillis();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession();
		Object obj = session.getAttribute("account");
		User buyer = (User) obj;
		Cart cart = new Cart();
		cart.setBuyer(buyer);
		cart.setBuyDate(new java.sql.Date(time));
		cart.setId(RandomUUID.getRandomID());
		cartService.insert(cart);

		Object objCart = session.getAttribute("cart");
		if (objCart != null) {
			Map<Integer, CartItem> map = (Map<Integer, CartItem>) objCart;

			for (CartItem cartItem : map.values()) {
				cartItem.setCart(cart);
				cartItem.setId(RandomUUID.getRandomID());
				SendMail sm = new SendMail();
				sm.sendMail(cart.getBuyer().getEmail(), "Sách Tốt", "Bạn đã đặt hàng thành công, chúng tôi sẽ liên hệ lại sau! ");
				cartItemService.insert(cartItem);
				
			}

		}
		session.removeAttribute("cart");
		resp.sendRedirect(req.getContextPath() + "/");

	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}
}

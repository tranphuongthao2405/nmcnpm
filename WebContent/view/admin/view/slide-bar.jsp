<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <c:url value="/view/admin/static" var="url"></c:url>
		<nav class="navbar-default navbar-side" role="navigation">
			<div class="sidebar-collapse">
				<ul class="nav" id="main-menu">
					<li class="text-center"><img src="${url}/img/find_user.png"
						class="user-image img-responsive" /></li>

					<li><a href="${pageContext.request.contextPath }/admin/product/list"><i class="fa fa-desktop fa-3x"></i>
							Quản lí sản phẩm</a></li>
					<li><a href="${pageContext.request.contextPath }/admin/user/list"><i class="fa fa-qrcode fa-3x"></i>
							Quản lí người dùng</a></li>
					<li><a href="${pageContext.request.contextPath }/admin/user/add"><i class="fa fa-qrcode fa-3x"></i>
							Thêm người dùng</a></li>
					<li><a href="${pageContext.request.contextPath }/admin/order/list"><i
							class="fa fa-bar-chart-o fa-3x"></i> Quản lí đơn hàng</a></li>
					<li><a href="${pageContext.request.contextPath }/admin/product/add"><i class="fa fa-table fa-3x"></i>
							Thêm sản phẩm mới</a></li>
				</ul>

			</div>

		</nav>
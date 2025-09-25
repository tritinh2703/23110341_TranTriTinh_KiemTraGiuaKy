<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core"%>
<header style="border-bottom: 1px solid #ddd; padding: 10px 0">
	<nav
		style="max-width: 1100px; margin: auto; display: flex; gap: 14px; align-items: center">
		<a href="${pageContext.request.contextPath}/home">Trang chủ</a> <a
			href="${pageContext.request.contextPath}/product">Sản phẩm</a>

		<c:choose>
			<c:when test="${empty sessionScope.account}">
				<a href="${pageContext.request.contextPath}/login"
					style="margin-left: auto">Đăng nhập</a>
				<a href="${pageContext.request.contextPath}/register">Đăng ký</a>
			</c:when>
			<c:otherwise>
				<span style="margin-left: auto">Xin chào,
					${sessionScope.account.fullname}</span>
				<c:if test="${sessionScope.account.admin}">
					<a href="${pageContext.request.contextPath}/admin/home">Trang
						quản trị</a>
				</c:if>
        | <a href="${pageContext.request.contextPath}/logout">Đăng
					xuất</a>
			</c:otherwise>
		</c:choose>
	</nav>
</header>

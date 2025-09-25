<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<h2>Đăng ký tài khoản</h2>
<form action="${pageContext.request.contextPath}/register" method="post">
  <label>Tài khoản:</label><br>
  <input type="text" name="username" required><br><br>

  <label>Mật khẩu:</label><br>
  <input type="password" name="password" required><br><br>

  <label>Họ tên:</label><br>
  <input type="text" name="fullname"><br><br>

  <label>Email:</label><br>
  <input type="email" name="email"><br><br>

  <button type="submit">Đăng ký</button>
</form>
<c:if test="${not empty message}">
  <p style="color:red">${message}</p>
</c:if>

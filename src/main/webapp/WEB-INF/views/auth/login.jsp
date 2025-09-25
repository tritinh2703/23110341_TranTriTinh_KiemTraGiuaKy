<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head><meta charset="UTF-8"><title>Đăng nhập</title></head>
<body>
<jsp:include page="/WEB-INF/views/layout/header.jsp"/>
<main style="max-width:420px;margin:20px auto;padding:0 16px">
  <h2>Đăng nhập</h2>
  <c:if test="${not empty alert}">
    <div style="color:#c00">${alert}</div>
  </c:if>
  <form method="post" action="${pageContext.request.contextPath}/login">
    <div>
      <label>Tài khoản</label>
      <input type="text" name="username" required/>
    </div>
    <div>
      <label>Mật khẩu</label>
      <input type="password" name="password" required/>
    </div>
    <label><input type="checkbox" name="remember"/> Nhớ tôi</label>
    <button type="submit">Đăng nhập</button>
  </form>
</main>
<jsp:include page="/WEB-INF/views/layout/footer.jsp"/>
</body>
</html>

<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head><meta charset="UTF-8"><title>Admin</title></head>
<body>
<jsp:include page="/WEB-INF/views/layout/header.jsp"/>
<main style="max-width:1100px;margin:20px auto;padding:0 16px">
  <h2>Dashboard</h2>
  <ul>
    <li><a href="${pageContext.request.contextPath}/admin/videos">Quản lý Videos</a></li>
  </ul>
</main>
<jsp:include page="/WEB-INF/views/layout/footer.jsp"/>
</body>
</html>

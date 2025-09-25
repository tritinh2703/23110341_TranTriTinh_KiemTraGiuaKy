<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head><meta charset="UTF-8"><title>Videos</title></head>
<body>
<jsp:include page="/WEB-INF/views/layout/header.jsp"/>
<main style="max-width:1100px;margin:20px auto;padding:0 16px">
  <h2>Danh sách Videos</h2>
  <p><a href="${pageContext.request.contextPath}/admin/videos/create">+ Thêm mới</a></p>
  <table border="1" cellpadding="6" cellspacing="0" width="100%">
    <tr>
      <th>Mã video</th><th>Tiêu đề</th><th>Poster</th><th>View</th><th>Active</th><th>Thao tác</th>
    </tr>
    <c:forEach var="v" items="${videos}">
      <tr>
        <td>${v.videoId}</td>
        <td>${v.title}</td>
        <td>${v.poster}</td>
        <td>${v.views}</td>
        <td><c:out value="${v.active}"/></td>
        <td>
          <a href="${pageContext.request.contextPath}/admin/videos/edit?id=${v.videoId}">Sửa</a> |
          <a href="${pageContext.request.contextPath}/admin/videos/delete?id=${v.videoId}" onclick="return confirm('Xóa?')">Xóa</a>
        </td>
      </tr>
    </c:forEach>
  </table>

  <div style="margin-top:12px">
    <c:forEach var="i" begin="1" end="${totalPages}">
      <a style="margin-right:6px;${i==page?'font-weight:bold':''}"
         href="${pageContext.request.contextPath}/admin/videos?page=${i}">${i}</a>
    </c:forEach>
  </div>
</main>
<jsp:include page="/WEB-INF/views/layout/footer.jsp"/>
</body>
</html>

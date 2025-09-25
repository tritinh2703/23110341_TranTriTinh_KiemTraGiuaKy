<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<!DOCTYPE html>
<html>
<head><meta charset="UTF-8"><title>Video theo Category</title></head>
<body>
<main style="max-width:1100px;margin:20px auto;padding:0 16px">
  <h2>Danh mục & Video</h2>

  <c:forEach var="row" items="${cats}">
    <c:set var="cat" value="${row[0]}"/>
    <c:set var="count" value="${row[1]}"/>

    <h3>${cat.categoryname} (${count})</h3>
    <table width="100%" border="1" cellspacing="0" cellpadding="6">
      <tr><th>Poster</th><th>Tiêu đề</th><th>Mã video</th><th>Category</th><th>View</th><th>Chi tiết</th></tr>
      <c:forEach var="v" items="${cat.videos}">
        <tr>
          <td>[poster] ${v.poster}</td>
          <td>${v.title}</td>
          <td>${v.videoId}</td>
          <td>${cat.categoryname}</td>
          <td>${v.views}</td>
          <td><a href="${pageContext.request.contextPath}/video/detail?id=${v.videoId}">Xem</a></td>
        </tr>
      </c:forEach>
    </table>
    <br/>
  </c:forEach>
</main>
</body>
</html>

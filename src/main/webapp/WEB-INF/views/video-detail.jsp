<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<!DOCTYPE html>
<html>
<head><meta charset="UTF-8"><title>Chi tiết video</title></head>
<body>
<jsp:include page="/WEB-INF/views/layout/header.jsp"/>
<main style="max-width:900px;margin:20px auto;padding:0 16px">
  <table width="100%" border="1" cellspacing="0" cellpadding="8">
    <tr>
      <td rowspan="6" style="width:240px;text-align:center">
        <div>[poster]</div>
        <div>${video.poster}</div>
      </td>
      <td><b>Tiêu đề:</b> ${video.title}</td>
    </tr>
    <tr><td><b>Mã video:</b> ${video.videoId}</td></tr>
    <tr><td><b>Category name:</b> ${video.category.categoryname}</td></tr>
    <tr><td><b>View:</b> ${video.views}</td></tr>
    <tr><td><b>Share(10):</b> ${shareCount}</td></tr>
    <tr><td><b>Like(10):</b> ${likeCount}</td></tr>
    <tr>
      <td colspan="2"><b>description</b><br/>${video.description}</td>
    </tr>
  </table>
</main>
<jsp:include page="/WEB-INF/views/layout/footer.jsp"/>
</body>
</html>

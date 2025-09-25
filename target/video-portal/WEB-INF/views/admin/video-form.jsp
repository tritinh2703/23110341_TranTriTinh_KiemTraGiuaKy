<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head><meta charset="UTF-8"><title>Video Form</title></head>
<body>
<main style="max-width:800px;margin:20px auto;padding:0 16px">
  <h2><c:out value="${empty video.videoId ? 'Thêm Video' : 'Sửa Video'}"/></h2>

  <form method="post" action="${pageContext.request.contextPath}${empty video.videoId ? '/admin/videos/create' : '/admin/videos/edit'}">
    <div>
      <label>Mã video</label>
      <input type="text" name="videoId" value="${video.videoId}" ${empty video.videoId? '' : 'readonly'}/>
    </div>
    <div>
      <label>Tiêu đề</label>
      <input type="text" name="title" value="${video.title}" required/>
    </div>
    <div>
      <label>Poster</label>
      <input type="text" name="poster" value="${video.poster}"/>
    </div>
    <div>
      <label>View</label>
      <input type="number" name="views" value="${video.views}"/>
    </div>
    <div>
      <label>Active</label>
      <input type="checkbox" name="active" ${video.active ? 'checked' : ''}/>
    </div>
    <div>
      <label>Category</label>
      <select name="categoryId">
        <c:forEach var="c" items="${categories}">
          <option value="${c.categoryId}" ${video.category.categoryId==c.categoryId?'selected':''}>
            ${c.categoryname}
          </option>
        </c:forEach>
      </select>
    </div>
    <div>
      <label>Mô tả</label>
      <textarea name="description" rows="4" cols="80">${video.description}</textarea>
    </div>
    <button type="submit">Lưu</button>
  </form>
</main>
</body>
</html>

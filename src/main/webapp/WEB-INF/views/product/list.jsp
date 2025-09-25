<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<main style="max-width:1100px;margin:20px auto 60px;padding:0 16px">
    <h2>Danh sách Video</h2>
    <div style="display:flex;flex-wrap:wrap;gap:20px;">
        <c:forEach var="v" items="${videos}">
            <div style="width:200px;text-align:center;">
                <!-- Ảnh poster -->
                <img src="${v.poster}" alt="${v.title}" style="width:100%;height:120px;object-fit:cover;">
                
                <!-- Tiêu đề video kèm liên kết tới trang chi tiết -->
                <div>
                    <a href="${pageContext.request.contextPath}/video/detail?id=${v.videoId}">
                        ${v.title}
                    </a>
                </div>
                
                <!-- Lượt xem -->
                <small>Lượt xem: ${v.views}</small>
            </div>
        </c:forEach>
    </div>
</main>

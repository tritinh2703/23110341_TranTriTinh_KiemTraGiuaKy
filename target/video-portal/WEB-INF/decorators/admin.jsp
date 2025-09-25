<%-- user.jsp --%>
<%@ page contentType="text/html; charset=UTF-8" %>
<html>
<head>
    <title><sitemesh:write property='title'/></title>
</head>
<body>
    <jsp:include page="/WEB-INF/views/layout/header.jsp"/>
    <sitemesh:write property='body'/>
    <jsp:include page="/WEB-INF/views/layout/footer.jsp"/>
</body>
</html>

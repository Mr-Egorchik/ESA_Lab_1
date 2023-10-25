<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>JSP - Hello World</title>
</head>
<body>
<h1><%= "Hello World!" %>
</h1>
<br/>
<a href="${pageContext.request.contextPath}/bonuses">See bonuses</a>
<a href="${pageContext.request.contextPath}/weapons">See weapons</a>
<a href="${pageContext.request.contextPath}/characters">See characters</a>
<a href="${pageContext.request.contextPath}/artefacts">See artefacts</a>
</body>
</html>
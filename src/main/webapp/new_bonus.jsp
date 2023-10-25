<%--
  Created by IntelliJ IDEA.
  User: 79372
  Date: 24.10.2023
  Time: 21:02
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>New bonus</title>
</head>
<body>
<form action="${pageContext.request.contextPath}/bonuses/create" method="post">
    <label>
        Type
        <select name="type" required>
            <c:forEach items="${types}" var="t">
                <option value="${t.ordinal()}">
                    ${t.name()}
                </option>
            </c:forEach>
        </select>
    </label>
    <label>
        Value
        <input name="value" type="number" required>
    </label>
    <div>
        <button type="submit">Save</button>
    </div>
</form>
</body>
</html>

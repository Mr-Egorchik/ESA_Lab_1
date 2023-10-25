<%--
  Created by IntelliJ IDEA.
  User: 79372
  Date: 25.10.2023
  Time: 14:43
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Update bonus</title>
</head>
<body>
<p>Bonus +${bonus.bonusValue} ${bonus.bonusType}</p>
<form action="${pageContext.request.contextPath}/bonuses/update" method="post">
    <label>
        <input name="id" value="${bonus.id}" hidden>
    </label>
    <label>
        Type
        <select name="type" required>
            <c:forEach items="${types}" var="t">
                <c:choose>
                    <c:when  test="${t == bonus.bonusType}">
                        <option value="${t.ordinal()}" selected>
                                ${t.name()}
                        </option>
                    </c:when>
                    <c:otherwise>
                        <option value="${t.ordinal()}">
                                ${t.name()}
                        </option>
                    </c:otherwise>
                </c:choose>
            </c:forEach>
        </select>
    </label>
    <label>
        Value
        <input name="value" type="number" value="${bonus.bonusValue}" required>
    </label>
    <div>
        <button type="submit">Save</button>
    </div>
</form>
</body>
</html>

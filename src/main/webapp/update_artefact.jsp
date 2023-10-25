<%--
  Created by IntelliJ IDEA.
  User: 79372
  Date: 25.10.2023
  Time: 19:23
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Update artefact</title>
</head>
<body>
<form action="${pageContext.request.contextPath}/artefacts/update" method="post">
    <label>
        <input name="id" value="${artefact.id}" hidden>
    </label>
    <label>
        Name
        <input name="name" value="${artefact.name}" required>
    </label>
    <label>
        Bonus
        <select name="bonus" required>
            <c:forEach items="${bonuses}" var="b">
                <c:choose>
                    <c:when test="${b.id == artefact.bonus}">
                        <option value="${b.id}" selected>
                                ${b.name} (+${b.bonusValue} ${b.bonusType})
                        </option>
                    </c:when>
                    <c:otherwise>
                        <option value="${b.id}">
                                +${b.bonusValue} ${b.bonusType}
                        </option>
                    </c:otherwise>
                </c:choose>
            </c:forEach>
        </select>
    </label>
    <label>
        Character
        <select name="character">
            <option value="">
                -No character-
            </option>
            <c:forEach items="${characters}" var="ch">
                <c:choose>
                    <c:when test="${b.id == artefact.bonus}">
                        <option value="${ch.id}" selected>
                                ${ch.name} (${ch.level} LVL)
                        </option>
                    </c:when>
                    <c:otherwise>
                        <option value="${ch.id}">
                                ${ch.name} (${ch.level} LVL)
                        </option>
                    </c:otherwise>
                </c:choose>
            </c:forEach>
        </select>
    </label>
    <div>
        <button type="submit">Save</button>
    </div>
</form>
</body>
</html>
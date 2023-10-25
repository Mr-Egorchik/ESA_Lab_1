<%--
  Created by IntelliJ IDEA.
  User: 79372
  Date: 25.10.2023
  Time: 16:52
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Update character</title>
</head>
<body>
<form action="${pageContext.request.contextPath}/characters/update" method="post">
    <label>
        <input name="id" value="${ch.id}" hidden>
    </label>
    <label>
        Name
        <input name="name" value="${ch.name}" required>
    </label>
    <label>
        HP
        <input name="hp" type="number" value="${ch.hp}" required>
    </label>
    <label>
        Attack
        <input name="attack" type="number" value="${ch.attack}" required>
    </label>
    <label>
        Defence
        <input name="defence" type="number" value="${ch.defence}" required>
    </label>
    <label>
        Level
        <input name="level" type="number" value="${ch.level}" required>
    </label>
    <label>
        Experience
        <input name="experience" type="number" value="${ch.experience}" required>
    </label>
    <label>
        Weapon
        <select name="weapon" required>
            <c:forEach items="${weapons}" var="w">
                <c:choose>
                    <c:when  test="${w.id == ch.weapon.id}">
                        <option value="${w.id}" selected>
                                ${w.name}
                        </option>
                    </c:when>

                    <c:otherwise>
                        <c:choose>
                            <c:when test="${w.owner == null}">
                                <option value="${w.id}">
                                        ${w.name}
                                </option>
                            </c:when>
                        </c:choose>
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

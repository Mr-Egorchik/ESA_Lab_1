<%--
  Created by IntelliJ IDEA.
  User: 79372
  Date: 25.10.2023
  Time: 16:47
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>New character</title>
</head>
<body>
<form action="${pageContext.request.contextPath}/characters/create" method="post">
  <label>
    Name
    <input name="name" required>
  </label>
  <label>
    HP
    <input name="hp" type="number" required>
  </label>
  <label>
    Attack
    <input name="attack" type="number" required>
  </label>
  <label>
    Defence
    <input name="defence" type="number" required>
  </label>
  <label>
    Level
    <input name="level" type="number" required>
  </label>
  <label>
    Experience
    <input name="experience" type="number" required>
  </label>
  <label>
    Weapon
    <select name="weapon">
      <option value="">
        -No weapon-
      </option>
      <c:forEach items="${weapons}" var="w">
        <c:choose>
          <c:when test="${w.owner == null}">
            <option value="${w.id}">
                ${w.name}
            </option>
          </c:when>
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

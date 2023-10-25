<%--
  Created by IntelliJ IDEA.
  User: 79372
  Date: 25.10.2023
  Time: 19:19
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
  <title>New Artefact</title>
</head>
<body>
<form action="${pageContext.request.contextPath}/artefacts/create" method="post">
  <label>
    Name
    <input name="name" required>
  </label>
  <label>
    Bonus
    <select name="bonus" required>
      <c:forEach items="${bonuses}" var="b">
        <option value="${b.id}">
            +${b.bonusValue} ${b.bonusType}
        </option>
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
        <option value="${ch.id}">
            ${ch.name} (${ch.level} LVL)
        </option>
      </c:forEach>
    </select>
  </label>
  <div>
    <button type="submit">Save</button>
  </div>
</form>
</body>
</html>
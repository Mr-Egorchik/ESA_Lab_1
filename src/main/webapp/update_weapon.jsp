<%--
  Created by IntelliJ IDEA.
  User: 79372
  Date: 25.10.2023
  Time: 15:50
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Update weapon</title>
</head>
<body>
<p>${weapon.name}, attack ${weapon.attack}</p>
<form action="${pageContext.request.contextPath}/weapons/update" method="post">
  <label>
    <input name="id" value="${weapon.id}" hidden>
  </label>
  <label>
    Name
    <input name="name" value="${weapon.name}" required>
  </label>
  <label>
    Attach
    <input name="attack" type="number" value="${weapon.attack}" required>
  </label>
  <div>
    <button type="submit">Save</button>
  </div>
</form>

</body>
</html>

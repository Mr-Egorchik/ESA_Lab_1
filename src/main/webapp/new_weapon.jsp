<%--
  Created by IntelliJ IDEA.
  User: 79372
  Date: 25.10.2023
  Time: 15:48
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>New Weapon</title>
</head>
<body>
<form action="${pageContext.request.contextPath}/weapons/create" method="post">
  <label>
    Name
    <input name="name" required>
  </label>
  <label>
    Attack
    <input name="attack" type="number" required>
  </label>
  <div>
    <button type="submit">Save</button>
  </div>
</form>
</body>
</html>

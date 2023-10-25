<%--
  Created by IntelliJ IDEA.
  User: 79372
  Date: 25.10.2023
  Time: 15:25
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Weapons</title>
</head>
<body>
<h1>Weapons</h1>
<a href="${pageContext.request.contextPath}/weapons/create">New weapon</a>
<table>
    <thead>
    <tr>
        <td>#</td>
        <td>Name</td>
        <td>Attack</td>
        <td>Update</td>
        <td>Delete</td>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${weapons}" var="w" varStatus="idx">
        <tr>
            <td>${idx.getIndex()+1}</td>
            <td>${w.name}</td>
            <td>${w.attack}</td>
            <td>
                <form action="${pageContext.request.contextPath}/weapons/update" method="get">
                    <label>
                        <input name="id" value="${w.id}" hidden>
                    </label>
                    <div>
                        <button type="submit">Update</button>
                    </div>
                </form>
            </td>
            <td>
                <form action="${pageContext.request.contextPath}/weapons/delete" method="post">
                    <label>
                        <input name="id" value="${w.id}" hidden>
                    </label>
                    <div>
                        <button type="submit">Delete</button>
                    </div>
                </form>
            </td>
        </tr>
    </c:forEach>
    </tbody>
</table>
</body>
</html>

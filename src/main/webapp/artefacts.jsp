<%--
  Created by IntelliJ IDEA.
  User: 79372
  Date: 25.10.2023
  Time: 19:14
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Artefacts</title>
</head>
<body>
<h1>Artefacts</h1>
<a href="${pageContext.request.contextPath}/artefacts/create">New artefact</a>
<table>
    <thead>
    <tr>
        <td>#</td>
        <td>Name</td>
        <td>Update</td>
        <td>Delete</td>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${artefacts}" var="a" varStatus="idx">
        <tr>
            <td>${idx.getIndex()+1}</td>
            <td>${a.name}</td>
            <td>
                <form action="${pageContext.request.contextPath}/artefacts/update" method="get">
                    <label>
                        <input name="id" value="${a.id}" hidden>
                    </label>
                    <div>
                        <button type="submit">Update</button>
                    </div>
                </form>
            </td>
            <td>
                <form action="${pageContext.request.contextPath}/artefacts/delete" method="post">
                    <label>
                        <input name="id" value="${a.id}" hidden>
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

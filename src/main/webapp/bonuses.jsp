<%--
  Created by IntelliJ IDEA.
  User: 79372
  Date: 20.10.2023
  Time: 12:36
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Bonuses</title>
</head>
<body>
    <h1>Bonuses</h1>
    <a href="${pageContext.request.contextPath}/bonuses/create">New bonus</a>
    <table>
        <thead>
            <tr>
                <td>#</td>
                <td>Type</td>
                <td>Value</td>
                <td>Artefacts</td>
                <td>Update</td>
                <td>Delete</td>
            </tr>
        </thead>
        <tbody>
        <c:forEach items="${bonuses}" var="b" varStatus="idx">
            <tr>
                <td>${idx.getIndex()+1}</td>
                <td>${b.bonusType}</td>
                <td>${b.bonusValue}</td>
                <td>
                    <c:forEach items="${b.artefacts}" var="art">
                        <p>${art.name}</p>
                    </c:forEach>
                </td>
                <td>
                    <form action="${pageContext.request.contextPath}/bonuses/update" method="get">
                        <label>
                            <input name="id" value="${b.id}" hidden>
                        </label>
                        <div>
                            <button type="submit">Update</button>
                        </div>
                    </form>
                </td>
                <td>
                    <form action="${pageContext.request.contextPath}/bonuses/delete" method="post">
                        <label>
                            <input name="id" value="${b.id}" hidden>
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

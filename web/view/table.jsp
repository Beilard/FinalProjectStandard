<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: gipno
  Date: 08.11.2019
  Time: 7:35
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Table</title>
</head>
<body>
<table border="1">
    <tr>
        <th>id</th>
        <th>Name</th>
        <th>Surname</th>
        <th>Email</th>
    </tr>
    <c:forEach var="user" items="${userList}">
        <tr>
            <td><c:out value="${user.id}"/></td>
            <td><c:out value="${user.name}"/></td>
            <td><c:out value="${user.surname}"/></td>
            <td><c:out value="${user.email}"/></td>
        </tr>

    </c:forEach>
</table>

<c:if test="${currentPage !=1}">
    <td><a href="table.jsp?page=${currentPage - 1}">Previous</a> </td>
</c:if>

<table border="1">
    <tr>
        <c:forEach begin="1" end="${numOfPages}" var="i">
            <c:choose>
                <c:when test="${currentPage eq i}">
                    <td>${i}</td>
                </c:when>
                <c:otherwise>
                    <td><a href="table.jsp?page=${i}"></a> </td>
                </c:otherwise>
            </c:choose>
        </c:forEach>
    </tr>
</table>


</body>
</html>

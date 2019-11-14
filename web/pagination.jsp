<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Pagination</title>
</head>
<body>

<a href="index.jsp">back</a>

<div>
    <table>
        <thead>
        <tr>
            <th scope="col">ID</th>
            <th scope="col">Name</th>
            <th scope="col">Surname</th>
            <th scope="col">Email</th>
        </tr>
        </thead>

        <tbody>
        <c:forEach var="user" items="${users}">
            <tr>
                <td>${user.id}</td>
                <td>${user.name}</td>
                <td>${user.surname}</td>
                <td>${user.email}</td>
            </tr>
        </c:forEach>

        </tbody>
    </table>
    <form action="<c:url value=''/>" method="post">
        <input type="hidden" name="rowCount" value="${rowCount}">
        <input type="hidden" name="startFrom" value="${startFrom}">
        <input type="submit" name="page" value="previous" class="btn btn-indigo btn-sm m-0">
        <input type="submit" name="page" value="next" class="btn btn-indigo btn-sm m-0">
    </form>

</div>
</body>
</html>

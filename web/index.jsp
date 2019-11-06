<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>$Title$</title>
</head>
<body>

<table border="1">
    <thread>
        <tr>
            <th>id</th>
            <th>Email</th>
            <th>Password</th>
            <th>Name</th>
            <th>Surname</th>
            <th>Birth Date</th>
            <th>Role</th>
        </tr>
    </thread>
    <tbody>
    <c:forEach items="${requestScope.list}" var="list">
        <td>${list.name}</td>
        <td>${list.surname}</td>
        <td>${list.name}</td>

    </c:forEach>
    </tbody>

</table>


</body>
</html>

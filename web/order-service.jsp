<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: gipno
  Date: 15.11.2019
  Time: 10:44
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Order Service</title>
</head>
<body>
THIS IS ORDER SERVICE
<select name="category">
    <c:forEach items="${kyivList}" var="category">
        <option name="City" value="${category.street}">
            ${category.buildingNumber}
        </option>
    </c:forEach>
</select>
</body>
</html>

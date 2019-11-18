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
<jsp:include page="user-bar.jsp" />

<form action="/user">
    <input style="position: absolute; display: none; top: -999px; left: -999px" type="text" class="hidden" name="command" value="">
    <select name="category" onchange="submit()">
        <c:forEach items="${citiesList}" var="category">
            <option ${seletedCity == category ? 'selected' : ''} name="City" value="${category}">
                    ${category}
            </option>
        </c:forEach>
    </select>
</form>

</body>
</html>

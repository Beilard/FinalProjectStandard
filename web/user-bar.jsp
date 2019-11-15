<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt" %>
<%--
  Created by IntelliJ IDEA.
  User: gipno
  Date: 14.11.2019
  Time: 10:14
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <title>User Navigation Bar</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta.2/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.6/umd/popper.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta.2/js/bootstrap.min.js"></script>
</head>
<body>

<div class="container-fluid">
</div>
<nav class="navbar navbar-expand-sm bg-light">
    <ul class="navbar-nav" style="width: 100%">
        <li class="nav-item" style="margin-right: 100px;">
            <form action="user" method="get">
                <input type="hidden" name="command" value="startOrder"/>
                <button type="submit" class="btn btn-primary btn-block"><fmt:message key="user.bar.order"/></button>
            </form>
        </li>
        <li class="nav-item" style="margin-right: 100px;">
            <form action="user" method="get">
                <input type="hidden" name="command" value="startOrder"/>
                <button type="submit" class="btn btn-primary btn-block"><fmt:message key="user.bar.pay"/></button>
            </form>
        </li>
        <li class="nav-item" style="margin-right: 100px;">
            <form action="guest" method="get">
                <input type="hidden" name="command" value="logout"/>
                <button type="submit" class="btn btn-primary btn-block"><fmt:message key="user.bar.logout"/></button>
            </form>
        </li>

        <nav class="navbar" style="position: absolute; right: 0;">
            <form class="form-inline" action="">
                <input class="form-control" type="text" placeholder="Order">
                <button class="btn btn-success" type="submit">Order</button>
            </form>
        </nav>
    </ul>
</nav>
</body>
</html>

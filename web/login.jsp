<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%--
  Created by IntelliJ IDEA.
  User: gipno
  Date: 10.11.2019
  Time: 21:02
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="${param.lang}">
<head>

    <title>Login Page</title>

    <link rel="canonical" href="https://getbootstrap.com/docs/4.3/examples/sign-in/">

    <link href="css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">

    <style>
        .bd-placeholder-img {
            font-size: 1.125rem;
            text-anchor: middle;
            -webkit-user-select: none;
            -moz-user-select: none;
            -ms-user-select: none;
            user-select: none;
        }
        @media (min-width: 768px) {
            .bd-placeholder-img-lg {
                font-size: 3.5rem;
            }
        }
    </style>

    <link href="css/signin.css" rel="stylesheet">
</head>
<body class="text-center">
<form class="form-signin" name = "loginForm" method="POST" action="guest" >
    <input type="hidden" name="command" value="login" />
    <h1 class="h3 mb-3 font-weight-normal"><fmt:message key="login.header"/></h1>
    <label for="inputEmail" class="sr-only">Email</label>
    <input type="email" id="inputEmail" class="form-control" placeholder=<fmt:message key="login.email"/> required autofocus name="email" value="">
    <label for="inputPassword" class="sr-only">Password</label>
    <input type="password" id="inputPassword" class="form-control" placeholder= <fmt:message key="login.password"/> required name="password" value="">
    <button class="btn btn-lg btn-primary btn-block" type="submit"><fmt:message key="login.submit"/></button>
</form>
</body>
</html>

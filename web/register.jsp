<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%--
  Created by IntelliJ IDEA.
  User: gipno
  Date: 10.11.2019
  Time: 21:02
  To change this template use File | Settings | File Templates.
--%>
<!DOCTYPE html>
<html lang="${param.lang}">
<head>
    <meta charset="utf-8">
    <meta name="robots" content="noindex, nofollow">

    <title>Registration form</title>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link href="css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
    <style type="text/css">
        body {
            background: url("img/delivery.jpg") fixed;
            background-size: cover;
        }
        *[role="form"] {
            max-width: 530px;
            padding: 15px;
            margin: 0 auto;
            border-radius: 0.3em;
            background-color: #f2f2f2;
        }
        *[role="form"] h2 {
            font-family: 'Open Sans' , sans-serif;
            font-size: 40px;
            font-weight: 600;
            color: #000000;
            margin-top: 5%;
            text-align: center;
            text-transform: uppercase;
            letter-spacing: 4px;
        }
    </style>
    <script src="js/bootstrap.min.js"></script>
    <script type="text/javascript">
        window.alert = function(){};
        var defaultCSS = document.getElementById('bootstrap-css');
        function changeCSS(css){
            if(css) $('head > link').filter(':first').replaceWith('<link rel="stylesheet" href="'+ css +'" type="text/css" />');
            else $('head > link').filter(':first').replaceWith(defaultCSS);
        }
        $( document ).ready(function() {
            var iframe_height = parseInt($('html').height());
            window.parent.postMessage( iframe_height, 'https://bootsnipp.com');
        });
    </script>
</head>
<body>
<div class="container" style="padding-top:3%;">
    <form class="form-horizontal" role="form" action="guest" method="post">
        <input type="hidden" name="command" value="register" />
        <h2><fmt:message key="register.start"/></h2>
        <div class="form-group">
            <label for="name" class="col-sm-6 control-label" ><fmt:message key="register.name"/></label>
            <div class="col-sm-9">
                <input type="text" id="name" name = "name" pattern="([A-Z])([a-z]{1,12})" minlength="2" maxlength="15" placeholder=<fmt:message key="register.inner.name"/> class="form-control" autofocus required>
            </div>
        </div>
        <div class="form-group">
            <label for="surname" class="col-sm-6 control-label"><fmt:message key="register.surname"/></label>
            <div class="col-sm-9">
                <input type="text" id="surname" name = "surname" pattern="([A-Z])([a-z]{1,12})" minlength="2" maxlength="15" placeholder=<fmt:message key="register.inner.surname"/> class="form-control" autofocus required>
            </div>
        </div>
        <div class="form-group">
            <label for="email" type="email" class="col-sm-6 control-label"><fmt:message key="register.email"/> </label>
            <div class="col-sm-9">
                <input type="email" id="email" name = "email" placeholder=<fmt:message key="register.inner.email"/> class="form-control" required>
            </div>
        </div>
        <div class="form-group">
            <label for="password" class="col-sm-6 control-label"><fmt:message key="register.password"/></label>
            <div class="col-sm-9">
                <input type="password" id="password" name="password" pattern="(?=.*\d)(?=.*[a-z])(?=.*[A-Z]).{6,}" placeholder=<fmt:message key="register.inner.password"/> class="form-control" required>
            </div>
        </div>
        <div class="form-group">
            <label for="confirmPassword" class="col-sm-6 control-label"><fmt:message key="register.confirm"/></label>
            <div class="col-sm-9">
                <input type="password" id="confirmPassword" name = "confirmPassword" placeholder=<fmt:message key="register.inner.password"/> class="form-control" required>
            </div>
        </div>
        <div class="form-group">
            <div class="col-sm-9 col-sm-offset-3">
                <span class="help-block"><fmt:message key="register.required"/></span>
            </div>
        </div>
        <button type="submit" class="btn btn-primary btn-block"><fmt:message key="register.submit"/></button>
    </form> <!-- /form -->
</div> <!-- ./container -->
</body>
</html>

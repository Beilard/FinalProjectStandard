<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<fmt:setLocale value="${sessionScope.curLang}"/>
<fmt:setBundle basename="lang"/>


<html>
<head>
    <title><fmt:message key="error.inv.inpt.title"/></title>
    <link href="${pageContext.request.contextPath}/css/reg_required.css" type="text/css" rel="stylesheet">
</head>
<body>
<div class="container">
    <div class="row">
        <div class="col-md-12">
            <div class="error-template">
                <h1><fmt:message key="error.oops"/></h1>
                <h2><fmt:message key="error.inv.inpt"/></h2>
                <div class="error-details">
                    <fmt:message key="error.inv.inpt.instr"/>
                </div>
                <div class="error-actions">
                    <a href="${pageContext.request.contextPath}/page/?curLang=${sessionScope.curLang}" class="btn btn-primary btn-lg"><span
                            class="glyphicon glyphicon-home"></span>
                        <fmt:message key="error.go.home"/> </a>
                    <a href="${pageContext.request.contextPath}/page/reg_fwd?curLang=${sessionScope.curLang}"
                       class="btn btn-default btn-lg"><span
                            class="glyphicon glyphicon-envelope"></span> <fmt:message key="error.return"/> </a>
                </div>
            </div>
        </div>
    </div>
</div>
</body>
</html>

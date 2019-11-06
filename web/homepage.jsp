<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<c:set var="theLocale" value="${param.theLocale ? param.theLocale : pageContext.request.locale}"
       scope="session" />

<fmt:setLocale value="${theLocale}" />

<fmt:setBundle basename="i18n/labels" />

<html>
<body>
<a href="homepage.jsp?theLocale=en_US">English</a>
|
<a href="homepage.jsp?theLocale=ru_RU">Russian</a>
<br/>
<br/>

<fmt:message key="label.header"/>



<fmt:message key="label.footer"/>
</body>
</html>
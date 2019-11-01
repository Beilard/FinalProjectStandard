<%@ page import="ua.delivery.model.dao.implementation.UserDaoImpl" %>
<%@ page import="ua.delivery.model.dao.DBConnector" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>$Title$</title>
  </head>
  <body>
  <%=new UserDaoImpl(new DBConnector("database")).findAll()%>

  <table>
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
    <c:forEach items="${list}" var = "list">
      <li>${ListItem.name}</li>
    </c:forEach>
    </tbody>

  </table>


  </body>
</html>

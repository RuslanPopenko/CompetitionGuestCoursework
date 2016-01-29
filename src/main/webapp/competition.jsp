<%--
  Created by IntelliJ IDEA.
  User: Rus
  Date: 4/9/2015
  Time: 8:14 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page import="entity.Competition" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page errorPage="error.jsp" %>
<html>
<head>
    <title>Змагання</title>
  <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
  <link rel="stylesheet" href="/css/main.css">
  <link rel="stylesheet" href="/css/table.css">
</head>
<body>
    <h1 align="middle">Система WorkOUT</h1>

    <h2>Таблиця змагань</h2>
    <table>
      <tr>
        <th>Номер змагання</th>
        <th>Місце</th>
        <th>Дата та час</th>
        <th>Опис</th>
        <th>Нагородження</th>
      </tr>
      <c:forEach items="${ListOfComp}" var="current">
        <tr>
          <td><c:out value="${current.id}" /></td>
          <td><c:out value="${current.place}" /></td>
          <td><c:out value="${current.date}" /></td>
            <td><c:out value="${current.description}" /></td>
            <td><c:out value="${current.rewarding}" /></td>
        </tr>
      </c:forEach>
    </table>
</body>
</html>

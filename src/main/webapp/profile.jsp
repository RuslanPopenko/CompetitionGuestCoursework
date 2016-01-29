<%--
  Created by IntelliJ IDEA.
  User: Rus
  Date: 4/10/2015
  Time: 10:10 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page errorPage="error.jsp" %>
<html>
<head>
    <title>Профіль</title>
    <link rel="stylesheet" href="/css/profile.css">
</head>
<body>

<h1>Система WorkOUT</h1>
<h2>Перегляд профілю</h2>
<form id="my_form" action="TransitionServlet" method="post">
<div class="profileImage">
  <img height="150px" src="/images/photo.jpg"/>
</div>
<div class="profileText">
  <div class="profileTextKey">

    <p>Номер заявки</p>
    <p>Час реєстрації </p>
    <p>Реєстрація </p>

    <p>Номер змагання</p>
    <p>Місце змагання</p>

    <p>Ім'я</p>
    <p>Пошта</p>
    <p>Контактний телефон</p>
    <p>Перехід до іншої категорії користувача</p>
  </div>
  <div class="profileTextValue">

    <p> ${usN} </p>
    <p> ${TimeOfApp} </p>
    <p> ${result} </p>

    <p> ${compId} </p>
    <p> ${compPlace} </p>

    <p> ${name} </p>
    <p> ${eMail} </p>
    <p> ${contacts} </p>
    <p><select class="styled-select" name="catOptions" >
      <option disabled selected>Вибрати категорію</option>
      <option value="1">Учасник (Participant)</option>
      <option value="2">Суддя (Judje)</option>
      <option value="4">Організатор (Orgnizer)</option>
    </select></p>
  </div>
</div>
  <input type="hidden" name="numberOfApp" value="${usN}" />
  <a class="button" id="footer" href="javascript:{}" onclick="document.getElementById('my_form').submit(); return false;">
    Перейти до іншої категорії
  </a><br/>
</form>
<form id="form1" method="post" action="DeleteAppForServlet">
  <input type="hidden" name="deleted" value="${usN}" />
  <a class="button" id="fooRig" href="javascript:{}" onclick="document.getElementById('form1').submit(); return false;">
    Видалити заявку і профіль
  </a><br/>
</form>

</body>
</html>

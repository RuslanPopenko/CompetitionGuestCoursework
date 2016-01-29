<%--
  Created by IntelliJ IDEA.
  User: Rus
  Date: 4/9/2015
  Time: 1:01 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page errorPage="error.jsp" %>
<html>
<head>
    <title>Реєстрація</title>
    <meta content="noindex, nofollow" name="robots">
    <link rel="stylesheet" href="/css/flipclock.css">
    <script src="js/jquery-1.11.2.min.js"></script>
    <script src="js/flipclock.js"></script>

    <link rel="stylesheet" href="/css/registr.css">
</head>
<body>
    <h1 align="middle">Система WorkOUT</h1>


    <div class="clock"style="margin:2em;" ></div>


    <script type="text/javascript">
        var clock;

        $(document).ready(function() {
            clock = $('.clock').FlipClock({
                clockFace: 'TwentyFourHourClock'
            });
        });
    </script>




    <div id="main">
        <div id="first">
            <form action="AppForPartServlet" method="post">
                <h2>Реєстрація гостя</h2>
                <h4>Заповніть всі поля</h4>
                <label>Ім'я: </label>
                <input name="name" placeholder="Ім'я" type="text">
                <label>E-mail: </label>
                <input name="eMail" placeholder="E-mail" type="text">
                <label>Контактний телефон </label>
                <input name="contact" placeholder="0981234567" type="text">
                <label>Введіть номер змагання </label>
                <input name="num" placeholder="1" type="number">

                <input name="dsubmit" type="submit" value="Зареєструватися">
            </form>
        </div>
    </div>

</body>
</html>

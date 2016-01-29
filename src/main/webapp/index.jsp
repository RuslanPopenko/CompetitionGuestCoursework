
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ page errorPage="error.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%--
  Created by IntelliJ IDEA.
  User: Rus
  Date: 4/9/2015
  Time: 6:51 PM
  To change this template use File | Settings | File Templates.
--%>
<html>
    <head>
       <title>Система WorkOUT</title>
        <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
        <link rel="stylesheet" href="/css/styles.css">

    </head>
    <body>

        <h1 align="right">Система WorkOUT</h1>
        <h2 align="right">Для гостів турніра</h2>
        <a class="button" id="fooRig" href="/registr.jsp">Перейти до сторінки реєстрації гостя</a><br/>
        <a class="button" id="footer" href="/CompetServlet">Подивитися таблицю змагань</a><br>
        <a class="button" id="middle" href="Javascript:void(0)" onclick="myFunction()">Переглянути свій профіль</a><br>
        <form id="form-id" action="/GetProfileServlet" method="post">
            <input type="hidden" name="userName" id="userNameId" />

        </form>
        <script>
            function myFunction() {
                var userN = prompt('Login:', '');
                var pass = prompt('Password:', '');

                if ( pass == 'qwerty' ) {

                    document.getElementById("userNameId").value = userN;
                    var form = document.getElementById("form-id");
                    form.submit();

                } else if ( pass == null ) {
                    alert('Password is incorrect');
                    window.location.href = "error.jsp";
                } else {
                    alert('Password is incorrect');
                    window.location.href = "error.jsp";
                }


            }

        </script>
    </body>
</html>
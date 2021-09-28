<%-- 
    Document   : recensioneInserita
    Created on : Apr 17, 2021, 3:34:55 AM
    Author     : fpw
--%>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Recensione inserita!</title>
        <link rel="stylesheet" type="text/css" href="style.css" media="screen">
    </head>
    <body>
        <div id="loginBox">
            <a href="index.jsp"><img title="Logo" alt="Logo di ScooterCritic" src="img/logo.png"></a>
                <c:if test="${empty user}">
                    <c:redirect url="login.jsp"/>
                </c:if>
                <c:if test="${not empty user}">
                <h1>Grazie per la tua recensione!</h1>
                <h2>Sei interessato ai nostri nuovi monopattini?</h2>
            </c:if>
        </div>
    </body>
</html>

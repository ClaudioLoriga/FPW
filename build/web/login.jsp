<%-- 
    Document   : login
    Author     : Claudio Loriga
--%>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>AVIS - Login</title>
        <meta name="author" content="Claudio Loriga">
        <meta name="description" content="Accesso al sito">
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="stylesheet" type="text/css" href="style.css" media="screen">
        <script type="text/javascript" src ="js/code.js"></script>
    </head>
    <body>
        <c:set var="page" value="login" scope="request"/>
        <jsp:include page="header.jsp"/>
        <div id="loginBoxUser">
            <a href="index.jsp"><img title="Logo" alt="Logo di Avis old" src="img/logo_avis_old.jpg"></a>
            <h1>Login</h1>
            <form action="login" method="post">
                <label for="user">Username</label>
                <input id="usernameLogin" type="text" id="user" name="user"/>
                <label for="pass">Password</label>
                <input type="password" id="pass" name="pass"/>
                <input type="submit" value="Accedi"/>
            </form>
        </div>
        <div id="registrazioneFrase">
            <h2>
                <a href="nuova-registrazione.jsp"> Non sei ancora registrato? Registrati ora!</a>
            </h2>
        </div>
    </body>
</html>

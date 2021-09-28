<!DOCTYPE html>
<!--
To change this license header, choose License Headers in Project Properties.
To change this template file, choose Tools | Templates
and open the template in the editor.
-->
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<html>
    <head>
        <title>ScooterCritic - Login</title>
        <meta name="author" content="Valentino Artizzu">
        <meta name="description" content="Accesso al sito">
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="stylesheet" type="text/css" href="style.css" media="screen">

    </head>
    <body>
        <div id="loginBox">
            <a href="index.jsp"><img title="Logo" alt="Logo di ScooterCritic" src="img/logo.png"></a>
            <h1>Login</h1>
            <form action="login" method="post">
                <label for="user">Username</label>
                <input id="usernameLogin" type="text" id="user" name="user"/>
                <label for="pass">Password</label>
                <input type="password" id="pass" name="pass"/>
                <input type="submit" value="Accedi"/>
            </form>
        </div>
        <script type="text/javascript" src ="js/code.js"></script>
    </body>
</html>

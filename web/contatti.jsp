<!DOCTYPE html>
<!--
To change this license header, choose License Headers in Project Properties.
To change this template file, choose Tools | Templates
and open the template in the editor.
-->
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<html>
    <head>
        <title>ScooterCritic - Contatti</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="stylesheet" type="text/css" href="style.css" media="screen">
        <script type="text/javascript" src ="js/code.js"></script>
        <script type="text/javascript" src ="js/jquery.js"></script>

    </head>
    <body>
        <c:if test="${empty user}">
            <c:redirect url="login.jsp"/>
        </c:if>
        <c:if test="${not empty user}">
            <c:set var="page" value="contatti" scope="request"/>
            <jsp:include page="header.jsp"/>

            <div id="contattiBox">
                <h1>Contatti</h1>
                <p>Se avete bisogno di contattarci potete farlo tramite i seguenti indirizzi:</p>
                <p><b>Richieste Varie</b>: <span class="mono">ciao@scootercritic.it</span><br/>
                    <b>Aggiunta Modelli nel Database</b>: <span class="mono">monopattini@scootercritic.it</span> <br/>
                    <b>Posta cartacea</b>: <span class="mono">ScooterCritic S.p.A <br/> Via Ospedale 72 <br/> 09124 - Cagliari (CA)</span>
                </p>
                <p>...Oppure, potete inviarci una nuova segnalazione</p>
                <form action="segnalazione" method="post">
                    <label>Oggetto</label>
                    <input id="oggettoSegnalazione" type="text" name="oggetto"/><br>
                    <label>Testo</label><br>
                    <textarea rows="4" cols="20" name="testo"></textarea><br>
                    <input id="corpoSegnalazione"type="submit" value="Invia"/>
                </form>
            </div>
        </c:if>
    </body>
</html>

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
        <title>ScooterCritic - Nuova Recensione</title>
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
            <c:set var="page" value="nuovo-post" scope="request"/>
            <jsp:include page="header.jsp"/>
            <div id="newRecensioneBox">
                <h1>Nuova Recensione</h1>
                <form action="recensione" method="post">
                    <label>Descrizione</label><br>
                    <textarea id="descrizioneRecensione" rows="4" cols="20" name="descrizione"></textarea><br>
                    <p id="caratteriRimanenti">Caratteri: 0/50</p>
                    <label>Modello:</label><br>
                    <select name="monopattino">
                        <option value="CorriVeloce Classic">CorriVeloce Classic</option>
                        <option value="DueRuote Roadster">DueRuote Roadster</option>
                        <option value="RisoPiccolo RisoScooter">RisoPiccolo RisoScooter</option>
                    </select><br>
                    <label>Voto (da 1 a 5):</label><br>
                    <input id="votoRecensione" type="number" name="voto" min="1" max="5"><br>
                    <input type="submit" value="Pubblica"/>
                </form>
            </div>
        </c:if>
    </body>
</html>

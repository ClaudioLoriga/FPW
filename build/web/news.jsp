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
        <title>ScooterCritic News</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="stylesheet" type="text/css" href="style.css" media="screen">

    </head>
    <body>
    <c:set var="page" value="news" scope="request"/>
    <jsp:include page="header.jsp"/>
    <h1>ScooterCritic informa</h1>

    <article class="news">
        <h2 class="newsTitle">Fiera dell'ecologia di Rimini </h2>
        <b class="newsDate">06/03/2021</b>
        <p class="newsBody">
            Oggi vi porteremo alla fiera dell'ecologia di Rimini, dove CorriVeloce e DueRuote annunciano in esclusiva i loro monopattini caricabili a spinta.
            Questi monopattini permettono di dimenticare completamente la presa di ricarica, in quanto rigenerano la loro batteria semplicemente tramite spinta
            dell'utente. Attendiamo questi modelli nei nostri uffici per darvi le nostre prime impressioni. Ci vediamo per la recensione!
        </p>
    </article>
    <article class="news">
        <h2 class="newsTitle">Hello World!</h2>
        <b class="newsDate">03/03/2021</b>
        <p class="newsBody">Ciao a tutti! Oggi iniziamo con voi la nuova avventura ScooterCritic! Questo sito vuole essere un punto di riferimento
            per chiunque sia alla ricerca del suo prossimo monopattino elettrico, oltre che contenere le recensioni degli utenti andremo noi stessi
            in prima linea alla caccia delle ultime novita'  in materia, e ve le proporremo sia in questa sezione, sia tra le recensioni dello staff. Non ci resta
            che augurarvi una buona passeggiata!</p>
    </article>
</body>
</html>

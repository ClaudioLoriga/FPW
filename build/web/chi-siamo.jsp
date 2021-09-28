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
        <title>ScooterCritic - Chi Siamo</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="stylesheet" type="text/css" href="style.css" media="screen">

    </head>
    <body>
        <c:set var="page" value="chi-siamo" scope="request"/>
        <jsp:include page="header.jsp"/>
        <h1>Chi siamo</h1>
        <p>ScooterCritic e' un gruppo di giovani (e non) con la passione delle due ruote elettriche, e sono:</p>
        <div class="fondatore">
            <img class="fondatoreImg col-3" src="img/Harold.jpg" alt="Giovanni Soli">
            <p class="fondatoreBio col-9"><b>Giovanni Soli</b>: Classe 1985, e' l'ideatore del sito, senza di lui tutto cio' non sarebbe stato possibile. Porta nel gruppo la sua esperienza
                decennale in campo di motori e informatica.</p>
        </div>
        <div class="fondatore">
            <img class="fondatoreImg col-3" src="img/bradley.jpg" alt="Jack Cabras">
            <p class="fondatoreBio col-9"><b>Jack Cabras</b>: Nato nel lontano 2000 nel New Jersey da padre italiano e madre statunitense, e' il cofondatore di questa azienda, le sue doti 
                imprenditoriali e finanziarie sono state fondamentali per creare una solida base dove far crescere la nostra realta'  a due ruote.</p>
        </div>
        <div class="fondatore">
<img class="fondatoreImg col-3" src="img/jack.png" alt="Aldo Pelosi">
            <p class="fondatoreBio col-9"><b>Aldo Pelosi</b>: Ultimo acquisto della squadra, e' il redattore della sezione notizie di ScooterCritic, grazie a lui possiamo informarvi
                sulle ultime novita'  del mondo della micromobilita'  elettrica.</p>
        </div>


    </body>
</html>

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
        <title>Scootercritic - About</title>
        <meta name="author" content="Valentino Artizzu">
        <meta name="description" content="Che cosa e' ScooterCritic?">
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="stylesheet" type="text/css" href="style.css" media="screen">
    </head>
    <body>
        <c:set var="page" value="about" scope="request"/>
        <jsp:include page="header.jsp"/>

        <h1 id="inizio">Cosa e' ScooterCritic?</h1>

        <div class="col-3">
            <h2>Indice</h2>
            <ul id="aboutIndex">
                <li><a href="#1">Informazioni sul Sito</a></li>
                <li><a href="#2">A chi e' rivolto?</a></li>
                <li><a href="#3">Quanto costa?</a></li>
            </ul>
        </div>

        <div id="about" class="col-9">
            <h2 id="1">Informazioni sul Sito</h2>
            <p>
                ScooterCritic ti permette di leggere e scrivere recensioni sui monopattini elettrici attualmente in commercio. <br/>
                Vota le recensioni degli altri utenti e guarda le recensioni in evidenza, anche senza registrarti!

            </p>
            <a href="#inizio">Torna su</a>
            <h2 id="2">A chi e' rivolto?</h2>
            <p>
                Avete visto l'ennesimo ragazzino sfrecciarvi accanto sul marciapiede in monopattino e volete fare altrettanto?
                Volete muovervi da casa a lavoro abbandonando la macchina?
                Volete rilassarvi al lungomare stando fermi ma allo stesso tempo sentendo l'ebbrezza della velocita' ?
                ScooterCritic vi puo' aiutare nel realizzare i vostri sogni!
            </p>
            <a href="#inizio">Torna su</a>
            <h2 id="3">Quanto costa?</h2>
            <table>
                <tr>
                    <th></th>
                    <th>Per gli utenti</th>
                    <th>Per i produttori di monopattini</th>
                </tr>
                <tr>
                    <td><b>Prezzo</b></td>
                    <td>Gratuito</td>
                    <td>Quota di adesione da concordare con lo staff.</td>
                </tr>
                <tr>
                    <td><b>Requisiti</b></td>
                    <td>Iscrizione al sito (gli utenti senza iscrizione possono solo leggere le recensioni degli altri utenti) </td>
                    <td>Se volete il vostro monopattino sul sito contattateci all'indirizzo e-mail <u>monopattini@scootercritic.it</u></td>
                </tr>
            </table>
            <a href="#inizio">Torna su</a>
        </div>
    </body>
</html>

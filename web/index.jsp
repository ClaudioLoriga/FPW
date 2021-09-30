<!--
To change this license header, choose License Headers in Project Properties.
To change this template file, choose Tools | Templates
and open the template in the editor.
-->
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>ScooterCritic</title>
        <meta name="author" content="Mauretto">
        <meta name="description" content="Il sito di recensioni di monopattini elettrici">
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="stylesheet" type="text/css" href="style.css" media="screen">
        <script type="text/javascript" src ="js/HomeSpecific.js"></script>

    </head>
    <body>
        <c:set var="page" value="index" scope="request"/>
        <jsp:include page="header.jsp"/>  
            <div id="intro">
                <h2>Benvenuti!</h2>
                <p>
                    In questo sito potrete <b><i>leggere e scrivere recensioni</i></b>
                    sui monopattini più in voga del momento!
                    Il tutto <u>completamente gratis</u>!     
                </p>

                <input list="listaDiMonopattini" type="text">
                <datalist id="listaDiMonopattini">

                </datalist>
            </div>
            <div>
                <h2>Recensioni in evidenza</h2>
                <div>
                    <div class="col-1">
                        <button id="prevReview"> < </button>
                    </div>
                    <div class="col-10">

                        <article>
                            <h3 id="titoloRecensione" class="stats"> Recensione di ${recensione.getUtente_id()} del ${recensione.getData()}</h3>
                            <p id="commentoRecensione">${recensione.getCommento()}</p>
                            <p id="statisticheRecensione" class="stats"><b>Giudizio: </b> ${recensione.getVoto()}<b> Like</b>: ${recensione.getNum_like()}</p>
                        </article>

                    </div>
                    <div class="col-1">
                        <button id="nextReview"> > </button>
                    </div>
                </div>
            </div>
            <div>
                <form class="col-12" action="upload" method="POST" enctype="multipart/form-data">
                    <label for="descrizione">Descrizione File</label>
                    <input name="descrizione" type="text"/>
                    <input name="file" type="file" accept="image/*"/>
                    <input type="submit" value="Carica Immagine"/>
                </form>
            </div>
    </body>
</html>





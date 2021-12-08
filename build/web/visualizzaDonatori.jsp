<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Nuova Sessione</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="stylesheet" type="text/css" href="style.css" media="screen">
        <script type="text/javascript" src ="js/code.js"></script>
        <script type="text/javascript" src ="js/jquery.js"></script>
    </head>
    <body>
        <c:set var="page" value="visualizzaDonatori" scope="request"/>
        <jsp:include page="header.jsp"/>
        <c:if test="${user != 'Loriga'}">
            <c:redirect url="index.jsp"/>
        </c:if>
        <c:if test="${user == 'Loriga'}">
            <c:if test="${empty utentiConDonazione}">
                <c:redirect url="VisualizzaDonatoriServlet"/>
            </c:if>
            <c:if test="${not empty utentiConDonazione}">
                <h1>Donatori registrati </h1>
                <form action="VisualizzaDonatoriServlet" method="post">
                    <select name="tipo_ordine">
                        <option value="0">Cognome A-Z</option>
                        <option value="1">Cognome Z-A</option>
                        <option value="2">Donazioni Crescente</option>
                        <option value="3">Donazione Decrescente</option>
                    </select>
                    <input type="submit" value="Ordina">
                </form>
                <c:forEach items="${utentiConDonazione}" var="utenteConDonazione">
                    <div class="col-12">
                        <article>
                            <h3 class="stats"><b>NOME: </b> ${utenteConDonazione.utente.getNome()}<b>  COGNOME: </b>${utenteConDonazione.utente.getCognome()}</b></h3>
                            <p class="stats"> DATA DI NASCITA:  ${utenteConDonazione.utente.getDataDiNascita()}  CODICE FISCALE:  ${utenteConDonazione.utente.getCf()}</p>
                            <p class="stats"> SESSO:  ${utenteConDonazione.utente.getSesso()}  EMAIL:  ${utenteConDonazione.utente.getEmail()}</p>
                            <p class="stats"> TELEFONO:  ${utenteConDonazione.utente.getTelefono()}  GRUPPO SANGUIGNO:  ${utenteConDonazione.utente.getGs()}</p>
                            <p class="stats"> PATOLOGIE:  ${utenteConDonazione.utente.getPatologie()}</p>
                            <p class="stats"> NUM_DONAZIONI:  ${utenteConDonazione.numeroDonazioni} </p> 
                            </article>
                        </div>
                </c:forEach>
            </c:if>
        </c:if>
</html>

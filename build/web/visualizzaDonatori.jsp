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
            <c:if test="${empty listaUtenti}">
                <c:redirect url="VisualizzaDonatoriServlet"/>
            </c:if>
            <c:if test="${not empty listaUtenti}">
                <h1>Donatori registrati </h1>       
                <c:forEach items="${listaUtenti}" var="utente">
                    <c:forEach items="${numDonazioni}" var="num_donazione">
                        <div class="col-12">
                            <article>
                                <h3 class="stats"><b>NOME: </b> ${utente.getNome()}<b>  COGNOME: </b>${utente.getCognome()}</b></h3>
                                <p class="stats"> DATA DI NASCITA:  ${utente.getDataDiNascita()}  CODICE FISCALE:  ${utente.getCf()}</p>
                                <p class="stats"> SESSO:  ${utente.getSesso()}  EMAIL:  ${utente.getEmail()}</p>
                                <p class="stats"> TELEFONO:  ${utente.getTelefono()}  GRUPPO SANGUIGNO:  ${utente.getGs()}</p>
                                <p class="stats"> PATOLOGIE:  ${utente.getPatologie()}  FOTO UTENTE:  ${utente.getFoto()}</p>
                                <p class="stats"> NUM_DONAZIONI:  ${num_donazione} </p> 
                            </article>
                        </c:forEach>
                    </c:forEach>
                </div>
            </c:if>
        </c:if>
</html>

<%-- 
    Document   : areaPersonale
    Created on : Apr 19, 2021, 4:05:34 AM
    Author     : fpw
--%>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Area personale</title>
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="stylesheet" type="text/css" href="style.css" media="screen">
    </head>
    <body>
        <c:if test="${empty user}">
            <c:redirect url="login.jsp"/>
        </c:if>
        <c:if test="${not empty user}">
            <c:set var="page" value="areaPersonale" scope="request"/>
            <jsp:include page="header.jsp"/>

            <div id="userBox">
                <h1>Ciao ${user}!</h1>
                <p>Ultimo accesso: ${lastLogin}</p>
                <form action="logout" method="get">
                    <input type="submit" value="logout"/>
                </form>
            </div>
        </c:if>
        <div>
            <h2>Le tue informazioni:</h2>
            <div class="row">
                <div class="col-12">
                    <article>
                        <h3 class="stats"><b>NOME: </b> ${utente.getNome()}<b>  COGNOME: </b>${utente.getCognome()}</b></h3>
                        <p class="stats"> DATA DI NASCITA:  ${utente.getDataDiNascita()}  CODICE FISCALE:  ${utente.getCf()}</p>
                        <p class="stats"> SESSO:  ${utente.getSesso()}  EMAIL:  ${utente.getEmail()}</p>
                        <p class="stats"> TELEFONO:  ${utente.getTelefono()}  GRUPPO SANGUIGNO:  ${utente.getGs()}</p>
                        <p class="stats"> PATOLOGIE:  ${utente.getPatologie()}  FOTO UTENTE:  ${utente.getFoto()}</p>
                    </article>
                    <c:if test="${user != 'Loriga'}">
                    <a href="modifica-utente.jsp">Le tue informazioni non sono corrette? Modificale qua</a>
                    <br>
                    <a href="DonazioniEffettuateServlet">Visualizza le tue donazioni effettuate</a>
                    </c:if>
                </div>
            </div>
        </div>
    </body>
</html>

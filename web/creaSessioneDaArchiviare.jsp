<%-- 
    Document   : creaSessioneDaArchiviare
    Author     : Claudio Loriga
--%>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Nuova sessione da archiviare</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="stylesheet" type="text/css" href="style.css" media="screen">
        <script type="text/javascript" src ="js/code.js"></script>
        <script type="text/javascript" src ="js/jquery.js"></script>
    </head>
    <body>
        <c:set var="page" value="creaSessioneDaArchiviare" scope="request"/>
        <jsp:include page="header.jsp"/>
        <c:if test="${user != 'Loriga'}">
            <c:redirect url="index.jsp"/>
        </c:if>
        <c:if test="${user == 'Loriga'}">
            <div id="loginBoxUser">
                <a href="index.jsp"><img title="Logo" alt="Logo di Avis old" src="img/logo_avis_old.jpg"></a>
                <h1>Aggiungi i dati della sessione da archiviare</h1>
                <form action="AggiungiSessioneArchiviataServlet" method="post">
                    <label for="utente_sessione">Inserisci l'utente della sessione</label>
                    <input type="text" id="utente_sessione" name="utente_sessione"/>
                    <label for="data_sessione">Inserisci la data della sessione</label>
                    <input type="text" id="data_sessione" name="data_sessione"/>
                    <label for="qsp_sessione">Inserisci la quantità di sangue prelevato</label>
                    <input type="text" id="qsp_sessione" name="qsp_sessione"/>
                    <label for="note_sessione">Inserisci eventuali note</label>
                    <input type="text" id="note_sessione" name="note_sessione"/>
                    <input type="hidden" name="idSessione" id="idSessione" value="${param.idSessione}">
                    <input type="submit" value="Archivia"/>
                </form>
            </div>
        </c:if>
    </body>
</html>

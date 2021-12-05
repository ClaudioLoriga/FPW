<%-- 
    Document   : nuova-prenotazione
    Created on : Nov 14, 2021, 11:00:18 AM
    Author     : fpw
--%>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Nuova Prenotazione</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="stylesheet" type="text/css" href="style.css" media="screen">
        <script type="text/javascript" src ="js/code.js"></script>
        <script type="text/javascript" src ="js/jquery.js"></script>
    </head>
    <body>
        <c:set var="page" value="nuova-prenotazione" scope="request"/>
        <jsp:include page="header.jsp"/>
        <c:if test="${empty user}">
            <c:redirect url="login.jsp"/>
        </c:if>
        <c:if test="${not empty user}">
            <c:if test="${empty listaSessioni}">
                <c:redirect url="PrenotazioneServlet"/>
            </c:if>
            <h1>Sessioni Disponibili</h1>          
            <form action="PrenotaSessioneServlet" method="post">
                <c:forEach items="${listaSessioni}" var="sessione">
                    <div class="col-12">
                        <article>
                            <h3 id="orarioSessione" class="stats">Sessione: Inizio ${sessione.getOra_inizio()} Fine ${sessione.getOra_fine()}</h3>
                            <p id="luogoSessione">Luogo: ${sessione.getLuogo()}</p>
                            <p id="dataSessione" class="stats"><b>Data: </b>${sessione.getData_sessione()}</p>
                            <input type="hidden" name="idSessione" id="idSessione" value="${sessione.getId()}">
                            <input type="submit" value ="Prenota">
                        </article>
                    </div>
                </c:forEach>
            </form>
        </c:if>
    </body>
</html>

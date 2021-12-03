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
    <c:set var="page" value="gestisciSessioniDonazioni" scope="request"/>
    <jsp:include page="header.jsp"/>
    <c:if test="${user != 'Loriga'}">
        <c:redirect url="index.jsp"/>
    </c:if>
    <c:if test="${user == 'Loriga'}">
        <c:if test="${empty listaSessioni}">
            <c:redirect url="GestisciSessioniDonazioniServlet"/>
        </c:if>
        <c:if test="${not empty listaSessioni}">
            <h1>Sessioni del giorno </h1>          
            <c:forEach items="${listaSessioni}" var="sessione">
                <div class="col-12">
                    <article>
                        <h3 id="orarioSessione" class="stats">Sessione: Inizio ${sessione.getOra_inizio()} Fine ${sessione.getOra_fine()}</h3>
                        <p id="luogoSessione">Luogo: ${sessione.getLuogo()}</p>
                        <p id="dataSessione" class="stats"><b>Data: </b>${sessione.getData_sessione()}</p>
                        <form action="creaSessioneDaArchiviare.jsp" method="post">
                            <input type="hidden" name="idSessione" id="idSessione" value="${sessione.getId()}">
                            <input type="submit" value ="Archivia">
                        </form>
                        <form action="EliminaSessioneDonazione" method="post">
                            <input type="hidden" name="idSessione" id="idSessione" value="${sessione.getId()}">
                            <input type="submit" value ="Elimina">
                        </form>
                    </article>
            </c:forEach>
            </div>
        </c:if>
    </c:if>
</html>

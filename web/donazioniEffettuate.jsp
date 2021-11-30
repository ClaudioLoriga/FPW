<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Donazioni Effettuate</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="stylesheet" type="text/css" href="style.css" media="screen">
        <script type="text/javascript" src ="js/code.js"></script>
        <script type="text/javascript" src ="js/jquery.js"></script>
    </head>
    <body>
        <c:set var="page" value="donazioniEffettuate" scope="request"/>
        <jsp:include page="header.jsp"/>
        <c:if test="${empty user}">
            <c:redirect url="login.jsp"/>
        </c:if>
        <c:if test="${not empty user}">
            <c:if test="${empty listaSessioni}">
                <c:redirect url="DonazioniEffettuateServlet"/>
            </c:if>
            <h1><b>Le tue donazioni effettuate</b></h1>
            <h2>Grazie di cuore!</h2>
                <c:forEach items="${listaSessioni}" var="sessione">
                    <div class="col-12">
                        <article>
                            <h3 id="orarioSessione" class="stats">Donazione ${sessione.getOra_inizio()} - ${sessione.getOra_fine()}</h3>
                            <p id="luogoSessione">Luogo: ${sessione.getLuogo()}</p>
                            <p id="dataSessione" class="stats"><b>Data: </b>${sessione.getData_sessione()}</p>
                        </article>
                    </c:forEach>
                </div>
        </c:if>
    </body>
</html>

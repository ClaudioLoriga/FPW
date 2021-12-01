<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Scelta giorno sessioni</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="stylesheet" type="text/css" href="style.css" media="screen">
        <script type="text/javascript" src ="js/code.js"></script>
        <script type="text/javascript" src ="js/jquery.js"></script>
    </head>
    <body>
        <c:set var="page" value="sceltaGiornoSessioni" scope="request"/>
        <jsp:include page="header.jsp"/>
        <c:if test="${user != 'Loriga'}">
            <c:redirect url="index.jsp"/>
        </c:if>
        <c:if test="${user == 'Loriga'}">
            <div id="loginBoxUser">
                <a href="index.jsp"><img title="Logo" alt="Logo avis old" src="img/logo_avis_old.jpg"></a>
                <h1>Scegli il giorno delle sessioni di donazione desiderate</h1>
                <form action="SceltaGiornoSessioniServlet" method="post">
                    <label for="data_sessione_search">Inserisci la data desiderata</label>
                    <input type="text" id="data_sessione_search" name="data_sessione_search"/>
                    <input type="submit" value="Conferma"/>
                </form>
            </div>
        </c:if>
    </body>
</html>

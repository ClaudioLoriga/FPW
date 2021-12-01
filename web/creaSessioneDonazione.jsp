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
        <c:set var="page" value="creaSessioneDonazione" scope="request"/>
        <jsp:include page="header.jsp"/>
        <c:if test="${user != 'Loriga'}">
            <c:redirect url="index.jsp"/>
        </c:if>
        <c:if test="${user == 'Loriga'}">
            <div id="loginBoxUser">
                <a href="index.jsp"><img title="Logo" alt="Logo avis old" src="img/logo_avis_old.jpg"></a>
                <h1>Crea la sessione di donazione</h1>
                <form action="CreaSessioneServlet" method="post">
                    <label for="data_sessione">Inserisci la data della sessione</label>
                    <input type="text" id="data_sessione" name="data_sessione"/>
                    <label for="orario_inizio_sessione">Inserisci l'orario d'inizio sessione</label>
                    <input type="text" id="orario_inizio_sessione" name="orario_inizio_sessione"/>
                    <label for="orario_fine_sessione">Inserisci l'orario di fine sessione</label>
                    <input type="text" id="orario_fine_sessione" name="orario_fine_sessione"/>
                    <label for="luogo_sessione">Inserisci il luogo della sessione</label>
                    <input type="text" id="luogo_sessione" name="luogo_sessione"/>
                    <input type="submit" value="Conferma"/>
                </form>
            </div>
        </c:if>
    </body>
</html>

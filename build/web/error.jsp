<%-- 
    Document   : error
    Author     : Claudio Loriga
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Error</title>
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="stylesheet" type="text/css" href="style.css" media="screen">
    </head>
    <body>
        <header>
                <jsp:include page="header.jsp"/>
        </header>
        <h1>Errore: ${errorMessage}</h1>
        <a href="${link}">Torna indietro</a>
    </body>
</html>

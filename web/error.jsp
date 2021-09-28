<%-- 
    Document   : error
    Created on : Apr 14, 2021, 7:39:49 AM
    Author     : fpw
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
            <a href="index.jsp"><img title="Logo" alt="Logo di ScooterCritic" src="img/logo.png" width="368" height="73"></a>
        </header>
        <h1>Error: ${errorMessage}</h1>
        <a href="${link}">Torna indietro</a>
        
    </body>
</html>

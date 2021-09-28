<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>File Inserito Correttamente!</title>
        <link rel="stylesheet" type="text/css" href="style.css" media="screen">
    </head>
    <body>
        <jsp:include page="header.jsp"/>
        <h1>Lista dei file inseriti</h1>
        <table>
            <tr>
                <th>ID</th>
                <th>Descrizione</th>
                <th>Link</th>                
            </tr>
            <c:forEach var="immagine" items="${lista}">
                <tr>
                    <td><b>${immagine.id}</b></td>
                    <td><b>${immagine.descrizione}</b></td>
                    <td><a href="${immagine.percorso}">${immagine.nomefile}</a></td>
                </tr>
            </c:forEach>
        </table>
    </body>
</html>
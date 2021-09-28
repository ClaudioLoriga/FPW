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
                <h2>Segnalazioni:</h2>
                <div class="row">
                    <c:forEach items="${listaSegnalazioni}" var="segnalazione">
                        <div class="col-6">
                            <article>
                                <h3 class="stats">Segnalazione ${segnalazioni.getOggetto()} fatta il ${segnalazioni.getData()}</h3>
                                <p>${segnalazioni.getTesto()}</p>
                                <p class="stats"><b>idUtente: </b> ${segnalazioni.getUtente_id()}</p>
                            </article>
                        </div>
                    </c:forEach>
                </div>
            </div>
    </body>
</html>

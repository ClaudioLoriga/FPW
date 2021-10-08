<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Registrazione effettuata</title>
        <link rel="stylesheet" type="text/css" href="style.css" media="screen">
    </head>
    <body>
        <div id="loginBox">
            <a href="index.jsp"><img title="Logo" alt="Logo avis old" src="img/logo_avis_old.jpg"></a>
            <c:if test="${empty user}">
                <c:redirect url="login.jsp"/>
            </c:if>
            <c:if test="${not empty user}">
                <h1>Grazie per la tua registrazione!</h1>
                <h2>Ora puoi usufruire pienamente dei nostri servizi.</h2>
                <a href="areaPersonale.jsp">Clicca qui per accedere alla tua area personale</a>
            </c:if>
        </div>
    </body>
</html>

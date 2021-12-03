<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Archiviazione effettuata</title>
        <link rel="stylesheet" type="text/css" href="style.css" media="screen">
    </head>
    <body>
        <c:set var="page" value="creaSessioneDaArchiviare" scope="request"/>
        <div id="loginBox">
            <a href="index.jsp"><img title="Logo" alt="Logo avis old" src="img/logo_avis_old.jpg"></a>
                <c:if test="${user != 'Loriga'}">
                    <c:redirect url="login.jsp"/>
                </c:if>
                <c:if test="${user == 'Loriga'}">
                <h1>Archiviazione Effettuata!</h1>
                <a href="index.jsp">Clicca qui per accedere alla home</a>
            </c:if>
        </div>
    </body>
</html>

<%-- 
    Document   : annullamentoEffettuato
    Author     : Claudio Loriga
--%>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Annullamento effettuato</title>
        <link rel="stylesheet" type="text/css" href="style.css" media="screen">
    </head>
    <body>
        <c:set var="page" value="creaSessioneDaArchiviare" scope="request"/>
    <jsp:include page="header.jsp"/>
    <div id="loginBox">
        <a href="index.jsp"><img title="Logo" alt="Logo avis old" src="img/logo_avis_old.jpg"></a>
        <c:if test="${empty user}">
            <c:redirect url="login.jsp"/>
        </c:if>
        <c:if test="${not empty user}">
            <h1>Annullamento Effettuato</h1>
            <a href="index.jsp">Clicca qui per accedere alla home</a>
        </c:if>
    </div>
</body>
</html>
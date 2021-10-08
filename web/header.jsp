<%-- 
    Document   : header
    Created on : May 7, 2021, 8:19:45 AM
    Author     : fpw
--%>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<header>
    <a href="index.jsp"><img title="Logo" alt="Logo di Avis old" src="img/logo_avis_old.jpg"></a>
    <a href="index.jsp" id="headerText">AVIS- Associazione Volontari Italiani Sangue</a>
</header>
<nav>
    <ul>
        <li><c:if test="${page == 'index'}"><div class="active"></c:if><a href="index.jsp">Home</a><c:if test="${page=='index'}"></div></c:if></li>
        <li><c:if test="${page=='news'}"><div class="active"></c:if><a href="news.jsp">News</a><c:if test="${page=='news'}"></div></c:if></li>
        <li><c:if test="${page=='nuovo-post'}"><div class="active"></c:if><a href="nuovo-post.jsp">Nuovo Prenotazione</a><c:if test="${page=='nuovo-post'}"></div></c:if></li>
        <li><c:if test="${page=='about'}"><div class="active"></c:if><a href="about.jsp">About</a><c:if test="${page=='about'}"></div></c:if></li>
        <li><c:if test="${page=='chi-siamo'}"><div class="active"></c:if><a href="chi-siamo.jsp">Chi Siamo</a><c:if test="${page=='chi-siamo'}"></div></c:if></li>
        <li><c:if test="${page=='contatti'}"><div class="active"></c:if><a href="contatti.jsp">Contatti</a><c:if test="${page=='contatti'}"></div></c:if></li>        
        <li><c:if test="${page=='areaPers'}"><div class="active"></c:if><a href="areaPersonale.jsp">Area Personale</a><c:if test="${page=='areaPers'}"></div></c:if></li> 
        <li><a href="login.jsp">Login</a></li>

    </ul>
    <script type="text/javascript" src ="js/code.js"></script>
</nav>
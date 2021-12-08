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
    <script type="text/javascript" src ="js/code.js"></script>
</header>
<nav>
    <ul>
        <li><c:if test="${page == 'index'}"><div class="active"></c:if><a href="index.jsp">Home</a><c:if test="${page=='index'}"></div></c:if></li>
        <c:if test="${user != 'Loriga'}"><li><c:if test="${page=='news'}"><div class="active"></c:if><a href="news.jsp">News</a><c:if test="${page=='news'}"></div></c:if></li></c:if>
        <c:if test="${user != 'Loriga'}"><li><c:if test="${page=='nuova-prenotazione'}"><div class="active"></c:if><a href="nuova-prenotazione.jsp">Prenotati</a><c:if test="${page=='nuova-prenotazione'}"></div></c:if></li></c:if>
        <li><c:if test="${page=='areaPers'}"><div class="active"></c:if><a href="areaPersonale.jsp">Area Personale</a><c:if test="${page=='areaPers'}"></div></c:if></li>
        <c:if test="${user == null}"><li><c:if test="${page=='login'}"><div class="active"></c:if><a href="login.jsp">Login</a><c:if test="${page=='login'}"></div></c:if></li></c:if>
        <c:if test="${user == 'Loriga'}"><li><c:if test="${page=='creaSessioneDonazione'}"><div class="active"></c:if><a href="creaSessioneDonazione.jsp">Crea una sessione</a><c:if test="${page=='creaSessioneDonazione'}"></div></c:if></li></c:if>
        <c:if test="${user == 'Loriga'}"><li><c:if test="${page=='sceltaGiornoSessioni'}"><div class="active"></c:if><a href="sceltaGiornoSessioni.jsp">Gestisci sessioni</a><c:if test="${page=='sceltaGiornoSessioni'}"></div></c:if></li></c:if>
        <c:if test="${user == 'Loriga'}"><li><c:if test="${page=='visualizzaDonatori'}"><div class="active"></c:if><a href="visualizzaDonatori.jsp">Visualizza Donatori</a><c:if test="${page=='visualizzaDonatori'}"></div></c:if></li></c:if>
        <c:if test="${not empty user}"><li><form action="logout" method="get"><input type="submit" value="Logout"/></form></li></c:if>  
    </ul>
</nav>
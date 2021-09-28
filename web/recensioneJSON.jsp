<%-- 
    Document   : recensioneJSON
    Created on : Sep 25, 2021, 9:13:14 AM
    Author     : fpw
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="json" uri="http://www.atg.com/taglibs/json"%>
<json:object>
    <json:property name="user" value="${recensione.getUtente_id()}"/>
    <json:property name="data" value="${recensione.getData()}"/>
    <json:property name="desc" value="${recensione.getCommento()}"/>
    <json:property name="voto" value="${recensione.getVoto()}"/>
    <json:property name="like" value="${recensione.getNum_like()}"/>
</json:object>

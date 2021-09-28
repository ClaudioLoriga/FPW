<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="json" uri="http://www.atg.com/taglibs/json" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<json:object>
    <c:forEach var="monopattino" items="${monopattini}" varStatus="conteggio">
        <json:property name="${conteggio.count}" value="${monopattino}"/>
    </c:forEach>
</json:object>

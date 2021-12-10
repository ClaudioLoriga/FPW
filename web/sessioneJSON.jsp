<%@page contentType="application/json" pageEncoding="UTF-8"%>
<%@taglib prefix="json" uri="http://www.atg.com/taglibs/json"%>
<json:object>
    <json:property name="id" value="${sessione.getId()}"/>
    <json:property name="ora_inizio" value="${sessione.getOra_inizio()}"/>
    <json:property name="ora_fine" value="${sessione.getOra_fine()}"/>
    <json:property name="luogo" value="${sessione.getLuogo()}"/>
    <json:property name="data" value="${sessione.getData_sessione()}"/>
</json:object>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:if test="${hasAdminBarPermission}">
<div id="adminPanel">
    <span style="font-weight: bold;">Admin bar</span>
</div>
</c:if>
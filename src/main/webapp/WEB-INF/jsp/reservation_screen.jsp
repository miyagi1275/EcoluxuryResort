<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ include file="template.jsp" %>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>検索結果</title>
</head>
<body>
<jsp:include page="head.jsp" />




<c:if test="${not empty result}">


<c:set var="action" value="action=${result}"/>
<jsp:include page="roomtypes.jsp?${action}"/>

</c:if> 

<c:if test="${resultList.size() > 1}"> 
<c:forEach var="room" items="${sessionScope.resultSet}">

<c:set var="action" value="action=${room}"/>
<jsp:include page="roomtypes.jsp?${action}"/>

</c:forEach>
</c:if>


<jsp:include page="foot.jsp" />

</body>
</html>
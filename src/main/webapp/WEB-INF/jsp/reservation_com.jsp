<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="template.jsp" %>
<!DOCTYPE html>
<html>
<head>

<meta charset="UTF-8">
<title>予約</title>
</head>
<body>

<p>${register.family_name}様</p>


<jsp:include page="roomtypes_riz.jsp?action=${reservation.room_type_ab}"/>


<p>チェックイン日：${reservation.checkIN}</p>
<p>チェックアウト日:${reservation.checkOUT}</p>

<p>こちらの内容で予約しますか？</p>

<p><a href="ReservationServlet">はい</a></p>

<p><a href="SelectServlet">戻る</a></p>

<jsp:include page="foot.jsp" />

</body>
</html>
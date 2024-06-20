<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="template.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>予約結果</title>
</head>
<body>
<jsp:include page="head.jsp" />


<p>${register.family_name}様</p>
<p>ご予約が完了しました</p>

<p>ご予約内容</p>
<p>チェックイン日：${reservation.checkIN}</p>
<p>チェックアウト日：${reservation.checkOUT}</p>
<p>お部屋タイプ：${reservation.room_type_ab}</p>

<jsp:include page="foot.jsp" />

</body>
</html>
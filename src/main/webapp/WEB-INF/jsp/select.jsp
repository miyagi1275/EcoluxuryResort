<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="template.jsp" %>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" type="text/css" href="css/select.css">
<meta charset="UTF-8">
<title>予約</title>
</head>
<body>
<jsp:include page="head.jsp" />


<h2>お部屋検索</h2>
<form id="selectform" action="SelectServlet" method="POST" oninput="hakusuu=dayCal(checkOUT,checkIN)">
<table id="selecttable">
<tr><th>チェックイン</th><th>泊数</th>
<th>チェックアウト</th><th>人数</th></tr>
<tr>
<td><input type="date" name="checkIN" id="checkIN" value="${select.checkIN}" required ></td><td>
<output name="hakusuu" for="checkIN checkOUT">0</output>泊</td>
<td><input type="date" name="checkOUT" id="checkOUT"  value="${select.checkOUT}" required></td>
<td><select name="personNum">
<option>1</option>
<option>2</option>
</select></td></tr>

</table>


<c:if test="${not empty errorMsg}" ><p class="errorMsg">約枠が埋まっています</p></c:if>
<br>

<input type="submit" value="検索">
</form>

<jsp:include page="foot.jsp" />

<script src="js/select.js"></script>
</body>
</html>
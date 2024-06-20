<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="template.jsp" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<style>
.errorMsg{ 
    box-sizing: border-box;
    border-radius: 5px;
    background-color: #e50031;
    color: #fff;
    display: block;
    font-size: 14px;
    font-weight: bold;
    margin-top: 10px;
    padding: 10px 10px;
    position: relative;}
</style>

<title>ログイン</title>
</head>
<body>
<jsp:include page="head.jsp" />



<form action="LoginServlet" method="post" >
<p>ユーザーID：<input type="text" name="id"value="${register.id}" required></p>
<p>パスワード：<input type="password" name="pass"value="${register.pass}" required></p>
<input type="submit" value="ログイン"><br>
</form>
<c:if test="${not empty errorMsg}" ><p class="errorMsg">IDとパスワードの組み合わせが違います</p></c:if>
<br>
<p><a href="LoginServlet?param=register">会員登録がお済でない方</a></p>
<br>
<p><a href="TopServlet">トップへ戻る</a></p>



<jsp:include page="foot.jsp" />

</body>
</html>
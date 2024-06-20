<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="template.jsp" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
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

<meta charset="UTF-8">
<title>登録画面</title>
</head>
<body>


<form  action="RegisterServlet"  method="POST">

<p>会員ID：<input type="text" name="register_id" value="${register.id}" required></p>
<p>パスワード：<input type="password" name="register_pass" value="${register.pass}" required>
<p>メールアドレス：<input type="text" name="email" value="${register.email}" required></p>
<p>姓：<input type="text" name="family_name" value="${register.family_name}" required></p>
<p>名前：<input type="text" name="given_name" value="${register.given_name}" required></p>
<p>誕生日：<input type="date" name="birth" value="${register.birth}" required></p>
<p>電話番号：<input type="number" name="tel" value="${register.tel}" required></p>
<p>郵便番号：<input type="number" name="postal_code" value="${register.postal_code}" required></p>
<input type="submit" value="送信">

</form>


<c:if test="${not empty errorMsg}" ><p class="errorMsg">${errorMsg}</p></c:if>


<jsp:include page="foot.jsp" />



</body>
</html>
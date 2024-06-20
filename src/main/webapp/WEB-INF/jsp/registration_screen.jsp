<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="template.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">

<title>確認画面</title>
</head>
<body>

<p>ID:${register.id}</p>
<p>お名前:${register.family_name} ${register.given_name}様</p>
<p>メール:${register.email}</p>
<p>生年月日:${register.birth}</p>
<p>電話番号:${register.tel}</p>

<p>こちらの情報でご登録します。</p>

<p><a href="RegisterServlet?state=end">登録</a></p>
<jsp:include page="foot.jsp" />

</body>
</html>
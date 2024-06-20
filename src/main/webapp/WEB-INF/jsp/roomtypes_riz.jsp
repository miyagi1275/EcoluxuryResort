<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.Optional" %>

<%
Optional<String> action = Optional.ofNullable(request.getParameter("action"));
String roomtypesValue = action.orElse("なし");

%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="css/top.css">
<link rel="stylesheet" href="css/roomtype.css">
<meta charset="UTF-8">
<title>結果</title>
</head>
<body>


<hr>

<div id="roomtype">

<main id ="spans">

<%-- リクエストパラメータによって異なる結果を表示する --%>
<%
    switch (roomtypesValue) {
        case "DLX":
%>			
            <h2>デラックスルーム</h2>           
            <p>デラックスルームは、広々とした空間と豪華なアメニティを提供します。</p>
            
<%
            break;
        case "SR":
%>
            <h2>スイートルーム</h2>
            <p>スイートルームは、最高級の快適さと贅沢な体験を提供します。</p>

<%

            break;
        case "V":
%>
            <h2>ヴィラ</h2>
            <p>ヴィラは、プライベートな空間でリラックスできる豪華な宿泊施設です。</p>

<%
            break;
        case "FR":
%>
            <h2>ファミリールーム</h2>
            <p>ファミリールームは、家族全員で楽しめる広々とした空間を提供します。</p>

<%
            break;
        case "CS":
%>
            <h2>コーナースイート</h2>
            <p>コーナースイートは、パノラマビューを楽しめる特別な部屋です。</p>

<%
            break;
        case "ES":
%>
            <h2>エグゼクティブスイート</h2>
            <p>エグゼクティブスイートは、ビジネスと快適さを兼ね備えた宿泊施設です。</p>

<%
            break;
        case "PS":
%>
            <h2>プレジデンシャルスイート</h2>
            <p>プレジデンシャルスイートは、最高の贅沢を提供するスイートです。</p>
<%
            break;
        case "RPO":
%>
            <h2>温泉付き客室</h2>
            <p>温泉付き客室は、プライベートな温泉を楽しめる特別な部屋です。</p>
<%
            break;
        case "DZR":
%>
            <h2>デザイナーズルーム</h2>
            <p>デザイナーズルームは、ユニークでおしゃれなインテリアを特徴としています。</p>
<%
            break;
        case "GVR":
%>
            <h2>ガーデンビュールーム</h2>
            <p>ガーデンビュールームは、美しい庭園の景色を楽しめる部屋です。</p>
<%
            break;
        default:
%>
            <h2>該当する部屋タイプが見つかりませんでした</h2>
            <p>指定された部屋タイプは存在しません。別の部屋タイプを選択してください。</p>
<%
            break;
    }
%>
</main>

</div>

<hr>

</body>
</html>

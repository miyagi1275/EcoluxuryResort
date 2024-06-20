<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
<link rel="stylesheet" type="text/css" href="css/menu.css"> 

<title>ヘッダー</title>

</head>
<body>

<div class="bannerdiv">	
<div class="bunner" id="bunner1">
<a href="TopServlet"><img id="icons" src="img/headicon3.png" alt="Top"></a>
<p><a href="TopServlet" id="headTitle">&ensp;Eco Luxury Resort</a><br>
<a href="MenuServlet?Get/menu=room">&ensp;客室</a>&ensp;
<a href="MenuServlet?Get/menu=eat">食事</a>&ensp;
<a href="MenuServlet?Get/menu=facilis">施設</a>&ensp;
<a href="MenuServlet?Get/menu=access">アクセス</a>&ensp;
<a href="MenuServlet?Get/menu=faq">FAQ</a>
</p>
</div>

<div class="banner" id="bunner2">
<button id="menubutton"><img class="menuImg" src="img/menu.png" alt="メニューページへ"></button>
<nav class="menu" id="menu">
            <ul>
                <li><a href="MenuServlet?Get/menu=room">客室</a></li>
                <li><a href="MenuServlet?Get/menu=eat">食事</a></li>
                <li><a href="MenuServlet?Get/menu=facilis">施設</a></li>
                <li><a href="MenuServlet?Get/menu=access">アクセス</a></li>
                <li><a href="MenuServlet?Get/menu=faq">FAQ</a></li>
                
            </ul>
        </nav> 
        
<a href="SelectServlet"><img class="menuImg" id="selectImg" src="img/reservationIcon.png" alt="ご予約ページ"></a>
</div>
</div>
<div id="empty"></div>
<hr id="line">

<script src="js/menu.js"></script>
</body>
</html>
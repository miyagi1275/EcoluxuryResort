/**
 * 
 */

	var roomFun = document.querySelector("#roomFun");
	
roomFun.innnerHTML = 

"<c:if test='${not empty result}'>"+

roomtype("${result}")

+"</c:if> "


+ "<c:if test='${resultList.size() > 1}'>" 
+ "<c:forEach var='room' items='${sessionScope.resultList}'>"



+ roomtype("<c:out value='${room.room_type_ab}'/>")+ " </c:forEach>";


function roomtype(s){
	 var n  = "<jsp:include page='WEB-INF/roomtype/" + s + ".jsp'/>"; 
 return n;
	 }
 
 
 
 
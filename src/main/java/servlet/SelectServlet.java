package servlet;

import java.io.IOException;
import java.sql.Date;
import java.util.ArrayList;
import java.util.HashSet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bo.SelectLogic;
import model.Reservation;
/**
 * Servlet implementation class SelectServlet
 */
@WebServlet("/SelectServlet")

public class SelectServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
 
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/jsp/select.jsp");
		
		dispatcher.forward(request, response);	
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		request.setCharacterEncoding("UTF-8");
		HttpSession session = request.getSession();	

		Date checkIN = Date.valueOf(request.getParameter("checkIN"));
		Date checkOUT = Date.valueOf(request.getParameter("checkOUT"));
		
		long differenceInMillis = checkOUT.getTime() - checkIN.getTime();
	    long differenceInDays = differenceInMillis / (1000 * 60 * 60 * 24);
	    int stay_night = (int)differenceInDays;
	    
	    int personNum = Integer.parseInt(request.getParameter("personNum"));
	 
		Reservation select = new Reservation(checkIN, checkOUT,stay_night,personNum);
		
		SelectLogic seLogic = new SelectLogic();
		ArrayList<Reservation> resultList = new ArrayList<>();
		resultList = seLogic.selectResult(select);

		
		if(!(resultList == null) && !(resultList.size() == 0)) {
			
			if(resultList.size() == 1) {
				session.setAttribute("select",select);
				session.setAttribute("result",resultList.get(0).getRoom_type_ab());
				RequestDispatcher disptcher = request.getRequestDispatcher("WEB-INF/jsp/reservation_screen.jsp");
				disptcher.forward(request, response);
				session.removeAttribute("result");

		}else if(resultList.size() > 1) {

			session.setAttribute("select",select);
			
			
			//部屋タイプの重複削除
			HashSet<String> resultSet = new HashSet<>(); 
			
			for (Reservation s:resultList) {
				resultSet.add(s.getRoom_type_ab());
			}
			
			session.setAttribute("resultSet",resultSet);			
			session.setAttribute("resultList",resultList);
			
			}
				
			RequestDispatcher disptcher = request.getRequestDispatcher("WEB-INF/jsp/reservation_screen.jsp");
			disptcher.forward(request, response);
			session.removeAttribute("resultList");
			
		}else {
			
			String errorMsg = "泊まれる部屋はありません";
			session.setAttribute("select",select);		
			request.setAttribute("errorMsg", errorMsg);
			RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/jsp/select.jsp");
			dispatcher.forward(request, response);
			
		}
		

		
	}
		
		
		
		
		
}


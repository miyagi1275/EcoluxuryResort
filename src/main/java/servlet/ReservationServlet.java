package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bo.ReservationLogic;
import model.Register;
import model.Reservation;

/**
 * Servlet implementation class ReservationServlet
 */
@WebServlet("/ReservationServlet")
public class ReservationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession();
		Reservation reservation = (Reservation)session.getAttribute("reservation");
		Register register = (Register)session.getAttribute("register");
		ReservationLogic resLogic = new ReservationLogic();
		boolean kekka = resLogic.execute(register, reservation);
		
		if(kekka) {
					
			RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/jsp/reservation.jsp");
			dispatcher.forward(request, response);	
			
			
		}else {
			
			RequestDispatcher dispatcher = request.getRequestDispatcher("SelectServlet");
			dispatcher.forward(request, response);	
			
			System.out.println("予約失敗");}
		
		
		
		
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

}

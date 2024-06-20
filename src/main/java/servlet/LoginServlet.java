package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bo.LoginLogic;
import model.Login;
import model.Register;
import model.Reservation;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String getPalam = request.getParameter("param");
		
		if(getPalam == null) {
		RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/jsp/login.jsp");
		dispatcher.forward(request, response);
		
		String getaction = request.getParameter("action");
		
		HttpSession session = request.getSession();
		
		Reservation reservation = (Reservation)session.getAttribute("select");

		reservation.setRoom_type_ab(getaction);
		session.setAttribute("reservation", reservation);
		
		
		
		}else if(getPalam.equals("register")){
	
		RequestDispatcher dispatcher = request.getRequestDispatcher("RegisterServlet");
		dispatcher.forward(request, response);
			
		}		
		
		
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		String id = request.getParameter("id");
		String pass = request.getParameter("pass");
		
		Login login = new Login(id,pass);
		
		LoginLogic loLogic = new LoginLogic();
		
		Register register = loLogic.execute(login);

		if(register != null) {
		
			HttpSession session = request.getSession();
			session.setAttribute("register",register);
			session.getAttribute("select");
			
			
			RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/jsp/reservation_com.jsp");
			dispatcher.forward(request, response);	
	
		}else {
			
			String errorMsg = "ログイン失敗";
			request.setAttribute("errorMsg",errorMsg);
			RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/jsp/login.jsp");
			dispatcher.forward(request, response);	
			
		}		
		
	}

}

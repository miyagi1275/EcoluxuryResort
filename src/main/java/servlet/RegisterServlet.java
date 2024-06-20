package servlet;

import java.io.IOException;
import java.sql.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bo.RegisterLogic;
import model.Register;

/**
 * Servlet implementation class RegisterServlet
 */
@WebServlet("/RegisterServlet")
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
				
		String state = null;
		state = request.getParameter("state");
		
		HttpSession session = request.getSession();
		session.getAttribute("reservation");
		
		if(state == null) {
		RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/jsp/register.jsp");
		dispatcher.forward(request, response);		

		}else if(state.equals("end")) {

				
		Register register = (Register)session.getAttribute("register");
		RegisterLogic reLogic = new RegisterLogic();
		reLogic.touroku(register);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/jsp/reservation_com.jsp");
		dispatcher.forward(request, response);	
				
		}		
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		request.setCharacterEncoding("UTF-8");
		
		String errorMsg = null;
		String id = request.getParameter("register_id");
		String pass = request.getParameter("register_pass");
		String email = request.getParameter("email");
		String family_name = request.getParameter("family_name");
		String given_name = request.getParameter("given_name");
		String postal_code = request.getParameter("postal_code");
		String tel = request.getParameter("tel");
		Date birth = Date.valueOf(request.getParameter("birth"));
		
		
		Register register = new Register(id,pass,email,family_name,given_name,postal_code,tel,birth);

		RegisterLogic reLogic = new RegisterLogic();
		
		boolean tyouhuku = reLogic.execute(register);
		
		HttpSession session = request.getSession();
		session.setAttribute("register", register);
		
			
			if(tyouhuku) {
				


				RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/jsp/registration_screen.jsp");
				dispatcher.forward(request, response);	
					
			
		}else {
			errorMsg = "ID・メールがすでに登録されています";
			request.setAttribute("errorMsg",errorMsg);

			RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/jsp/register.jsp");
			dispatcher.forward(request, response);	
		}
	

	}
		
	}

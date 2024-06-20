package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class MenuServlet
 */
@WebServlet("/MenuServlet")
public class MenuServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String forwardPass = null;	
		String getMenu = request.getParameter("Get/menu");
		
		switch(getMenu) {

		case "room" -> forwardPass = "WEB-INF/jsp/room.jsp";
		case "eat" -> forwardPass = "WEB-INF/jsp/eat.jsp";
		case "facilis" -> forwardPass = "WEB-INF/jsp/facilis.jsp";
		case "access" -> forwardPass = "WEB-INF/jsp/access.jsp";
		case "faq" -> forwardPass = "WEB-INF/jsp/faq.jsp";
		case "top" -> forwardPass = "WEB-INF/jsp/menu.jsp";

		
		
		}
	
		RequestDispatcher dispatcher = request.getRequestDispatcher(forwardPass);
		dispatcher.forward(request, response);
		
		
		
	}

}

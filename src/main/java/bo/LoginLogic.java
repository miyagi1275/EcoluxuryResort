package bo;

import dao.LoginDAO;
import model.Login;
import model.Register;

public class LoginLogic {

	
	public Register execute(Login login) {		
		LoginDAO loDAO = new LoginDAO();
		return loDAO.findbyLogin(login);
		
	}
	
	

}

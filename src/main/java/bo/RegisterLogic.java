package bo;

import dao.RegisterDAO;
import model.Register;

public class RegisterLogic {
	
		RegisterDAO reDAO = new RegisterDAO();
		
	public boolean execute(Register register) {	
		boolean isId = reDAO.findbyId(register);
		boolean isEmail= reDAO.findbyEmail(register);
		
		
		
		if(isId == false && isEmail == false) {
			return true;
		}else {return false;}
			
	}
	
	public boolean touroku(Register register) {
		boolean result = reDAO.registCast(register);
		
		return result;
		
	}
	
	
	
	

}

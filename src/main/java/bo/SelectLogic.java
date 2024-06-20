package bo;
import java.util.ArrayList;

import dao.SelectDAO;
import model.Reservation;
public class SelectLogic {
		
	public ArrayList<Reservation> selectResult(Reservation reservation) {
		
		SelectDAO selectDAO = new SelectDAO();
		ArrayList<Reservation> selectArray = new ArrayList<>();

		
		selectArray = selectDAO.selectRoom(reservation);
	
		if(selectArray == null) {return null;}else {

		return selectArray;
		}
	}
	
	

}

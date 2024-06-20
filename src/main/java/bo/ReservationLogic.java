package bo;

import dao.ReservationDAO;
import model.Register;
import model.Reservation;

public class ReservationLogic {
	
	public boolean execute(Register register,Reservation reservation) {
		
		ReservationDAO resDAO = new ReservationDAO();
		boolean kekka = resDAO.reservation(register,reservation);
		
		return kekka;
	}

	

}

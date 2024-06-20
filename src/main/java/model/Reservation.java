package model;

import java.sql.Date;

public class Reservation {
	
	private String reserv_id,room_type_ab;
	private Date acc_date,checkIN,checkOUT;
	private int room_number,stay_night,personNum;
	
	public Reservation(Date checkIN,Date checkOUT) {
		this.checkIN = checkIN;
		this.checkOUT = checkOUT;
	}
	
	public Reservation(Date checkIN,Date checkOUT,int stay_night,int personNum) {
		this.checkIN = checkIN;
		this.checkOUT = checkOUT;
		this.stay_night = stay_night;
		this.personNum = personNum;
		
	}
	
	
	
	public Reservation(String reserv_id,Date acc_date, int room_number,String room_type_ab) {
		this.reserv_id = reserv_id;
		this.acc_date = acc_date;
		this.room_number = room_number;
		this.room_type_ab = room_type_ab;
	}

	
	
	public String getRoom_type_ab() {
		return room_type_ab;
	}


	public Date getCheckIN() {
		return checkIN;
	}

	public Date getCheckOUT() {
		return checkOUT;
	}


	public String getReserv_id() {
		return reserv_id;
	}

	public Date getAcc_date() {
		return acc_date;
	}

	public int getRoom_number() {
		return room_number;
	}

	public void setRoom_type_ab(String room_type_ab) {
		this.room_type_ab = room_type_ab;		
		
	}
	
	public int getStay_Night() {
		return stay_night;
	}
	
	public int getPersonNum() {
		return personNum;
	}
	

}

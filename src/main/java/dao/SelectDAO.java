package dao;


	import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import model.Reservation;


	public class SelectDAO {

		private final String JDBC_URL = "jdbc:mysql://localhost:3306/ecoluxuryresort";
		private final String DB_USER = "root";
		private final String DB_PASS = "Miyagi7512@";
		
		public ArrayList<Reservation> selectRoom(Reservation reservation) {
			ArrayList<Reservation> rooms = new ArrayList<>();
			 List<Date> dates = getDatesBetween(reservation.getCheckIN(), reservation.getCheckOUT());

			try {
				Class.forName("com.mysql.cj.jdbc.Driver");
				
			}catch(ClassNotFoundException e){
				throw new IllegalStateException("JDBCドライブを読み込めませんでした");
			}
			try(Connection conn = DriverManager.getConnection(JDBC_URL,DB_USER,DB_PASS) ) {
				String sql = "WITH reservations AS (" +
                        "    SELECT " +
							"r.reserv_id,"+
                        "        r.room_number, " +
                        "        r.acc_date, " +
                        "        r.state, " +
                        "        LEAD(r.acc_date, 1) OVER (PARTITION BY r.room_number ORDER BY r.acc_date) AS next_date, " +
                        "        LAG(r.acc_date, 1) OVER (PARTITION BY r.room_number ORDER BY r.acc_date) AS prev_date, " +
                        "        LEAD(r.state, 1) OVER (PARTITION BY r.room_number ORDER BY r.acc_date) AS next_state, " +
                        "        LAG(r.state, 1) OVER (PARTITION BY r.room_number ORDER BY r.acc_date) AS prev_state " +
                        "    FROM " +
                        "        ecoluxuryresort.reservation r " +
                        "    WHERE " +
                        "        r.acc_date = ?" +
                        ") " +
                        "SELECT " +
                        "   r.reserv_id,"+
                        "    r.room_number, " +
                        "    r.acc_date, " +
                        "    r.state, " +
                        "    rt.room_type_ab " +
                        "FROM " +
                        "    reservations r " +
                        "JOIN " +
                        "    ecoluxuryresort.roomtype rt ON r.room_number = rt.room_number " +
                        "WHERE " +
                        "    r.state = 'f'";
						
				
				 for (Date date : dates) {
		                try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
		                    pstmt.setDate(1, date);
		                try(ResultSet rs = pstmt.executeQuery()){

						while(rs.next()) {
							String reserv_id = rs.getString("RESERV_ID");
							Date acc_date = rs.getDate("ACC_DATE");
							int room_number = rs.getInt("ROOM_NUMBER");
							String room_type_ab =rs.getString("ROOM_TYPE_AB");
							
							Reservation room = new Reservation(reserv_id,acc_date,room_number,room_type_ab);
							rooms.add(room);
						}
					
		                }	}
				 }
				

				
				// TODO: handle exception
			}catch(SQLException e) {
				e.printStackTrace();
				return null;
			}
	
			return rooms;
	
		
	}
		
		
		   private List<Date> getDatesBetween(Date startDate, Date endDate) {
		        List<Date> dates = new ArrayList<>();
		        LocalDate start = startDate.toLocalDate();
		        LocalDate end =  endDate.toLocalDate();

		        while (!start.isAfter(end)) {
		        	dates.add(Date.valueOf(start));
		            start = start.plusDays(1);
		        }
		        return dates;
		
		   }
		
		
	  /*  private Date addDays(Date startDate, int days) { 
	    	LocalDate date = startDate.toLocalDate(); 
	    	date = date.plusDays(days); 	
	        return Date.valueOf(date);
	    }
		
		*/
		
}

package dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import model.Register;
import model.Reservation;

public class ReservationDAO {
	
		private final String JDBC_URL = "jdbc:mysql://localhost:3306/ecoluxuryresort";
		private final String DB_USER = "root";
		private final String DB_PASS = "Miyagi7512@";

		
		public boolean reservation(Register register,Reservation reservation) {
			//予約
			
			int staynight = reservation.getStay_Night();
			//一泊二日　1
			//二泊三日　2
			List<Date> nights = getDatesBetween(reservation.getCheckIN(), reservation.getCheckOUT());
			
			
			try {
				Class.forName("com.mysql.cj.jdbc.Driver");
				
			}catch(ClassNotFoundException e){
				throw new IllegalStateException("JDBCドライブを読み込めませんでした");
			}
			
			
			try(Connection conn = DriverManager.getConnection(JDBC_URL,DB_USER,DB_PASS) ) {
				
				try (PreparedStatement pstmtCreateTempTable = conn.prepareStatement(
				        "CREATE TEMPORARY TABLE TempRoomNumbers AS " +
				        "SELECT r.ROOM_NUMBER " +
				        "FROM reservation r " +
				        "LEFT OUTER JOIN roomtype rt ON r.ROOM_NUMBER = rt.ROOM_NUMBER " +
				        "WHERE rt.ROOM_TYPE_AB = ?")) {

				    // プリペアドステートメントにパラメータを設定
				    pstmtCreateTempTable.setString(1,reservation.getRoom_type_ab()); // rt.ROOM_TYPE_AB

				    // 一時テーブルを作成
				    pstmtCreateTempTable.executeUpdate();
				}

	
				for(int i = 0 ;i < staynight; i++ ){
					
					try(PreparedStatement pstmtUpdateReservation = conn.prepareStatement(
				        "UPDATE reservation r " +
				        "SET r.REGIST_ID = ?, r.STATE = 't' " +
				        "WHERE r.STATE = 'f' AND r.ACC_DATE = ? AND r.ROOM_NUMBER IN (SELECT tr.ROOM_NUMBER FROM TempRoomNumbers tr)")) {

				    // プリペアドステートメントにパラメータを設定
				    pstmtUpdateReservation.setString(1,register.getId()); // r.REGIST_ID
				    pstmtUpdateReservation.setDate(2,nights.get(i)); // r.ACC_DATE

				    // レコードを更新
				    
				    
					int result = pstmtUpdateReservation.executeUpdate();
					if(result != 1) {return false;}
					
					
					}
					
				}

				// 一時テーブルを削除
				try (PreparedStatement pstmtDropTempTable = conn.prepareStatement(
				        "DROP TEMPORARY TABLE TempRoomNumbers")) {
				    pstmtDropTempTable.executeUpdate();
				    
				    
				}			
				// TODO: handle exception
			}catch(SQLException e) {
				e.printStackTrace();
				return false;
			}

			return true;
		
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
		

}

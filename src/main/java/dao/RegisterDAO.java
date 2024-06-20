package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.Register;

public class RegisterDAO {
	
		private final String JDBC_URL = "jdbc:mysql://localhost:3306/ecoluxuryresort";
		private final String DB_USER = "root";
		private final String DB_PASS = "Miyagi7512@";
		
		
		public boolean findbyId(Register register) {
			
			try {
				Class.forName("com.mysql.cj.jdbc.Driver");
				
			}catch(ClassNotFoundException e){
				throw new IllegalStateException("JDBCドライブを読み込めませんでした");
			}
			try(Connection conn = DriverManager.getConnection(JDBC_URL,DB_USER,DB_PASS) ) {
				
				String sql = "SELECT REGIST_ID FROM registration "
						+ "WHERE REGIST_ID = ?"; 
				PreparedStatement pStmt = conn.prepareStatement(sql);
				pStmt.setString(1,register.getId());

			try (ResultSet resultSet = pStmt.executeQuery()) {
		                return resultSet.next();}

			
			}catch(SQLException e) {
				e.printStackTrace();
				return false;
			}

		
			
		}
		
		public boolean findbyEmail(Register register) {
			//メールの重複の確認
			try {
				Class.forName("com.mysql.cj.jdbc.Driver");
				
			}catch(ClassNotFoundException e){
				throw new IllegalStateException("JDBCドライブを読み込めませんでした");
			}
			try(Connection conn = DriverManager.getConnection(JDBC_URL,DB_USER,DB_PASS) ) {
			String sql = "SELECT EMAIL FROM registration "
					+ "WHERE EMAIL = ?"; 
			PreparedStatement pStmt = conn.prepareStatement(sql);
			pStmt.setString(1,register.getEmail());

			try (ResultSet resultSet = pStmt.executeQuery()) {
                return resultSet.next();}
				//次のデータがない場合、falseを返す
			
			
					
		}catch(SQLException e) {
			e.printStackTrace();
			return true;
		}
		}
		
		
		public boolean registCast(Register register) {
				//登録

			try {
				Class.forName("com.mysql.cj.jdbc.Driver");
				
			}catch(ClassNotFoundException e){
				throw new IllegalStateException("JDBCドライブを読み込めませんでした");
			}
			try(Connection conn = DriverManager.getConnection(JDBC_URL,DB_USER,DB_PASS) ) {
				String sql = "INSERT INTO registration(REGIST_ID,REGIST_PASS,EMAIL,FAMILY_NAME,GIVEN_NAME,"
						+ "POSTAL_CODE,TEL,BIRTH) "
						+ "VALUES(?,?,?,?,?,?,?,?)"; 
				PreparedStatement pStmt = conn.prepareStatement(sql);
				pStmt.setString(1,register.getId());
				pStmt.setString(2,register.getPass());
				pStmt.setString(3,register.getEmail());
				pStmt.setString(4,register.getFamily_name());
				pStmt.setString(5,register.getGiven_name());
				pStmt.setString(6,register.getPostal_code());
				pStmt.setString(7,register.getTel());
				pStmt.setDate(8,register.getBirth());
			
				int result = pStmt.executeUpdate();
				if(result != 1) {return false;}
				
				
				// TODO: handle exception
			}catch(SQLException e) {
				e.printStackTrace();
				return true;
			}

			return true;
		
	}	
		
	

}

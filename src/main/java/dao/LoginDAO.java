package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.Login;
import model.Register;

public class LoginDAO {

	private final String JDBC_URL = "jdbc:mysql://localhost:3306/ecoluxuryresort";
	private final String DB_USER = "root";
	private final String DB_PASS = "Miyagi7512@";
	
	public Register findbyLogin(Login login) {
		Register register = null;

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			
		}catch(ClassNotFoundException e){
			throw new IllegalStateException("JDBCドライブを読み込めませんでした");
		}
		try(Connection conn = DriverManager.getConnection(JDBC_URL,DB_USER,DB_PASS) ) {
			String sql = "SELECT REGIST_ID,REGIST_PASS,FAMILY_NAME,TEL FROM registration"
					+ " WHERE REGIST_ID = ? AND REGIST_PASS = ?"; 
			PreparedStatement pStmt = conn.prepareStatement(sql);
			pStmt.setString(1,login.getRegist_id());
			pStmt.setString(2,login.getPass());
		
			ResultSet rs = pStmt.executeQuery();
			
			if(rs.next()) {
				String id = rs.getString("REGIST_ID");
				String pass = rs.getString("REGIST_PASS");
				String family_name = rs.getString("FAMILY_NAME");
				String tel = rs.getString("TEL");
				
				 register = new Register(id,pass,family_name,tel);

			}
			
			
			// TODO: handle exception
		}catch(SQLException e) {
			e.printStackTrace();
			return null;
		}

		return register;
	
}	
	
}

package model;

//ログイン

public class Login {
		
	private String regist_id,pass;
	
	
	public Login(String regist_id,String pass) {
	
	this.regist_id = regist_id;
	this.pass = pass;
	
	}
	
	public Login(String regist_id) {
		
	this.regist_id = regist_id;

	
	}


	public String getRegist_id() {
		return regist_id;
	}


	public String getPass() {
		return pass;
	}

}

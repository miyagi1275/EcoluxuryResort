package model;

import java.sql.Date;

//会員登録

public class Register {
	

	private String id,pass,email,family_name,given_name,postal_code,tel;
	private Date birth;
	
	public Register() {}
	
	public Register(String id,String pass) {
		this.id = id;
		this.pass = pass;
	}
	
	public Register(String id,String email,String tel) {
		this.id = id;
		this.email = email;
		this.tel = tel;
	}
	
	public Register(String id, String pass,String family_name,String tel) {
		this.id = id;
		this.pass = pass;
		this.family_name = family_name;
		this.tel = tel;
	}
	
	public Register(String id,String pass,String email,String family_name,String given_name,String postal_code,String tel,Date birth) {
		this.id = id;
		this.pass = pass;
		this.email = email;
		this.family_name = family_name;
		this.given_name = given_name;
		this.postal_code = postal_code;
		this.tel = tel;
		this.birth = birth;
		
	}
	public String getFamily_name() {
		return family_name;
	}
	public Date getBirth() {
		return birth;
	}
	public String getId() {
		return id;
	}
	public String getPass() {
		return pass;
	}
	public String getEmail() {
		return email;
	}
	public String getGiven_name() {
		return given_name;
	}
	public String getPostal_code() {
		return postal_code;
	}
	public String getTel() {
		return tel;
	}
	
	public void setId(String id) {
		this.id = id;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	
}

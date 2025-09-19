package com.model;

public class admin {

	private String a_email;
	private String a_pass;
	
	
	
	public admin() {
		super();
		// TODO Auto-generated constructor stub
	}



	public admin(String a_email, String a_pass) {
		super();
		this.a_email = a_email;
		this.a_pass = a_pass;
	}



	public String getA_email() {
		return a_email;
	}



	public void setA_email(String a_email) {
		this.a_email = a_email;
	}



	public String getA_pass() {
		return a_pass;
	}



	public void setA_pass(String a_pass) {
		this.a_pass = a_pass;
	}



	@Override
	public String toString() {
		return "admin [a_email=" + a_email + ", a_pass=" + a_pass + "]";
	}



	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}

package com.model;

public class cart {

	private int c_id; 
	private int f_id;
	private String c_email; 
	private String f_name;
	private float f_price;
	private int f_quanity;
	private float t_price;
	
	
	public cart() {
		super();
		// TODO Auto-generated constructor stub
	}


	public cart(int f_id, String c_email, String f_name, float f_price, int f_quanity, float t_price) {
		super();
		this.f_id = f_id;
		this.c_email = c_email;
		this.f_name = f_name;
		this.f_price = f_price;
		this.f_quanity = f_quanity;
		this.t_price = t_price;
	}


	public int getC_id() {
		return c_id;
	}


	public void setC_id(int c_id) {
		this.c_id = c_id;
	}


	public int getF_id() {
		return f_id;
	}


	public void setF_id(int f_id) {
		this.f_id = f_id;
	}


	public String getC_email() {
		return c_email;
	}


	public void setC_email(String c_email) {
		this.c_email = c_email;
	}


	public String getF_name() {
		return f_name;
	}


	public void setF_name(String f_name) {
		this.f_name = f_name;
	}


	public float getF_price() {
		return f_price;
	}


	public void setF_price(float f_price) {
		this.f_price = f_price;
	}


	public int getF_quanity() {
		return f_quanity;
	}


	public void setF_quanity(int f_quanity) {
		this.f_quanity = f_quanity;
	}


	public float getT_price() {
		return t_price;
	}


	public void setT_price(float t_price) {
		this.t_price = t_price;
	}


	@Override
	public String toString() {
		return "cart [c_id=" + c_id + ", f_id=" + f_id + ", c_email=" + c_email + ", f_name=" + f_name + ", f_price="
				+ f_price + ", f_quanity=" + f_quanity + ", t_price=" + t_price + "]";
	}


	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}

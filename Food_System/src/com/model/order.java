package com.model;

public class order {
	private int o_id;
	private String c_email;
	private String t_price;
	private String date;
	
	
	public order() {
		super();
		// TODO Auto-generated constructor stub
	}


	public int getO_id() {
		return o_id;
	}


	public void setO_id(int o_id) {
		this.o_id = o_id;
	}


	public String getC_email() {
		return c_email;
	}


	public void setC_email(String c_email) {
		this.c_email = c_email;
	}


	public String getT_price() {
		return t_price;
	}


	public void setT_price(String t_price) {
		this.t_price = t_price;
	}


	public String getDate() {
		return date;
	}


	public void setDate(String date) {
		this.date = date;
	}


	public order(String c_email, String t_price, String date) {
		super();
		this.c_email = c_email;
		this.t_price = t_price;
		this.date = date;
	}


	@Override
	public String toString() {
		return "order [o_id=" + o_id + ", c_email=" + c_email + ", t_price=" + t_price + ", date=" + date + "]";
	}


	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}

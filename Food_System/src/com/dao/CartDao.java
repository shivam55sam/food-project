package com.dao;

import java.util.List;

import com.model.cart;

public interface CartDao {

	boolean add_tocart(cart c);
	cart get_cart(int f_id);
	boolean delete_cart(int c_id);
	boolean update_cart(cart c);
	boolean clear_cart(String c_email);
	List<cart> show_cart(String c_email);
	
}

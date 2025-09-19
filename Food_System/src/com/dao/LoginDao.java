package com.dao;
import com.model.admin;
import com.model.customer;

public interface LoginDao {
	boolean admin_login(admin ad);
	boolean admin_changepass(admin ad);
	boolean user_login(customer cust);
	boolean user_changepass(customer cust);
}

	







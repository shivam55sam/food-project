package com.dao;
import java.util.List;
import com.model.customer;


public interface CustomerDao {

	boolean add_customer(customer cs);
	boolean update_customerbyemail(customer cs);
	boolean delete_customerbyemail(String c_email);
	customer get_customerbyemail(String c_email);
	List<customer>get_allcustomer();

}



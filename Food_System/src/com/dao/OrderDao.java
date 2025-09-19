package com.dao;
import java.util.List;
import com.model.orders;
import com.mysql.cj.x.protobuf.MysqlxCrud.Order;



public interface OrderDao {
	boolean update_order(String c_email,float t_price);
	orders place_order(String c_email);
	List<orders>show_order();
}


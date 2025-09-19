package com.dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import com.model.admin;
import com.model.customer;
import com.test.DbConnect;

public class LoginImpl implements LoginDao {

	Connection con;
	PreparedStatement ps;
	ResultSet rs;
	int row;
	boolean b;
	@Override
	public boolean admin_login(admin ad) {
		// TODO Auto-generated method stub
		try {
			con=DbConnect.get_connect();
			ps=con.prepareStatement("select *from where a_email=? and a_pass=?");
			ps.setString(1, ad.getA_email());
			ps.setString(2, ad.getA_pass());
			rs=ps.executeQuery();
			b=(rs.next())?true:false;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return b;
	}
	@Override
	public boolean admin_changepass(admin ad) {
		// TODO Auto-generated method stub
		try {
			con=DbConnect.get_connect();
			ps=con.prepareStatement("update admin set a_pass=? where a_email=?");
			ps.setString(1, ad.getA_pass());
			ps.setString(2, ad.getA_email());
			row=ps.executeUpdate();
			b=(row>0)?true:false;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return b;
	}
	@Override
	public boolean user_login(customer cust) {
		// TODO Auto-generated method stub
		try {
			con=DbConnect.get_connect();
			ps=con.prepareStatement("select c_mail,c_pass from customer where c_email=? and c_pass=?");
			ps.setString(1, cust.getC_email());
			ps.setString(2, cust.getC_pass());
			rs=ps.executeQuery();
			b=(rs.next())?true:false;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return b;
	}
	@Override
	public boolean user_changepass(customer cust) {
		// TODO Auto-generated method stub
		try {
			con=DbConnect.get_connect();
			ps=con.prepareStatement("update customer  set c_pass=? where c_email=?");
			ps.setString(1, cust.getC_pass());
			ps.setString(2, cust.getC_email());
			row=ps.executeUpdate();
			b=(row>0)?true:false;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return b;
	}
}


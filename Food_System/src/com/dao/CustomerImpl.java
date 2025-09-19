package com.dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import com.model.customer;
import com.test.DbConnect;


public class CustomerImpl implements CustomerDao {


	Connection con;
	PreparedStatement ps;
	int row;
	boolean b;
	ResultSet rs;
	@Override
	public boolean add_customer(customer cs) {
		// TODO Auto-generated method stub
		try {
			con=DbConnect.get_connect();
			ps=con.prepareStatement("insert into customers values(c_id,?,?,?,?,?)");
			ps.setString(1, cs.getC_name());
			ps.setString(2, cs.getC_email());
			ps.setString(3, cs.getC_pass());
			ps.setFloat(4, cs.getC_contact());
			ps.setString(5, cs.getC_pass());
            row=ps.executeUpdate();
			b=(row>0)?true:false;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return b;
	}
	@Override

	public boolean update_customerbyemail(customer cs) {

		// TODO Auto-generated method stub
		try {
			con=DbConnect.get_connect();
			ps=con.prepareStatement("update customer set c_name=?,c_pass=?,c_contact=?,c_address=? where c_email=?");
			ps.setString(1, cs.getC_name());
			ps.setString(2, cs.getC_pass());
			ps.setFloat(3, cs.getC_contact());
			ps.setString(4, cs.getC_address());
			ps.setString(5, cs.getC_email());;
			row=ps.executeUpdate();
			b=(row>0)?true:false;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return b;
	}
@Override

	public boolean delete_customerbyemail(String c_email) {
// TODO Auto-generated method stub
		try {
			con=DbConnect.get_connect();
			ps=con.prepareStatement("delete from customer where c_email=?");
			ps.setString(1, c_email);
			row=ps.executeUpdate();
			b=(row>0)?true:false;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return b;
	}
	@Override
	public customer get_customerbyemail(String c_email) {
		// TODO Auto-generated method stub
		customer c=new customer();
		try {
			con=DbConnect.get_connect();
			ps=con.prepareStatement("select *from customer where c_email=?");
			ps.setString(1, c_email);
			rs=ps.executeQuery();
			if(rs.next())
			{
				c.setC_id(rs.getInt("c_id"));
				c.setC_name(rs.getString("c_name"));
				c.setC_email(rs.getString("c_email"));
				c.setC_pass(rs.getString("c_pass"));
				c.setC_contact(rs.getLong("c_contact"));
				c.setC_address(rs.getString("c_address"));
			}
			else
			{
				return null;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return c;
	}
	@Override
	public List<customer> get_allcustomer() {
		// TODO Auto-generated method stub
		List<customer>list=new ArrayList<>();
		try {
			con=DbConnect.get_connect();
			ps=con.prepareStatement("select *from customers");
			rs=ps.executeQuery();
			while(rs.next())
			{
				customer c=new customer();
				c.setC_id(rs.getInt("c_id"));
				c.setC_name(rs.getString("c_name"));
				c.setC_email(rs.getString("c_email"));
				c.setC_pass(rs.getString("c_pass"));
				c.setC_contact(rs.getLong("c_contact"));
				c.setC_address(rs.getString("c_address"));

				list.add(c);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}
}


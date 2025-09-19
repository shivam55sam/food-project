package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.model.cart;

import com.test.DbConnect;

public class CartImpl implements CartDao{
	Connection con;
	PreparedStatement ps;
	ResultSet rs;
	int row;
	boolean b;

	@Override
	public boolean add_tocart(cart c) {
		
		try {
			con=DbConnect.get_connect();
			ps=con.prepareStatement("insert into cart values(c_id,?,?,?,?,?,?)");
			ps.setInt(1, c.getF_id());
			ps.setString(2, c.getC_email());
			ps.setString(3, c.getF_name());
			ps.setFloat(4, c.getF_price());
			ps.setFloat(5, c.getF_quanity());
			ps.setFloat(6, c.getT_price());
			
			row=ps.executeUpdate();
			b=(row>0)?true:false;
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return b;
	}

	@Override
	public cart get_cart(int f_id) {
		// TODO Auto-generated method stub
		cart c=new cart();
		try {
			con=DbConnect.get_connect();
			ps=con.prepareStatement("select *from cart where f_id=?");
			ps.setInt(1, f_id);
			rs=ps.executeQuery();
			
			if(rs.next())
			{
				c.setC_id(rs.getInt("c_id"));
				c.setF_id(rs.getInt("f_id"));
				c.setC_email(rs.getString("c_email"));
				c.setF_name(rs.getString("f_name"));
				c.setF_price(rs.getFloat("f_price"));
				c.setF_quanity(rs.getInt("f_quanity"));
				c.setT_price(rs.getFloat("t_price"));
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
	public boolean delete_cart(int c_id) {
		// TODO Auto-generated method stub
		try {
			con=DbConnect.get_connect();
			ps=con.prepareStatement("delete from cart where c_id=?");
			ps.setInt(1, c_id);
			row=ps.executeUpdate();
			
			b=(row>0)?true:false;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return b;
	}

	@Override
	public boolean update_cart(cart c) {
		// TODO Auto-generated method stub
		try {
			con=DbConnect.get_connect();
			ps=con.prepareStatement("update cart set f_id=?,c_email=?,f_name=?,f_price=?,f_quanity=?,t_price=? where c_id=?");
			ps.setInt(1, c.getF_id());
			ps.setString(2, c.getC_email());
			ps.setString(3, c.getF_name());
			ps.setFloat(4, c.getF_price());
			ps.setFloat(5, c.getF_quanity());
			ps.setFloat(6, c.getT_price());
			ps.setInt(7, c.getC_id());
			
			row=ps.executeUpdate();
			b=(row>0)?true:false;
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return b;
	}

	@Override
	public List<cart> show_cart(String c_email) {
		// TODO Auto-generated method stub
		List<cart>list=new ArrayList<>();
		
		try {
			con=DbConnect.get_connect();
			ps=con.prepareStatement("select *from cart where c_email=?");
			ps.setString(1, c_email);
			rs=ps.executeQuery();
			
			while(rs.next())
			{
				cart c=new cart();
				c.setC_id(rs.getInt("c_id"));
				c.setF_id(rs.getInt("f_id"));
				c.setC_email(rs.getString("c_email"));
				c.setF_name(rs.getString("f_name"));
				c.setF_price(rs.getFloat("f_price"));
				c.setF_quanity(rs.getInt("f_quanity"));
				c.setT_price(rs.getFloat("t_price"));
				
				list.add(c);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return list;
	}

	@Override
	public boolean clear_cart(String c_email) {
		// TODO Auto-generated method stub
		try {
			con=DbConnect.get_connect();
			ps=con.prepareStatement("delete cart where c_email=?");
			row=ps.executeUpdate();
			b=(row>0)?true:false;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return b;
	}

}
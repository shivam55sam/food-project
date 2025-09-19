package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.model.food;
import com.test.DbConnect;

public class FoodImpl implements FoodDao {
	
	Connection con;
    PreparedStatement ps;
	ResultSet rs;
	int row; 
	boolean b;
	
	




	@Override
	public boolean add_food(food food) {
		// TODO Auto-generated method stub
		try {
			con=DbConnect.get_connect();
			ps=con.prepareStatement("insert into food values (f_id,?,?,?,?)");
			ps.setString(1, food.getF_name());
			ps.setString(2, food.getF_type());
			ps.setString(3, food.getF_category());
			ps.setFloat(4, food.getF_price());
			row=ps.executeUpdate();
			b=(row>0)?true:false;
			
		}catch (Exception e) {
			
		}
		return b;
	}



	@Override
	public boolean update_food_byid(food food) {
		// TODO Auto-generated method stub
		
		try {
			con=DbConnect.get_connect();
			ps=con.prepareStatement("update food set f_name=?,f_type=?,f_category=?,f_price=? where f_id=?");
			
			ps.setString(1, food.getF_name());
			ps.setString(2, food.getF_type());
			ps.setString(3, food.getF_category());
			ps.setFloat(4, food.getF_price());
			ps.setInt(5, food.getF_id());
			
			row=ps.executeUpdate();
			b=(row>0)?true:false;
			
		}catch(Exception e){
			
		}
		return b;
	}



	@Override
	public boolean delete_food_byid(int f_id) {
		// TODO Auto-generated method stub

		try {
			con=DbConnect.get_connect();
			ps=con.prepareStatement("delete from food where f_id=?");
			ps.setInt(1, f_id);
			row=ps.executeUpdate();
			b=(row>0)?true:false;
					
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return b;
	}



	@Override
	public food get_food_byid(int f_id) {
	
		food f=new food();
		try {
				con=DbConnect.get_connect();
				ps=con.prepareStatement("select *from food where f_id=?");
				ps.setInt(1, f_id);
				rs=ps.executeQuery();
				if(rs.next()) {
					f.setF_id(rs.getInt("f_id"));
					f.setF_name(rs.getString("f_name"));
					f.setF_type(rs.getString("f_type"));
					f.setF_category(rs.getString("f_category"));
					f.setF_price(rs.getFloat("f_price"));	
				}
				else {
					return null;
				}
		}catch(Exception e) {
			
		}
		
		return f;
	}



	@Override
	public List<food> get_all_food() {
		// TODO Auto-generated method stub
		List<food> list=new ArrayList<>();
	
		try {
			
			con=DbConnect.get_connect();
			ps=con.prepareStatement("select *from food");
			rs=ps.executeQuery();
			while(rs.next()) {
				food f=new food();
				f.setF_id(rs.getInt("f_id"));
				f.setF_name(rs.getString("f_name"));
				f.setF_category(rs.getString("f_category"));
				f.setF_price(rs.getFloat("f_price"));
				list.add(f);
				
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return list;
	}

}

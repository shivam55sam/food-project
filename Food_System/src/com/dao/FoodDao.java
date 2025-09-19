package com.dao;
import java.util.List;
import com.model.food;

public  interface FoodDao {

	boolean add_food(food food);
	boolean update_food_byid(food food);
	boolean delete_food_byid(int f_id);
	food get_food_byid(int f_id);
	List<food> get_all_food();
	
	
}

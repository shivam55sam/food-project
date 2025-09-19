package com.test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

import com.dao.FoodImpl;
import com.model.food;

public class FoodTest {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		Scanner sc=new Scanner(System.in);
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		
		int foodId;
		int fQuantity; 
		String fName, fType, fCategory; 
		float fPrice;
		food f=new food();
		FoodImpl foodObj=new FoodImpl();
		List<food> l=new ArrayList<>();
		
		while(true)
		{
			System.out.println("1.add\n2.Update\n3.Delete\n4.search\n5.showAllData");
			System.out.println("Enter the choice");
			int choice=sc.nextInt();
			
			boolean b;
			switch (choice) {
			
			case 1:
				
				System.out.println("Enter the how many data you want to add");
				int num=sc.nextInt();
				for(int i=1; i<=num; i++) {
					System.out.println("Enter the food name");
					fName=br.readLine();
					System.out.println("Enter the food type");
					fType=br.readLine();
					System.out.println("Enter the categroy");
					fCategory=br.readLine();
					System.out.println("Enter the price  of the food");
					fPrice=sc.nextFloat();
					
					
					b=foodObj.add_food(new food(fName, fType, fCategory,fPrice));
					if (b) {
						System.out.println("successfully" +fName);
					}else {
						System.out.println("Failed");
					}
				}break;
				
			case 2:
				
				    System.out.println("ENTER THE FOOD ID");
				    foodId=sc.nextInt();
					System.out.println("Enter the food name");
					fName=br.readLine();
					System.out.println("Enter the food type");
					fType=br.readLine();
					System.out.println("Enter the categroy");
					fCategory=br.readLine();
					System.out.println("Enter the price  of the food");
					fPrice=sc.nextFloat();
					
					food food=new food(fName,fType,fCategory,fPrice);
					food.setF_id(foodId);System.out.println(food);
					b=foodObj.update_food_byid(food);
					
					
					if (b) {
						System.out.println("successfully update");
					}else {
						System.out.println("Failed");
					}
					
					
				break;
			case 3:
				System.out.println("Enter the foodId for delete :");
				foodId=sc.nextInt();
				b=foodObj.delete_food_byid(foodId);
				if(b) {
					System.out.println("deldete");
				}else {
					System.out.println("failed");
				}
				break;
				
				
				
			case 4:
				System.out.println("Enter the food id where you want serach");
				foodId =sc.nextInt();
				f=foodObj.get_food_byid(foodId);
				if(f!=null) {
					System.out.println(f);
				}else {
					System.out.println("not available");
				}
				break;
				
			case 5:
				System.out.println("show all data");
				l=foodObj.get_all_food();
				Iterator<food> it=l.iterator();
				while(it.hasNext()) {
					System.out.println(it.next());
				}
				break;
			}
			
			
		}
		
	}

}

package com.test;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

import com.dao.CartImpl;
import com.dao.FoodImpl;
import com.model.cart;
import com.model.food;

public class CartTest {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		
		int cartId,foodId,fQuantity;
		String cMail,fName;
		float fPrice,tPrice;
		boolean b;
		
		cart c=new cart();
		CartImpl cartObj=new CartImpl();
		List<cart>l=new ArrayList<>();
		
		while(true)
		{
			System.out.println("1.Add\n2.Update\n3.Delete\n4.Search\n5.Clear\n6.View Cart");
			System.out.println("Enter the choice: ");
			int choice=sc.nextInt();
			
			switch(choice)
			{
			case 1:
				
				System.out.println("Enter Food Id: ");
				foodId=sc.nextInt();
				System.out.println("Enter customer email: ");
				cMail=br.readLine();
				System.out.println("Enter Food Name: ");
				fName=br.readLine();
				System.out.println("Enter Food Price: ");
				fPrice=sc.nextFloat();
				System.out.println("Enter Food Quantity: ");
				fQuantity=sc.nextInt();
				System.out.println("Enter Total Sum of Amount: ");
				tPrice=sc.nextFloat();
				
				b=cartObj.add_tocart(new cart(foodId,cMail,fName,fPrice,fQuantity,tPrice));
				if(b)
				{
					System.out.println("Successfully "+foodId);
				}
				else
				{
					System.out.println("Failed");
				}
				break;
				
			case 2:
				
				System.out.println("Enter Cart Id:");
				cartId=sc.nextInt();
				System.out.println("Enter Food Id: ");
				foodId=sc.nextInt();
				System.out.println("Enter customer email: ");
				cMail=br.readLine();
				System.out.println("Enter Food Name: ");
				fName=br.readLine();
				System.out.println("Enter Food Price: ");
				fPrice=sc.nextFloat();
				System.out.println("Enter Food Quantity: ");
				fQuantity=sc.nextInt();
				System.out.println("Enter Total Sum of Amount: ");
				tPrice=sc.nextFloat();
				
				cart cart=new cart(foodId,cMail,fName,fPrice,fQuantity,tPrice);
				cart.setC_id(cartId);
				b=cartObj.update_cart(cart);
				if(b)
				{
					System.out.println("Successfully Update");
				}
				else
				{
					System.out.println("Failed");
				}
				break;
				
			case 3:
				System.out.println("Enter Cart Id for Delete:");
				cartId=sc.nextInt();
				
				b=cartObj.delete_cart(cartId);
				if(b)
				{
					System.out.println("Successfully Deleted ");
				}
				else
				{
					System.out.println("Failed");
				}
				break;
				
			case 4:
				System.out.println("Enter Food Id for Search: ");
				foodId=sc.nextInt();
				 c=cartObj.get_cart(foodId);
				 
				 if(c!=null)
					{
						System.out.println(c);
					}
					else
					{
						System.out.println("Not avilable");
					}
			break;
			
			case 5:
				System.out.println("Enter Email Id for delete: ");
				cMail=br.readLine();
				
				b=cartObj.clear_cart(cMail);
				if(b)
				{
					System.out.println("Successfully Deleted ");
				}
				else
				{
					System.out.println("Failed");
				}
				break;
				
			case 6:
				System.out.println("Enter Email Id to Show cart:");
				cMail=br.readLine();
				
				l=cartObj.show_cart(cMail);
				Iterator<cart>it=l.iterator();
				while(it.hasNext())
				{
					System.out.println(it.next());
				}
				break;
//			case 7:
//				System.exit(choice);
				
			}
		}

	}

}
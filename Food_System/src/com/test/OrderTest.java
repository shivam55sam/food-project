package com.test;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;
import com.dao.OrderImpl;
import com.model.orders;

public class OrderTest {
	public static void main(String[] args) {

		Scanner sc=new Scanner(System.in);
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		OrderImpl od=new OrderImpl();
		String emailId;


		int choice;
		while(true)
		{
		System.out.println("********Order********");
		System.out.println("1.Place Order\n2.Show Order\n3.Exit");
		System.out.println("Enter Choice: ");
		choice=sc.nextInt();

		switch(choice)
		{
		case 1:
			System.out.println("Enter An Exiting Email Id: ");
			emailId=sc.next();
			orders o=od.place_order(emailId);
			if(o!=null)
			{
				System.out.println(o);
			}
			else
			{
				System.out.println("Failed");
			}
			break;
		case 2:
			System.out.println("Show Orders:");
			List <orders>l=od.show_order();
			Iterator <orders>itr=l.iterator();
			while(itr.hasNext())
			{
				System.out.println(itr.next());
			}
		case 3:
		    System.exit(0);
		}
	}

	}

}

package com.test;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;
import com.dao.CustomerImpl;
import com.model.customer;



public class CustomerTest {
	public static void main(String[] args) throws Exception {

		Scanner sc=new Scanner(System.in);
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));

		int custId;
		String cName,cMail,cPassword,cAddress;
		Long cContact;
		boolean b;
	
		customer c=new customer();
		CustomerImpl custObj=new CustomerImpl();
		List<customer>l=new ArrayList<>();
		System.out.println("*************Customer Module*****************");
		System.out.println("1.Add\n2.Update\n3.Delete\n4.Search\n5.SearchAllCustomer ");
		System.out.println("Enter the choice: ");
		int choice=sc.nextInt();
		switch(choice)
		{
		case 1:
			System.out.println("Enter Your Name: ");
			cName=br.readLine();
			System.out.println("Enter Your Mail: ");
			cMail=br.readLine();
			System.out.println("Enter Your Password: ");
			cPassword=br.readLine();
			System.out.println("Enter Your Contact Number: ");
			cContact=sc.nextLong();
			System.out.println("Enter Your Address: ");
			cAddress=br.readLine();
			b=custObj.add_customer(new customer(cName,cMail,cPassword,cContact,cAddress));
			if(b)
			{
				System.out.println("Successfully "+cName);
			}
			else
			{
				System.out.println("Failed");
			}
			break;
		case 2:
			System.out.println("Enter Your Old Mail Id: ");
			cMail=br.readLine();
			System.out.println("Enter Your Name: ");
			cName=br.readLine();
			System.out.println("Enter Your Mail: ");
			cMail=br.readLine();
			System.out.println("Enter Your Password: ");
			cPassword=br.readLine();
			System.out.println("Enter Your Contact Number: ");
			cContact=sc.nextLong();	
			sc.nextLine();
			System.out.println("Enter Your Address: ");
			cAddress=br.readLine();
			customer customer=new customer(cName,cMail,cPassword,cContact,cAddress);
			customer.setC_email(cMail);
			b=custObj.update_customerbyemail(customer);
			if(b)
			{	
				System.out.println("Update Successfully ");
			}
			else
			{
				System.out.println("Failed");
			}
			break;
		case 3:
			System.out.println("Enter the Email Id for delete: ");
			cMail=br.readLine();
			b=custObj.delete_customerbyemail(cMail);
			if(b)
			{
				System.out.println("Delete Successfully ");
			}
			else
			{
				System.out.println("Failed");
			}
			break;
		case 4:
			System.out.println("Enter you Email Id: ");
			cMail=br.readLine();
			c=custObj.get_customerbyemail(cMail);
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
			System.out.println("Show All Customers");
			l=custObj.get_allcustomer();
			Iterator<customer>it=l.iterator();
			while(it.hasNext())
			{
				System.out.println(it.next());
			}
		}
	}
}

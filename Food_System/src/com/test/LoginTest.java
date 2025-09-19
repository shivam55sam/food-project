package com.test;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import com.dao.LoginImpl;
import com.model.admin;
import com.model.customer;



public class LoginTest {
	public static void main(String[] args) throws Exception {

		Scanner sc=new Scanner(System.in);
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		LoginImpl adObj=new LoginImpl();
		
		String emailId,password;
		System.out.println("1.User Login\n2.User Change Password\n3.Admin Login\n4.Admin Change Password");
		System.out.println("Enter Choice: ");
		int choice=sc.nextInt();
		switch(choice)
		{
		case 1:
			System.out.println("Enter you mail Id: ");
			emailId=br.readLine();
			System.out.println("Enter your Password: ");
			password=br.readLine();
			customer c=new customer(emailId,password);
			boolean b1=adObj.user_login(c);
			if(b1)
			{
				System.out.println("Login Sucessfully");
			}
			else
			{
				System.out.println("Login Failed");
			}
			break;
		case 2:

			System.out.println("Enter the existing emailId: ");
			emailId=br.readLine();
			System.out.println("Enter the new Password: ");
			password=br.readLine();
			customer c1=new customer(emailId,password);
			boolean b2=adObj.user_changepass(c1);
			if(b2)
			{
				System.out.println("Change Password Sucessfully");
			}
			else
			{
				System.out.println("Invalid mail Id");
			}
			break;
		case 3:
			System.out.println("Enter you emailId: ");
			emailId=br.readLine();
			System.out.println("Enter the new Password: ");
			password=br.readLine();
			admin a=new admin(emailId,password);
			boolean b3=adObj.admin_changepass(a);
			if(b3)
			{
				System.out.println("Login Sucessfully");
			}
			else
			{
				System.out.println("Login Failed");
			}
			break;
		case 4:
			System.out.println("Enter the existing emailId: ");
			emailId=br.readLine();
			System.out.println("Enter the new Password: ");
			password=br.readLine();
			admin a1=new admin(emailId,password);
			boolean b4=adObj.admin_changepass(a1);
			if(b4)
			{
				System.out.println("Change Password Sucessfully");
			}
			else
			{
				System.out.println("Invalid mail Id");
			}
			break;
		}
	}
}


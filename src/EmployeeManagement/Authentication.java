package EmployeeManagement;

import java.sql.*;
import java.util.Scanner;

public class Authentication {
	public static boolean checkUser() {
	    Scanner scan = new Scanner(System.in);
	    System.out.println("SELECT \n1.Login\n2.Register\n");
		int choice  = scan.nextInt();
		boolean temp= false;
		
		if(choice==1) {
			temp= login();
			return temp;
		}
		if(choice==2){
			temp = register();
			return temp;
		}
		return temp;	
	}
	public static boolean login() {
		Scanner scan = new Scanner(System.in);
		System.out.println("Enter UserName : ");
		String userName = scan.nextLine();
		System.out.println("Enter Password : ");
		String userPassword = scan.nextLine();
	
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/Employeemanagement","root","M1racle@123"); 
			String query = "select * from login_credentials where userName=? and userPassword=?";
			PreparedStatement ps = conn.prepareStatement(query);
			ps.setString(1, userName);
			ps.setString(2, userPassword);
			ResultSet rs = ps.executeQuery();
			//System.out.print(rs.getString(1)+" "+rs.getString(2));
			if(rs.isBeforeFirst()) {
				System.out.println("Login Successful..");
				return true;
			}
			else {
				System.out.println("Invalid UserName or Password");
				return false;
			}
		
		
		}
		catch(Exception e) {
			System.out.println("Enter valid Input");
			System.out.println(e.getMessage());
		}
		
		return false;
		
	}
	public static boolean register() {
		Scanner scan = new Scanner(System.in);
		System.out.println("Enter  Your UserName : ");
		String userName = scan.nextLine();
		System.out.println("Enter Your Password : ");
		String userPassword = scan.nextLine();
	
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/Employeemanagement","root","M1racle@123"); 
			String query = "insert into login_credentials values(?,?)";
			PreparedStatement ps = conn.prepareStatement(query);
			ps.setString(1, userName);
			ps.setString(2, userPassword);
			int i = ps.executeUpdate();
			if(i>=1) {
				System.out.println("user created Successfully");
				System.out.println("Do you want to login..\n1.Login\n------");
				int choice = scan.nextInt();
				if(choice==1) {
					boolean temp=login();
					return temp;
				}
				if(choice==2) {
					System.out.println("Thank you for using our services....");
					return false;
				}
			}
			else {
				System.out.println("Try again");
				return false;
			}
	
		
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return false;
		
		
	}
}

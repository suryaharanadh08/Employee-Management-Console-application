package EmployeeManagement;
import java.sql.*;
import java.util.Scanner;

public class AddUsers {
	public static void addUsers() {
		Scanner scan = new Scanner(System.in);
		System.out.println("Enter Employee ID : ");
		int e_id = scan.nextInt();
		System.out.println("Enter Employee Name: ");
		scan.nextLine();
		String e_name = scan.nextLine();
		System.out.println("Enter Employee Age: ");
		int e_age = scan.nextInt();
		System.out.println("Enter Employee Salary: ");
		int e_salary = scan.nextInt();
		System.out.println("Enter Employee Department: ");
		scan.nextLine();
		String e_dept = scan.nextLine();		
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/Employeemanagement","root","password"); 
			String query = "insert into employee_details values(?,?,?,?,?)";
			PreparedStatement ps = conn.prepareStatement(query);
			ps.setInt(1,e_id);
			ps.setString(2, e_name);
			ps.setInt(3, e_age);
			ps.setInt(4, e_salary);
			ps.setString(5, e_dept);
			int i = ps.executeUpdate();
			if(i>=1) {
				System.out.println(i+"Record inserted Successfully..");
			}
			else {
				System.out.println("Failed to insert...");
			}
		
		
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	}
	

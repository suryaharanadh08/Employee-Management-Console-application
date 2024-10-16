package EmployeeManagement;

import java.sql.*;
import java.util.Scanner;
public class UpdateUsers {
	public static void updateUsers() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/Employeemanagement","root","M1racle@123"); 
			Scanner scan = new Scanner(System.in);
			System.out.println("Enter the userName to update :");
			String e_name = scan.nextLine();
			System.out.println("Enter the salary to update :");
			int e_salary = scan.nextInt();
			System.out.println("Enter the department to update :");
			scan.nextLine();
			String e_dept = scan.nextLine();
			String query = "update employee_details set e_salary=?,e_dept=? where e_name=?";
			PreparedStatement ps = conn.prepareStatement(query);
			ps.setInt(1, e_salary);
			ps.setString(2, e_dept);
			ps.setString(3, e_name);
			int i = ps.executeUpdate();
			if(i>=1) {
				System.out.println(i+"Record modified Successfully..");
			}
			else {
				System.out.println("Failed to update...");
			}
		
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
	}

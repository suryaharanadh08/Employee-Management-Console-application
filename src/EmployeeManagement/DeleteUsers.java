package EmployeeManagement;

import java.sql.*;
import java.util.Scanner;

public class DeleteUsers {
	public static void deleteUsers() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/Employeemanagement","root","M1racle@123"); 
			Scanner scan = new Scanner(System.in);
			System.out.println("Enter the EMPLOYEE NAME to Delete his data ");
			String e_name = scan.nextLine();
			String query = "delete from employee_details where e_name=?";
			PreparedStatement ps = conn.prepareStatement(query);
			ps.setString(1,e_name);
			int i = ps.executeUpdate();
			if(i>=1) {
				System.out.println(i+" Record Deleted Successfully..");
			}
			else {
				System.out.println("Failed to Delete...");
			}
	
			
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
	}
}

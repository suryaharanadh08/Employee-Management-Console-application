package EmployeeManagement;
import java.sql.*;
import java.util.Scanner;
public class GetUserData {
		
	public static void getUserData() {
		Scanner scan = new Scanner(System.in);
		try {
	
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/Employeemanagement","root","password");
			String query = "select * from employee_details where e_name=?";
			System.out.println("Enter Employee Name to get his details : ");
			String e_name = scan.nextLine();
			PreparedStatement ps = conn.prepareStatement(query);
			ps.setString(1, e_name);
			ResultSet rs = ps.executeQuery();
			
			if(rs.isBeforeFirst()) {
				while(rs.next()) {
					System.out.println(rs.getInt(1)+"	"+rs.getString(2)+"	"+rs.getInt(3)+""+rs.getInt(4)+"	"+rs.getString(5));
				}
			}
			else {
				System.out.println("User not Found");
			}
		} 
		catch (Exception e) {
		
			e.printStackTrace();
		}
	}
}

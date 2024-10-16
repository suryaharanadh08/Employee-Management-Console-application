package EmployeeManagement;
import java.util.Scanner;
public class HomePage {
		public static void main(String args[]) {
			Scanner scan = new Scanner(System.in);
			System.out.println("WELCOME TO EMPLOYEE MANAGEMENT APPLICATION\n-----------------------------------------");
			boolean auth = Authentication.checkUser();
			boolean flag=true;
			int option=1;
			if(auth) {
				do{
				System.out.println("1.Add New Employee");
				System.out.println("2.Update Employee");
				System.out.println("3.Delete Employee ");
				System.out.println("4.Find an Employee");
				System.out.println("5.Logout");
				int choice = scan.nextInt();
				switch(choice){
					case 1:
						EmployeeManagement.AddUsers.addUsers(); 
						break;
					case 2:
						UpdateUsers.updateUsers();
						break;
					case 3:
						DeleteUsers.deleteUsers();
						break;
					case 4:
						GetUserData.getUserData();
						break;
					case 5:
						System.out.println("Logout Successfull...");
						option=2;
						break;
						
				}
				
				if(option!=2){
					System.out.println("\nEnter \n1.CONTINUE \n2.EXIT");
					option=scan.nextInt();
				}
				if(option==2)
						flag=false;
				}while(flag);
			}
			
			
	}
}

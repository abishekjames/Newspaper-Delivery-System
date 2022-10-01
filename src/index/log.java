package index;

import java.sql.ResultSet;
import java.util.Scanner;

import Customer.cCommandLine;
import Delivery_person.pCommandLine;
import Publication.puCommandLine;
import login.Login;
import login.MySQLAccess;
import login.lCommandLine;
import subscriptions.sCommandLine;

public class log {
	private static void index() {
		//Present Delivery_Person with Functionality Options
		
		System.out.println(" ");
		System.out.println("=============================================");
		System.out.println("Please Login Your Account:");
		System.out.println("1. Login existed Account");
		System.out.println("2. Create a Customer Account");
		System.out.println("99. Close");
		System.out.println("=============================================");
		System.out.println(" ");
		
	}
public static void main(String[] args) {
	//Create the Database Object
	
			try {
				

				
				// Configure System for Running
				Scanner keyboard = new Scanner(System.in); 
				String functionNumber = "-99";
				boolean keepAppOpen = true;
			
			
				while (keepAppOpen == true) {
				
					//Present list of functionality and get selection
					index();
					functionNumber = keyboard.next();
			
					switch (functionNumber) {
			
					case "1":
						MySQLAccess dao = new MySQLAccess();
						System.out.printf("Enter Login Username: \n");
						String Username = keyboard.next();
						System.out.printf("Enter Login Password: \n");
						String Password = keyboard.next();
						System.out.printf("Enter Position: \n");
						String Position = keyboard.next();
						
						ResultSet rs = dao.LoginAccount(Username, Password, Position);
						if(rs.next()) {
							if(Position.equals("Manager")) {
								Managerindex i =new Managerindex();
								i.show();
							}
							else if(Position.equals("Customer")) {
								Customerindex c =new Customerindex();
								c.main(args);
							}
						}
						
						break;
						
					case "2": 
						MySQLAccess dao2 = new MySQLAccess();
						//Get Login Details from the User
						System.out.printf("Enter Login Username: \n");
						String Username2 = keyboard.next();
						System.out.printf("Enter Login Password: \n");
						String Password2 = keyboard.next();
						
						
						Login loObj = new Login(Username2,Password2,"Customer");
					
						//Insert Login Details into the database
						boolean insertResult = dao2.insertLoginDetailsAccount(loObj);
						
						if (insertResult == true)
							System.out.println("Login Details Saved");
						else 
							System.out.println("ERROR: Login Details NOT Saved");
						break;
						
					case "99":
						keepAppOpen = false;
						System.out.println("Close");
						break;
				
					default:
						System.out.println("No Valid Function Selected");
						break;
					} // end switch
			
				}// end while
			
				//Tidy up Resources
				keyboard.close();
			
			}
		
			catch(Exception e) {
				System.out.println("PROGRAM TERMINATED - ERROR MESSAGE:" + e.getMessage());
			} // end try-catch
			
}
}

package index;

import java.util.Scanner;

import Customer.cCommandLine;
import Delivery_person.pCommandLine;
import Publication.puCommandLine;
import subscriptions.sCommandLine;

public class Customerindex {
	private static void index() {
		//Present Delivery_Person with Functionality Options
		
		System.out.println(" ");
		System.out.println("=========Welcome to the Customer Page=========");
		System.out.println("Please choose ONE of the following options:");
		System.out.println("1. Delivery_Person Account");
		System.out.println("2. Subscription Account");
		System.out.println("3. Customer Account");
		System.out.println("4. Publication Account");
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
						pCommandLine p = new pCommandLine();
						p.show();
						break;
						
					case "2": 
						sCommandLine s = new sCommandLine();
						s.show();
						break;
						
					case "3": 
						cCommandLine c = new cCommandLine();
						c.show();
						break;
						
					case "4": 
						puCommandLine pu = new puCommandLine();
						pu.show();
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

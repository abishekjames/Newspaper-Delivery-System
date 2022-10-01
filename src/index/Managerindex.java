package index;
import java.sql.ResultSet;
import java.util.Scanner;

import Customer.cCommandLine;
import Delivery_docket.tCommandLine;
import Delivery_person.*;
import Publication.puCommandLine;
import login.lCommandLine;
import subscriptions.*;

public class Managerindex {
	private static void index() {
			//Present Delivery_Person with Functionality Options
			
			System.out.println(" ");
			System.out.println("=========Welcome to the Manager Page=========");
			System.out.println("Please choose ONE of the following options:");
			System.out.println("1. Manage Delivery_Person Account");
			System.out.println("2. Manage Subscription Account");
			System.out.println("3. Manage Customer Account");
			System.out.println("4. Manage Publication ");
			System.out.println("5. Manage Delivery Docket ");
			System.out.println("6. Manage own login Account");
			System.out.println("99. Close");
			System.out.println("=============================================");
			System.out.println(" ");
			
		}
	public static void show() {
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
						case "5": 
							tCommandLine t = new tCommandLine();
							t.show();
							break;
						case "6": 
							lCommandLine l = new lCommandLine();
							l.show();
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

package Delivery_person;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.Scanner;

import index.Managerindex;

public class pCommandLine {
	
	private static void listDelivery_PersonFuctionalityAvailable() {
		
		//Present Delivery_Person with Functionality Options
		
		System.out.println(" ");
		System.out.println("=============================================");
		System.out.println("Please choose ONE of the following options:");
		System.out.println("1. Create Delivery_Person Account");
		System.out.println("2. View ALL Delivery_Person Records");
		System.out.println("3. Delete Delivery_Person Record by ID");
		System.out.println("99. Close the Delivery_Person Application");
		System.out.println("=============================================");
		System.out.println(" ");
		
	}

	
	private static boolean printDelivery_PersonTable(ResultSet rs) throws Exception {
		
		//Print The Contents of the Full Delivery_Person Table
		
		System.out.println("------------------------------------------------------------------------------------------------------------------------------------");
		System.out.println("Table: " + rs.getMetaData().getTableName(1));
		for (int i = 1; i <= rs.getMetaData().getColumnCount(); i++) {
			System.out.printf("%30s",rs.getMetaData().getColumnName(i));
		}
		System.out.println();
		while (rs.next()) {
			int id = rs.getInt("Delivery_person_id");
			String name = rs.getString("Name");
			String addr = rs.getString("Delivery_address");
			String phone = rs.getString("Contact_num");
			String area = rs.getString("Delivery_area");
			int hour = rs.getInt("Working_hours");
			String day_off=rs.getString("Day_Off");
			
			System.out.printf("%30s", id);
			System.out.printf("%30s", name);
			System.out.printf("%30s", addr);
			System.out.printf("%30s", phone);
			System.out.printf("%30s", area);
			System.out.printf("%30s", hour);
			System.out.printf("%30s", day_off);
			System.out.println();
		}// end while
		System.out.println("--------------------------------------------------------------------------------------------------------------------------------------");
		
		return true;
		
	}

	public void show() {
		
		//Create the Database Object
		
		try {
			
			MySQLAccess dao = new MySQLAccess();
		
			// Configure System for Running
			Scanner keyboard = new Scanner(System.in); 
			String functionNumber = "-99";
			boolean keepAppOpen = true;
		
			while (keepAppOpen == true) {
			
				//Present list of functionality and get selection
				listDelivery_PersonFuctionalityAvailable();
				functionNumber = keyboard.next();
		
				switch (functionNumber) {
		
				case "1":
					//Get Delivery_Person Details from the User
					System.out.printf("Enter Delivery_Person Name: \n");
					String DeliName = keyboard.next();
					System.out.printf("Enter Delivery_Person Address: \n");
					String DeliAddr = keyboard.next();
					System.out.printf("Enter Delivery_Person PhoneNumber: \n");
					String DeliPhoneNumber = keyboard.next();
					System.out.printf("Enter Delivery Area: \n");
					String DeliArea = keyboard.next();
					System.out.printf("Enter Delivery_Person Working Hours: \n");
					int Hour = keyboard.nextInt();
					System.out.printf("Enter Delivery Day_off: \n");
					String DeliDay_off = keyboard.next();
					
					Delivery_person deliObj = new Delivery_person(DeliName,DeliAddr,DeliPhoneNumber,DeliArea,Hour,DeliDay_off);
				
					//Insert Delivery_Person Details into the database
					boolean insertResult = dao.insertDelivery_PersonDetailsAccount(deliObj);
					if (insertResult == true)
						System.out.println("Delivery_Person Details Saved");
					else 
						System.out.println("ERROR: Delivery_Person Details NOT Saved");
					break;
					
				case "2": 
					//Retrieve ALL Delivery_Person Records
					ResultSet rSet = dao.retrieveAllDelivery_PersonDetailsAccounts();
					if (rSet == null) {
						System.out.println("No Records Found");
						break;
					}
					else {
						boolean tablePrinted = printDelivery_PersonTable(rSet);
						if (tablePrinted == true)
							rSet.close();
					}
					break;
					
				case "3":
					//Delete Delivery_Person Record by ID
					System.out.println("Enter Delivery_Person Id to be deleted or -99 to Clear all Rows");
					String deleteCustId = keyboard.next();
					boolean deleteResult = dao.deleteDelivery_PersonDetailsById(Integer.parseInt(deleteCustId));
					if ((deleteResult == true) && (deleteCustId.equals("-99")))
						System.out.println("Delivery_Person Table Emptied");
					else if (deleteResult == true)
						System.out.println("Delivery_Person Deleted");
					else 
						System.out.println("ERROR: Delivery_Person Details NOT Deleted or Do Not Exist");
					break;
			
				case "99":
					keepAppOpen = false;
					Managerindex i= new Managerindex();
					i.show();
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
		

	} // end main
	
	
}
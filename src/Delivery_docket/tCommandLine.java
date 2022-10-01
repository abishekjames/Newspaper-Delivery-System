package Delivery_docket;

import java.sql.Connection;
import java.sql.ResultSet;
import java.util.Scanner;

import index.Managerindex;

public class tCommandLine {
	
	private static void listDeliveryDocketFuctionalityAvailable() {
		
		//Present Delivery Docket with Functionality Options
		
		System.out.println(" ");
		System.out.println("=============================================");
		System.out.println("Please choose ONE of the following options:");
		System.out.println("1. Create Delivery Docket Account");
		System.out.println("2. View ALL Delivery Docket Records");
		System.out.println("3. Delete Delivery Docket Record by ID");
		System.out.println("99.Close the NewsAgent Application");
		System.out.println("=============================================");
		System.out.println(" ");
		
	}

	
	private static boolean printDeliveryDocketTable(ResultSet rs) throws Exception {
		
		//Print The Contents of the Full Delivery Docket Table
		
		System.out.println("------------------------------------------------------------------------------------------------------------------------------------");
		System.out.println("Table: " + rs.getMetaData().getTableName(1));
		for (int i = 1; i <= rs.getMetaData().getColumnCount(); i++) {
			System.out.printf("%30s",rs.getMetaData().getColumnName(i));
		}
		System.out.println();
		while (rs.next()) {
			String docketID = String.valueOf(rs.getInt("docketID"));
			String custId = String.valueOf(rs.getInt("custId"));
			String delvid = String.valueOf(rs.getInt("delvid"));
			String address = rs.getString("address");
			String phoneNumber = rs.getString("phoneNumber");
			String deliveryArea = rs.getString("deliveryArea");
			String type = rs.getString("type");
			String time = rs.getString("time");

		
			System.out.printf("%30s", docketID);
			System.out.printf("%30s", custId);
			System.out.printf("%30s", delvid);
			System.out.printf("%30s", address);
			System.out.printf("%30s", phoneNumber);
			System.out.printf("%30s", deliveryArea);
			System.out.printf("%30s", type);
			System.out.printf("%30s", time);
			System.out.println();
		}// end while
		System.out.println("--------------------------------------------------------------------------------------------------------------------------------------");
		
		return true;
		
	}

	public static void show() {
		
		//Create the Database Object
		
		try {
			
			MySQLAccess dao = new MySQLAccess();
		
			// Configure System for Running
			Scanner keyboard = new Scanner(System.in); 
			String functionNumber = "-99";
			boolean keepAppOpen = true;
		
			while (keepAppOpen == true) {
			
				//Present list of functionality and get selection
				listDeliveryDocketFuctionalityAvailable();
				functionNumber = keyboard.next();
		
				switch (functionNumber) {
		
				case "1":
					//Get Delivery Docket Details from the User
					System.out.printf("Enter Delivery person Id: \n");
					int delvid = keyboard.nextInt();
					System.out.printf("Enter DeliveryDocket Id: \n");
					int custId = keyboard.nextInt();
					System.out.printf("Enter DeliveryDocket address: \n");
					String address = keyboard.next();
					System.out.printf("Enter DeliveryDocket PhoneNumber: \n");
					String phoneNumber = keyboard.next();
					System.out.printf("Enter DeliveryDocket area: \n");
					String deliveryArea = keyboard.next();
					System.out.printf("Enter Delivery type: \n");
					String type = keyboard.next();
					System.out.printf("Enter DeliveryDocket time: \n");
					String time = keyboard.next();
					
					DeliveryDocket docketObj = new DeliveryDocket(custId,custId,address,phoneNumber,deliveryArea,type,time);
				
					//Insert DeliveryDocket Details into the database
					boolean insertResult = dao.insertDeliveryDocketDetailsAccount(docketObj);
					if (insertResult == true)
						System.out.println("Delivery Docket Details Saved");
					else 
						System.out.println("ERROR: Delivery Docket Details NOT Saved");
					break;
					
				case "2": 
					//Retrieve ALL DeliveryDocket Records
					ResultSet rSet = dao.retrieveAllDeliveryDocketAccounts();
					if (rSet == null) {
						System.out.println("No Records Found");
						break;
					}
					else {
						boolean tablePrinted = printDeliveryDocketTable(rSet);
						if (tablePrinted == true)
							rSet.close();
					}
					break;
					
				case "3":
					//Delete DeliveryDocket Record by ID
					System.out.println("Enter Delivery Docket Id to be deleted or -99 to Clear all Rows");
					String deletedocketID = keyboard.next();
					boolean deleteResult = dao.deleteDeliveryDocketById(Integer.parseInt(deletedocketID));
					if ((deleteResult == true) && (deletedocketID.equals("-99")))
						System.out.println("Delivery Docket Table Emptied");
					else if (deleteResult == true)
						System.out.println("Delivery Docket Deleted");
					else 
						System.out.println("ERROR: Delivery Docket Details NOT Deleted or Do Not Exist");
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
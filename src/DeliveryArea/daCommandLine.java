package DeliveryArea;

import java.beans.Customizer;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.Scanner;


public class daCommandLine {
	
	private static void listDeliveryAreaFuctionalityAvailable() {
		
		//Present DeliveryArea with Functionality Options
		
		System.out.println(" ");
		System.out.println("=============================================");
		System.out.println("Please choose ONE of the following options:");
		System.out.println("1. Create Delivery Area");
		System.out.println("2. View ALL Delivery Area");
		System.out.println("3. Delete Delivery Area Record by ID");
		System.out.println("99.Close the NewsAgent Application");
		System.out.println("=============================================");
		System.out.println(" ");
		
	}

	
	private static boolean printDeliveryAreaTable(ResultSet rs) throws Exception {
		
		//Print The Contents of the Full DeliveryArea Table
		
		System.out.println("------------------------------------------------------------------------------------------------------------------------------------");
		System.out.println("Table: " + rs.getMetaData().getTableName(1));
		for (int i = 1; i <= rs.getMetaData().getColumnCount(); i++) {
			System.out.printf("%30s",rs.getMetaData().getColumnName(i));
		}
		System.out.println();
		while (rs.next()) {
			String deliveryArea = rs.getString("deliveryArea");
			int delvid = rs.getInt("delvid");

			System.out.printf("%30s", deliveryArea);
			System.out.printf("%30s", delvid);
		
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
				listDeliveryAreaFuctionalityAvailable();
				functionNumber = keyboard.next();
		
				switch (functionNumber) {
		
				case "1":
					//Get DeliveryArea Details from the User
					System.out.printf("Enter delivery Area: \n");
					String deliveryArea = keyboard.next();
					System.out.printf("Enter delivery person Id: \n");
					int delvid = keyboard.nextInt();
			
					
					DeliveryArea daObj = new DeliveryArea(delvid,deliveryArea);
				
					//Insert DeliveryArea Details into the database
					boolean insertResult = dao.insertDeliveryAreaDetailsAccount(daObj);
					if (insertResult == true)
						System.out.println("DeliveryArea Details Saved");
					else 
						System.out.println("ERROR: DeliveryArea Details NOT Saved");
					break;
					
				case "2": 
					//Retrieve ALL DeliveryArea Records
					ResultSet rSet = dao.retrieveAllDeliveryAreaAccounts();
					if (rSet == null) {
						System.out.println("No Records Found");
						break;
					}
					else {
						boolean tablePrinted = printDeliveryAreaTable(rSet);
						if (tablePrinted == true)
							rSet.close();
					}
					break;
					
				case "3":
					//Delete DeliveryArea Record by ID
					System.out.println("Enter DeliveryArea Id to be deleted or -99 to Clear all Rows");
					String deleteCustId = keyboard.next();
					boolean deleteResult = dao.deleteDeliveryAreaById(Integer.parseInt(deleteCustId));
					if ((deleteResult == true) && (deleteCustId.equals("-99")))
						System.out.println("DeliveryArea Table Emptied");
					else if (deleteResult == true)
						System.out.println("DeliveryArea Deleted");
					else 
						System.out.println("ERROR: DeliveryArea Details NOT Deleted or Do Not Exist");
					break;
			
				case "99":
					keepAppOpen = false;
					System.out.println("Closing the Application");
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
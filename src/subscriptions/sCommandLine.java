package subscriptions;

import java.sql.ResultSet;
import java.util.Scanner;

import index.Managerindex;

public class sCommandLine {
private static void listSubscriptionFuctionalityAvailable() {
		
		//Present Subscription with Functionality Options
		
		System.out.println(" ");
		System.out.println("=============================================");
		System.out.println("Please choose ONE of the following options:");
		System.out.println("1. Create Subscription Account");
		System.out.println("2. View ALL Subscription Records");
		System.out.println("3. Delete Subscription Record by ID");
		System.out.println("99. Close the Subscription Application");
		System.out.println("=============================================");
		System.out.println(" ");
		
	}
private static boolean printSubsciptionTable(ResultSet rs) throws Exception {
	
	//Print The Contents of the Full Subscription Table
	
	System.out.println("------------------------------------------------------------------------------------------------------------------------------------");
	System.out.println("Table: " + rs.getMetaData().getTableName(1));
	for (int i = 1; i <= rs.getMetaData().getColumnCount(); i++) {
		System.out.printf("%30s",rs.getMetaData().getColumnName(i));
	}
	System.out.println();
	while (rs.next()) {
		String custId = rs.getString("Subscription_id");
		String subId = rs.getString("Customer_id");
		double subPrice = rs.getDouble("Price");
		String subState = rs.getString("State");
		String subType = rs.getString("Type");
		String subDate = rs.getString("Date");
		
		System.out.printf("%30s", custId);
		System.out.printf("%30s", subId);
		System.out.printf("%30s", subPrice);
		System.out.printf("%30s", subState);
		System.out.printf("%30s", subType);
		System.out.printf("%30s", subDate);
		System.out.println();
	}// end while
	System.out.println("--------------------------------------------------------------------------------------------------------------------------------------");
	
	return true;
}
public void show() {
	
	//Create the Database Object
	
	try {
		
		MySqlAccess dao = new MySqlAccess();
	
		// Configure System for Running
		Scanner keyboard = new Scanner(System.in); 
		String functionNumber = "-99";
		boolean keepAppOpen = true;
	
		while (keepAppOpen == true) {
		
			//Present list of functionality and get selection
			listSubscriptionFuctionalityAvailable();
			functionNumber = keyboard.next();
	
			switch (functionNumber) {
	
			case "1":
				//Get Subscription Details from the User
				
				System.out.printf("Enter Customer id: \n");
				String custId = keyboard.next();
				System.out.printf("Enter Subscription price: \n");
				double subPrice = keyboard.nextDouble();
				System.out.printf("Enter Subscription state: \n");
				String subState = keyboard.next();
				System.out.printf("Enter Subscription type: \n");
				String subType = keyboard.next();
				System.out.printf("Enter Subscription date: \n");
				String subDate = keyboard.next();
				
			
				Subscription subObj = new Subscription(Integer.valueOf(custId),subPrice,subState,subType,subDate);
				//Insert Customer Details into the database
				boolean insertResult = dao.insertSubscriptionDetailsAccount(subObj);
				if (insertResult == true)
					System.out.println("Subscription Details Saved");
				else 
					System.out.println("ERROR: Subscription Details NOT Saved");
				break;
			case "2": 
				//Retrieve ALL Subscription Records
				ResultSet rSet = dao.retrieveAllSubscriptionAccounts();
				if (rSet == null) {
					System.out.println("No Records Found");
					break;
				}
				else {
					boolean tablePrinted = printSubsciptionTable(rSet);
					if (tablePrinted == true)
						rSet.close();
				}
				break;
				
			case "3":
				//Delete Subscription Record by ID
				System.out.println("Enter Subscription Id to be deleted or -99 to Clear all Rows");
				String deleteCustId = keyboard.next();
				boolean deleteResult = dao.deleteSubscriptionById(deleteCustId);
				if ((deleteResult == true) && (deleteCustId.equals("-99")))
					System.out.println("Subscription Table Emptied");
				else if (deleteResult == true)
					System.out.println("Subscription Deleted");
				else 
					System.out.println("ERROR: Subscription Details NOT Deleted or Do Not Exist");
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

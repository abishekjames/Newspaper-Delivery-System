package Customer;

import java.sql.Connection;
import java.sql.ResultSet;
import java.util.Scanner;

import index.Managerindex;

public class cCommandLine {
	
	private static void listCustomerFuctionalityAvailable() {
		
		//Present Customer with Functionality Options
		
		System.out.println(" ");
		System.out.println("=============================================");
		System.out.println("Please choose ONE of the following options:");
		System.out.println("1. Create Customer Account");
		System.out.println("2. View ALL Customer Records");
		System.out.println("3. Delete Customer Record by ID");
		System.out.println("99.Close the NewsAgent Application");
		System.out.println("=============================================");
		System.out.println(" ");
		
	}

	
	private static boolean printCustomerTable(ResultSet rs) throws Exception {
		
		//Print The Contents of the Full Customer Table
		
		System.out.println("------------------------------------------------------------------------------------------------------------------------------------");
		System.out.println("Table: " + rs.getMetaData().getTableName(1));
		for (int i = 1; i <= rs.getMetaData().getColumnCount(); i++) {
			System.out.printf("%30s",rs.getMetaData().getColumnName(i));
		}
		System.out.println();
		while (rs.next()) {
			int id = rs.getInt("Customer_id");
			String name = rs.getString("Name");
			String addr = rs.getString("Address");
			String phone = rs.getString("Contact_num");
			String area = rs.getString("Delivery_area");
			System.out.printf("%30s", id);
			System.out.printf("%30s", name);
			System.out.printf("%30s", addr);
			System.out.printf("%30s", phone);
			System.out.printf("%30s", area);
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
				listCustomerFuctionalityAvailable();
				functionNumber = keyboard.next();
		
				switch (functionNumber) {
		
				case "1":
					//Get Customer Details from the User
					System.out.printf("Enter Customer Name: \n");
					String custName = keyboard.next();
					System.out.printf("Enter Customer Address: \n");
					String custAddr = keyboard.next();
					System.out.printf("Enter Customer PhoneNumber: \n");
					String custphoneNumber = keyboard.next();
					System.out.printf("Enter Customer Area: \n");
					String custArea = keyboard.next();
					
					Customer custObj = new Customer(custName,custAddr,custphoneNumber,custArea);
				
					//Insert Customer Details into the database
					boolean insertResult = dao.insertCustomerDetailsAccount(custObj);
					if (insertResult == true)
						System.out.println("Customer Details Saved");
					else 
						System.out.println("ERROR: Customer Details NOT Saved");
					break;
					
				case "2": 
					//Retrieve ALL Customer Records
					ResultSet rSet = dao.retrieveAllCustomerAccounts();
					if (rSet == null) {
						System.out.println("No Records Found");
						break;
					}
					else {
						boolean tablePrinted = printCustomerTable(rSet);
						if (tablePrinted == true)
							rSet.close();
					}
					break;
					
				case "3":
					//Delete Customer Record by ID
					System.out.println("Enter Customer Id to be deleted or -99 to Clear all Rows");
					String deleteCustId = keyboard.next();
					boolean deleteResult = dao.deleteCustomerById(Integer.parseInt(deleteCustId));
					if ((deleteResult == true) && (deleteCustId.equals("-99")))
						System.out.println("Customer Table Emptied");
					else if (deleteResult == true)
						System.out.println("Customer Deleted");
					else 
						System.out.println("ERROR: Customer Details NOT Deleted or Do Not Exist");
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
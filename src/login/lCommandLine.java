package login;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.Scanner;

import index.Managerindex;

public class lCommandLine {
	
	private static void listLoginFuctionalityAvailable() {
		
		//Present Login with Functionality Options
		
		System.out.println(" ");
		System.out.println("=============================================");
		System.out.println("Please choose ONE of the following options:");
		System.out.println("2. View ALL Login Records");
		System.out.println("3. Delete Login Customer Record by ID");
		System.out.println("99. Close the Login Application");
		System.out.println("=============================================");
		System.out.println(" ");
		
	}

	
	private static boolean printLoginTable(ResultSet rs) throws Exception {
		
		//Print The Contents of the Full Login Table
		
		System.out.println("------------------------------------------------------------------------------------------------------------------------------------");
		System.out.println("Table: " + rs.getMetaData().getTableName(1));
		for (int i = 1; i <= rs.getMetaData().getColumnCount(); i++) {
			System.out.printf("%30s",rs.getMetaData().getColumnName(i));
		}
		System.out.println();
		while (rs.next()) {
			int id = rs.getInt("id");
			String username = rs.getString("Username");
			String password = rs.getString("Password");
			String position = rs.getString("Position");
			
			
			System.out.printf("%30s", id);
			System.out.printf("%30s", username);
			System.out.printf("%30s", password);
			System.out.printf("%30s", position);
			
		
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
				listLoginFuctionalityAvailable();
				functionNumber = keyboard.next();
		
				switch (functionNumber) {
		
					
				case "2": 
					//Retrieve ALL Login Records
					ResultSet rSet = dao.retrieveAllLoginDetailsAccounts();
					if (rSet == null) {
						System.out.println("No Records Found");
						break;
					}
					else {
						boolean tablePrinted = printLoginTable(rSet);
						if (tablePrinted == true)
							rSet.close();
					}
					break;
					
				case "3":
					//Delete Login Record by ID
					System.out.println("Enter Login Id to be deleted or -99 to Clear all Rows");
					String deleteCustId = keyboard.next();
					boolean deleteResult = dao.deleteLoginDetailsById(Integer.parseInt(deleteCustId));
					if ((deleteResult == true) && (deleteCustId.equals("-99")))
						System.out.println("Login Customer Table Emptied");
					else if (deleteResult == true)
						System.out.println("Login Customer Deleted");
					else 
						System.out.println("ERROR: Login Customer Details NOT Deleted or Do Not Exist");
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
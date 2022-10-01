package Publication;
import java.sql.ResultSet;
import java.util.Scanner;

import index.Managerindex;

public class puCommandLine {
	
	private static void listPublicationFuctionalityAvailable() {
		
		
		
		System.out.println(" ");
		System.out.println("=============================================");
		System.out.println("Please choose ONE of the following options:");
		System.out.println("1. Add Product Name");
		System.out.println("2. View ALL Product list");
		System.out.println("3. Delete Product Items by ID");
		System.out.println("99. Close the NewsAgent Application");
		System.out.println("=============================================");
		System.out.println(" ");
		
	}

	
	private static boolean printPublicationTable(ResultSet rs) throws Exception {
		
		//Print The Contents of the Full Product Table
		
		System.out.println("------------------------------------------------------------------------------------------------------------------------------------");
		System.out.println("Table: " + rs.getMetaData().getTableName(1));
		for (int i = 1; i <= rs.getMetaData().getColumnCount(); i++) {
			System.out.printf("%30s",rs.getMetaData().getColumnName(i));
		}
		System.out.println();
		while (rs.next()) {
			String id = rs.getString("pub_id");
			String name = rs.getString("pub_name");
			double price = rs.getDouble("price");
			String details = rs.getString("details");
			String message = rs.getString("message");
			
			System.out.printf("%30s", id);
			System.out.printf("%30s", name);
			System.out.printf("%30s", price);
			System.out.printf("%30s", details);
			System.out.printf("%30s", message);
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
				listPublicationFuctionalityAvailable();
				functionNumber = keyboard.next();
		
				switch (functionNumber) {
		
				case "1":
					//Get Product Details from the User
					System.out.printf("Enter Product Name: \n");
					String prodName = keyboard.next();
					System.out.printf("Enter Product Price: \n");
					double prodPrice = keyboard.nextDouble();
					System.out.printf("Enter Product Details: \n");
					String prodDetails = keyboard.next();
					System.out.printf("Enter Product Message: \n");
					String prodMessage = keyboard.next();
					
				
					Publication pubObj = new Publication(prodName, prodPrice, prodDetails,  prodMessage);
				
					//Add Product Details into the database
					boolean insertResult = dao.insertPublicationDetails(pubObj);
					if (insertResult == true)
						System.out.println("Product Details Saved");
					else 
						System.out.println("ERROR: Product Details NOT Saved");
					break;
					
				case "2": 
					//Retrieve ALL Product Records
					ResultSet rSet = dao.retrieveAllProductDetails();
					if (rSet == null) {
						System.out.println("No Records Found");
						break;
					}
					else {
						boolean tablePrinted = printPublicationTable(rSet);
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
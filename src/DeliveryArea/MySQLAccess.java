package DeliveryArea;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.sql.ResultSet;


public class MySQLAccess {
	
	private Connection connect = null;
	private Statement statement = null;
	private PreparedStatement preparedStatement = null;
	private ResultSet resultSet = null;
	
	final private String host ="localhost:3306";
	final private String user = "root";
	final private String password = "123456";
	
	
	public MySQLAccess() throws Exception {
		
		try {
			
			//Load MySQL Driver
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			//Setup the connection with the DB
			connect = DriverManager.getConnection("jdbc:mysql://" + host + "/newspaper?serverTimezone=UTC", user, password);
		}
		catch (Exception e) {
			throw e;
		}
		
		
	}	

	public boolean insertDeliveryAreaDetailsAccount(DeliveryArea c) {
	
		boolean insertSucessfull = true;
	
		//Add Code here to call embedded SQL to insert Customer into DB
	
		try {
		
			//Create prepared statement to issue SQL query to the database
			preparedStatement = connect.prepareStatement("insert into newspaper.delivery_area values (?, ?)");
	
			preparedStatement.setString(1, c.getDeliveryArea());
			preparedStatement.setInt(2, c.getDelvid());

			preparedStatement.executeUpdate();
		
	 
		}
		catch (Exception e) {
			insertSucessfull = false;
		}
	
		return insertSucessfull;
		
	}// end insertCustomerDetailsAccount

	public ResultSet retrieveAllDeliveryAreaAccounts() {
		
		//Add Code here to call embedded SQL to view Customer Details
	
		try {
			statement = connect.createStatement();
			resultSet = statement.executeQuery("Select * from newspaper.delivery_area");
		
		}
		catch (Exception e) {
			resultSet = null;
		}
		return resultSet;
	}
	
	public boolean deleteDeliveryAreaById(int DeliID) {

		boolean deleteSucessfull = true;
		
		//Add Code here to call embedded SQL to insert Customer into DB
		
		try {
			
			//Create prepared statement to issue SQL query to the database
			if (DeliID == -99)
				//Delete all entries in Table
				preparedStatement = connect.prepareStatement("delete from newspaper.delivery_area");
			else
				//Delete a particular Customer
				preparedStatement = connect.prepareStatement("delete from newspaper.delivery_area where delvid = " + DeliID);
				preparedStatement.executeUpdate();
		 
		}
		catch (Exception e) {
			deleteSucessfull = false;
		}
		
		return deleteSucessfull;
		
	}


}// end Class


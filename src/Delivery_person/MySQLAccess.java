package Delivery_person;
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

	public boolean insertDelivery_PersonDetailsAccount(Delivery_person c) {
	
		boolean insertSucessfull = true;
	
		//Add Code here to call embedded SQL to insert Customer into DB
	
		try {
		
			//Create prepared statement to issue SQL query to the database
			preparedStatement = connect.prepareStatement("insert into newspaper.delivery_person values (default, ?, ?, ?, ?, ?, ?)");
	
			preparedStatement.setString(1, c.getName());
			preparedStatement.setString(2, c.getAddress());
			preparedStatement.setString(3, c.getContact());
			preparedStatement.setString(4, c.getArea());
			preparedStatement.setInt(5, c.getHour());
			preparedStatement.setString(6, c.getDay_off());
			preparedStatement.executeUpdate();
		
	 
		}
		catch (Exception e) {
			insertSucessfull = false;
		}
	
		return insertSucessfull;
		
	}// end insertCustomerDetailsAccount

	public ResultSet retrieveAllDelivery_PersonDetailsAccounts() {
		
		//Add Code here to call embedded SQL to view Customer Details
	
		try {
			statement = connect.createStatement();
			resultSet = statement.executeQuery("Select * from newspaper.delivery_person");
		
		}
		catch (Exception e) {
			resultSet = null;
		}
		return resultSet;
	}
	
	public boolean deleteDelivery_PersonDetailsById(int DeliID) {

		boolean deleteSucessfull = true;
		
		//Add Code here to call embedded SQL to insert Customer into DB
		
		try {
			
			//Create prepared statement to issue SQL query to the database
			if (DeliID == -99)
				//Delete all entries in Table
				preparedStatement = connect.prepareStatement("delete from newspaper.delivery_person");
			else
				//Delete a particular Customer
				preparedStatement = connect.prepareStatement("delete from newspaper.delivery_person where Delivery_person_id = " + DeliID);
				preparedStatement.executeUpdate();
		 
		}
		catch (Exception e) {
			deleteSucessfull = false;
		}
		
		return deleteSucessfull;
		
	}


}// end Class


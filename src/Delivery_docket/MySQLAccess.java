package Delivery_docket;

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

	public boolean insertDeliveryDocketDetailsAccount(DeliveryDocket c) {
	
		boolean insertSucessfull = true;
	
		//Add Code here to call embedded SQL to insert deliverydocket into DB
	
		try {
		
			//Create prepared statement to issue SQL query to the database
			preparedStatement = connect.prepareStatement("insert into newspaper.deliverydocket values (default, ?, ?, ?, ?, ?, ?, ?)");
			preparedStatement.setInt(1, c.getCustid());
			preparedStatement.setInt(2, c.getDelvid());
			preparedStatement.setString(3, c.getAddress());
			preparedStatement.setString(4, c.getPhoneNumber());
			preparedStatement.setString(5, c.getDeliveryArea());
			preparedStatement.setString(6, c.getType());
			preparedStatement.setString(7, c.getTime());
			preparedStatement.executeUpdate();
		
	 
		}
		catch (Exception e) {
			insertSucessfull = false;
		}
	
		return insertSucessfull;
		
	}// end insertdeliverydocketDetailsAccount

	public ResultSet retrieveAllDeliveryDocketAccounts() {
		
		//Add Code here to call embedded SQL to view deliverydocket Details
	
		try {
			statement = connect.createStatement();
			resultSet = statement.executeQuery("Select * from newspaper.deliverydocket");
		
		}
		catch (Exception e) {
			resultSet = null;
		}
		return resultSet;
	}
	
	public boolean deleteDeliveryDocketById(int docketID) {

		boolean deleteSucessfull = true;
		
		//Add Code here to call embedded SQL to insert deliverydocket into DB
		
		try {
			
			//Create prepared statement to issue SQL query to the database
			if (docketID == -99)
				//Delete all entries in Table
				preparedStatement = connect.prepareStatement("delete from newspaper.deliverydocket");
			else
				//Delete a particular deliverydocket
				preparedStatement = connect.prepareStatement("delete from newspaper.deliverydocket where docketID = " + docketID);
			preparedStatement.executeUpdate();
		 
		}
		catch (Exception e) {
			deleteSucessfull = false;
		}
		
		return deleteSucessfull;
		
	}


}// end Class


package subscriptions;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.sql.ResultSet;


public class MySqlAccess {
	
	private Connection connect = null;
	private Statement statement = null;
	private PreparedStatement preparedStatement = null;
	private ResultSet resultSet = null;
	
	final private String host ="localhost:3306";
	final private String user = "root";
	final private String password = "123456";
	
	
	public MySqlAccess() throws Exception {
		
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

	public boolean insertSubscriptionDetailsAccount(Subscription c) {
	
		boolean insertSucessfull = true;
	
		//Add Code here to call embedded SQL to insert Customer into DB
	
		try {
		
			//Create prepared statement to issue SQL query to the database
			preparedStatement = connect.prepareStatement("insert into newspaper.subscriptions values (default ,? , ?, ?, ? ,? )");
			preparedStatement.setInt(1, c.getcustId());
			preparedStatement.setString(2, c.getsubType());
			preparedStatement.setDouble(3, c.getPrice());
			preparedStatement.setString(4, c.getsubState());
			preparedStatement.setString(5, c.getsubDate());
			preparedStatement.executeUpdate();
		
	 
		}
		catch (Exception e) {
			insertSucessfull = false;
		}
	
		return insertSucessfull;
		
	}// end insertSubscriptionDetailsAccount

	public ResultSet retrieveAllSubscriptionAccounts() {
		
		//Add Code here to call embedded SQL to view Subscription Details
	
		try {
			statement = connect.createStatement();
			resultSet = statement.executeQuery("Select * from newspaper.subscriptions");
		
		}
		catch (Exception e) {
			resultSet = null;
		}
		return resultSet;
	}
	
	public boolean deleteSubscriptionById(String subId) {

		boolean deleteSucessfull = true;
		
		//Add Code here to call embedded SQL to insert Customer into DB
		
		try {
			
			//Create prepared statement to issue SQL query to the database
			if (subId.equals("-99"))
				//Delete all entries in Table
				preparedStatement = connect.prepareStatement("delete from newspaper.subscriptions");
			else
				//Delete a particular Customer
				preparedStatement = connect.prepareStatement("delete from newspaper.subscriptions where Subscription_id ='" + subId+"'");
				preparedStatement.executeUpdate();
		 
		}
		catch (Exception e) {
			deleteSucessfull = false;
		}
		
		return deleteSucessfull;
		
	}
}// end Class

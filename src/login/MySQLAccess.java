package login;
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

	public boolean insertLoginDetailsAccount(Login c) {
	
		boolean insertSucessfull = true;
	
		//Add Code here to call embedded SQL to insert Customer into DB
	
		try {
		
			//Create prepared statement to issue SQL query to the database
			preparedStatement = connect.prepareStatement("insert into newspaper.login values (default, ?, ?, 'Customer')");
	
			preparedStatement.setString(1, c.getUsername());
			preparedStatement.setString(2, c.getPassword());
			
			preparedStatement.executeUpdate();
		
	 
		}
		catch (Exception e) {
			insertSucessfull = false;
		}
	
		return insertSucessfull;
		
	}// end insertCustomerDetailsAccount

	public ResultSet retrieveAllLoginDetailsAccounts() {
		
		//Add Code here to call embedded SQL to view Customer Details
	
		try {
			statement = connect.createStatement();
			resultSet = statement.executeQuery("Select * from newspaper.login");
		
		}
		catch (Exception e) {
			resultSet = null;
		}
		return resultSet;
	}

	public ResultSet retrieveSpecifiedLoginDetailsAccounts(String na) {
		
		//Add Code here to call embedded SQL to view Customer Details
	
		try {
			statement = connect.createStatement();
			resultSet = statement.executeQuery("Select * from newspaper.login where username='"+na+"'");
		
		}
		catch (Exception e) {
			resultSet = null;
		}
		return resultSet;
	}
	
	public ResultSet LoginAccount(String n, String p, String po) {
		
		//Add Code here to call embedded SQL to view Customer Details
		
		try {
			statement = connect.createStatement();
			String sql ="Select * from newspaper.login where username = '"+n+"' and password = '"+p+"' and position = '"+po+"'";
			resultSet = statement.executeQuery(sql);
			
		}
		catch (Exception e) {
			resultSet = null;
		}
		return resultSet;
	}

	public boolean deleteLoginDetailsById(int LogID) {

		boolean deleteSucessfull = true;
		
		//Add Code here to call embedded SQL to insert Customer into DB
		
		try {
			
			//Create prepared statement to issue SQL query to the database
			if (LogID == -99)
				//Delete all entries in Table
				preparedStatement = connect.prepareStatement("delete from newspaper.login where position = 'customer' ");
			else
				//Delete a particular Customer
				preparedStatement = connect.prepareStatement("delete from newspaper.login where id = " + LogID);
				preparedStatement.executeUpdate();
		 
		}
		catch (Exception e) {
			deleteSucessfull = false;
		}
		
		return deleteSucessfull;
		
	}


}// end Class


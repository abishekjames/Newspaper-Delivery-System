package Publication;
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
			connect = DriverManager.getConnection("jdbc:mysql://" + host + "/newspaper?serverTimezone=UTC",user,password);
		}
		catch (Exception e) {
			throw e;
		}
		
		
	}	

	public boolean insertPublicationDetails(Publication p) {
		boolean insertSucessful = true;
	
		try {
		
			//Create prepared statement to issue SQL query to the database
			preparedStatement = connect.prepareStatement("insert into newspaper.publication values (default, ?, ?, ?, ?)");
			preparedStatement.setString(1, p.getName());
			preparedStatement.setDouble(2, p.getPrice());
			preparedStatement.setString(3, p.getDetails());
			preparedStatement.setString(4, p.getMessage());
			preparedStatement.executeUpdate();
		
	 
		}
		catch (Exception e) {
			e.printStackTrace();
			insertSucessful = false;
		}
	
		return insertSucessful;
		
	}// end add product

	public ResultSet retrieveAllProductDetails() {
		
		//Add Code here to call embedded SQL to view Customer Details
	
		try {
			statement = connect.createStatement();
			resultSet = statement.executeQuery("Select * from newspaper.publication");
		
		}
		catch (Exception e) {
			resultSet = null;
		}
		return resultSet;
	}
	
	public boolean deleteProductById(String prodID) {

		boolean deleteSucessful = true;
		
		
		try {
			
			//Create prepared statement to issue SQL query to the database
			if (prodID.equals("-99"))
				//Delete all entries in Table
				preparedStatement = connect.prepareStatement("delete from newspaper.publication");
			else
				//Delete a particular Customer
				preparedStatement = connect.prepareStatement("delete from newspaper.publication where id = " + prodID);
			preparedStatement.executeUpdate();
		 
		}
		catch (Exception e) {
			deleteSucessful = false;
		}
		
		return deleteSucessful;
		
	}

	public boolean deleteCustomerById(int pubId) {
		boolean deleteSucessfull = true;
		
		//Add Code here to call embedded SQL to insert Customer into DB
		
		try {
			
			//Create prepared statement to issue SQL query to the database
			if (pubId == -99)
				//Delete all entries in Table
				preparedStatement = connect.prepareStatement("delete from newspaper.publication");
			else
				//Delete a particular Customer
				preparedStatement = connect.prepareStatement("delete from newspaper.publication where pub_id = " + pubId);
			preparedStatement.executeUpdate();
		 
		}
		catch (Exception e) {
			deleteSucessfull = false;
		}
		
		return deleteSucessfull;
	}

	


}// end Class


package login;

import Delivery_person.Delivery_personExceptionHandler;

public class Login {
	private int login_id;
	private String username;
	private String password;
	private String position;

	public int getLogin_id() {
		return login_id;
	}

	public String getUsername() {
		return username;
	} 

	public void setUsername(String user) throws LoginExceptionHandler {
		try {
			validateUsername(user);
		}
		catch (LoginExceptionHandler e) {
			throw new LoginExceptionHandler("Fail to update username");
		}
		username = user;
	}


	public String getPassword() {
		return password;
	}

	public void setPassword(String ps) throws LoginExceptionHandler {
		try {
			validatePassword(ps);
		}
		catch (LoginExceptionHandler e) {
			throw new LoginExceptionHandler("Fail to update password");
		}
		password = ps;
	}


	public String getPosition() {
		return position;
	}

	public void setPosition(String po) throws LoginExceptionHandler {
		try {
			validatePassword(po);
		}
		catch (LoginExceptionHandler e) {
			throw new LoginExceptionHandler("Fail to update position");
		}
		position = po;
	}
	
	public Login(String user, String ps, String po) throws LoginExceptionHandler {
		
		login_id=0;
		// Validate Input
		try {
	
			validateUsername(user);
			validatePassword(ps);
			validatePosition(po);
		
		}
		catch (LoginExceptionHandler e) {
			throw new LoginExceptionHandler("Fail to create a new account");
		}
		
		// Set Attributes
		username=user;
		password=ps;
		position=po;
		
	}
	
	static void validateUsername(String n) throws LoginExceptionHandler {
		// TODO Auto-generated method stub
		if (n.isBlank() || n.isEmpty())
			throw new LoginExceptionHandler("LOG_in name NOT specified");
		else if (n.length()<8){
			throw new LoginExceptionHandler("LOG_in name does not meet minimum length requirements");
		}
		else if (n.length()>20){
			throw new LoginExceptionHandler("LOG_in name exceeds max length requirements");
		}
	}

	public static void validatePassword(String ps) throws LoginExceptionHandler {
		
		//Agree Formating Rules on "Delivery Person Name"
		//E.G. Name String must be a minimum of 2 characters and a maximum of 50 characters
		
		if (ps.isBlank() || ps.isEmpty())
			throw new LoginExceptionHandler("LOG_in password NOT specified");
		else if (ps.length() < 12)
			throw new LoginExceptionHandler("LOG_in password does not meet minimum length requirements");
		else if (ps.length() > 24)
			throw new LoginExceptionHandler("LOG_in password exceeds maximum length requirements");
		
	}
	
	static void validatePosition(String po) throws LoginExceptionHandler {
		// TODO Auto-generated method stub
		if (po.isBlank() || po.isEmpty())
			throw new LoginExceptionHandler("LOG_in position NOT specified");
		else if (!(po.equals("Manger")||po.equals("Customer")))
			throw new LoginExceptionHandler("LOG_in position does not meet requirements");
	}


}




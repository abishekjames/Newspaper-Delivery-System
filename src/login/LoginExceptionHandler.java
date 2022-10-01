package login;

public class LoginExceptionHandler extends Exception {
	String message;
	
	public LoginExceptionHandler(String errMessage){
		message = errMessage;
	}
	
	public String getMessage() {
		return message;
	}
}
 
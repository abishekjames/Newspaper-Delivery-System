package Delivery_person;

public class Delivery_personExceptionHandler extends Exception {
	String message;
	
	public Delivery_personExceptionHandler(String errMessage){
		message = errMessage;
	}
	
	public String getMessage() {
		return message;
	}
}

package Delivery_docket;

public class DeliveryDocketExceptionHandler extends Exception {
	
	String message;
	
	public DeliveryDocketExceptionHandler(String errMessage){
		message = errMessage;
	}
	
	public String getMessage() {
		return message;
	}
}

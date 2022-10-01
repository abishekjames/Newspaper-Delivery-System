package DeliveryArea;

public class DeliveryAreaExceptionHandler extends Exception  {
	String message;
	
	public DeliveryAreaExceptionHandler(String errMessage){
		message = errMessage;
	}
	
	public String getMessage() {
		return message;
	}
}

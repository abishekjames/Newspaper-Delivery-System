package subscriptions;

public class SubscriptionExceptionHandler extends Exception {


String message;
	
	public  SubscriptionExceptionHandler(String errMessage){
		message = errMessage;
	}
	
	public String getMessage() {
		return message;
	}
}



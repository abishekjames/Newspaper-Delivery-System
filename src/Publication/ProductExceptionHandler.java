package Publication;
public class ProductExceptionHandler extends Exception {

	String message;
	
	public ProductExceptionHandler(String errMessage){
		message = errMessage;
	}
	
	public String getMessage() {
		return message;
	}

}

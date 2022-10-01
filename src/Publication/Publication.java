package Publication;
public class Publication {
	
	private int id;
	private String name;
	private double price;
	private String details;
	private String message;
	
	void setID(int prodID) {
		id = prodID;
	}
	void setName(String prodName) {
		name = prodName;
	}
	
	void setPrice(double prodPrice) {
		price = prodPrice;
	}
	
	void setDetails(String prodDetails) {
		details = prodDetails;
	}
	
	void setMessage(String prodMessage) {
		message = prodMessage;
	}
	
	int getID() {
		return id;
	}
	
	String getName() {
		return name;
	}
	
	double getPrice() {
		return price;
	}
	
	String getDetails() {
		return details;
	}
	
	String getMessage() {
		return message;
	}
	
	public Publication(String prodName, double prodPrice, String prodDetails, String prodMessage) throws ProductExceptionHandler  {
		
		
		// Validate Input
		try {
		
			validateName(prodName);
			validatePrice(prodPrice);
			validateDetails(prodDetails);
			validateMessage(prodMessage);

			
		}
		catch (ProductExceptionHandler e) {
			throw e;
		}
		
		// Set Attributes
	
		name = prodName;
		price = prodPrice;
		details = prodDetails;
		message = prodMessage;
	}
	
	public static void validateName(String prodName) throws ProductExceptionHandler {
		
		 //Agree Formating Rules on "Product Name"
		//Name String must be a minimum of 3 characters and a maximum of 15 characters
		
		if (prodName.isBlank() || prodName.isEmpty())
			throw new ProductExceptionHandler("Product Name NOT specified");
		else if (prodName.length() < 3)
			throw new ProductExceptionHandler("Product Name does not meet minimum length requirements");
		else if (prodName.length() > 15)
			throw new ProductExceptionHandler("Product Name does not exceeds maximum length requirements");
		
	}
	
	public static void validatePrice(double prodPrice) throws ProductExceptionHandler {
		
		//Agree Formating Rules on "Product Price"
		//Price  must be greater than 0 
		
		
		if (prodPrice < 0.00001)
			throw new ProductExceptionHandler("Product Price does not meet the valid requirements");
		
		
	}

	
	
	public static void validateDetails(String prodDetails) throws ProductExceptionHandler {
		
		 //Agree Formating Rules on "Product Details"
		//Name String must be a minimum of 5 characters and a maximum of 40 characters
		
		if (prodDetails.isBlank() || prodDetails.isEmpty())
			throw new ProductExceptionHandler("Product Details NOT specified");
		else if (prodDetails.length() < 5)
			throw new ProductExceptionHandler("Product Details does not meet minimum length requirements");
		else if (prodDetails.length() > 40)
			throw new ProductExceptionHandler("Product Details does not exceeds maximum length requirements");
		
	}
	
	public static void validateMessage(String prodMessage) throws ProductExceptionHandler {
		
		 //Agree Formating Rules on "Product Details"
		//Name String must be a minimum of 5 characters and a maximum of 15 characters
		
		if (prodMessage.isBlank() || prodMessage.isEmpty())
			throw new ProductExceptionHandler("Product Message NOT specified");
		else if (prodMessage.length() < 5)
			throw new ProductExceptionHandler("Product Message does not meet minimum length requirements");
		else if (prodMessage.length() > 15)
			throw new ProductExceptionHandler("Product Message does not exceeds maximum length requirements");
		
	}
	
	
	

	public void updateprodName(String prodName) throws ProductExceptionHandler {
		
		 try {
			 validateName(prodName);
			 name=prodName;
		 }
		 catch(ProductExceptionHandler e) {
			 throw new ProductExceptionHandler("Fail to update product name");
		 }
		
	}
	public void updateprodPrice(double prodPrice) throws ProductExceptionHandler {
		
		 try {
			 validatePrice(prodPrice);
			 price=prodPrice;
		 }
		 catch(ProductExceptionHandler e) {
			 throw new ProductExceptionHandler("Fail to update product price");
		 }
		
	}
	public void updateprodDetails(String prodDetails) throws ProductExceptionHandler {
		
		 try {
			 validateDetails(prodDetails);
			 details=prodDetails;
		 }
		 catch(ProductExceptionHandler e) {
			 throw new ProductExceptionHandler("Fail to update product details");
		 }
		
	}
	public void updateprodMessage(String prodMessage) throws ProductExceptionHandler {
		
		 try {
			 validateMessage(prodMessage);
			 message=prodMessage;
		 }
		 catch(ProductExceptionHandler e) {
			 throw new ProductExceptionHandler("Fail to update product message");
		 }
		
	}
}

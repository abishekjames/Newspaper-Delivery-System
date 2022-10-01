package subscriptions;

import Delivery_person.Delivery_personExceptionHandler;

public class Subscription {
	
	private int custid;
	private String subid;
	private double price;
	private String stateofsub;
	private String typeofsub;
	private String dateofsub;
	
	void setCustId(int custId) {
		custid = custId;
	}
	
	void setSubId(String subId) {
	      subid = subId;
	}
	void setPrice(double subPrice) {
	      price = subPrice;
	}
	
	void setState(String subState) {
		stateofsub=subState;
	}
	void setType(String subType) {
		typeofsub=subType;
	}
	void setDate(String subDate) {
		dateofsub=subDate;
	}
	int getcustId() {
		return custid;
	}
	
	String getSubId() {
		return subid;
	}
	
	double getPrice() {
		return price;
	}
	
	String getsubState() {
		return stateofsub;
	}
	String getsubType() {
		return typeofsub;
	}
	String getsubDate() {
		return dateofsub;
	}
	public Subscription(int custId2,double subPrice,String subState,String subType,String subDate) throws 	SubscriptionExceptionHandler  {
		
		// Validate Input
		try {
			validatecustId(custId2);
			validatesubState(subState);
			validatePrice(subPrice);
			validatesubType(subType);
			validatesubDate(subDate);
			
		}
		catch (	SubscriptionExceptionHandler e) {
			throw e;
		}
		
		// Set Attributes
		custid = custId2;
		price=subPrice;
		stateofsub=subState;
	    typeofsub=subType; 
	    dateofsub=subDate;
	}
 


public static void validatecustId(int custId) throws SubscriptionExceptionHandler {
		
		//Agree Formating Rules on "Subscription Id"
		//E.G. Name String must be a minimum of 4 characters and a maximum of 8 characters
		if (custId<=0)
			throw new SubscriptionExceptionHandler("Customer Id is unreasonable");
		
	}
	

public static void validatesubId(String subId) throws SubscriptionExceptionHandler {
		
		//Agree Formating Rules on "Subscription Id"
		//E.G. Name String must be a minimum of 5 characters and a maximum of 10 characters
		
		if (subId.isBlank() || subId.isEmpty())
			throw new SubscriptionExceptionHandler("Subscription Id NOT specified");
		else if (subId.length() < 2)
			throw new SubscriptionExceptionHandler("Subscription Id does not meet minimum length requirements");
		else if (subId.length() > 40)
			throw new SubscriptionExceptionHandler("Subscription Id does not exceeds maximum length requirements");
		
	}
	
	public static void validatePrice(double Price) throws SubscriptionExceptionHandler {
		
		//Agree Formating Rules on "Price"
		//E.G. Id  must be a minimum of 3 characters and a maximum of 8 integer
		
		if (Price < 0.00001)
			throw new SubscriptionExceptionHandler("Price does not meet minimum requirements");
		
		
	}


	public static void validatesubState(String subState) throws SubscriptionExceptionHandler {
	
	//Agree Formating Rules on "state of Subscription"
			//E.G.  String must be a minimum of 3 characters and a maximum of 10 characters
			System.out.print(subState);
			if (subState.isBlank() || subState.isEmpty())
				throw new SubscriptionExceptionHandler("subState NOT specified");
			else if (subState.length() < 3)
				throw new SubscriptionExceptionHandler("subState does not meet minimum length requirements");
			else if (subState.length() > 45)
				throw new SubscriptionExceptionHandler("subState exceeds maximum length requirements");	
}
	public static void validatesubType(String subType) throws SubscriptionExceptionHandler {
		
		//Agree Formating Rules on "type of Subscription"
				//E.G.  String must be a minimum of 3 characters and a maximum of 10 characters
				
				if (subType.isBlank() || subType.isEmpty())
					throw new SubscriptionExceptionHandler("subType NOT specified");
				else if (subType.length() < 2)
					throw new SubscriptionExceptionHandler("subType does not meet minimum length requirements");
				else if (subType.length() > 45)
					throw new SubscriptionExceptionHandler("subType does not exceeds maximum length requirements");	
	}
  public static void validatesubDate(String subDate) throws SubscriptionExceptionHandler {
		
		//Agree Formating Rules on "Date of Subscription"
				//E.G.  String must be a minimum of 0 characters and a maximum of 10 characters
				
				if (subDate.isBlank() || subDate.isEmpty())
					throw new SubscriptionExceptionHandler("subDate NOT specified");
				else if (subDate.length() < 0)
					throw new SubscriptionExceptionHandler("subDate does not meet minimum length requirements");
				else if (subDate.length() > 11)
					throw new SubscriptionExceptionHandler("subDate does not exceeds maximum length requirements");	
	}
  public void modifysubId(String subId) throws SubscriptionExceptionHandler {
		try {
			validatesubId(subId);
		}
		catch (SubscriptionExceptionHandler e) {
			throw new SubscriptionExceptionHandler("Fail to modify subId");
		}
		this.subid = subId;
	}
  
  public void modifysubPrice(double subPrice) throws SubscriptionExceptionHandler {
		try {
			validatePrice(subPrice);
		}
		catch (SubscriptionExceptionHandler e) {
			throw new SubscriptionExceptionHandler("Fail to modify price");
		}
		this.price = subPrice;
	}
  
  public void modifysubState(String subState) throws SubscriptionExceptionHandler {
		try {
			validatesubState(subState);
		}
		catch (SubscriptionExceptionHandler e) {
			throw new SubscriptionExceptionHandler("Fail to modify subState");
		}
		this.stateofsub = subState;
	}
 
  public void modifysubType(String subType) throws SubscriptionExceptionHandler {
		try {
			validatesubType(subType);
		}
		catch (SubscriptionExceptionHandler e) {
			throw new SubscriptionExceptionHandler("Fail to modify subType");
		}
		this.typeofsub = subType;
	}
  
  public void modifysubDate(String subDate) throws SubscriptionExceptionHandler {
		try {
			validatesubDate(subDate);
		}
		catch (SubscriptionExceptionHandler e) {
			throw new SubscriptionExceptionHandler("Fail to modify subDate");
		}
		this.dateofsub = subDate;
	}
}






		


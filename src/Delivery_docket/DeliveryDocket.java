package Delivery_docket;


public class DeliveryDocket {
	private int docketID;

	private int custId;
	private int delvid;
	private String address;
	private String phoneNumber;
	private String deliveryArea;
	private String type;
	private String time;
	
	public int getDocketID() {
		return docketID;
	}

	public void setDocketID(int docketID) {
		this.docketID = docketID;
	}
	public int getCustid() {
		return custId;
	}

	public void setCustid(int Custid) {
		custId = Custid;
	}

	public int getDelvid() {
		return delvid;
	}

	public void setDelvid(int Delvid) {
		delvid = Delvid;
	}




	public String getAddress() {
		return address;
	}

	public void setAddress(String Address) throws DeliveryDocketExceptionHandler {
		try {
			validateAddress(Address);
		}
		catch (DeliveryDocketExceptionHandler e) {
			throw e;
		}
		address = Address;
		
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String PhoneNumber) throws DeliveryDocketExceptionHandler {
		try {
			validatePhoneNumber(PhoneNumber);
		}
		catch (DeliveryDocketExceptionHandler e) {
			throw e;
		}
	
		phoneNumber = PhoneNumber;
	}

	public String getDeliveryArea() {
		return deliveryArea;
	}

	public void setDeliveryArea(String DeliveryArea) {
		deliveryArea = DeliveryArea;
	}



	public String getType() {
		return type;
	}

	public void setType(String Type) {
		type = Type;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String Time) {
		time = Time;
	}


	
	
	public DeliveryDocket(int CustId, int Delvid, String Address,String PhoneNumber,String Deliveryarea,String Type,String Time) throws DeliveryDocketExceptionHandler  {
		
		docketID = 0;
		
		// Validate Input
		try {
			validateCustID(CustId);
			validateDelvID(Delvid);
			validateAddress(Address);
			validatePhoneNumber(PhoneNumber);
			validateDeliveryArea(Deliveryarea);
			validateTime(Time);
			
		}
		catch (DeliveryDocketExceptionHandler e) {
			throw e;
		}
		
		// Set Attributes
		custId=CustId;
		delvid =Delvid;
		address = Address;
		phoneNumber = PhoneNumber;
		deliveryArea= Deliveryarea;
		type= Type;
		time = Time;
		
		
	}
	
	public static void validateCustID(int custId2) throws DeliveryDocketExceptionHandler {
		
		//Agree Formating Rules on "DeliveryDocket Name"
		//E.G. Name String must be a minimum of 2 characters and a maximum of 50 characters
		
		if (custId2<0.000001)
			throw new DeliveryDocketExceptionHandler("CustomerID NOT specified");
		
	}
	
	public static void validateAddress(String address) throws DeliveryDocketExceptionHandler {
		
		//Agree Formating Rules on "DeliveryDocket Address"
		//E.G. Name String must be a minimum of 5 characters and a maximum of 60 characters
		
		if (address.isBlank() || address.isEmpty())
			throw new DeliveryDocketExceptionHandler("deliveryArea Address NOT specified");
		else if (address.length() <4)
			throw new DeliveryDocketExceptionHandler("deliveryArea Address does not meet minimum length requirements");
		else if (address.length() > 60)
			throw new DeliveryDocketExceptionHandler("deliveryArea Address exceeds maximum length requirements");
		
	}
	
	public static void validatePhoneNumber(String phoneNumber) throws DeliveryDocketExceptionHandler {
		
		//Agree Formating Rules on "DeliveryDocket PhoneNumber"
		//E.G. Name String must be a minimum of 7 characters and a maximum of 15 characters
		
		if (phoneNumber.isBlank() || phoneNumber.isEmpty())
			throw new DeliveryDocketExceptionHandler("Customer PhoneNumber NOT specified");
		else if (phoneNumber.length() < 7)
			throw new DeliveryDocketExceptionHandler("Customer PhoneNumber does not meet minimum length requirements");
		else if (phoneNumber.length() > 15)
			throw new DeliveryDocketExceptionHandler("Customer PhoneNumber exceeds maximum length requirements");
		
	}
	
	public static void validateDelvID(int delvid2) throws DeliveryDocketExceptionHandler {
		
		//Agree Formating Rules on "DeliveryDocket Name"
		//E.G. Name String must be a minimum of 2 characters and a maximum of 50 characters

		if (delvid2<0.000001)
			throw new DeliveryDocketExceptionHandler("DelvID NOT specified");
		
		
	}
	
		public static void validateDeliveryArea(String deliveryArea) throws DeliveryDocketExceptionHandler {
		
		//Agree Formating Rules on "DeliveryDocket Address"
		//E.G. Name String must be a minimum of 5 characters and a maximum of 60 characters
		
		if (deliveryArea.isBlank() || deliveryArea.isEmpty())
			throw new DeliveryDocketExceptionHandler("deliveryArea NOT specified");
		else if (deliveryArea.length() < 3)
			throw new DeliveryDocketExceptionHandler("deliveryArea does not meet minimum length requirements");
		else if (deliveryArea.length() > 50)
			throw new DeliveryDocketExceptionHandler("deliveryArea exceeds maximum length requirements");
		
	}
		public static void validateDeliveryperson(String deliveryPerson) throws DeliveryDocketExceptionHandler {
			
			//Agree Formating Rules on "DeliveryDocket Address"
			//E.G. Name String must be a minimum of 5 characters and a maximum of 60 characters
			
			if (deliveryPerson.isBlank() || deliveryPerson.isEmpty())
				throw new DeliveryDocketExceptionHandler("deliveryPerson NOT specified");
			else if (deliveryPerson.length() < 2)
				throw new DeliveryDocketExceptionHandler("deliveryPerson does not meet minimum length requirements");
			else if (deliveryPerson.length() > 20)
				throw new DeliveryDocketExceptionHandler("deliveryPerson exceeds maximum length requirements");
			
		}
		public static void validateType(String type) throws DeliveryDocketExceptionHandler {
			
			//Agree Formating Rules on "DeliveryDocket Address"
			//E.G. Name String must be a minimum of 5 characters and a maximum of 60 characters
			
			if (type.isBlank() || type.isEmpty())
				throw new DeliveryDocketExceptionHandler("type NOT specified");
			else if (type.length() < 5)
				throw new DeliveryDocketExceptionHandler("delivery type does not meet minimum length requirements");
			else if (type.length() > 20)
				throw new DeliveryDocketExceptionHandler("delivery type exceeds maximum length requirements");
			
		}
		public static void validateTime(String time) throws DeliveryDocketExceptionHandler {
			
			//Agree Formating Rules on "DeliveryDocket Address"
			//E.G. Name String must be a minimum of 5 characters and a maximum of 60 characters
			
			if (time.isBlank() || time.isEmpty())
				throw new DeliveryDocketExceptionHandler("time NOT specified");
			else if (time.length() < 5)
				throw new DeliveryDocketExceptionHandler("time does not meet minimum length requirements");
			else if (time.length() > 15)
				throw new DeliveryDocketExceptionHandler("time exceeds maximum length requirements");
			
		}

		
	
	

}

package Customer;


public class Customer {
	private int Customer_Id;
	private String Customer_Name;
	private String Customer_Address;
	private String Customer_Contact;
	private String Area;
	
	public int getCustomer_Id() {
		return Customer_Id;
	}

	public String getCustomer_Name() {
		return Customer_Name;
	}

	public void updateCustomer_Name(String Customer_Name) throws CustomerExceptionHandler {
		try {
			validateCustomer_Name(Customer_Name);
		}
		catch (CustomerExceptionHandler e) {
			throw new CustomerExceptionHandler("Fail to update Name");
		}
		this.Customer_Name = Customer_Name;
	}

	public String getCustomer_Address() {
		return Customer_Address;
	}

	public void updateCustomer_Address(String customer_Address) throws CustomerExceptionHandler {
		try {
			validateCustomer_Address(customer_Address);
		}
		catch (CustomerExceptionHandler e) {
			throw new CustomerExceptionHandler("Fail to update Address");
		}
		Customer_Address = customer_Address;
	}

	
	public String getCustomer_Contact() {
		return Customer_Contact;
	}

	public void updateCustomer_Contact(String customer_Contact) throws CustomerExceptionHandler {
		try {
			validateCustomer_Contact(customer_Contact);
		}
		catch (CustomerExceptionHandler e) {
			throw new CustomerExceptionHandler("Fail to update ContactNumber");
		}
		Customer_Contact = customer_Contact;
	}
	
	public String getArea() {
		return Area;
	}
	
	public void updateArea(String area) throws CustomerExceptionHandler {
		try {
			validateArea(area);
		}
		catch (CustomerExceptionHandler e) {
			throw new CustomerExceptionHandler("Fail to update area");
		}
		this.Area = area;
	}
		
	public Customer(String name, String add, String pho,String area) throws CustomerExceptionHandler {
		
		Customer_Id=0;
		// Validate Input
		try {
	
			validateCustomer_Name(name);
			validateCustomer_Address(add);
			validateCustomer_Contact(pho);
			validateArea(area);

		}
		catch (CustomerExceptionHandler e) {
			throw e;
		}
		
		// update Attributes
		Customer_Name=name;
		Customer_Address=add;
		Customer_Contact=pho;
		Area=area;
	
	}
	
	public static void validateCustomer_Name(String name) throws CustomerExceptionHandler {
		//Agree Formating Rules on "Customer Name"
		//E.G. Name String must be a minimum of 2 characters and a maximum of 50 characters
		
		
		if (name.isBlank() || name.isEmpty())
			throw new CustomerExceptionHandler("Customer Name NOT specified");
		else if (name.length() < 2)
			throw new CustomerExceptionHandler("Customer Name does not meet minimum length requirements");
		else if (name.length() > 20)
			throw new CustomerExceptionHandler("Customer Name does not exceeds maximum length requirements");
	}

	public static void validateCustomer_Address(String address) throws CustomerExceptionHandler {
		//Agree Formating Rules on "Customer Address"
		//E.G. Name String must be a minimum of 5 characters and a maximum of 60 characters
				
		if (address.isBlank() || address.isEmpty())
			throw new CustomerExceptionHandler("Customer Address NOT specified");
		else if (address.length() < 2)
			throw new CustomerExceptionHandler("Customer Address does not meet minimum length requirements");
		else if (address.length() > 40)
			throw new CustomerExceptionHandler("Customer Address does not exceeds maximum length requirements");
		
	}
	
	public static void validateCustomer_Contact(String pho) throws CustomerExceptionHandler {
		
		//Agree Formating Rules on "Customer ContactNumber"
		//E.G. Name String must be a minimum of 7 characters and a maximum of 15 characters
				
		if (pho.isBlank() || pho.isEmpty())
			throw new CustomerExceptionHandler("Customer ContactNumber NOT specified");
		else if (pho.length() < 7)
			throw new CustomerExceptionHandler("Customer ContactNumber does not meet minimum length requirements");
		else if (pho.length() > 15)
			throw new CustomerExceptionHandler("Customer ContactNumber does not exceeds maximum length requirements");
				
	}
	

	public static void validateArea(String area) throws CustomerExceptionHandler {
		
		//Agree Formating Rules on "Delivery Area"
		
		if (area.isBlank() || area.isEmpty())
			throw new CustomerExceptionHandler("Customer Area NOT specified");
		else if (area.length() < 2)
			throw new CustomerExceptionHandler("Customer Area does not meet minimum length requirements");
		else if (area.length() > 20)
			throw new CustomerExceptionHandler("Customer Area does not exceeds maximum length requirements");
		
	}
	
	
	
	public String viewCus() {
		return Customer_Name+" "+Customer_Address+" "+Customer_Contact+" "+Area;
			
	}
		

}




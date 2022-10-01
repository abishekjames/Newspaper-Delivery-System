package Delivery_person;

public class Delivery_person {
	private int delivery_person_id;
	private String name;
	private String address;
	private String Contact;
	private String area;
	private int hour;
	private String day_off;
	public String getDay_off() {
		return day_off;
	}

	public void updateDay_off(String day_off) throws Delivery_personExceptionHandler {
		try {
			validateDay_off(day_off);
		}
		catch (Delivery_personExceptionHandler e) {
			throw new Delivery_personExceptionHandler("Fail to update Day_off");
		}
		this.day_off = day_off;
	}

	public int getDelivery_person_id() {
		return delivery_person_id;
	}
	
	public String getName() {
		return name;
	}
	
	public void updateName(String name) throws Delivery_personExceptionHandler {
		try {
			validateName(name);
		}
		catch (Delivery_personExceptionHandler e) {
			throw new Delivery_personExceptionHandler("Fail to update name");
		}
		this.name = name;
	}
	
	public String getAddress() {
		return address;
	}
	
	public void updateAddress(String address) throws Delivery_personExceptionHandler {
		try {
			validateAddress(address);
		}
		catch (Delivery_personExceptionHandler e) {
			throw new Delivery_personExceptionHandler("Fail to update address");
		}
		this.address = address;
	}
	
	public String getContact() {
		return Contact;
	}
	
	public void updateContact(String Contact) throws Delivery_personExceptionHandler {
		try {
			validateContactNumber(Contact);
		}
		catch (Delivery_personExceptionHandler e) {
			throw new Delivery_personExceptionHandler("Fail to update ContactNumber");
		}
		this.Contact = Contact;
	}
	
	public String getArea() {
		return area;
	}
	
	public void updateArea(String area) throws Delivery_personExceptionHandler {
		try {
			validateArea(area);
		}
		catch (Delivery_personExceptionHandler e) {
			throw new Delivery_personExceptionHandler("Fail to update area");
		}
		this.area = area;
	}
	
	public int getHour() {
		return hour;
	}
	
	public void updateHour(int hour) throws Delivery_personExceptionHandler {
		try {
			validateWorkhours(hour);
		}
		catch (Delivery_personExceptionHandler e) {
			throw new Delivery_personExceptionHandler("Fail to update Workhours");
		}
		this.hour = hour;
	}
	
	public Delivery_person(String na, String add, String pho,String darea, int dhour, String day) throws Delivery_personExceptionHandler {
		
		delivery_person_id=0;
		// Validate Input
		try {
	
			validateName(na);
			validateAddress(add);
			validateContactNumber(pho);
			validateArea(darea);
			validateWorkhours(dhour);
			validateDay_off(day);
			
		}
		catch (Delivery_personExceptionHandler e) {
			throw new Delivery_personExceptionHandler("Fail to create a new account");
		}
		
		// Set Attributes
		name=na;
		address=add;
		Contact=pho;
		area=darea;
		hour=dhour;
		day_off=day;
	}
	
	private void validateDay_off(String day) throws Delivery_personExceptionHandler {
		// TODO Auto-generated method stub
		if (day.isBlank() || day.isEmpty())
			throw new Delivery_personExceptionHandler("Delivery Person Day_off NOT specified");
		else if (!(day.equals("Work")||day.equals("Nil")))
			throw new Delivery_personExceptionHandler("Delivery Person Day_off does not meet minimum length requirements");

	}

	public static void validateName(String name) throws Delivery_personExceptionHandler {
		
		//Agree Formating Rules on "Delivery Person Name"
		//E.G. Name String must be a minimum of 2 characters and a maximum of 50 characters
		
		if (name.isBlank() || name.isEmpty())
			throw new Delivery_personExceptionHandler("Delivery Person Name NOT specified");
		else if (name.length() < 2)
			throw new Delivery_personExceptionHandler("Delivery Person Name does not meet minimum length requirements");
		else if (name.length() > 20)
			throw new Delivery_personExceptionHandler("Delivery Person Name does not exceeds maximum length requirements");
		
	}
	
	public static void validateAddress(String custAddr) throws Delivery_personExceptionHandler {
		
		//Agree Formating Rules on "Delivery Person Address"
		//E.G. Name String must be a minimum of 5 characters and a maximum of 60 characters
		
		if (custAddr.isBlank() || custAddr.isEmpty())
			throw new Delivery_personExceptionHandler("Delivery Person Address NOT specified");
		else if (custAddr.length() < 2)
			throw new Delivery_personExceptionHandler("Delivery Person Address does not meet minimum length requirements");
		else if (custAddr.length() > 40)
			throw new Delivery_personExceptionHandler("Delivery Person Address does not exceeds maximum length requirements");
		
	}
	
	public static void validateContactNumber(String custContact) throws Delivery_personExceptionHandler {
		
		//Agree Formating Rules on "Delivery Person ContactNumber"
		//E.G. Name String must be a minimum of 7 characters and a maximum of 15 characters
		
		if (custContact.isBlank() || custContact.isEmpty())
			throw new Delivery_personExceptionHandler("Delivery Person ContactNumber NOT specified");
		else if (custContact.length() < 7)
			throw new Delivery_personExceptionHandler("Delivery Person ContactNumber does not meet minimum length requirements");
		else if (custContact.length() > 15)
			throw new Delivery_personExceptionHandler("Delivery Person ContactNumber does not exceeds maximum length requirements");
		
	}

	public static void validateArea(String area) throws Delivery_personExceptionHandler {
		
		//Agree Formating Rules on "Delivery Area"
		
		if (area.isBlank() || area.isEmpty())
			throw new Delivery_personExceptionHandler("Delivery Area NOT specified");
		else if (area.length() < 2)
			throw new Delivery_personExceptionHandler("Delivery Area does not meet minimum length requirements");
		else if (area.length() > 20)
			throw new Delivery_personExceptionHandler("Delivery Area does not exceeds maximum length requirements");
		
	}
	
	public static void validateWorkhours(int hour) throws Delivery_personExceptionHandler {
		
		//Agree Formating Rules on "Delivery Person ContactNumber"
		//E.G. Work hours must be bigger than 0
		
		if (hour<=0)
			throw new Delivery_personExceptionHandler("Delivery Person Working Hour is unreasonable");
		else if (hour>84)
			throw new Delivery_personExceptionHandler("Delivery Person Working Hour is too long");

	}
	
	public String viewDeli() {
		return name+" "+address+" "+Contact+" "+area+" "+hour+" "+day_off;
			
	}
		

}




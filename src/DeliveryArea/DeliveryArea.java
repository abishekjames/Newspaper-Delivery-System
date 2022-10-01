package DeliveryArea;


public class DeliveryArea {
	
	private int delvid;
	
	private String deliveryArea;
	
	


	public int getDelvid() {
		return delvid;
	}

	public void setDelvid(int Delvid) {
		delvid = Delvid;
	}

	

	public String getDeliveryArea() {
		return deliveryArea;
	}

	public void setDeliveryArea(String DeliveryArea) {
		deliveryArea = DeliveryArea;
	}

	


	
	
	public DeliveryArea( int Delvid, String Deliveryarea) throws DeliveryAreaExceptionHandler  {
		

		
		// Validate Input
		try {
			
			validateDelvID(Delvid);
			
			validateDeliveryArea(Deliveryarea);
			
			
		}
		catch (DeliveryAreaExceptionHandler e) {
			throw e;
		}
		
		// Set Attributes
		
		delvid =Delvid;
		
		deliveryArea= Deliveryarea;
		
		
		
	}
	
	
	public static void validateDelvID(int delvid2) throws DeliveryAreaExceptionHandler {
		
		//Agree Formating Rules on "DeliveryDocket Name"
		//E.G. Name String must be a minimum of 2 characters and a maximum of 50 characters
		
		if (delvid2<0.00000001)
			throw new DeliveryAreaExceptionHandler("DelvID NOT specified");
	
		
	}
	
		public static void validateDeliveryArea(String deliveryArea) throws DeliveryAreaExceptionHandler {
		
		//Agree Formating Rules on "DeliveryAreas Address"
		//E.G. Name String must be a minimum of 5 characters and a maximum of 60 characters
		
		if (deliveryArea.isBlank() || deliveryArea.isEmpty())
			throw new DeliveryAreaExceptionHandler("deliveryArea NOT specified");
		else if (deliveryArea.length() < 2)
			throw new DeliveryAreaExceptionHandler("deliveryArea does not meet minimum length requirements");
		else if (deliveryArea.length() > 30)
			throw new DeliveryAreaExceptionHandler("deliveryArea exceeds maximum length requirements");
		
	}

	
	
	

}

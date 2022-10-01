package DeliveryArea;


import junit.framework.TestCase;

public class DeliveryAreasTest extends TestCase {
	//Test #: 1
		
		private static final DeliveryArea DeliveryArea = null;

		public void testDeliveryArea001() {

			//Create the Delivery Area Object
			
			DeliveryArea DeliObj = null;
			
			try {
				
				//Call method under test
				DeliObj = new DeliveryArea(1,"West");
				
				// Use getters to check for object creation
				
				assertEquals(1, DeliObj.getDelvid());
				assertEquals("West", DeliObj.getDeliveryArea());
				
				
			} 
			
			catch (DeliveryAreaExceptionHandler e) {
				// TODO Auto-generated catch block
				System.out.print(e.getMessage());
				fail("Exception not expected");
			}
				

		}
		
				
		//Test #: 2
		//Test Objective: To catch a invalid Delivery Area
		//Inputs: name = "W"
		//Expected Output: Exception Message: "Delivery Area does not meet minimum length requirements"
				
		public void testValidateDeliveryArea001() {

			
			try {
				
				//Call method under test
				DeliveryArea.validateDeliveryArea("W");
				fail("Exception expected");
			} 
			catch (DeliveryAreaExceptionHandler e) {
				// TODO Auto-generated catch block
				assertEquals("deliveryArea does not meet minimum length requirements", e.getMessage());	

			}
			
		}
		
		//Test #: 3
		//Test Objective: To catch a invalid Delivery Area
		//Inputs: name = "wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww"
		//Expected Output: Exception Message: "Delivery Area exceeds maximum length requirements"
				
		public void testValidateDeliveryArea002() {

				
			try {
					
				//Call method under test
				DeliveryArea.validateDeliveryArea("wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww");
				fail("Exception expected");
			} 
			catch (DeliveryAreaExceptionHandler e) {
				// TODO Auto-generated catch block
				assertEquals("deliveryArea exceeds maximum length requirements", e.getMessage());	

			}
				
		}
			
		//Test #: 4
		//Test Objective: To catch a invalid Delivery Area
		//Inputs: name = ""
		//Expected Output: Exception Message: "Delivery Area exceeds maximum length requirements"
							
		public void testValidateDeliveryArea003() {

						
			try {
							
				//Call method under test
				DeliveryArea.validateDeliveryArea("");
				fail("Exception expected");
			} 
			catch (DeliveryAreaExceptionHandler e) {
				// TODO Auto-generated catch block
				assertEquals("deliveryArea NOT specified", e.getMessage());	
			}
						
		}		
//Test #: 14
		//Test Objective: To catch a invalid DelvId
		//Inputs: Hour = "-1"
		//Expected Output: Exception Message: "DelvId is unreasonable"
										
		public void testValidateDelvId0011() {

									
			try {
										
				//Call method under test
				DeliveryArea.validateDelvID(-1);
				fail("Exception expected");
			} 
			catch (DeliveryAreaExceptionHandler e) {
				// TODO Auto-generated catch block
				assertEquals("DelvID NOT specified", e.getMessage());	
			}
									
		}

		
		//Test #: 16
				//Test Objective: To catch a invalid DelvId
				//Inputs: Hour = "-1"
				//Expected Output: Exception Message: "DelvId is unreasonable"
												
				public void testValidateDelvId001() {

											
					try {
												
						//Call method under test
						DeliveryArea.validateDelvID(-1);
						fail("Exception expected");
					} 
					catch(DeliveryAreaExceptionHandler e) {
						// TODO Auto-generated catch block
						assertEquals("DelvID NOT specified", e.getMessage());	
					}
											
				}
}
				
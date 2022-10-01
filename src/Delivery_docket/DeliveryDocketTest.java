package Delivery_docket;


import junit.framework.TestCase;

public class DeliveryDocketTest extends TestCase {
	//Test #: 1
		//Test Objective: To create a Delivery  Docket
		//Inputs: custid = 1, delvid = 2,name = "Christopher", address = "15 Willow Park", Contact = "0894071300", delivery area= "West",  type ="news paper", time = """ 
		//Expected Output: Delivery Person Object created with id = 0, "Hong", custAddr = "Athlone", custContact = "087-123123123", area= "Garry", hours = 10,day_off="Work"
			
		private static final DeliveryDocket DeliveryDocket = null;

		public void testDeliveryDocket001() {

			//Create the Delivery Docket Object
			
			DeliveryDocket DeliObj = null;
			
			try {
				
				//Call method under test
				DeliObj = new DeliveryDocket(1, 2, "15 Willow Park","0894071300","West","news paper","morning");
				
				// Use getters to check for object creation
				assertEquals(1, DeliObj.getCustid());
				assertEquals(2, DeliObj.getDelvid());
				assertEquals("15 Willow Park", DeliObj.getAddress());
				assertEquals("0894071300", DeliObj.getPhoneNumber());
				assertEquals("West", DeliObj.getDeliveryArea());
				assertEquals("news paper", DeliObj.getType());
				assertEquals("morning", DeliObj.getTime());
				
			} 
			
			catch (DeliveryDocketExceptionHandler e) {
				// TODO Auto-generated catch block
				System.out.print(e.getMessage());
				fail("Exception not expected");
			}
				

		}
		
				
	
			
		//Test #: 5
		//Test Objective: To catch a invalid DeliveryAddress
		//Inputs: address = ""
		//Expected Output: Exception Message: " Address exceeds maximum length requirements"
								
		public void testValidateAddress001() {

							
			try {
								
				//Call method under test
				DeliveryDocket.validateAddress("");
				fail("Exception expected");
			} 
			catch (DeliveryDocketExceptionHandler e) {
				// TODO Auto-generated catch block
				assertEquals("deliveryArea Address NOT specified", e.getMessage());	
			}
							
		}	
		
		
		//Test #: 6
		//Test Objective: To catch a invalid Customer Address
		//Inputs: address = "Will"
		//Expected Output: Exception Message: "Customer Address  exceeds maximum length requirements"
									
		public void testValidateAddress002() {

								
			try {
									
				//Call method under test
				DeliveryDocket.validateAddress("A");
				fail("Exception expected");
			} 
			catch (DeliveryDocketExceptionHandler e) {
				// TODO Auto-generated catch block
				assertEquals("deliveryArea Address does not meet minimum length requirements", e.getMessage());	
			}
								
		}
		
		//Test #: 7
		//Test Objective: To catch a invalid Customer Person Address
		//Inputs: address = "Willoweeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeee"
		//Expected Output: Exception Message: "Delivery Address Name exceeds maximum length requirements"
									
		public void testValidateAddress003() {

								
			try {
									
				//Call method under test
				DeliveryDocket.validateAddress("Willoweeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeee");
				fail("Exception expected");
			} 
			catch (DeliveryDocketExceptionHandler e) {
				// TODO Auto-generated catch block
				assertEquals("deliveryArea Address exceeds maximum length requirements", e.getMessage());	
			}
								
		}
		
		//Test #: 8
		//Test Objective: To catch a invalid Delivery Person PhoneNumber
		//Inputs: PhoneNumber = ""
		//Expected Output: Exception Message: "PhoneNumber NOT specified"
								
		public void testValidatePhonenumber001() {

							
			try {
								
				//Call method under test
				DeliveryDocket.validatePhoneNumber("");;
				fail("Exception expected");
			} 
			catch (DeliveryDocketExceptionHandler e) {
				// TODO Auto-generated catch block
				assertEquals("Customer PhoneNumber NOT specified", e.getMessage());	
			}
							
		}	
		
		
		//Test #: 9
		//Test Objective: To catch a invalid Customer ContactNumber
		//Inputs: Contact = "143356"
		//Expected Output: Exception Message: "Customer ContactNumber does not meet minimum length requirements"
									
		public void testValidatePhoneNumber002() {

								
			try {
									
				//Call method under test
				DeliveryDocket.validatePhoneNumber("143356");
				fail("Exception expected");
			} 
			catch (DeliveryDocketExceptionHandler e) {
				// TODO Auto-generated catch block
				assertEquals("Customer PhoneNumber does not meet minimum length requirements", e.getMessage());	
			}
								
		}
		
		//Test #: 10
		//Test Objective: To catch a invalid Customer ContactNumber
		//Inputs: Contact = "678965433545678755456788"
		//Expected Output: Exception Message: "Delivery Person ContactNumber exceeds maximum length requirement"
									
		public void testValidatePhoneNumber003() {

								
			try {
									
				//Call method under test
				DeliveryDocket.validatePhoneNumber("678965433545678755456788");
				fail("Exception expected");
			} 
			catch (DeliveryDocketExceptionHandler e) {
				// TODO Auto-generated catch block
				assertEquals("Customer PhoneNumber exceeds maximum length requirements", e.getMessage());	
			}
								
		}
		
		//Test #: 11
		//Test Objective: To catch a invalid Delivery Area
		//Inputs: area = ""
		//Expected Output: Exception Message: "Delivery Area exceeds maximum length requirement"
										
		public void testValidateArea001() {

									
			try {
										
				//Call method under test
				DeliveryDocket.validateDeliveryArea("");
				fail("Exception expected");
			} 
			catch (DeliveryDocketExceptionHandler e) {
				// TODO Auto-generated catch block
				assertEquals("deliveryArea NOT specified", e.getMessage());	
			}
									
		}
		
		//Test #: 12
		//Test Objective: To catch a invalid Delivery Area
		//Inputs: area = "L"
		//Expected Output: Exception Message: "Delivery Area exceeds maximum length requirements"
									
		public void testValidateArea002() {

								
			try {
									
				//Call method under test
				DeliveryDocket.validateDeliveryArea("L");
				fail("Exception expected");
			} 
			catch (DeliveryDocketExceptionHandler e) {
				// TODO Auto-generated catch block
				assertEquals("deliveryArea does not meet minimum length requirements", e.getMessage());	
			}
								
		}
		
		//Test #: 13
		//Test Objective: To catch a invalid Delivery Area
		//Inputs: area = "Wiiloweeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeee"
		//Expected Output: Exception Message: "Delivery Area exceeds maximum length requirements"
									
		public void testValidateArea003() {

								
			try {
									
				//Call method under test
				DeliveryDocket.validateDeliveryArea("Wiiloweeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeee");
				fail("Exception expected");
			} 
			catch (DeliveryDocketExceptionHandler e) {
				// TODO Auto-generated catch block
				assertEquals("deliveryArea exceeds maximum length requirements", e.getMessage());	
			}
								
		}
		

		
	

		
		
		//Test #: 20
		//Test Objective: To update successfully a  Address
		//Inputs: address = "Motea"
		//Expected Output: address has been replaced with Motae
												
		public void testUpdateAddress001() throws Exception {
			
			try {
					
				DeliveryDocket DeliObj = new DeliveryDocket(1, 2, "15 Willow Park","0894071300","West","news paper","morning");
				DeliObj.setAddress("Motea");
				assertEquals("Motea", DeliObj.getAddress());
					
				
			} catch (DeliveryDocketExceptionHandler e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
											
											
		}
			
			//Test #: 21
			//Test Objective: Fail to update a Address
			//Inputs: address = "G"
			//Expected Output: Exception Message: "Fail to update address"
													
			public void testUpdateAddress002() throws Exception {
				
				try {
						
					DeliveryDocket DeliObj = new DeliveryDocket(1, 2,"15 Willow Park","0894071300","West","news paper","morning");
					DeliObj.setAddress("G");				
					
				} catch (DeliveryDocketExceptionHandler e) {
					// TODO Auto-generated catch block
					assertEquals("deliveryArea Address does not meet minimum length requirements",e.getMessage());
				}
												
												
			}										
											
			
			//Test #: 22
			//Test Objective: To update successfully a  Contact number
			//Inputs: Contact = "330033003300"
			//Expected Output: Contact has been replaced with 330033003300
													
			public void testUpdatePhoneNumber001() {
				
				try {
						
					DeliveryDocket DeliObj = new DeliveryDocket(1, 2,"15 Willow Park","0894071300","West" ,"news paper","morning");
					DeliObj.setPhoneNumber("330033003300");
					assertEquals("330033003300", DeliObj.getPhoneNumber());
						
					
				} catch (DeliveryDocketExceptionHandler e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
												
												
			}
				
			
			//Test #: 23
			//Test Objective: Fail to update a Contact number
			//Inputs: Contact = "2"
			//Expected Output: Exception Message: ""Fail to update ContactNumber"
														
			public void testUpdateContact002() {
					
				try {
							
					DeliveryDocket DeliObj = new DeliveryDocket(1, 2,"15 Willow Park","0894071300","West","news paper","morning");
					DeliObj.setPhoneNumber("2");				
						
				} catch (DeliveryDocketExceptionHandler e) {
					// TODO Auto-generated catch block
					assertEquals("Customer PhoneNumber does not meet minimum length requirements",e.getMessage());
				}
													
													
			}			
		
			//Test #: 24
			//Test Objective: To update successfully a Delivery area
			//Inputs: area = "Dublin"
			//Expected Output: Delivery area has been replaced with Dublin
													
			public void testUpdateArea001() {
				
				try {
						
					DeliveryDocket DeliObj = new DeliveryDocket(1, 2,"15 Willow Park","0894071300","West","news paper","morning");
					DeliObj.setDeliveryArea("Dublin");
					assertEquals("Dublin", DeliObj.getDeliveryArea());
						
					
				} catch (DeliveryDocketExceptionHandler e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
												
												
			}
				
			
			//Test #: 25
			//Test Objective: Fail to update a Delivery  area
			//Inputs: area = "C"
			//Expected Output: Exception Message: ""Fail to update Area"
														
			public void testUpdateArea002() {
					
				try {
							
					DeliveryDocket DeliObj = new DeliveryDocket(1, 2,"15 Willow Park","0894071300","West","news paper","morning");
					DeliObj.setDeliveryArea("C");				
						
				} catch (DeliveryDocketExceptionHandler e) {
					// TODO Auto-generated catch block

					assertEquals("deliveryPerson does not meet minimum length requirements",e.getMessage());
				}
													
													
			}			
			
			//Test #: 26
			//Test Objective: To update successfully a Delivery Time
			//Inputs: hour = Evening
			//Expected Output: Delivery time has been updated as Evening
													
			public void testUpdateTime001() {
				
				try {
						
					DeliveryDocket DeliObj = new DeliveryDocket(1, 2,"15 Willow Park","0894071300","West","news paper","morning");
					DeliObj.setTime("Evening");
					assertEquals("Evening", DeliObj.getTime());
						
					
				} catch (DeliveryDocketExceptionHandler e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
												
												
			}
				
			
		
////Test #: 27
			//Test Objective: To update successfully delivery type
			//Inputs:  Type = "Evening"
			//Expected Output: Time has been replaced with Evening
														
			public void testSetTime001() {
					
				try {
							
					DeliveryDocket DeliObj = new DeliveryDocket(1, 2,"15 Willow Park","0894071300","West","news paper","morning");
					DeliObj.setTime("Evening");
					assertEquals("Evening",DeliObj.getTime());
					
				} catch (DeliveryDocketExceptionHandler e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				
				}}
				
			
			
			//Test #: 28
			//Test Objective: To catch an empty entry
			//Inputs: Time = ""
			//Expected Output: Exception Message: "time NOT specified"
				
				public void testValidateTime001() {

					
					try {
												
						//Call method under test
						DeliveryDocket.validateTime("");
						fail("Exception expected");
					} 
					catch (DeliveryDocketExceptionHandler e) {
						// TODO Auto-generated catch block
						assertEquals("time NOT specified", e.getMessage());	
					}
					try {
						
						//Call method under test
						DeliveryDocket.validateTime("Morn");
						fail("Exception expected");
					} 
					catch (DeliveryDocketExceptionHandler e) {
						// TODO Auto-generated catch block
						assertEquals("time does not meet minimum length requirements", e.getMessage());	
					}
											
				}
				
				
				//Test #: 29
				//Test Objective: To catch an empty entry
				//Inputs: Time = ""
				//Expected Output: Exception Message: "time NOT specified"		
				
public void testValidateTime002() {

					
					try {
												
						//Call method under test
						DeliveryDocket.validateTime("");
						fail("Exception expected");
					} 
					catch (DeliveryDocketExceptionHandler e) {
						// TODO Auto-generated catch block
						assertEquals("time NOT specified", e.getMessage());	
					}
}

//Test #: 30
//Test Objective: To catch an invalid time
//Inputs: Time = "Mor"
//Expected Output: Exception Message: "deliveryPerson does not meet minimum length requirements"



public void testValidateTime003() {
					try {
						
						//Call method under test
						DeliveryDocket.validateTime("Mor");
						fail("Exception expected");
					} 
					catch (DeliveryDocketExceptionHandler e) {
						// TODO Auto-generated catch block
						assertEquals("time does not meet minimum length requirements", e.getMessage());	
					}
											
				}



//Test #: 31
//Test Objective: To catch an invalid time
//Inputs: Time = "Morninggggggggggg"
//Expected Output: Exception Message: "time exceeds maximum length requirements length requirements"


public void testValidateTime004() {
				
				
	try {
		
		//Call method under test
		DeliveryDocket.validateTime("Morninggggggggggg");
		fail("Exception expected");
	} 
	catch (DeliveryDocketExceptionHandler e) {
		// TODO Auto-generated catch block
		assertEquals("time exceeds maximum length requirements", e.getMessage());	
	}
							
}

	
	
//Test #: 32
		//Test Objective: To update successfully a Delivery Type
		//Inputs: name = "Magazine"
		//Expected Output: Exception Message: //Expected Output: " Delivery Type has been replaced with Magazine "
				
				
				public void testSetType001() {
					
					try {
								
						DeliveryDocket DeliObj = new DeliveryDocket(1, 2,"15 Willow Park","0894071300","West","news paper","morning");
						DeliObj.setType("Magazine");
						assertEquals("Magazine",DeliObj.getType());
						
					} catch (DeliveryDocketExceptionHandler e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					
					} }							
													
			
				//Test #: 33
				//Test Objective: To catch an empty entry
				//Inputs: Type = ""
				//Expected Output: Exception Message: "type NOT specified"		

public void testValidateType001() {

	
	try {
								
		//Call method under test
		DeliveryDocket.validateType("");
		fail("Exception expected");
	} 
	catch (DeliveryDocketExceptionHandler e) {
		// TODO Auto-generated catch block
		assertEquals("type NOT specified", e.getMessage());	
		}
	
}


//Test #: 34
//Test Objective: To catch an invalid entry
//Inputs: Type = ""
//Expected Output: Exception Message: "delivery type does not meet minimum length requirements""		

				public void testValidateType002() {

					
					try {
												
						//Call method under test
						DeliveryDocket.validateType("Mag");
						fail("Exception expected");
					} 
					catch (DeliveryDocketExceptionHandler e) {
						// TODO Auto-generated catch block
						assertEquals("delivery type does not meet minimum length requirements", e.getMessage());	
						}
					
				}
				
				////Test #: 35
				//Test Objective: To catch an invalid entry
				//Inputs: Type = ""
				//Expected Output: Exception Message: "delivery Type exceeds maximum length requirements"
				
				
public void testValidateType003() {

					
					try {
												
						//Call method under test
						DeliveryDocket.validateType("Magazineeeeeeeeeeeeeeeeeeeee");
						fail("Exception expected");
					} 
					catch (DeliveryDocketExceptionHandler e) {
						// TODO Auto-generated catch block
						assertEquals("delivery type exceeds maximum length requirements", e.getMessage());	
						}
					}
				}


package Delivery_person;

import junit.framework.TestCase;

public class Delivery_personTest extends TestCase {
	//Test #: 1
		//Test Objective: To create a Delivery Person Account
		//Inputs: name = "Hong", address = "Athlone", Contact = "087-123123123", area= "Garry", hours = 10
		//Expected Output: Delivery Person Object created with id = 0, "Hong", custAddr = "Athlone", custContact = "087-123123123", area= "Garry", hours = 10,day_off="Work"
			
		public void testDelivery_person001() {

			//Create the Delivery Person Object
			
			Delivery_person DeliObj = null;
			
			try {
				
				//Call method under test
				DeliObj = new Delivery_person("Hong", "Athlone", "087-123123123", "Garry", 10,"Work");
				
				// Use getters to check for object creation
				assertEquals(0, DeliObj.getDelivery_person_id());
				assertEquals("Hong", DeliObj.getName());
				assertEquals("Athlone", DeliObj.getAddress());
				assertEquals("087-123123123", DeliObj.getContact());
				assertEquals("Garry", DeliObj.getArea());
				assertEquals(10, DeliObj.getHour());
				assertEquals("Work", DeliObj.getDay_off());
			} catch (Delivery_personExceptionHandler e) {
				// TODO Auto-generated catch block
				fail("Exception not expected");
			}
				

		}
		
		//Test #: 1
				//Test Objective: To create a Delivery Person Account
				//Inputs: name = "Hong", address = "Athlone", Contact = "087-123123123", area= "Garry", hours = -1
				//Expected Output: Fail to create a new account
					
				public void testDelivery_person002() {

					//Create the Delivery Person Object
					
					Delivery_person DeliObj = null;
					
					try {
						
						//Call method under test
						DeliObj = new Delivery_person("Hong", "Athlone", "087-123123123", "Garry", -1,"Work");
						
						// Use getters to check for object creation
						assertEquals(0, DeliObj.getDelivery_person_id());
						assertEquals("Hong", DeliObj.getName());
						assertEquals("Athlone", DeliObj.getAddress());
						assertEquals("087-123123123", DeliObj.getContact());
						assertEquals("Garry", DeliObj.getArea());
						assertEquals(10, DeliObj.getHour());
						
					} catch (Delivery_personExceptionHandler e) {
						// TODO Auto-generated catch block
						assertEquals("Fail to create a new account", e.getMessage());
					}
						

				}				
		//Test #: 2
		//Test Objective: To catch a invalid Delivery Person Name
		//Inputs: name = "H"
		//Expected Output: Exception Message: "Delivery Person Name does not meet minimum length requirements"
				
		public void testValidateName001() {

			
			try {
				
				//Call method under test
				Delivery_person.validateName("H");
				fail("Exception expected");
			} 
			catch (Delivery_personExceptionHandler e) {
				// TODO Auto-generated catch block
				assertEquals("Delivery Person Name does not meet minimum length requirements", e.getMessage());	

			}
			
		}
		
		//Test #: 4
		//Test Objective: To catch a invalid Delivery Person Name
		//Inputs: name = ""
		//Expected Output: Exception Message: "Delivery Person Name does not exceeds maximum length requirements"
							
		public void testValidateName002() {
		
						
			try {
							
				//Call method under test
				Delivery_person.validateName(" ");
				fail("Exception expected");
			} 
			catch (Delivery_personExceptionHandler e) {
				// TODO Auto-generated catch block
				assertEquals("Delivery Person Name NOT specified", e.getMessage());	
			}
						
		}		
			
		//Test #: 3
		//Test Objective: To catch a invalid Delivery Person Name
		//Inputs: name = "HHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHH"
		//Expected Output: Exception Message: "Delivery Person Name does not exceeds maximum length requirements"
				
		public void testValidateName003() {

				
			try {
					
				//Call method under test
				Delivery_person.validateName("HHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHH");
				fail("Exception expected");
			} 
			catch (Delivery_personExceptionHandler e) {
				// TODO Auto-generated catch block
				assertEquals("Delivery Person Name does not exceeds maximum length requirements", e.getMessage());	

			}
				
		}
			
		//Test #: 4
		//Test Objective: To catch a invalid Delivery Person Name
		//Inputs: name = ""
		//Expected Output: Exception Message: "Delivery Person Name does not exceeds maximum length requirements"
							
		public void testValidateName004() {

						
			try {
							
				//Call method under test
				Delivery_person.validateName("");
				fail("Exception expected");
			} 
			catch (Delivery_personExceptionHandler e) {
				// TODO Auto-generated catch block
				assertEquals("Delivery Person Name NOT specified", e.getMessage());	
			}
						
		}		
			
		//Test #: 5
		//Test Objective: To catch a invalid Delivery Person Address
		//Inputs: address = ""
		//Expected Output: Exception Message: "Delivery Person Name does not exceeds maximum length requirements"
								
		public void testValidateAddress001() {

							
			try {
								
				//Call method under test
				Delivery_person.validateAddress("");
				fail("Exception expected");
			} 
			catch (Delivery_personExceptionHandler e) {
				// TODO Auto-generated catch block
				assertEquals("Delivery Person Address NOT specified", e.getMessage());	
			}
							
		}	
		
		
		//Test #: 6
		//Test Objective: To catch a invalid Delivery Person Address
		//Inputs: address = "Athl"
		//Expected Output: Exception Message: "Delivery Person Name does not exceeds maximum length requirements"
									
		public void testValidateAddress002() {

								
			try {
									
				//Call method under test
				Delivery_person.validateAddress("A");
				fail("Exception expected");
			} 
			catch (Delivery_personExceptionHandler e) {
				// TODO Auto-generated catch block
				assertEquals("Delivery Person Address does not meet minimum length requirements", e.getMessage());	
			}
								
		}
		
		//Test #: 7
		//Test Objective: To catch a invalid Delivery Person Address
		//Inputs: address = "Athloneeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeee"
		//Expected Output: Exception Message: "Delivery Person Name does not exceeds maximum length requirements"
									
		public void testValidateAddress003() {

								
			try {
									
				//Call method under test
				Delivery_person.validateAddress("Athloneeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeee");
				fail("Exception expected");
			} 
			catch (Delivery_personExceptionHandler e) {
				// TODO Auto-generated catch block
				assertEquals("Delivery Person Address does not exceeds maximum length requirements", e.getMessage());	
			}
								
		}
		
		//Test #: 8
		//Test Objective: To catch a invalid Delivery Person ContactNumber
		//Inputs: Contact = ""
		//Expected Output: Exception Message: "Delivery Person Name does not exceeds maximum length requirements"
								
		public void testValidateContactNumber001() {

							
			try {
								
				//Call method under test
				Delivery_person.validateContactNumber("");;
				fail("Exception expected");
			} 
			catch (Delivery_personExceptionHandler e) {
				// TODO Auto-generated catch block
				assertEquals("Delivery Person ContactNumber NOT specified", e.getMessage());	
			}
							
		}	
		
		
		//Test #: 9
		//Test Objective: To catch a invalid Delivery Person ContactNumber
		//Inputs: Contact = "123456"
		//Expected Output: Exception Message: "Delivery Person ContactNumber does not meet minimum length requirements"
									
		public void testValidateContactNumber002() {

								
			try {
									
				//Call method under test
				Delivery_person.validateContactNumber("123456");
				fail("Exception expected");
			} 
			catch (Delivery_personExceptionHandler e) {
				// TODO Auto-generated catch block
				assertEquals("Delivery Person ContactNumber does not meet minimum length requirements", e.getMessage());	
			}
								
		}
		
		//Test #: 10
		//Test Objective: To catch a invalid Delivery Person ContactNumber
		//Inputs: Contact = "123456789123456"
		//Expected Output: Exception Message: "Delivery Person ContactNumber does not exceeds maximum length requirement"
									
		public void testValidateContactNumber003() {

								
			try {
									
				//Call method under test
				Delivery_person.validateContactNumber("1234567891234567");
				fail("Exception expected");
			} 
			catch (Delivery_personExceptionHandler e) {
				// TODO Auto-generated catch block
				assertEquals("Delivery Person ContactNumber does not exceeds maximum length requirements", e.getMessage());	
			}
								
		}
		
		//Test #: 11
		//Test Objective: To catch a invalid Delivery Area
		//Inputs: area = ""
		//Expected Output: Exception Message: "Delivery Area does not exceeds maximum length requirement"
										
		public void testValidateArea001() {

									
			try {
										
				//Call method under test
				Delivery_person.validateArea("");
				fail("Exception expected");
			} 
			catch (Delivery_personExceptionHandler e) {
				// TODO Auto-generated catch block
				assertEquals("Delivery Area NOT specified", e.getMessage());	
			}
									
		}
		
		//Test #: 12
		//Test Objective: To catch a invalid Delivery Area
		//Inputs: area = "w"
		//Expected Output: Exception Message: "Delivery Area does not exceeds maximum length requirements"
									
		public void testValidateArea002() {

								
			try {
									
				//Call method under test
				Delivery_person.validateArea("W");
				fail("Exception expected");
			} 
			catch (Delivery_personExceptionHandler e) {
				// TODO Auto-generated catch block
				assertEquals("Delivery Area does not meet minimum length requirements", e.getMessage());	
			}
								
		}
		
		//Test #: 13
		//Test Objective: To catch a invalid Delivery Area
		//Inputs: area = "Wiiloweeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeee"
		//Expected Output: Exception Message: "Delivery Person Name does not exceeds maximum length requirements"
									
		public void testValidateArea003() {

								
			try {
									
				//Call method under test
				Delivery_person.validateArea("Wiiloweeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeee");
				fail("Exception expected");
			} 
			catch (Delivery_personExceptionHandler e) {
				// TODO Auto-generated catch block
				assertEquals("Delivery Area does not exceeds maximum length requirements", e.getMessage());	
			}
								
		}
		
		//Test #: 14
		//Test Objective: To catch a invalid Work Hour
		//Inputs: Hour = "-1"
		//Expected Output: Exception Message: "Delivery Person Working Hour is unreasonable"
										
		public void testValidateWorkhours001() {

									
			try {
										
				//Call method under test
				Delivery_person.validateWorkhours(-1);
				fail("Exception expected");
			} 
			catch (Delivery_personExceptionHandler e) {
				// TODO Auto-generated catch block
				assertEquals("Delivery Person Working Hour is unreasonable", e.getMessage());	
			}
									
		}
		
		//Test #: 15
		//Test Objective: To catch a invalid Work Hour
		//Inputs: Hour = "85"
		//Expected Output: Exception Message: "Delivery Person Working Hour is too long"
										
		public void testValidateWorkhours002() {

									
			try {
										
				//Call method under test
				Delivery_person.validateWorkhours(90);
				fail("Exception expected");
			} 
			catch (Delivery_personExceptionHandler e) {
				// TODO Auto-generated catch block
				assertEquals("Delivery Person Working Hour is too long", e.getMessage());	
			}
									
		}
		
		//Test #: 16
		//Test Objective: To update successfully a Delivery Person Name
		//Inputs: name = "Zhou"
		//Expected Output: name of the Delivery Person has been replaced with Zhou
											
		public void testUpdateName001() {
		
			try {
				
				Delivery_person DeliObj = new Delivery_person("Hong", "Athlone", "087-123123123", "Garry", 10,"Work");
				DeliObj.updateName("Zhou");
				assertEquals("Zhou", DeliObj.getName());
				
			
			} catch (Delivery_personExceptionHandler e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
										
										
		}
		
		//Test #: 17
		//Test Objective: To update successfully a Delivery Person Name
		//Inputs: name = "Z"
		//Expected Output: Exception Message: "Fail to update name"
												
		public void testUpdateName002() {
			
			try {
					
				Delivery_person DeliObj = new Delivery_person("Hong", "Athlone", "087-123123123", "Garry", 10,"Work");
				DeliObj.updateName("Z");				
				
			} catch (Delivery_personExceptionHandler e) {
				// TODO Auto-generated catch block
				assertEquals("Fail to update name",e.getMessage());
			}
											
											
		}
		
		
		//Test #: 18
		//Test Objective: To update successfully a Delivery Person Address
		//Inputs: address = "Cork"
		//Expected Output: address has been replaced with Zhou
												
		public void testUpdateAddress001() {
			
			try {
					
				Delivery_person DeliObj = new Delivery_person("Hong", "Athlone", "087-123123123", "Garry", 10,"Work");
				DeliObj.updateAddress("Cork");
				assertEquals("Cork", DeliObj.getAddress());
					
				
			} catch (Delivery_personExceptionHandler e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
											
											
		}
			
			//Test #: 19
			//Test Objective: Fail to update a Delivery Person Name
			//Inputs: address = "W"
			//Expected Output: Exception Message: "Fail to update address"
													
			public void testUpdateAddress002() {
				
				try {
						
					Delivery_person DeliObj = new Delivery_person("Hong", "Athlone", "087-123123123", "Garry", 10,"Work");
					DeliObj.updateAddress("W");				
					
				} catch (Delivery_personExceptionHandler e) {
					// TODO Auto-generated catch block
					assertEquals("Fail to update address",e.getMessage());
				}
												
												
			}										
											
			
			//Test #: 20
			//Test Objective: To update successfully a Delivery Person Contact number
			//Inputs: Contact = "990099009900"
			//Expected Output: Contact has been replaced with 990099009900
													
			public void testUpdateContact001() {
				
				try {
						
					Delivery_person DeliObj = new Delivery_person("Hong", "Athlone", "087-123123123", "Garry", 10,"Work");
					DeliObj.updateContact("990099009900");
					assertEquals("990099009900", DeliObj.getContact());
						
					
				} catch (Delivery_personExceptionHandler e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
												
												
			}
				
			
			//Test #: 21
			//Test Objective: Fail to update a Delivery Person Contact number
			//Inputs: Contact = "1"
			//Expected Output: Exception Message: ""Fail to update ContactNumber"
														
			public void testUpdateContact002() {
					
				try {
							
					Delivery_person DeliObj = new Delivery_person("Hong", "Athlone", "087-123123123", "Garry", 10,"Work");
					DeliObj.updateContact("1");				
						
				} catch (Delivery_personExceptionHandler e) {
					// TODO Auto-generated catch block
					assertEquals("Fail to update ContactNumber",e.getMessage());
				}
													
													
			}			
		
			//Test #: 22
			//Test Objective: To update successfully a Delivery area
			//Inputs: area = "Crystal"
			//Expected Output: Delivery area has been replaced with Crystal
													
			public void testUpdateArea001() {
				
				try {
						
					Delivery_person DeliObj = new Delivery_person("Hong", "Athlone", "087-123123123", "Garry", 10,"Work");
					DeliObj.updateArea("Crystal");
					assertEquals("Crystal", DeliObj.getArea());
						
					
				} catch (Delivery_personExceptionHandler e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
												
												
			}
				
			
			//Test #: 23
			//Test Objective: Fail to update a Delivery Person area
			//Inputs: area = "C"
			//Expected Output: Exception Message: ""Fail to update ContactNumber"
														
			public void testUpdateArea002() {
					
				try {
							
					Delivery_person DeliObj = new Delivery_person("Hong", "Athlone", "087-123123123", "Garry", 10,"Work");
					DeliObj.updateArea("C");				
						
				} catch (Delivery_personExceptionHandler e) {
					// TODO Auto-generated catch block
					assertEquals("Fail to update area",e.getMessage());
				}
													
													
			}			
			
			//Test #: 24
			//Test Objective: To update successfully a Delivery person work hours
			//Inputs: hour = 20
			//Expected Output: Delivery area has been replaced with Crystal
													
			public void testUpdateWorkhours001() {
				
				try {
						
					Delivery_person DeliObj = new Delivery_person("Hong", "Athlone", "087-123123123", "Garry", 10,"Work");
					DeliObj.updateHour(20);
					assertEquals(20, DeliObj.getHour());
						
					
				} catch (Delivery_personExceptionHandler e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
												
												
			}
				
			
			//Test #: 25
			//Test Objective: Fail to update a Delivery Person work hours
			//Inputs: hour = -1
			//Expected Output: Exception Message: "Fail to update Workhours"
														
			public void testUpdateWorkhours002() {
					
				try {
							
					Delivery_person DeliObj = new Delivery_person("Hong", "Athlone", "087-123123123", "Garry", 10,"Work");
					DeliObj.updateHour(-1);
						
				} catch (Delivery_personExceptionHandler e) {
					// TODO Auto-generated catch block
					assertEquals("Fail to update Workhours",e.getMessage());
				}
													
													
			}
			
			
			//Test #: 26
			//Test Objective: To update successfully a Delivery person Day_off
			//Inputs: Day_off = "Nil"
			//Expected Output: Exception Message: "Fail to update Workhours"
														
			public void testUpdateDay_off001() {
					
				try {
							
					Delivery_person DeliObj = new Delivery_person("Hong", "Athlone", "087-123123123", "Garry", 10,"Work");
					DeliObj.updateDay_off("Nil");
					assertEquals("Nil",DeliObj.getDay_off());	
				} catch (Delivery_personExceptionHandler e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
													
													
			}	
			
			
			//Test #: 27
			//Test Objective: Fail to update a Delivery Person work hours
			//Inputs: hour = -1
			//Expected Output: Exception Message: "Fail to update Workhours"
														
			public void testUpdateDay_off002() {
					
				try {
							
					Delivery_person DeliObj = new Delivery_person("Hong", "Athlone", "087-123123123", "Garry", 10,"Work");
					DeliObj.updateDay_off("LLL");
						
				} catch (Delivery_personExceptionHandler e) {
					// TODO Auto-generated catch block
					assertEquals("Fail to update Day_off",e.getMessage());
				}
													
													
			}		
			
			//Test #: 28
			//Test Objective: Success to view the Delivery_person details
			//Inputs: name = "Hong", address = "Athlone", Contact = "087-123123123", area= "Garry", hours = 10
			//Expected Output: The content of view method is similar to the "Hong Athlone 087-123123123 Garry 10 Work"
														
			public void testViewDelivery_person001() {
					
				try {
							
					Delivery_person DeliObj = new Delivery_person("Hong", "Athlone", "087-123123123", "Garry", 10,"Work");
					String a=DeliObj.viewDeli();
					System.out.print(a);
					assertEquals("Hong Athlone 087-123123123 Garry 10 Work",a);
					
				} catch (Delivery_personExceptionHandler e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
													
													
			}				
}

package subscriptions;

import junit.framework.TestCase;

public class SubscriptionTest extends TestCase {
			//Test #: 1
			//Test Objective: To create a subscription account valid customer id
			//Inputs: customer id="J001000" Subscription Id  = 1000 Subscription price=100 Subscription state="active" Subscription type=newspaper Subscription date="02.01.2022"
			//Expected Output: successful Subscription meet all requirements
			//Type:Junit
			public void testcreateSubscription001() {
				
				//Create subscription
				
				try {
					
					//Call method under test
					Subscription subObj = new Subscription(2,100,"active","newspaper","02.01.2022");
					
					// Use getters to check for object creation
			
				assertEquals(2, subObj.getcustId());
				assertEquals(100.0, subObj.getPrice());
				assertEquals("active", subObj.getsubState());
				assertEquals("newspaper", subObj.getsubType());
				assertEquals("02.01.2022", subObj.getsubDate());
				}
				catch (SubscriptionExceptionHandler e) {
					fail("Exception not expected");
				}
				
			}
			//Test #: 2
			//Test Objective: To create a invalid Customer Id range from 0 to 4 characters
			//Inputs: Customer Id  = 002
			//Expected Output: Exception Message: "Customer Id does not meet minimum length requirements"
			//Type:Junit
			public void  testcreateSubscription002()  {
				try {	
				//Call method under test
				Subscription.validatecustId(002);
				}
				catch (SubscriptionExceptionHandler e) {
				fail("Exception expected");
		        assertEquals("Customer Id does not meet minimum length requirements", e.getMessage());	
			}
	}
			//Test #: 2
			//Test Objective: To create a invalid Customer Id range from 8 to max character
			//Inputs: Customer Id  = "J0010000"
			//Expected Output: Exception Message: "Customer Id does not exceeds maximum length requirements"
			//Type:Junit
			public void  testcreateSubscription003()   {
				try {	
				//Call method under test
				Subscription.validatecustId(2);
				
				}
				catch (SubscriptionExceptionHandler e) {
					fail("Exception expected");
				assertEquals("Customer Id does not exceeds maximum length requirements", e.getMessage());	
			}
	}		
	
	
	
	
		
		//Test #: 3
		//Test Objective: To create a invalid Subscription Id range from 10 to max character
		//Inputs: Subscription Id  = "A002905490"
		//Expected Output: Exception Message: "Subscription Id does not exceeds maximum length requirements"
		//Type:Junit
		public void testcreateSubscription006()   {
			try {	
			//Call method under test
			Subscription.validatesubId("A002905490");
			
			}
			catch (SubscriptionExceptionHandler e) {
				fail("Exception expected");
			assertEquals("Subscription Id does not exceeds maximum length requirements", e.getMessage());	
		}
}	
		
	        //Test #: 4
			//Test Objective: To test a valid subscription price
			//Inputs: subPrice="100"
			//Expected Output:Sucessful "Price meet the requirements"
			//Type:Junit
			public void testcreateSubscription007() {
				
				//Create the Subscription 
				try {
					
					//Call method under test
					Subscription SubObj = new Subscription(2,100,"active","newspaper","02.09.2021");
					
					// Use getters to check for object creation
					assertEquals(100.0, SubObj.getPrice());
				
				}
				catch (SubscriptionExceptionHandler e) {
					fail("Exception not expected");
				}
			}
			
			//Test #: 5
			//Test Objective: To catch an invalid subscription price
			//Inputs: subPrice="100"
			//Expected Output: Exception Message: "Price does not meet minimum  requirements"
			//Type:Junit
			public void testcreateSubscription008() {
					
				try {
						
					//Call method under test
					Subscription.validatePrice(-1);
					
				}
				catch (SubscriptionExceptionHandler e) {
					assertEquals("Price does not meet minimum requirements", e.getMessage());	
				}
			}
		
		//Test #: 6
		//Test Objective: To catch an valid subscription state
		//Inputs:state of subscription  = "active"
		//Expected Output: successful with state of subscription = "active" range from 3 to 10 characters
		//Type:Junit

		public void testcreateSubscription009() {
			
			//Create the Subscription 	
			
			try {
				
				//Call method under test
				Subscription SubObj = new Subscription(2,100,"active","newspaper","02.09.2021");
				
				// Use getters to check for object creation
				
				assertEquals("active", SubObj.getsubState());
			}
			catch (SubscriptionExceptionHandler e) {
				fail("Exception not expected");
			}
		}
			//Test #: 7
			//Test Objective: To catch an invalid subscription state range from 0 to 3 character
			//Inputs: custName = "In"
			//Expected Output: Exception Message: "subState does not meet minimum length requirements"
		    //Type:Junit
			public void testcreateSubscription010() {
					
				try {
						
					//Call method under test
					Subscription.validatesubState("In");
					fail("Exception expected");
					}
				catch (SubscriptionExceptionHandler e) {
				
					assertEquals("subState does not meet minimum length requirements", e.getMessage());
									}
			}
			

			//Test #: 8
			//Test Objective: To catch an invalid subscription state range from 10 to max
			//Inputs: custName = "Suspended State"
			//Expected Output: Exception Message: subState does not exceeds maximum length requirements"
			//Type:Junit
			public void testcreateSubscription011() {
					
				try {
						
					//Call method under test
					Subscription.validatesubState("Suspended State");
				}
				catch (SubscriptionExceptionHandler e) {
					assertEquals("subState exceeds maximum length requirements", e.getMessage());
				}
			
			
		}
			//Test #: 9
			//Test Objective: To catch an valid subscription state
			//Inputs:Type of subscription  = "Newspaper"
			//Expected Output: successful with Type of subscription = "Newspaper" range from 3 to 10 characters
			//Type:Junit

			public void testcreateSubscription012() {
				
				//Create the Subscription 	
				
				try {
					
					//Call method under test
					Subscription SubObj = new Subscription(2,100,"active","newspaper","02.09.2021");
					
					// Use getters to check for object creation
					
					assertEquals("newspaper", SubObj.getsubType());
				}
				catch (SubscriptionExceptionHandler e) {
					fail("Exception not expected");
				}
			}
			//Test #: 10
			//Test Objective: To catch an invalid subscription type range from 0 to 3 character
			//Inputs: custName = "In"
			//Expected Output: Exception Message: "subType does not meet minimum length requirements"
		    //Type:Junit
			public void testcreateSubscription013() {
					
				try {
						
					//Call method under test
					Subscription.validatesubType("In");

					}
				catch (SubscriptionExceptionHandler e) {
					fail("Exception expected");

					assertEquals("subType does not meet minimum length requirements", e.getMessage());
									}
			}
			//Test #: 11
			//Test Objective: To catch an invalid subscription type range from 9 to max
			//Inputs: subType = "Newspaper and Magazine"
			//Expected Output: Exception Message: subState does not exceeds maximum length requirements"
			//Type:Junit
			public void testcreateSubscription014() {
					
				try {
						
					//Call method under test
					Subscription.validatesubType("Newspaper");
					
				}
				catch (SubscriptionExceptionHandler e) {
					fail("Exception expected");
					assertEquals("subType does not exceeds maximum length requirements", e.getMessage());
				}
			}
			//Test #: 12
			//Test Objective: To catch an valid subscription date range from 0 to 10
			//Inputs: subType = "02/09/2021"
			//Expected Output: Exception Message: "subDate does not meet minimum length requirements"
			//Type:Junit
			public void testcreateSubscription015() {
					
				try {
						
					//Call method under test
					Subscription.validatesubDate("02.09.2021");
					
				}
				catch (SubscriptionExceptionHandler e) {
					fail("Exception expected");
					assertEquals("subDate does not meet minimum length requirements", e.getMessage());
				}
			}	
			
			//Test #: 13
			//Test Objective: To catch an invalid subscription date range from 10 to max
			//Inputs: subType ="02/01/2022 January"
			//Expected Output: Exception Message: subDate does not exceeds maximum length requirements"
			//Type:Junit
			public void testcreateSubscription016() {
					
				try {
						
					//Call method under test
					Subscription.validatesubDate("02.01.2022 January");
					fail("Exception expected");
				}
				catch (SubscriptionExceptionHandler e) {
					
					assertEquals("subDate does not exceeds maximum length requirements", e.getMessage());
				}
			}
			//Test #: 14
			//Test Objective: To update successfully a Subscription id
			//Inputs: name = "B00290549"
			//Expected Output: Subscription Id has been replaced with "B00290549"
			//Type:Junit										
				public void testmodifySubscription017() {
				
					try {
						Subscription SubObj = new Subscription(2,100,"active","newspaper","02.09.2021");
						SubObj.modifysubId("B00290549");
						assertEquals("B00290549", SubObj.getSubId());
						
					
					} catch (SubscriptionExceptionHandler e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
				//Test #: 15
				//Test Objective: Fail to modify invalid subId
				//Inputs: name = "C00290549"
				//Expected Output: Exception Message: "Fail to update subId"
				//Type:Junit											
				public void testmodifySubscription018() {
						
						try {
								
							Subscription SubObj = new Subscription(2,100,"active","newspaper","02.09.2021");
							SubObj.modifysubId("C00290549");				
							
						} catch (SubscriptionExceptionHandler e) {
							// TODO Auto-generated catch block
							assertEquals("Fail to modify subId",e.getMessage());
						}
}
				//Test #: 16
				//Test Objective: To update successfully a Subscription price
				//Inputs: name = "200"
				//Expected Output: Subscription price has been replaced with 200
				//Type:Junit										
				public void testmodifySubscription019() {
						
				try {
					Subscription SubObj = new Subscription(2,100,"active","newspaper","02.09.2021");
					SubObj.modifysubPrice(200);
					assertEquals(200.0, SubObj.getPrice());
								
							
					} catch (SubscriptionExceptionHandler e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
							}
						}
				//Test #: 17
				//Test Objective: Fail to modify invalid subPrice
				//Inputs: name = "300"
				//Expected Output: Exception Message: "Fail to update subPrice"
				//Type:Junit											
				public void testmodifySubscription020() {
								
				try {
										
				    Subscription SubObj = new Subscription(2,100,"active","newspaper","02.09.2021");
					SubObj.modifysubPrice(300);				
									
					} catch (SubscriptionExceptionHandler e) {
						// TODO Auto-generated catch block
					 assertEquals("Fail to modify subPrice",e.getMessage());
				}
}
				//Test #: 18
				//Test Objective: To update successfully a Subscription state
				//Inputs: name = "inactive"
				//Expected Output: Subscription state has been replaced with "inactive"
				//Type:Junit										
				public void testmodifySubscription021() {
								
				try {
					Subscription SubObj = new Subscription(2,100,"active","newspaper","02.09.2021");
					SubObj.modifysubState("inactive");
					assertEquals("inactive", SubObj.getsubState());
										
									
					} catch (SubscriptionExceptionHandler e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
		}
				//Test #: 19
				//Test Objective: Fail to modify invalid subState
				//Inputs: name = "inactive"
				//Expected Output: Exception Message: "Fail to update subscription state"
				//Type:Junit											
				public void testmodifySubscription022() {
										
				try {
												
					Subscription SubObj = new Subscription(2,100,"active","newspaper","02.09.2021");
					SubObj.modifysubState("inactive");				
											
					} catch (SubscriptionExceptionHandler e) {
					// TODO Auto-generated catch block
					 assertEquals("Fail to modify subState",e.getMessage());
				}
		}		
				//Test #: 20
				//Test Objective: To update successfully a Subscription type
				//Inputs: name = "magazine"
				//Expected Output: Subscription state has been replaced with "magazine"
				//Type:Junit										
				public void testmodifySubscription023() {
										
				try {
					Subscription SubObj = new Subscription(2,100,"active","newspaper","02.09.2021");
					SubObj.modifysubType("magazine");
					assertEquals("magazine", SubObj.getsubType());
												
											
					} catch (SubscriptionExceptionHandler e1) {
				    // TODO Auto-generated catch block
					e1.printStackTrace();
				}
	}
				//Test #: 21
				//Test Objective: Fail to modify invalid subscription type
				//Inputs: name = "magazine"
			    //Expected Output: Exception Message: "Fail to update subscription type"
				//Type:Junit											
			    public void testmodifySubscription024() {
												
				try {
														
					Subscription SubObj = new Subscription(2,100,"active","newspaper","02.09.2021");
					SubObj.modifysubType("magazine");				
													
					} catch (SubscriptionExceptionHandler e) {
						// TODO Auto-generated catch block
					 assertEquals("Fail to modify subType",e.getMessage());
				}
		}
				//Test #: 22
				//Test Objective: To update successfully a Subscription date
			    //Inputs: name = "12.10.2022"
				//Expected Output: Subscription state has been replaced with "12.10.2022"
				//Type:Junit										
				public void testmodifySubscription025() {
												
				try {
					Subscription SubObj = new Subscription(2,100,"active","newspaper","02.09.2021");
					SubObj.modifysubDate("12.10.2022");
					assertEquals("12.10.2022", SubObj.getsubDate());
														
													
					} catch (SubscriptionExceptionHandler e1) {
					  // TODO Auto-generated catch block
					  e1.printStackTrace();
			}
	}
				//Test #: 23
				//Test Objective: Fail to update invalid subscription date
				//Inputs: name = "12.10.2022"
				//Expected Output: Exception Message: "Fail to update subscription date"
				//Type:Junit											
				public void testmodifySubscription026() {
														
				try {
																
				 Subscription SubObj = new Subscription(2,100,"active","newspaper","02.09.2021");;
			    	SubObj.modifysubDate("12.10.2022");				
															
				     } catch (SubscriptionExceptionHandler e) {
					// TODO Auto-generated catch block
						assertEquals("Fail to modify subDate",e.getMessage());
				}
		}								
}


	
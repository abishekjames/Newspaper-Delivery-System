package Publication;

import junit.framework.TestCase;

public class PublicationTest extends TestCase {
	    //Test #: 1
		//Test Objective: To add a valid Product
		//Inputs(s): prodName = "Daily Mirror", prodPrice = "100"
		//Expected Output: Product added with prodName = "Daily Mirror", prodPrice = "100"
		
		
		public void testValidateproduct001() {
			
			//Added the Product
			
			
			try {
				
				//Call method under test
				Publication pubObj = new Publication("Daily Mirror",100,"Is a British national daily newsapaper", "Available");
				
				// Use getters to check for object creation
				assertEquals("Daily Mirror", pubObj.getName());
				assertEquals(100.0, pubObj.getPrice());
				assertEquals("Is a British national daily newsapaper", pubObj.getDetails());
				assertEquals("Available", pubObj.getMessage());
				
		
			}
			catch (ProductExceptionHandler e) {
				fail("Exception not expected");
			}
			
		}


	
	//Test #: 5
	//Test Objective: To test an invalid product name
	//Inputs: prodName = "an"
	//Expected Output: Exception Message: "Product Name does not meet minimum length requirements"
	

		public void testValidatename005() {
			
		
			try {
					
				//Call method under test
				Publication.validateName("an");
				fail("Exception expected");
			}
			catch (ProductExceptionHandler e) {
				assertEquals("Product Name does not meet minimum length requirements", e.getMessage());	
			}
		}
		
	//Test #: 6
	//Test Objective: To test an valid product name
	//Inputs: prodName = "Daily Mirror"
	//Expected Output: True
	

			public void testValidatename006() {
		
					
				try {
					Publication pubObj = new Publication("Daily Mirror",100,"Is a British national daily newsapaper", "Available");
					
					
					// Use getters to check for object creation
					assertEquals("Daily Mirror", pubObj.getName());
			
				}
				catch (ProductExceptionHandler e) {
					fail("Exception not expected");
				}
				
			}
			
		//Test #: 7
		//Test Objective: To test an invalid product name
		//Inputs: prodName = "Sunday Independent"
		//Expected Output: Exception Message: "Product Name does not meet maximum length requirements"
		

				public void testValidatename007() {
					
					try {
							
						//Call method under test
						Publication.validateName("Sunday Independent");
						fail("Exception expected");
					}
					catch (ProductExceptionHandler e) {
						assertEquals("Product Name does not exceeds maximum length requirements", e.getMessage());	
					}
				}
				
		//Test #: 8
		//Test Objective: To test an valid product price
		//Inputs: prod = "100"
		//Expected Output: True
		

				public void testValidateprice008() {		
								
					try {
						Publication pubObj = new Publication("Daily Mirror",0.10,"Is a British national daily newsapaper", "Available");								
								
						// Use getters to check for object creation
						assertEquals(0.10, pubObj.getPrice());
						
						}
					catch (ProductExceptionHandler e) {
						fail("Exception not expected");
						
							}
							
						}
				
		//Test #: 9
		//Test Objective: To test an invalid product price
		//Inputs: prodName = "-10"
		//Expected Output: Exception Message: "Product Price meet the valid requirements"
	

				public void testValidatepriceProduct009() {
							
					try {
									
						//Call method under test
						Publication.validatePrice(0.10);
								
								
					}
					catch (ProductExceptionHandler e) {
						fail("Exception expected");
								
						assertEquals("Product Price does not meet the valid requirements", e.getMessage());	
					}
				}
						
		//Test #: 10
		//Test Objective: To test an invalid product details
		//Inputs: prodDetails = "British national"
		//Expected Output: Exception Message: "Product Details does not meet minimum length requirements"
	

				public void testValidatedetails010() {
							
					try {
									
						//Call method under test
						Publication.validateDetails("British national");
						
					}
					catch (ProductExceptionHandler e) {
						fail("Exception expected");
						assertEquals("Product Details does not meet minimum length requirements", e.getMessage());	
					}
				}
						
		//Test #: 11
		//Test Objective: To test an valid product details
		//Inputs: prodName = "Daily Mirror"
		//Expected Output: True
	

				public void testValidatedetails011() {
													
										
					try {
						Publication pubObj = new Publication("Daily Mirror",100,"Is a British national daily newsapaper", "Available");										
										
						// Use getters to check for object creation
					    assertEquals("Daily Mirror", pubObj.getName());
								
						}
						catch (ProductExceptionHandler e) {
						fail("Exception not expected");
						}
									
					}
						
		//Test #: 12
		//Test Objective: To test an invalid product details
		//Inputs: prodDetails = "Daily Mirror is a British national daily newspaper"
		//Expected Output: Exception Message: "Product Details does not meet maximum length requirements"
	

				public void testValidatedetails012() {
									
					try {
											
						//Call method under test
						Publication.validateDetails("Daily Mirror is a British national daily newspaper");
						fail("Exception expected");
					}
					catch (ProductExceptionHandler e) {
						assertEquals("Product Details does not exceeds maximum length requirements", e.getMessage());	
						}
					}
								
		//Test #: 13
		//Test Objective: To test an invalid product message
		//Inputs: prodDetails = "out"
		//Expected Output: Exception Message: "Product Details does not meet minimum length requirements"
		
				public void testValidatemessage013() {
											
					try {
													
						//Call method under test
						Publication.validateDetails("out");
						fail("Exception expected");
							}
					catch (ProductExceptionHandler e) {
						assertEquals("Product Details does not meet minimum length requirements", e.getMessage());	
						}
					}
										
			//Test #: 14
			//Test Objective: To test an valid product message
			//Inputs: prodName = "Available"
			//Expected Output: True
		

				public void testValidatemessage014() {									
														
					try {
						Publication pubObj = new Publication("Daily Mirror",100,"Is a British national daily newsapaper", "Available");														
														
						// Use getters to check for object creation
						assertEquals("Available", pubObj.getMessage());
												
							}
					catch (ProductExceptionHandler e) {
						fail("Exception not expected");
								}
													
						}
										
		//Test #: 15
		//Test Objective: To test an invalid product message
	    //Inputs: prodDetails = "Daily Mirror is a British national daily newspaper"
		//Expected Output: Exception Message: "Product Message does not exceeds maximum length requirements"
																		
				
				public void testValidatemessage015() {
													
					try {
															
						//Call method under test
						Publication.validateMessage("Daily mirror newspaper out of order");
						fail("Exception expected");
							}
					catch (ProductExceptionHandler e) {
						assertEquals("Product Message does not exceeds maximum length requirements", e.getMessage());	
							}
						}

			
								
		//Test #: 18
			//Test Objective: Test to update invalid product name failed
			//Inputs: prodDetails = "Daily hunt"
			//Expected Output: Exception Message: "Fail to update product name"
								

			public void testupdateProductname018() {
																				
			try {
				Publication pubObj = new Publication("Daily Mirror",100,"Is a British national daily newsapaper", "Available");
				pubObj.updateprodName("Daily hunt");
											
				}
			catch (ProductExceptionHandler e) {
				assertEquals("Fail to update product name", e.getMessage());	
				}
										
		 }
								    
			//Test #: 19
			//Test Objective: Test to successfully update a valid product name
			//Inputs: prodDetails = "Daily hunt"
			//Expected Output: True
									

			 public void testupdateProductname019() {
																					
			 try {
																							
			//Call method under test
			Publication pubObj = new Publication("Daily Mirror",100,"Is a British national daily newsapaper", "Available");
			pubObj.updateprodName("Daily hunt");
			assertEquals("Daily hunt", pubObj.getName());	
											
				}
			 catch (ProductExceptionHandler e) {
			  e.printStackTrace();
				}
		   }
			 //Test #: 20
				//Test Objective: Test to update invalid product price failed
				//Inputs: prodDetails = "Daily hunt"
				//Expected Output: Exception Message: "Fail to update product price"
									

				public void testupdateProductPrice020() {
																					
				try {
					Publication pubObj = new Publication("Daily Mirror",100,"Is a British national daily newsapaper", "Available");																		
					pubObj.updateprodPrice(200);
												
					}
				catch (ProductExceptionHandler e) {
					assertEquals("Fail to update product price", e.getMessage());	
					}
											
			 }
									    
				//Test #: 21
				//Test Objective: Test to successfully update a valid product price
				//Inputs: prodDetails = "Daily hunt"
				//Expected Output: True
										

				 public void testupdateProductprice021() {
																						
				 try {
																								
					//Call method under test
					Publication pubObj = new Publication("Daily Mirror",100,"Is a British national daily newsapaper", "Available");
					pubObj.updateprodPrice(200);
					assertEquals(200.0, pubObj.getPrice());	
												
					}
				 catch (ProductExceptionHandler e) {
				  e.printStackTrace();
					}
			   }
				 //Test #: 22
					//Test Objective: Test to update invalid product details failed
					//Inputs: prodDetails = "Is a English national daily newspaper"
					//Expected Output: Exception Message: "Fail to update product details"
										

					public void testupdateProductdetails022() {
																						
					try {
						Publication pubObj = new Publication("Daily Mirror",100,"Is a British national daily newsapaper", "Available");																		
						pubObj.updateprodDetails("Is a English national daily newsapaper");
													
						}
					catch (ProductExceptionHandler e) {
						assertEquals("Fail to update product details", e.getMessage());	
						}
												
				 }
										    
					//Test #: 23
					//Test Objective: Test to successfully update a valid product details
					//Inputs: prodDetails = "Is a English national daily news paper"
					//Expected Output: True
											

					 public void testupdateProductdetails023() {
																							
					 try {
																									
					//Call method under test
					Publication pubObj = new Publication("Daily Mirror",100,"Is a British national daily newsapaper", "Available");
					pubObj.updateprodDetails("Is a English national daily newsapaper");
					assertEquals("Is a English national daily newsapaper", pubObj.getDetails());	
													
						}
					 catch (ProductExceptionHandler e) {
					  e.printStackTrace();
						}
				   }
					//Test #: 24
					//Test Objective: Test to update invalid product details failed
					//Inputs: prodMessage = "Not available"
					//Expected Output: Exception Message: "Fail to update product message"
											

						public void testupdateProductdetails024() {
																							
						try {
							Publication pubObj = new Publication("Daily Mirror",100,"Is a British national daily newsapaper", "Available");																		
							pubObj.updateprodMessage("Notavailable");
														
							}
						catch (ProductExceptionHandler e) {
							assertEquals("Fail to update product message", e.getMessage());	
							}
													
					 }
											    
					//Test #: 25
					//Test Objective: Test to successfully update a valid product message
					//Inputs: prodMessage = "Not available"
					//Expected Output: True
												

						 public void testupdateProductdetails025() {
																								
						 try {
																										
						//Call method under test
						Publication pubObj = new Publication("Daily Mirror",100,"Is a British national daily newsapaper", "Available");
						pubObj.updateprodMessage("Not available");
						assertEquals("Not available", pubObj.getMessage());	
														
							}
						 catch (ProductExceptionHandler e) {
						  e.printStackTrace();
							}
					   }
																													
		    }  												
														


																
   										
												


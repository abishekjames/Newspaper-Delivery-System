package Customer;

import junit.framework.TestCase;

public class CustomerTest extends TestCase {
	// Test #: 1
	// Test Objective: To create a Customer Account
	// Inputs: name = "Hong", address = "Athlone", Contact = "087-123123123", area=
	// "Garry"
	// Expected Output: Customer Object created with id = 0, "Hong", custAddr
	// = "Athlone", custContact = "087-123123123", area= "Garry"

	public void testCustomer001() {

		// Create the Customer Object

		Customer CusObj = null;

		try {

			// Call method under test
			CusObj = new Customer("Hong", "Athlone", "087-123123123", "Garry");

			// Use getters to check for object creation
			assertEquals(0, CusObj.getCustomer_Id());
			assertEquals("Hong", CusObj.getCustomer_Name());
			assertEquals("Athlone", CusObj.getCustomer_Address());
			assertEquals("087-123123123", CusObj.getCustomer_Contact());
			assertEquals("Garry", CusObj.getArea());

		} catch (CustomerExceptionHandler e) {
			// TODO Auto-generated catch block
			fail("Exception not expected");
		}

	}

	// Test #: 2
	// Test Objective: To catch a invalid Customer Name
	// Inputs: name = "H"
	// Expected Output: Exception Message: "Customer Name does not meet
	// minimum length requirements"

	public void validateCustomer_Name() {

		try {

			// Call method under test
			Customer.validateCustomer_Name("H");
			fail("Exception expected");
		} catch (CustomerExceptionHandler e) {
			// TODO Auto-generated catch block
			assertEquals("Customer Name does not meet minimum length requirements", e.getMessage());

		}

	}

	// Test #: 3
	// Test Objective: To catch a invalid Customer Name
	// Inputs: name = "HHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHH"
	// Expected Output: Exception Message: "Customer Name does not exceeds
	// maximum length requirements"

	public void validateCustomer_Name002() {

		try {

			// Call method under test
			Customer.validateCustomer_Name("HHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHH");
			fail("Exception expected");
		} catch (CustomerExceptionHandler e) {
			// TODO Auto-generated catch block
			assertEquals("Customer Name does not exceeds maximum length requirements", e.getMessage());

		}

	}

	// Test #: 4
	// Test Objective: To catch a invalid Customer Name
	// Inputs: name = ""
	// Expected Output: Exception Message: "Customer Name does not exceeds
	// maximum length requirements"

	public void validateCustomer_Name003() {

		try {

			// Call method under test
			Customer.validateCustomer_Name("");
			fail("Exception expected");
		} catch (CustomerExceptionHandler e) {
			// TODO Auto-generated catch block
			assertEquals("Customer Name NOT specified", e.getMessage());
		}

	}

	// Test #: 5
	// Test Objective: To catch a valid Customer Name
	// Inputs: name = "Hong"
	// Expected Output: the Customer name is valid
	// maximum length requirements"

//	public void validateCustomer_Name004() {
//
//		try {
//
//			// Call method under test
//			Customer.validateCustomer_Name("Hong");
//			assertEquals("Customer Name NOT specified",);
//			fail("Exception expected");
//		} catch (CustomerExceptionHandler e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//
//	}

	// Test #: 5
	// Test Objective: To catch a invalid Customer Address
	// Inputs: address = ""
	// Expected Output: Exception Message: "Customer Name does not exceeds
	// maximum length requirements"

	public void testValidateAddress001() {

		try {

			// Call method under test
			Customer.validateCustomer_Address("");
			fail("Exception expected");
		} catch (CustomerExceptionHandler e) {
			// TODO Auto-generated catch block
			assertEquals("Customer Address NOT specified", e.getMessage());
		}

	}

	// Test #: 6
	// Test Objective: To catch a invalid Customer Address
	// Inputs: address = "Athl"
	// Expected Output: Exception Message: "Customer Name does not exceeds
	// maximum length requirements"

	public void testValidateAddress002() {

		try {

			// Call method under test
			Customer.validateCustomer_Address("A");
			fail("Exception expected");
		} catch (CustomerExceptionHandler e) {
			// TODO Auto-generated catch block
			assertEquals("Customer Address does not meet minimum length requirements", e.getMessage());
		}

	}

	// Test #: 7
	// Test Objective: To catch a invalid Customer Address
	// Inputs: address =
	// "Athloneeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeee"
	// Expected Output: Exception Message: "Customer Name does not exceeds
	// maximum length requirements"

	public void testValidateAddress003() {

		try {

			// Call method under test
			Customer.validateCustomer_Address("Athloneeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeee");
			fail("Exception expected");
		} catch (CustomerExceptionHandler e) {
			// TODO Auto-generated catch block
			assertEquals("Customer Address does not exceeds maximum length requirements", e.getMessage());
		}

	}

	// Test #: 8
	// Test Objective: To catch a invalid Customer ContactNumber
	// Inputs: Contact = ""
	// Expected Output: Exception Message: "Customer Name does not exceeds
	// maximum length requirements"

	public void testvalidateCustomer_Contact001() {

		try {

			// Call method under test
			Customer.validateCustomer_Contact("");
			;
			fail("Exception expected");
		} catch (CustomerExceptionHandler e) {
			// TODO Auto-generated catch block
			assertEquals("Customer ContactNumber NOT specified", e.getMessage());
		}

	}

	// Test #: 9
	// Test Objective: To catch a invalid Customer ContactNumber
	// Inputs: Contact = "123456"
	// Expected Output: Exception Message: "Customer ContactNumber does not
	// meet minimum length requirements"

	public void testvalidateCustomer_Contact002() {

		try {

			// Call method under test
			Customer.validateCustomer_Contact("123456");
			fail("Exception expected");
		} catch (CustomerExceptionHandler e) {
			// TODO Auto-generated catch block
			assertEquals("Customer ContactNumber does not meet minimum length requirements", e.getMessage());
		}

	}

	// Test #: 10
	// Test Objective: To catch a invalid Customer ContactNumber
	// Inputs: Contact = "123456789123456"
	// Expected Output: Exception Message: "Customer ContactNumber does not
	// exceeds maximum length requirement"

	public void testvalidateCustomer_Contact003() {

		try {

			// Call method under test
			Customer.validateCustomer_Contact("1234567891234567");
			fail("Exception expected");
		} catch (CustomerExceptionHandler e) {
			// TODO Auto-generated catch block
			assertEquals("Customer ContactNumber does not exceeds maximum length requirements", e.getMessage());
		}

	}

	// Test #: 11
	// Test Objective: To catch a invalid Delivery Area
	// Inputs: area = ""
	// Expected Output: Exception Message: "Delivery Area does not exceeds maximum
	// length requirement"

	public void testValidateArea001() {

		try {

			// Call method under test
			Customer.validateArea("");
			fail("Exception expected");
		} catch (CustomerExceptionHandler e) {
			// TODO Auto-generated catch block
			assertEquals("Customer Area NOT specified", e.getMessage());
		}

	}

	// Test #: 12
	// Test Objective: To catch a invalid Delivery Area
	// Inputs: area = "w"
	// Expected Output: Exception Message: "Delivery Area does not exceeds maximum
	// length requirements"

	public void testValidateArea002() {

		try {

			// Call method under test
			Customer.validateArea("W");
			fail("Exception expected");
		} catch (CustomerExceptionHandler e) {
			// TODO Auto-generated catch block
			assertEquals("Customer Area does not meet minimum length requirements", e.getMessage());
		}

	}

	// Test #: 13
	// Test Objective: To catch a invalid Delivery Area
	// Inputs: area =
	// "Wiiloweeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeee"
	// Expected Output: Exception Message: "Customer Name does not exceeds
	// maximum length requirements"

	public void testValidateArea003() {

		try {

			// Call method under test
			Customer.validateArea("Wiiloweeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeee");
			fail("Exception expected");
		} catch (CustomerExceptionHandler e) {
			// TODO Auto-generated catch block
			assertEquals("Customer Area does not exceeds maximum length requirements", e.getMessage());
		}

	}

	// Test #: 14
	// Test Objective: To update successfully a Customer Name
	// Inputs: name = "Zhou"
	// Expected Output: name of the Customer has been replaced with Zhou

	public void testUpdateName001() {

		try {

			Customer CusObj = new Customer("Hong", "Athlone", "087-123123123", "Garry");
			CusObj.updateCustomer_Name("Zhou");
			assertEquals("Zhou", CusObj.getCustomer_Name());

		} catch (CustomerExceptionHandler e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

	}

	// Test #: 15
	// Test Objective: To update successfully a Customer Name
	// Inputs: name = "Z"
	// Expected Output: Exception Message: "Fail to update name"

	public void testUpdateName002() {

		try {

			Customer CusObj = new Customer("Hong", "Athlone", "087-123123123", "Garry");
			CusObj.updateCustomer_Name("Z");

		} catch (CustomerExceptionHandler e) {
			// TODO Auto-generated catch block
			assertEquals("Fail to update Name", e.getMessage());
		}

	}

	// Test #: 16
	// Test Objective: To update successfully a Customer Address
	// Inputs: address = "Cork"
	// Expected Output: address has been replaced with Zhou

	public void testUpdateAddress001() {

		try {

			Customer CusObj = new Customer("Hong", "Athlone", "087-123123123", "Garry");
			CusObj.updateCustomer_Address("Cork");
			assertEquals("Cork", CusObj.getCustomer_Address());

		} catch (CustomerExceptionHandler e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

	}

	// Test #: 17
	// Test Objective: Fail to update a Customer Name
	// Inputs: address = "W"
	// Expected Output: Exception Message: "Fail to update address"

	public void testUpdateAddress002() {

		try {

			Customer CusObj = new Customer("Hong", "Athlone", "087-123123123", "Garry");
			CusObj.updateCustomer_Address("W");

		} catch (CustomerExceptionHandler e) {
			// TODO Auto-generated catch block
			assertEquals("Fail to update Address", e.getMessage());
		}

	}

	// Test #: 18
	// Test Objective: To update successfully a Customer Contact number
	// Inputs: Contact = "990099009900"
	// Expected Output: Contact has been replaced with 990099009900

	public void testUpdateContact001() {

		try {

			Customer CusObj = new Customer("Hong", "Athlone", "087-123123123", "Garry");
			CusObj.updateCustomer_Contact("990099009900");
			assertEquals("990099009900", CusObj.getCustomer_Contact());

		} catch (CustomerExceptionHandler e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

	}

	// Test #: 19
	// Test Objective: Fail to update a Customer Contact number
	// Inputs: Contact = "1"
	// Expected Output: Exception Message: ""Fail to update ContactNumber"

	public void testUpdateContact002() {

		try {

			Customer CusObj = new Customer("Hong", "Athlone", "087-123123123", "Garry");
			CusObj.updateCustomer_Contact("1");

		} catch (CustomerExceptionHandler e) {
			// TODO Auto-generated catch block
			assertEquals("Fail to update ContactNumber", e.getMessage());
		}

	}

	// Test #: 20
	// Test Objective: To update successfully a Delivery area
	// Inputs: area = "Crystal"
	// Expected Output: Delivery area has been replaced with Crystal

	public void testUpdateArea001() {

		try {

			Customer CusObj = new Customer("Hong", "Athlone", "087-123123123", "Garry");
			CusObj.updateArea("Crystal");
			assertEquals("Crystal", CusObj.getArea());

		} catch (CustomerExceptionHandler e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

	}

	// Test #: 21
	// Test Objective: Fail to update a Customer area
	// Inputs: area = "C"
	// Expected Output: Exception Message: ""Fail to update ContactNumber"

	public void testUpdateArea002() {

		try {

			Customer CusObj = new Customer("Hong", "Athlone", "087-123123123", "Garry");
			CusObj.updateArea("C");

		} catch (CustomerExceptionHandler e) {
			// TODO Auto-generated catch block
			assertEquals("Fail to update area", e.getMessage());
		}

	}

	// Test #: 22
	// Test Objective: Success to view the Customer details
	// Inputs: name = "Hong", address = "Athlone", Contact = "087-123123123", area=
	// "Garry"
	// Expected Output: The content of view method is similar to the "Hong Athlone
	// 087-123123123 Garry 10 Work"

	public void testViewCustomer001() {

		try {

			Customer CusObj = new Customer("Hong", "Athlone", "087-123123123", "Garry");
			String a = CusObj.viewCus();
			System.out.print(a);
			assertEquals("Hong Athlone 087-123123123 Garry", a);

		} catch (CustomerExceptionHandler e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}

package login;

import junit.framework.TestCase;

public class LoginTest extends TestCase {
	

		// Test #: 1
		// Test Objective: To create a Login Account
		// Inputs: username = "Hongggggg", password = "Athloneeeee", position = "Customer"
		// Expected Output: Login Object created with username = "Hongggggg", password = "Athloneeeee", position = "Customer"

		public void testLogin001() {

			// Create the Login Object

			Login LoginObj = null;

			try {

				// Call method under test
				LoginObj = new Login("Hongggggg", "Athloneeeeeeee", "Customer");

				// Use getters to check for object creation
				assertEquals("Hongggggg", LoginObj.getUsername());
				assertEquals("Athloneeeeeeee", LoginObj.getPassword());
				assertEquals("Customer", LoginObj.getPosition());

			} catch (LoginExceptionHandler e) {
				// TODO Auto-generated catch block
				fail("Exception not expected");
			}

		}

		// Test #: 2
		// Test Objective: To catch a invalid Login Name
		// Inputs: name = "H"
		// Expected Output: Exception Message: "Login Name does not meet
		// minimum length requirements"

		public void testValidateUsername001() {

			try {

				// Call method under test
				Login.validateUsername("H");
				fail("Exception expected");
			} catch (LoginExceptionHandler e) {
				// TODO Auto-generated catch block
				assertEquals("LOG_in name does not meet minimum length requirements", e.getMessage());

			}

		}

		// Test #: 3
		// Test Objective: To catch a invalid Login Name
		// Inputs: name = "HHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHH"
		// Expected Output: Exception Message: "Login Name exceeds
		// maximum length requirements"

		public void testValidateUsername002() {

			try {

				// Call method under test
				Login.validateUsername("HHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHH");
				fail("Exception expected");
			} catch (LoginExceptionHandler e) {
				// TODO Auto-generated catch block
				assertEquals("LOG_in name exceeds max length requirements", e.getMessage());

			}

		}

		// Test #: 4
		// Test Objective: To catch a invalid Login Name
		// Inputs: name = ""
		// Expected Output: Exception Message: "Login Name exceeds
		// maximum length requirements"

		public void validateUsername003() {

			try {

				// Call method under test
				Login.validateUsername("");
				fail("Exception expected");
			} catch (LoginExceptionHandler e) {
				// TODO Auto-generated catch block
				assertEquals("LOG_in Name NOT specified", e.getMessage());
			}

		}


		// Test #: 5
		// Test Objective: To catch a invalid Login Address
		// Inputs: address = ""
		// Expected Output: Exception Message: "Login Name exceeds
		// maximum length requirements"

		public void testValidatePassword001() {

			try {

				// Call method under test
				Login.validatePassword("");
				fail("Exception expected");
			} catch (LoginExceptionHandler e) {
				// TODO Auto-generated catch block
				assertEquals("LOG_in password NOT specified", e.getMessage());
			}

		}

		// Test #: 6
		// Test Objective: To catch a invalid Login Address
		// Inputs: address = "Athl"
		// Expected Output: Exception Message: "Login Name exceeds
		// maximum length requirements"

		public void testValidatePassword002() {

			try {

				// Call method under test
				Login.validatePassword("A");
				fail("Exception expected");
			} catch (LoginExceptionHandler e) {
				// TODO Auto-generated catch block
				assertEquals("LOG_in password does not meet minimum length requirements", e.getMessage());
			}

		}

		// Test #: 7
		// Test Objective: To catch a invalid Login Address
		// Inputs: address =
		// "Athloneeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeee"
		// Expected Output: Exception Message: "Login Name exceeds
		// maximum length requirements"

		public void testValidatePassword003() {

			try {

				// Call method under test
				Login.validatePassword("Athloneeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeee");
				fail("Exception expected");
			} catch (LoginExceptionHandler e) {
				// TODO Auto-generated catch block
				assertEquals("LOG_in password exceeds maximum length requirements", e.getMessage());
			}

		}

		// Test #: 8
		// Test Objective: To catch a invalid Login ContactNumber
		// Inputs: Contact = ""
		// Expected Output: Exception Message: "Login Name exceeds
		// maximum length requirements"

		public void testValidatePosition001() {

			try {

				// Call method under test
				Login.validatePosition("");
				fail("Exception expected");
			} catch (LoginExceptionHandler e) {
				// TODO Auto-generated catch block
				assertEquals("LOG_in position NOT specified", e.getMessage());
			}

		}

		// Test #: 9
		// Test Objective: To catch a invalid Login ContactNumber
		// Inputs: Contact = "123456"
		// Expected Output: Exception Message: "Login ContactNumber does not
		// meet minimum length requirements"

		public void testValidatePosition002() {

			try {

				// Call method under test
				Login.validatePosition("123456");
				fail("Exception expected");
			} catch (LoginExceptionHandler e) {
				// TODO Auto-generated catch block
				assertEquals("LOG_in position does not meet requirements", e.getMessage());
			}

		}

		
		// Test #: 10
		// Test Objective: To update successfully a Login Name
		// Inputs: name = "Zhou"
		// Expected Output: name of the Login has been replaced with Zhou

		public void testSetPassword001() {

			try {

				Login LoginObj = new Login("Hongggggg", "Athloneeeeeeee", "Customer");
				LoginObj.setPassword("Hongggggg");
				assertEquals("Hongggggg", LoginObj.getUsername());

			} catch (LoginExceptionHandler e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}

		}

		// Test #: 11
		// Test Objective: To update successfully a Login Name
		// Inputs: name = "Z"
		// Expected Output: Exception Message: "Fail to update name"

		public void testUpdateName002() {

			try {

				Login LoginObj = new Login("Hongggggg", "Athloneeeeeeee", "Customer");
				LoginObj.setPassword("Z");

			} catch (LoginExceptionHandler e) {
				// TODO Auto-generated catch block

				assertEquals("Fail to update password", e.getMessage());
			}

		}
		}

	
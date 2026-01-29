package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import base.BaseTest;
import pages.LoginPage;

public class LoginNegativeTest extends BaseTest {
	
	
	
	@Test
	public void shouldShowErrorForInvalidCredentials() {
		LoginPage loginPage = new LoginPage(driver);
		
		loginPage.loginToOrangeHRM("invalidUser", "invalidPass");
		
		String error = loginPage.getLoginErrorMessage();
		
		Assert.assertTrue(error.contains("Invalid credentials"),
				"Expected invalid credentials toast message");
	}

	
	@Test
	public void shouldShowValidationForEmptyCredentials() {
		LoginPage loginPage = new LoginPage(driver);
		
		loginPage.loginToOrangeHRM("", "");
		
		Assert.assertEquals(loginPage.getRequiredFieldErrorCount(),
				2,
				"Username and Password should both show Required validation");
	}
}

package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import base.BaseTest;
import pages.LoginPage;
import utils.ConfigReader;

public class LoginTest extends BaseTest {
	
	@Test
	public void testSuccesfulLogin() {
		LoginPage loginPage = new LoginPage(driver);
		
		// Pulling username and password from config.properties
		loginPage.loginToOrangeHRM(
				ConfigReader.getProperty("username"),
				ConfigReader.getProperty("password")
				);
		
		Assert.assertTrue(loginPage.isDashboardVisible(), "Login failed!");
	}
	
}

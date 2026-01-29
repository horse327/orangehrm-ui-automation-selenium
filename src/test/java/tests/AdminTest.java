package tests;

import static org.testng.Assert.assertTrue;

import org.testng.annotations.Test;

import base.BaseTest;
import pages.AdminPage;
import pages.LoginPage;
import utils.ConfigReader;

public class AdminTest extends BaseTest {
	
	@Test (description = "Verify admin user search returns matching username", priority = 1)
	public void testSearchAdminUser_shouldReturnMatchingUsername() {
		
		// Test data
		String username = ConfigReader.getProperty("username");
		String password = ConfigReader.getProperty("password");
		String searchKeyword = "Admin";
		
		// Page Objects
		LoginPage loginPage = new LoginPage(driver);
		AdminPage adminPage = new AdminPage(driver);
		
		// Step 1: Login
		loginPage.loginToOrangeHRM(username, password);
		
		// Step 2: Navigate to Admin module and search user
		adminPage.navigateToAdmin();
		adminPage.searchUser(searchKeyword);
		
		//3. Verify the search result matches
		String actualUsername = adminPage.getfirstResultUsername();
		assertTrue(actualUsername.contains(searchKeyword),
				"Expected username to contain'" + searchKeyword + "' but found: " + actualUsername);
	}

}

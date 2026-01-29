package tests;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import base.BaseTest;
import pages.LoginPage;
import pages.PIMPage;
import utils.ConfigReader;

public class PIMTest extends BaseTest {

	@DataProvider (name = "EmployeeData")
	public Object[][] getEmployeeData(){
		return new Object [][] {
			{"Budi", "Santoso"},
			{"Siti", "Aminah"},
			{"Agus", "Pratama"}
		};
	}
	
	
	@Test(dataProvider = "EmployeeData")
	public void shouldAddAndDeleteEmployeeSuccessfully(String firstName, String lastName) {
		
		// ==== Arrange ====
		LoginPage loginPage = new LoginPage(driver);
		PIMPage pimPage = new PIMPage(driver);
		
		// ==== Act: Login ====
		loginPage.loginToOrangeHRM(ConfigReader.getProperty("username"),ConfigReader.getProperty("password"));
		
		// ==== Act: Add Employee ====
		pimPage.navigateToPIM();
		pimPage.addNewEmployee(firstName, lastName);
		
		// ==== Assert: Employee Added ====
		Assert.assertTrue(
				pimPage.isEmployeeProfileDisplayed(),
				"Employee was not added successfully for: " + firstName + " " + lastName);
		
		// ==== Act: Delete Employee ====
		// NOTE: This deletes the first employee in the list.
		// Assumption: Newly added employee appears at the top
		pimPage.navigateToPIM();
		pimPage.deleteFirstEmployee();
	
		// ==== Assert: Employee Deleted ====
		Assert.assertTrue(
				pimPage.isEmployeeDeletedSuccessfully(),
				"Employee was not deleted successfully for: " + firstName + " " + lastName);
	}
	


}

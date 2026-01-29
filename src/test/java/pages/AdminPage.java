package pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class AdminPage {
	
	private WebDriverWait wait;
	
	
	// ==== Locators ====
	private By adminMenu = By.xpath("//span[normalize-space()='Admin']");
	private By usernameSearchField = By.xpath("//label[normalize-space()= 'Username']/following::input[1]");
	private By searchButton = By.xpath("//button[@type='submit']");
	private By firstResultUsername = By.xpath("//div[@class='oxd-table-body']//div[@role='row'][1]//div[@role='cell'][2]");
	
	// ==== Constructor ====
	public AdminPage(WebDriver driver) {
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }
	
	
	public void navigateToAdmin() {
		wait.until(ExpectedConditions.elementToBeClickable(adminMenu)).click();
	}
	
	public void searchUser(String username) {
		wait.until(ExpectedConditions.visibilityOfElementLocated(usernameSearchField)).clear();
		wait.until(ExpectedConditions.visibilityOfElementLocated(usernameSearchField)).sendKeys(username);
		wait.until(ExpectedConditions.elementToBeClickable(searchButton)).click();
	}
	
	// ==== Verifications ====
	
	public String getfirstResultUsername() {
		// We wait for the table to refresh with the search result
		return wait.until(ExpectedConditions.visibilityOfElementLocated(firstResultUsername)).getText();
	}
	
	

}

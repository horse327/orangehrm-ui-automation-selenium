package pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage {
	private WebDriver driver;
	private WebDriverWait wait;
	
	// Locators for OrangeHRM
	private By usernameField = By.name("username");
	private By passwordField = By.name("password");
	private By loginButton = By.xpath("//button[@type='submit']");
	private By dashboardHeader = By.xpath("//h6[text()='Dashboard']");
	private By requiredFieldErrors = By.cssSelector("span.oxd-input-field-error-message");
	private By loginErrorToast = By.cssSelector(".oxd-alert-content-text");

	
	public LoginPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(20));
    }
	
	public void loginToOrangeHRM(String username, String password) {
		wait.until(ExpectedConditions.visibilityOfElementLocated(usernameField)).clear();
		driver.findElement(usernameField).sendKeys(username);
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(passwordField)).clear();
		driver.findElement(passwordField).sendKeys(password);
		
		
		
		wait.until(ExpectedConditions.elementToBeClickable(loginButton)).click();
	}
	
	// For invalid username/password
	public String getLoginErrorMessage() {
		return wait.until(ExpectedConditions.visibilityOfElementLocated(loginErrorToast)).getText();
	}
	
	// For empty username/password
	
	public int getRequiredFieldErrorCount(){
		return wait.until(ExpectedConditions.numberOfElementsToBeMoreThan(requiredFieldErrors, 0)).size();
	}
	
	
	public boolean isDashboardVisible() {
		return wait.until(ExpectedConditions.visibilityOfElementLocated(dashboardHeader)).isDisplayed();
	}

}
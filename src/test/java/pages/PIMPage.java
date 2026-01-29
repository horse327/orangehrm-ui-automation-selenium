package pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PIMPage {
	private WebDriver driver;
	private WebDriverWait wait;
	
	// Locators
	private By pimMenu = By.xpath("//span[normalize-space()='PIM']");
	private By addButton = By.xpath("//button[.//i[contains(@class,'bi-plus')]]");
	private By firstNameField = By.name("firstName");
	private By lastNameField = By.name("lastName");
	private By saveButton = By.xpath("//button[@type='submit']");
	private By loader = By.cssSelector(".oxd-form-loader");
	private By deleteIcon = By.xpath("(//i[contains(@class,'bi-trash')])[1]");
	private By confirmDeleteButton = By.xpath("//button[contains(.,'Delete')]");
	private By successToast = By.xpath("//div[contains(@class,'oxd-toast--success')]");
	private By deleteSuccessToast = By.xpath("//div[contains(@class,'oxd-toast--success')]");
	
	public PIMPage(WebDriver driver) {
		this.driver = driver;
		this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	}
	
	public void navigateToPIM() {
		wait.until(ExpectedConditions.elementToBeClickable(pimMenu)).click();
	}
	
	public void addNewEmployee(String firstName, String lastName) {
		wait.until(ExpectedConditions.elementToBeClickable(addButton)).click();
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(firstNameField)).clear();
		driver.findElement(firstNameField).sendKeys(firstName);
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(lastNameField)).clear();
		driver.findElement(lastNameField).sendKeys(lastName);
		
		wait.until(ExpectedConditions.elementToBeClickable(saveButton)).click();
		waitForLoaderToDissapear();
	}
	
	private void waitForLoaderToDissapear() {
		wait.until(ExpectedConditions.invisibilityOfElementLocated(loader));
	}
	
	public void deleteFirstEmployee() {
		 // Note: Deletes the first employee in the list (demo limitation)
		wait.until(ExpectedConditions.elementToBeClickable(deleteIcon)).click();
		wait.until(ExpectedConditions.elementToBeClickable(confirmDeleteButton)).click();
		waitForLoaderToDissapear();
		
	}
	
	public boolean isEmployeeProfileDisplayed() {
		return wait.until(ExpectedConditions.visibilityOfElementLocated(successToast)).isDisplayed();
	}
	
	public boolean isEmployeeDeletedSuccessfully() {
		return wait.until(ExpectedConditions.visibilityOfElementLocated(deleteSuccessToast)).isDisplayed();
	}
	
	
}

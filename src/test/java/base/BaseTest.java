package base;

import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.apache.commons.io.FileUtils;
import org.testng.ITestResult;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import io.github.bonigarcia.wdm.WebDriverManager;
import utils.ConfigReader;

public class BaseTest {
	protected WebDriver driver;
	
	@BeforeMethod
	public void setUp () {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver ();
		
		driver.manage().window().maximize();
		
		String url = ConfigReader.getProperty("url");
		driver.get(url);
	}
	
	public void takeScreenshot(String testName) {
	try {
		File screenshotDir = new File(System.getProperty("user.dir") + "/screenshots");
		if (!screenshotDir.exists()) {
			screenshotDir.mkdirs();
		}
		
		String timestamp = LocalDateTime.now()
				.format(DateTimeFormatter.ofPattern("yyyyMMdd_HHmmss"));
				
		File source = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		File destination = new File(screenshotDir + "/" + testName + "_" + timestamp + ".png");
		FileUtils.copyFile(source, destination);

		
	} catch (IOException e) {
		System.err.println("Failed to capture screenshot: " + e.getMessage());
	}
	
	}
	
	@AfterMethod
	public void tearDown(ITestResult result) {
		if (ITestResult.FAILURE == result.getStatus()) {
			takeScreenshot (result.getTestName());
		}
		
		if (driver != null) {
			driver.quit();
		}
	}

}

package sit707_week2;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import java.util.List;


public class SeleniumOperations {

	public static void sleep(int sec) {
		try {
			Thread.sleep(sec*1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	public static void officeworks_registration_page(String url) {
		System.setProperty("webdriver.chrome.driver","C:\\Users\\Srikar\\chromedriver-win64\\chromedriver.exe");
		
		System.out.println("Fire up chrome browser.");
		WebDriver driver = new ChromeDriver();
		
		System.out.println("Driver info: " + driver);
		
		sleep(2);
	
		driver.get(url);

		WebElement element = driver.findElement(By.id("firstname"));
		System.out.println("Found element: " + element);
		element.sendKeys("Srikar");
		driver.findElement(By.id("lastname")).sendKeys("Boske");
		driver.findElement(By.id("phoneNumber")).sendKeys("0412183780");
		driver.findElement(By.id("email")).sendKeys("boskesrikar@gmail.com");
		driver.findElement(By.id("password")).sendKeys("789654");
		driver.findElement(By.id("confirmPassword")).sendKeys("1236457");

		WebElement createButton = driver.findElement(By.xpath("//button[contains(text(),'Create account')]"));
		createButton.click();

		sleep(3);

		// Take screenshot
		File srcFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		File destFile = new File("W:\\Deakin\\T3\\SIT707\\officeworks_registration.png");

		try {
			FileUtils.copyFile(srcFile, destFile);
			System.out.println("Screenshot saved successfully at: " + destFile.getAbsolutePath());
		} catch (IOException e) {
			e.printStackTrace();
		}

		sleep(2);
				
		driver.close();	
	}
	
	
	public static void footlocker_registration(String footlocker_registration) {
		System.setProperty("webdriver.chrome.driver","C:\\Users\\Srikar\\chromedriver-win64\\chromedriver.exe");
		
		System.out.println("Fire up chrome browser.");
		WebDriver driver = new ChromeDriver();
		
		System.out.println("Driver info: " + driver);
		
		sleep(2);
	
		driver.get(footlocker_registration);
		
		WebElement element = driver.findElement(By.id("AccountCreate_text_firstName"));
		System.out.println("Found element: " + element);
		element.sendKeys("Srikar");
		driver.findElement(By.id("AccountCreate_text_lastName")).sendKeys("Boske");
		driver.findElement(By.id("AccountCreate_email_uid")).sendKeys("boskesrikar@gmail.com");
		driver.findElement(By.id("AccountCreate_password_password")).sendKeys("252525");
		driver.findElement(By.id("AccountCreate_tel_dateofbirthday")).sendKeys("19");
		driver.findElement(By.id("AccountCreate_tel_dateofbirthmonth")).sendKeys("09");
		driver.findElement(By.id("AccountCreate_tel_dateofbirthyear")).sendKeys("2003");

		List<WebElement> checkboxes = driver.findElements(By.className("c-form-field__indicator"));

		if (checkboxes.size() >= 2) {
		    checkboxes.get(0).click();
		    checkboxes.get(1).click();
		} else if (checkboxes.size() == 1) {
		    checkboxes.get(0).click();
		    System.out.println("Only one checkbox found.");
		} else {
		    System.out.println("No checkbox found.");
		}
		sleep(2);
				
		driver.close();	
	}
	
	
	
}

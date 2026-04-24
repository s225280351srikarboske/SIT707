package web.service;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class SeleniumTest {

	WebDriver driver;

	@Before
	public void setup() {
		System.setProperty(
				"webdriver.chrome.driver",
				"C:\\Users\\Srikar\\chromedriver-win64\\chromedriver.exe"
		);
		driver = new ChromeDriver();
		driver.get("http://127.0.0.1:8080/login");
	}

	@Test
	public void testSuccessfulFlow() throws InterruptedException {

		// LOGIN
		driver.findElement(By.id("username")).sendKeys("ahsan");
		driver.findElement(By.id("passwd")).sendKeys("ahsan_pass");
		driver.findElement(By.id("dob")).sendKeys("2000-01-01");
		driver.findElement(By.xpath("//input[@type='submit']")).click();

		Thread.sleep(2000);

		// Q1 → 2 + 3 = 5
		driver.findElement(By.id("number1")).sendKeys("2");
		driver.findElement(By.id("number2")).sendKeys("3");
		driver.findElement(By.id("result")).sendKeys("5");
		driver.findElement(By.xpath("//input[@type='submit']")).click();

		Thread.sleep(2000);

		// Q2 → 7 - 3 = 4
		driver.findElement(By.id("number1")).sendKeys("7");
		driver.findElement(By.id("number2")).sendKeys("3");
		driver.findElement(By.id("result")).sendKeys("4");
		driver.findElement(By.xpath("//input[@type='submit']")).click();

		Thread.sleep(2000);

		// Q3 → 4 * 3 = 12
		driver.findElement(By.id("number1")).sendKeys("4");
		driver.findElement(By.id("number2")).sendKeys("3");
		driver.findElement(By.id("result")).sendKeys("12");
		driver.findElement(By.xpath("//input[@type='submit']")).click();

		Thread.sleep(2000);

		// CHECK SUCCESS PAGE
		Assert.assertTrue(driver.getPageSource().contains("Congratulations"));
	}

	@Test
	public void testInvalidLogin() throws InterruptedException {

		driver.findElement(By.id("username")).sendKeys("wrong");
		driver.findElement(By.id("passwd")).sendKeys("wrong");
		driver.findElement(By.id("dob")).sendKeys("2000-01-01");
		driver.findElement(By.xpath("//input[@type='submit']")).click();

		Thread.sleep(2000);

		Assert.assertTrue(driver.getPageSource().contains("Incorrect credentials"));
	}

	@Test
	public void testWrongAnswerQ1() throws InterruptedException {

		// LOGIN FIRST
		driver.findElement(By.id("username")).sendKeys("ahsan");
		driver.findElement(By.id("passwd")).sendKeys("ahsan_pass");
		driver.findElement(By.id("dob")).sendKeys("2000-01-01");
		driver.findElement(By.xpath("//input[@type='submit']")).click();

		Thread.sleep(2000);

		// WRONG ANSWER
		driver.findElement(By.id("number1")).sendKeys("2");
		driver.findElement(By.id("number2")).sendKeys("3");
		driver.findElement(By.id("result")).sendKeys("10");
		driver.findElement(By.xpath("//input[@type='submit']")).click();

		Thread.sleep(2000);

		Assert.assertTrue(driver.getPageSource().contains("Wrong answer"));
	}

	@After
	public void close() {
		driver.quit();
	}
}
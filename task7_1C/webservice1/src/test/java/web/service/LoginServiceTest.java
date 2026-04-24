package web.service;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class LoginServiceTest {

	private void sleep(long sec) {
		try {
			Thread.sleep(sec * 1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	private void runLoginTest(String username, String password, String dob, String expectedTitle) {
		System.setProperty(
				"webdriver.chrome.driver",
				"C:\\Users\\Srikar\\chromedriver-win64\\chromedriver.exe"
		);

		WebDriver driver = new ChromeDriver();

		driver.navigate().to(
				"file:///W:/Deakin/T3/SIT707/Java_project/task7_1C/pages/login.html"
		);

		sleep(2);

		driver.findElement(By.id("username")).clear();
		driver.findElement(By.id("username")).sendKeys(username);

		driver.findElement(By.id("passwd")).clear();
		driver.findElement(By.id("passwd")).sendKeys(password);

		driver.findElement(By.id("dob")).clear();
		driver.findElement(By.id("dob")).sendKeys(dob);

		driver.findElement(By.cssSelector("[type=submit]")).click();

		sleep(2);

		String title = driver.getTitle();
		System.out.println("Expected: " + expectedTitle + " | Actual: " + title);

		Assert.assertEquals(expectedTitle, title);

		driver.close();
	}

	@Test
	public void testLoginSuccess() {
		runLoginTest("ahsan", "ahsan_pass", "1990-01-01", "success");
	}

	@Test
	public void testInvalidUsername() {
		runLoginTest("wronguser", "ahsan_pass", "1990-01-01", "fail");
	}

	@Test
	public void testInvalidPassword() {
		runLoginTest("ahsan", "wrongpass", "1990-01-01", "fail");
	}

	@Test
	public void testInvalidDob() {
		runLoginTest("ahsan", "ahsan_pass", "2000-01-01", "fail");
	}

	@Test
	public void testEmptyUsername() {
		runLoginTest("", "ahsan_pass", "1990-01-01", "fail");
	}

	@Test
	public void testEmptyPassword() {
		runLoginTest("ahsan", "", "1990-01-01", "fail");
	}

	@Test
	public void testEmptyDob() {
		runLoginTest("ahsan", "ahsan_pass", "", "fail");
	}
}
package sit707_week2;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

import java.time.Duration;

public class BunningsLoginTest {

    private static final String LOGIN_URL = "https://www.bunnings.com.au/login";

    // Replace these only if you want to test a real successful login
    private static final String VALID_EMAIL = "your_email_here";
    private static final String VALID_PASSWORD = "your_password_here";

    private static final String INVALID_EMAIL = "wronguser123@gmail.com";
    private static final String INVALID_PASSWORD = "wrongpass123";

    private WebDriver driver;
    private WebDriverWait wait;

    @Before
    public void setUp() {
        WebDriverManager.chromedriver().setup();

        ChromeOptions options = new ChromeOptions();
        options.addArguments("--start-maximized");

        driver = new ChromeDriver(options);
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    @After
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }

    private void openLoginPage() {
        driver.get(LOGIN_URL);
    }

    private void doLogin(String email, String password) {
        openLoginPage();

        WebElement emailField = wait.until(
                ExpectedConditions.visibilityOfElementLocated(By.id("loginForm_emailAddress"))
        );

        WebElement passwordField = driver.findElement(By.id("loginForm_password"));
        WebElement loginButton = driver.findElement(By.cssSelector("button[data-locator='login-submit']"));

        emailField.clear();
        emailField.sendKeys(email);

        passwordField.clear();
        passwordField.sendKeys(password);

        loginButton.click();
    }

    @Test
    public void testStudentIdentity() {
        String studentId = "225280351";
        Assert.assertNotNull("Student ID must not be null", studentId);
    }

    @Test
    public void testStudentName() {
        String studentName = "Srikar Boske";
        Assert.assertNotNull("Student name must not be null", studentName);
    }

    // Decision table tests

    @Test
    public void testValidEmailAndInvalidPassword() throws InterruptedException {
        doLogin(VALID_EMAIL, INVALID_PASSWORD);
        Thread.sleep(3000);
        String currentUrl = driver.getCurrentUrl();
        Assert.assertTrue("Expected to remain on login page", currentUrl.contains("login"));
    }

    @Test
    public void testInvalidEmailAndValidPassword() throws InterruptedException {
        doLogin(INVALID_EMAIL, VALID_PASSWORD);
        Thread.sleep(3000);
        String currentUrl = driver.getCurrentUrl();
        Assert.assertTrue("Expected to remain on login page", currentUrl.contains("login"));
    }

    @Test
    public void testInvalidEmailAndInvalidPassword() throws InterruptedException {
        doLogin(INVALID_EMAIL, INVALID_PASSWORD);
        Thread.sleep(3000);
        String currentUrl = driver.getCurrentUrl();
        Assert.assertTrue("Expected to remain on login page", currentUrl.contains("login"));
    }

    @Test
    public void testEmptyEmailAndEmptyPassword() throws InterruptedException {
        doLogin("", "");
        Thread.sleep(3000);
        String currentUrl = driver.getCurrentUrl();
        Assert.assertTrue("Expected to remain on login page", currentUrl.contains("login"));
    }

    @Test
    public void testEmptyEmailAndValidPassword() throws InterruptedException {
        doLogin("", VALID_PASSWORD);
        Thread.sleep(3000);
        String currentUrl = driver.getCurrentUrl();
        Assert.assertTrue("Expected to remain on login page", currentUrl.contains("login"));
    }

    @Test
    public void testValidEmailAndEmptyPassword() throws InterruptedException {
        doLogin(VALID_EMAIL, "");
        Thread.sleep(3000);
        String currentUrl = driver.getCurrentUrl();
        Assert.assertTrue("Expected to remain on login page", currentUrl.contains("login"));
    }

    @Test
    public void testValidEmailAndValidPassword() throws InterruptedException {
        doLogin(VALID_EMAIL, VALID_PASSWORD);
        Thread.sleep(5000);
        String currentUrl = driver.getCurrentUrl();
        Assert.assertTrue("Expected successful login", currentUrl.contains("account") || currentUrl.contains("my-account"));
    }
}
package demo;

import java.io.InputStream;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
import org.testng.annotations.*;
import static org.testng.Assert.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class SimpleTest {
	private WebDriver driver;
	private String baseUrl;
	private boolean acceptNextAlert = true;
	private StringBuffer verificationErrors = new StringBuffer();

	private String browser;

	public static Properties prop = new Properties();

	@BeforeClass(alwaysRun = true)
	public void setUp() throws Exception {
		InputStream input = this.getClass().getClassLoader().getResourceAsStream("config/config.properties");
		prop.load(input);
		browser = prop.getProperty("browser");
		switch (browser) {
			case "chrome":
				System.setProperty("webdriver.chrome.driver", prop.getProperty("chromeDriverPath"));
				driver = new ChromeDriver();
				break;
			case "firefox":
				System.setProperty("webdriver.gecko.driver", prop.getProperty("fireFoxDriverPath"));
				driver = new FirefoxDriver();
				break;
			default:
				System.setProperty("webdriver.chrome.driver", prop.getProperty("chromeDriverPath"));
				driver = new ChromeDriver();
		}
		driver.manage().timeouts().implicitlyWait(Integer.parseInt(prop.getProperty("timeout")), TimeUnit.SECONDS);
	}

	@Test
	public void testOrangeHRM() throws Exception {
		driver.get("https://opensource-demo.orangehrmlive.com/index.php/auth/login");
		driver.findElement(By.id("txtUsername")).click();
		driver.findElement(By.id("txtUsername")).clear();
		driver.findElement(By.id("txtUsername")).sendKeys("Admin");
		driver.findElement(By.id("txtPassword")).clear();
		driver.findElement(By.id("txtPassword")).sendKeys("admin123");
		driver.findElement(By.id("frmLogin")).submit();
		try {
			assertEquals(driver.findElement(By.id("welcome")).getText(), "Welcome Admin");
		} catch (Error e) {
			verificationErrors.append(e.toString());
		}
		Thread.sleep(2000);
		driver.findElement(By.id("welcome")).click();
		driver.findElement(By.linkText("Logout")).click();
	}

	@AfterClass(alwaysRun = true)
	public void tearDown() throws Exception {
		//driver.quit();
		String verificationErrorString = verificationErrors.toString();
		if (!"".equals(verificationErrorString)) {
			fail(verificationErrorString);
		}
	}

	private boolean isElementPresent(By by) {
		try {
			driver.findElement(by);
			return true;
		} catch (NoSuchElementException e) {
			return false;
		}
	}

	private boolean isAlertPresent() {
		try {
			driver.switchTo().alert();
			return true;
		} catch (NoAlertPresentException e) {
			return false;
		}
	}

	private String closeAlertAndGetItsText() {
		try {
			Alert alert = driver.switchTo().alert();
			String alertText = alert.getText();
			if (acceptNextAlert) {
				alert.accept();
			} else {
				alert.dismiss();
			}
			return alertText;
		} finally {
			acceptNextAlert = true;
		}
	}
}
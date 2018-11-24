package demo.test;
import demo.util.Functions;
import static org.testng.Assert.fail;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;


import demo.util.Log;

public class BaseTest {

	protected static WebDriver driver;
	protected String baseUrl;
	protected boolean acceptNextAlert = true;
	protected StringBuffer verificationErrors = new StringBuffer();

	private String browser;

	public static Properties prop = new Properties();
	private static Logger logger = LogManager.getLogger(Log.class);
	private static String screenShotFolderPath = "C:/Users/Pawan/eclipse-workspace-oxygen/automation/src/test/resourcee/screenshots/";

	@BeforeClass(alwaysRun = true)
	public void setUp() throws Exception {
		InputStream input = this.getClass().getClassLoader().getResourceAsStream("config/config.properties");
		prop.load(input);
		browser = prop.getProperty("browser");

		switch (browser) {
		case "chrome":
			System.setProperty("webdriver.chrome.driver", prop.getProperty("chromeDriverPath"));
			driver = new ChromeDriver();
			logger.log(Level.INFO, "************ Chrome Launched *************");
			break;
		case "firefox":
			System.setProperty("webdriver.gecko.driver", prop.getProperty("fireFoxDriverPath"));
			driver = new FirefoxDriver();
			logger.log(Level.INFO, "************ Chrome Launched *************");
			break;
		default:
			System.setProperty("webdriver.chrome.driver", prop.getProperty("chromeDriverPath"));
			driver = new ChromeDriver();
			logger.log(Level.INFO, "************ Default Brower Launched *************");
		}
		driver.manage().timeouts().implicitlyWait(Integer.parseInt(prop.getProperty("timeout")), TimeUnit.SECONDS);
	}

	public static String captureScreenShot() {
        String filename = Functions.getTimeStamp("yyyy-MM-dd_HH:mm:ss")+".jpg";
        File screenshotFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        try {
            FileUtils.copyFile(screenshotFile, new File(screenShotFolderPath + filename));
        } catch (IOException e) {
            e.printStackTrace();
        }    
        return filename;
    }

	@AfterClass(alwaysRun = true)
	public void tearDown() throws Exception {
		driver.quit();
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

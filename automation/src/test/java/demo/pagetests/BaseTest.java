package demo.pagetests;
import java.io.InputStream;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import demo.util.Log;

public class BaseTest {
	private static Logger logger = LogManager.getLogger(Log.class);

	protected static WebDriver driver;
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
		driver.get(prop.getProperty("baseUrl"));
		driver.manage().timeouts().implicitlyWait(Integer.parseInt(prop.getProperty("timeout")), TimeUnit.SECONDS);
	}

	@AfterClass(alwaysRun = true)
	public void tearDown() throws Exception {
		//driver.quit();
	}

}

package demo;

import java.io.InputStream;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeClass;

public class BaseTest {

	protected WebDriver driver;
	protected String baseUrl;
	protected boolean acceptNextAlert = true;
	protected StringBuffer verificationErrors = new StringBuffer();

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

}

package demo.test;
import org.testng.Assert;
import org.testng.annotations.*;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import demo.util.Log;

import static org.testng.Assert.*;
import org.openqa.selenium.*;

public class LoginTest extends BaseTest {

	private static Logger logger = LogManager.getLogger(LoginTest.class);

	boolean flag =false;
	
	@Test
	public void testOrangeHRM() throws Exception {
		driver.get(prop.getProperty("baseUrl"));
		Log.startTestCase();
		driver.findElement(By.id("txtUsername")).click();
		driver.findElement(By.id("txtUsername")).clear();
		driver.findElement(By.id("txtUsername")).sendKeys("Admin");
		logger.log(Level.INFO, "************** Set User Name ************");
		driver.findElement(By.id("txtPassword")).clear();
		driver.findElement(By.id("txtPassword")).sendKeys("admin123");
		logger.log(Level.INFO, "************** Set Password *************");
		driver.findElement(By.id("frmLogin")).submit();
		try {
			assertEquals(driver.findElement(By.id("welcome")).getText(), "Welcome Admin");
			logger.log(Level.INFO, "************** Logged *************");
		} catch (Error e) {
			verificationErrors.append(e.toString());
		}
		
		//Checking values
		if (driver.findElement(By.id("welcome")).getText().equalsIgnoreCase("Welcome Admin2")) {
			flag =true;
		} else {
			String file = captureScreenShot();
			logger.log(Level.ERROR, "Failed To find the message\n"+"ScreenShot File "+file);		
		}
		
		Assert.assertTrue(flag);
		Thread.sleep(2000);
		driver.findElement(By.id("welcome")).click();
		driver.findElement(By.linkText("Logout")).click();
		logger.log(Level.INFO, "************** Logged Out *************");
		Log.endTestCase();
		
	}
}

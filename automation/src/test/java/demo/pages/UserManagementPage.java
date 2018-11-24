package demo.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class UserManagementPage extends BasePage {
	private WebElement lblHeader = driver.findElement(By.id("searchSystemUser_userName"));
	
	UserManagementPage(WebDriver webdriver) {
		super(webdriver);
		// TODO Auto-generated constructor stub
	}
	
	public boolean isUserManagementDisplayed() {
		boolean flag = false;
		try {
			lblHeader.isDisplayed();
			flag = true;
		} catch (Exception e) {
			flag = false;
		}
		return flag;
	}
}

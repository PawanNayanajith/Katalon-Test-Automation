package demo.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class DashBoardPage extends BasePage {

	private WebElement lblHeader = driver.findElement(By.xpath("//h1"));
	private WebElement btnUM = driver.findElement(By.id("menu_admin_viewAdminModule"));
	
	DashBoardPage(WebDriver webdriver) {
		super(webdriver);
		// TODO Auto-generated constructor stub
	}
	
	public UserManagementPage navigateToUserManagement() {
		btnUM.click();
		return new UserManagementPage(driver);
	}

	public boolean isDashBoardDisplayed() {
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

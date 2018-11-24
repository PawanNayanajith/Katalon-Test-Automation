package demo.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage extends BasePage {

	private WebElement txtUsername = driver.findElement(By.id("txtUsername"));
	private WebElement txtPassword = driver.findElement(By.id("txtPassword"));
	private WebElement btnLogin = driver.findElement(By.id("btnLogin"));

	public LoginPage(WebDriver webdriver) {
		super(webdriver);
		// TODO Auto-generated constructor stub
	}

	public DashBoardPage login(String userName, String password) {
		txtUsername.sendKeys(userName);
		txtPassword.sendKeys(password);
		btnLogin.click();
		return new DashBoardPage(driver);
	}
}

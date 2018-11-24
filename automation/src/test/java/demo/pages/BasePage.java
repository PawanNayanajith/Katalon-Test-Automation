package demo.pages;

import org.openqa.selenium.WebDriver;

public class BasePage {
	
	protected WebDriver driver;
	
	BasePage(WebDriver webdriver){
		this.driver=webdriver;
	}

}

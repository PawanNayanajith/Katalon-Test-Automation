package demo.pagetests;

import org.testng.Assert;
import org.testng.annotations.Test;

import demo.pages.DashBoardPage;
import demo.pages.LoginPage;

public class LoginTest extends BaseTest {
	
	@Test
	public void verifyAdminLogin() {
		LoginPage loginPage = new LoginPage(driver);
		DashBoardPage dashboardpage = loginPage.login("Admin", "admin123");
		Assert.assertTrue(dashboardpage.isDashBoardDisplayed());

	}

}

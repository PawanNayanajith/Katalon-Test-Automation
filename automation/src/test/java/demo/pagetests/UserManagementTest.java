package demo.pagetests;

import org.testng.Assert;
import org.testng.annotations.Test;

import demo.pages.DashBoardPage;
import demo.pages.LoginPage;
import demo.pages.UserManagementPage;

public class UserManagementTest extends BaseTest {

	@Test
	public void verifyUserManagement() {
		LoginPage loginPage = new LoginPage(driver);
		DashBoardPage dashboardpage = loginPage.login("Admin", "admin123");
		UserManagementPage usermanagementpage = dashboardpage.navigateToUserManagement();
		Assert.assertTrue(usermanagementpage.isUserManagementDisplayed());
	}
}

package com.qa.freecrm.tests;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.qa.freecrm.utility.Constants;

public class LoginPageTest extends BaseTest {
	@Test
	public void verifyLoginPageTitleTest() {
		String LoginPageTitle = loginpage.getLoginPageTitleTest();
		Assert.assertEquals(LoginPageTitle, Constants.LOGIN_PAGE_TITLE);
	}

	@Test
	public void verifytReturningCustomerTitleTest() {

		Assert.assertTrue(loginpage.getReturningCustomerTitle());
	}

	@Test
	public void verifyisForgotPasswordLinkTest() {
		Boolean status = loginpage.getisForgotPasswordLink();
		Assert.assertTrue(status);
	}

	@Test
	public void verifyLoginPageTilesTest() {
		List<String> tile = loginpage.getLoginPageTiles();

		Assert.assertEquals(tile, Constants.getLoginPageTile());

	}

	@Test
	public void verifyDoLoginTest() {
		accountpage = loginpage.doLogin(prop.getProperty("username"), prop.getProperty("password"));
		Assert.assertEquals(accountpage.getAccountPageTitle(), Constants.ACCOUNTS_PAGE_TITLE);
	}
}

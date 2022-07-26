package com.qa.freecrm.tests;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.qa.freecrm.utility.Constants;

public class LoginPageTest extends BaseTest {
	@Test
	public void verifyLoginPageTitleTest() {
		String LoginPageTitle = loginpage.getLoginPageTitle();
		//System.out.println(LoginPageTitle);
	Assert.assertEquals(LoginPageTitle, Constants.LOGIN_PAGE_TITLE);
	}

	@Test
	public void verifyisForgotPasswordLinkTest() {
		Boolean status = loginpage.getisForgotPasswordLink();
		Assert.assertTrue(status);
	}

	@Test
	public void verifyLoginPageTilesTest() {
		List<String> tile = loginpage.getLoginPageTiles();
		System.out.println(tile);
		Assert.assertEquals(tile, Constants.getLoginPageTiles());

	}

	@Test
	public void verifyDoLoginTest() {
		accountpage = loginpage.doLogin(prop.getProperty("username"), prop.getProperty("password"));
		Assert.assertEquals(accountpage.getAccountPageTitle(), Constants.ACCOUNTS_PAGE_TITLE);
	}
}

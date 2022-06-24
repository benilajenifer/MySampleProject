package com.qa.freecrm.tests;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.qa.freecrm.utility.Constants;

public class LoginPageTest extends BaseTest {

	public void verifyLoginPageTitleTest() {
		String LoginPageTitle = loginpage.getLoginPageTitleTest();
		Assert.assertEquals(LoginPageTitle, Constants.LOGIN_PAGE_TITLE);
	}

	public void verifytReturningCustomerTitle() {
		String ReturningCustomerTitle = loginpage.getReturningCustomerTitle();
		Assert.assertEquals(ReturningCustomerTitle, Constants.RETURNING_CUS_TILE);
	}

	public void verifyisForgotPasswordLink() {
		Boolean status = loginpage.getisForgotPasswordLink();
		Assert.assertTrue(status);
	}

	public void verifyLoginPageTiles() {
		List<String> tile = loginpage.getLoginPageTiles();
		for (String b : tile) {
			Assert.assertEquals(b, Constants.getLoginPageTile());
		}
	}

	public void verifyDoLogin() {
		accountpage = loginpage.doLogin(prop.getProperty("username"), prop.getProperty("password"));
		Assert.assertEquals(accountpage.getAccountPageTitle(), Constants.ACCOUNTS_PAGE_TITLE);
	}
}

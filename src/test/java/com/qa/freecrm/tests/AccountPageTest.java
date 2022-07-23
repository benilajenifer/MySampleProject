package com.qa.freecrm.tests;

import java.util.List;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.qa.freecrm.utility.Constants;

public class AccountPageTest extends BaseTest {

	@BeforeClass
	public void accountPageSetUp() {
		accountpage=loginpage.doLogin(prop.getProperty("username"), prop.getProperty("password"));
	}

	@Test
	public void verifyAccountPageHeadersTest() {

		List<String> acpge = accountpage.getAccountPageHeaders();
		System.out.println(acpge);

		Assert.assertEquals(acpge, Constants.getAccountPageSections());

	}

	@Test
	public void verifyAccountPageTitleTest() {
		String accPageTile = accountpage.getAccountPageTitle();
		Assert.assertEquals(accPageTile, Constants.ACCOUNTS_PAGE_TITLE);
	}
	
	@Test
	public void selectCurrencyTest()
	{
		accountpage.selectCurrency();
		
		
	}

}

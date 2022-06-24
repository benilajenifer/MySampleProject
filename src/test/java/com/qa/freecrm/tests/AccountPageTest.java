package com.qa.freecrm.tests;

import java.util.List;

import org.testng.Assert;

import com.qa.freecrm.utility.Constants;

public class AccountPageTest extends BaseTest {

	public void verifyAccountPageHeaders() {

		List<String> acpge = accountpage.getAccountPageHeaders();
		for (String o : acpge) {
			Assert.assertEquals(o, Constants.getAccountPageSections());
		}
	}

	public void verifyAccountPageTitle() {
		String accPageTile = accountpage.getAccountPageTitle();
		Assert.assertEquals(accPageTile, Constants.ACCOUNTS_PAGE_TITLE);
	}

}

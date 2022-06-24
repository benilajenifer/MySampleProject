package com.qa.freecrm.utility;

import java.util.Arrays;
import java.util.List;

public class Constants {
	public final static int LOGIN_PAGE_PARAGRAPH_COUNT = 15;
	public static final String LOGIN_PAGE_TITLE = "Account Login";
	public static final String ACCOUNTS_PAGE_TITLE = "My Account";
	public static final String RETURNING_CUS_TILE = "Returning Customer";

	public static List<String> getLoginPageTile() {
		return Arrays.asList("Login", "Register", "Forgotten Password", "My Account", "Address Book", "Wish List",
				"Order History", "Downloads", "Recurring payments", "Reward Points", "Returns", "Transactions",
				"Newsletter");
	}

	public static List<String> getAccountPageSections() {
		return Arrays.asList("My Account", "My Orders", "My Affiliate Account", "Newsletter");
	}
}

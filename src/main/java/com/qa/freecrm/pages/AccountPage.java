package com.qa.freecrm.pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.qa.freecrm.utility.ElementUtil;

public class AccountPage {
	private WebDriver driver;
	private ElementUtil eleutil;

	public AccountPage(WebDriver driver) {
		this.driver = driver;
		eleutil = new ElementUtil(driver);
	}

	private By AccountPageHeaders = By.xpath("//h2");

	// public methods

	public String getAccountPageTitle() {
		return driver.getTitle();
	}

	public List<String> getAccountPageHeaders() {
		List<WebElement> AccPageHead = eleutil.doGetElements(AccountPageHeaders);

		List<String> newAccPageHead = new ArrayList<String>();

		for (WebElement e : AccPageHead) {
			newAccPageHead.add(e.getText());
		}

		return newAccPageHead;
	}

}

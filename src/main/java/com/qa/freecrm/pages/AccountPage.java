package com.qa.freecrm.pages;

import java.time.Duration;
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
		eleutil = new ElementUtil(this.driver);
	}

	private By AccountPageHeaders = By.cssSelector("div#content h2 ");
	private By currencySelection = By.cssSelector("button.btn.btn-link.dropdown-toggle");
	private By currencyList = By.cssSelector("button.currency-select.btn.btn-link.btn-block");

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

	public void selectCurrency() {

		try {
			eleutil.getElement(currencySelection).click();

			List<WebElement> dropcurr = eleutil.doGetElements(currencyList);
			for (WebElement ele : dropcurr) {
				ele.click();
				eleutil.waitForElementsToBeVisible(currencySelection, Duration.ofSeconds(2));
			}
		} catch (Exception e) {
			e.printStackTrace();

		}

	}

}

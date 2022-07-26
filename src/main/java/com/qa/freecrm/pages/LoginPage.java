package com.qa.freecrm.pages;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.qa.freecrm.utility.ElementUtil;

public class LoginPage {
	private WebDriver driver;
	private ElementUtil eleutil;

	// private loactors:

	private By email = By.id("input-email");
	private By password = By.id("input-password");
	private By forgotPwdLink = By.xpath("(//a[text()='Forgotten Password'])[1]");
	private By loginButton = By.xpath("//input[@class='btn btn-primary']");
	private By loginPageTiles = By.cssSelector("div.list-group a");

	// constructor

	public LoginPage(WebDriver driver) {
		this.driver = driver;
		eleutil = new ElementUtil(this.driver);
	}

//public methods

	public String getLoginPageTitle() {
		return driver.getTitle();
	}

	public Boolean getisForgotPasswordLink() {
		return eleutil.waitForElementsToBeInVisible(forgotPwdLink, Duration.ofSeconds(1000));
	}

	public List<String> getLoginPageTiles() {
		List<WebElement> logintiles = eleutil.doGetElements(loginPageTiles);

		List<String> newLoginTileSections = new ArrayList<String>();

		for (WebElement e : logintiles) {
			newLoginTileSections.add(e.getText());
		}
		return newLoginTileSections;

	}

	public AccountPage doLogin(String un, String pwd) {
		eleutil.doSendKeys(email, un);
		eleutil.doSendKeys(password, pwd);
		eleutil.doClick(loginButton);
		return new AccountPage(driver);

	}

}
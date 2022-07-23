package com.qa.freecrm.tests;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.asserts.SoftAssert;

import com.qa.freecrm.factory.DriverFactory;
import com.qa.freecrm.pages.AccountPage;
import com.qa.freecrm.pages.HomePage;
import com.qa.freecrm.pages.LoginPage;

public class BaseTest {

	public WebDriver driver;
	public Properties prop;
	public DriverFactory driverFact;
	public LoginPage loginpage;
	public AccountPage accountpage;

	public SoftAssert softAssert = new SoftAssert();

	@BeforeTest
	public void setUp() {
		driverFact = new DriverFactory();
		prop = driverFact.init_prop();
        driver = driverFact.init_driver(prop);
		loginpage = new LoginPage(driver);
	}

	@AfterTest
	public void tearDown() {
		driver.quit();
	}
}
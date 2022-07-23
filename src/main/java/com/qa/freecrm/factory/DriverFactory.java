package com.qa.freecrm.factory;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.safari.SafariDriver;



import io.github.bonigarcia.wdm.WebDriverManager;

public class DriverFactory {

	public WebDriver driver;
	public Properties prop;
	public OptionsManager optionsManager;
	public ChromeOptions co;
	public FirefoxOptions fo;
	public static String highlight;
	public static ThreadLocal<WebDriver> tlDriver = new ThreadLocal<>();

	public WebDriver init_driver(Properties prop) {

		String browserName = prop.getProperty("browser").trim();
		//String browserVersion = prop.getProperty("browserversion").trim();

		System.out.println("browser name is : " + browserName);
		optionsManager = new OptionsManager(prop);
		highlight = prop.getProperty("highlight");

		if (browserName.equals("chrome")) {
			WebDriverManager.chromedriver().setup();

			if (Boolean.parseBoolean(prop.getProperty("remote"))) {
				init_remoteDriver("chrome");
			} else {
				tlDriver.set(new ChromeDriver(optionsManager.chromeOptions()));
			}

		} else if (browserName.equals("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			if (Boolean.parseBoolean(prop.getProperty("remote"))) {
				init_remoteDriver("firefox");
			} else {
				tlDriver.set(new FirefoxDriver(optionsManager.firefocOptions()));
			}
		}

		else if (browserName.equals("safari")) {
			// driver = new SafariDriver();
			tlDriver.set(new SafariDriver());
		}

		else {
			System.out.println("Please pass the right brower: " + browserName);
		}

		getDriver().get(prop.getProperty("url"));
		getDriver().manage().deleteAllCookies();
		getDriver().manage().window().maximize();
		return getDriver();

	}
	private void init_remoteDriver(String browser) {

//		System.out.println("Running test on grid server: " + browser + " version: " + browserVersion);

		co = new ChromeOptions();
		if (browser.equals("chrome")) {

			co.setCapability("browserName", "chrome");
//			co.setCapability("browserVersion", browserVersion);
			co.setCapability("enableVNC", true);
			co.setCapability(ChromeOptions.CAPABILITY, optionsManager.chromeOptions());
			try {
				tlDriver.set(new RemoteWebDriver(new URL(prop.getProperty("huburl")), co));
			} catch (MalformedURLException e) {
				e.printStackTrace();
			}
		} else if (browser.equals("firefox")) {
			fo=new FirefoxOptions();
			
			fo.setCapability("browserName", "firefox");
//			fo.setCapability("browserVersion", browserVersion);
			fo.setCapability("enableVNC", true);
			fo.setCapability(FirefoxOptions.FIREFOX_OPTIONS, optionsManager.firefocOptions());
			try {
				tlDriver.set(new RemoteWebDriver(new URL(prop.getProperty("huburl")), fo));
			} catch (MalformedURLException e) {
				e.printStackTrace();
			}
		}

	}

	public static synchronized WebDriver getDriver() {
		return tlDriver.get();
	}

	public Properties init_prop() {
		prop = new Properties();
		FileInputStream ip = null;
		String envName = System.getProperty("env");
//updating
		if (envName == null) {
			System.out.println("Running on Environmane on PROD env");
			try {
				ip = new FileInputStream("./src/main/resources/config/config.properties");
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			}
		} else {
			System.out.println("Running on environment: " + envName);
			try {
				switch (envName) {
				case "qa":
					ip = new FileInputStream("./src/main/resources/config/stage.config.properties");
					break;
				case "stage":
					ip = new FileInputStream("./src/main/resources/config/stage.config.properties");
					break;
				case "dev":
					ip = new FileInputStream("./src/main/resources/config/dev.config.properties");
					break;
				default:
					break;
				}
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			}
		}

		try {
			prop.load(ip);
		} catch (IOException e) {
			e.printStackTrace();
		}

		return prop;
	}
	public String getScreenshot() {
		File src = ((TakesScreenshot) getDriver()).getScreenshotAs(OutputType.FILE);
		String path = System.getProperty("user.dir") + "/screenshots/" + System.currentTimeMillis() + ".png";
		File destination = new File(path);
		try {
			FileUtils.copyFile(src, destination);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return path;
	}

}



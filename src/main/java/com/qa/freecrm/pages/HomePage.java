package com.qa.freecrm.pages;

import org.openqa.selenium.WebDriver;

import com.qa.freecrm.utility.ElementUtil;

public class HomePage {
  
	private ElementUtil eleutil;
	
	public HomePage(WebDriver driver) {
		eleutil=new ElementUtil(driver);
	}

	

}

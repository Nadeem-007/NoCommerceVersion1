package com.noCommerceVFinal.pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class IndexPage {

 // 1.  create object of webdriver
	
	WebDriver ldriver;
	
	public IndexPage(WebDriver rdriver) {
		ldriver=rdriver;
		
		PageFactory.initElements(rdriver, this);
	}
	
	// identify web elements
	
	@FindBy(linkText = "Log in")
	WebElement login;
	
	public void clickOnlogin() {
		login.click();
	}
	
	
}

package com.noCommerceVFinal.pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RegisteredUser {
	WebDriver ldriver;
	
	public RegisteredUser(WebDriver rdriver) {
		ldriver=rdriver;
		
		PageFactory.initElements(rdriver, this);
	}
	
	// identify web elements
	
	@FindBy(xpath = "//div[text()=\"Your registration completed\"]")
	WebElement verifiedText;
	
	
	@FindBy(xpath = "(//a[@href=\"/customer/info\"])[1]")
	WebElement myAccount;
	
	@FindBy(linkText = "Log out")
	WebElement Logout;
	
	public String getVerifiedText() {
		
		return verifiedText.getText();
	}
	
	public String getValue() {
		
		return myAccount.getText();
	}
	
	public void clickLogoutLink() {
		Logout.click();
	}
}

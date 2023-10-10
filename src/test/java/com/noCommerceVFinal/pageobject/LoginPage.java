package com.noCommerceVFinal.pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	// 1.  create object of webdriver
	
		WebDriver ldriver;
		
		public LoginPage(WebDriver rdriver) {
			ldriver=rdriver;
			
			PageFactory.initElements(rdriver, this);
		}
		
		//======================= below element registerOption is for on Register button 
		
		@FindBy(xpath  = "//button[text()=\"Register\"]")
		WebElement registerOption;
		
		public void clickOnRegister() {
			registerOption.click();
		}
		
		//====================== below elements are for Login button
		@FindBy(id  = "Email")
		WebElement emailBox;
		
		@FindBy(id  = "Password")
		WebElement pwdBox;
		
		@FindBy(xpath ="//button[text()=\"Log in\"]")
		WebElement loginButton;
		
		
		public void enterEmail(String email) {
			emailBox.sendKeys(email);
		}
		
		public void enterPassword(String pwd) {
			pwdBox.sendKeys(pwd);
		}
		
		public void clickOnLoginButton() {
			loginButton.submit();
		}
		
		
}

package com.noCommerceVFinal.pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class AccountCreationDetails {
WebDriver ldriver;
	
	public AccountCreationDetails(WebDriver rdriver) {
		ldriver=rdriver;
		
		PageFactory.initElements(rdriver, this);
	}
	
	// identify web elements
	
	@FindBy(id = "gender-male")
	WebElement gendermale;
	
	@FindBy(id = "FirstName")
	WebElement firstName;
	
	@FindBy(id = "LastName")
	WebElement lastName;
	
	@FindBy(name = "DateOfBirthDay")
	WebElement day;
	
	@FindBy(name = "DateOfBirthMonth")
	WebElement month;
	
	@FindBy(name = "DateOfBirthYear")
	WebElement year;
	
	@FindBy(id = "Email")
	WebElement email;
	
	@FindBy(id = "Password")
	WebElement password;
	
	@FindBy(id = "ConfirmPassword")
	WebElement confirmPassword;
	
	@FindBy(id = "register-button")
	WebElement registerButton;
	
	
	
	public void clickOnRadio() {
		gendermale.click();
	}
	
	public void enterFirstName(String fname) {
		firstName.sendKeys(fname);
	}
	
	public void enterLastName(String lname) {
		lastName.sendKeys(lname);
	}
	
	public void selectDay() {
		
		Select s=new Select(day);
		s.selectByIndex(4);
	}
	
    public void selectMonth() {
		
		Select s=new Select(month);
		s.selectByIndex(6);
	}
    public void selectYear(String num) {
		
		Select s=new Select(year);
		s.selectByVisibleText(num);
	}
	
	public void enterEmail(String lemail) {  // change to lemail- it will show duplicate
		email.sendKeys(lemail);
	}
	
	public void enterPassword(String pass) {
		password.sendKeys(pass);
	}
	
	public void enterConfirmPassword(String confpass) {
		confirmPassword.sendKeys(confpass);
	}
	
	public void registerButton() {
		registerButton.submit();
	}
	
	
}

package com.noCommerceVFinal.testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.noCommerceVFinal.pageobject.AccountCreationDetails;
import com.noCommerceVFinal.pageobject.IndexPage;
import com.noCommerceVFinal.pageobject.LoginPage;
import com.noCommerceVFinal.pageobject.RegisteredUser;

public class TC_RegisterationPageTest extends BaseClass{

	@Test(priority = 1)
	public void verifyRegistrationAndLogin() {
		
		
		IndexPage first=new IndexPage(driver);
		first.clickOnlogin();
		logger.info("clicked on Login link");

		LoginPage lp=new LoginPage(driver);
		
		lp.clickOnRegister();
		logger.info("clicked on register link");
		
		AccountCreationDetails acd=new AccountCreationDetails(driver);
		
		acd.clickOnRadio();
		logger.info("clicked on radio button");

		acd.enterFirstName("Nadeem");
		logger.info("Entered FirstName into text field");

		acd.enterLastName("Pha");
		logger.info("Entered LastName into text field");

		acd.selectDay();
		logger.info("Selected day");

		acd.selectMonth();
		logger.info("Selected month");

		acd.selectYear("1995");
		logger.info("Selected year");

		acd.enterEmail("er.shubham.sagar@gmail.com");
		logger.info("Entered Email into textfield");

		acd.enterPassword("Nadeem1234!");
		logger.info("Entered password into textfield");

		acd.enterConfirmPassword("Nadeem1234!");
		logger.info("Entered Confirm password into textfield");

		acd.registerButton();
		logger.info("clicked on register button");
		
		RegisteredUser ru=new RegisteredUser(driver);
		
		String verifyMessage=ru.getVerifiedText();
		
		System.out.println("verified Message is :"+verifyMessage);
		
		logger.info(" ************verifyRegistrationAndLogin Test case is completed********************************");


	}
	
	@Test (priority = 2)
	public void verifyLogin() throws Exception {
		
		IndexPage first=new IndexPage(driver);
		first.clickOnlogin();
		logger.info("clicked on Login link");
		
		LoginPage lp=new LoginPage(driver);
		lp.enterEmail("nadeem@gmail.com");
		logger.info("Email id is entered");

		lp.enterPassword("Nadeem1234!");
		logger.info("Password is entered");
		
		lp.clickOnLoginButton();
		logger.info("Clicked on Login button");
		Thread.sleep(2000);
		
		RegisteredUser ru=new RegisteredUser(driver);
		String textvalue=ru.getValue();
		System.out.println("textvalue is "+textvalue);
		
		if(textvalue.equals("My account")) {
			logger.info("verify login is passed");
			Thread.sleep(2000);

			Assert.assertTrue(true);
			
		}
		else {
			logger.info("verify login is failed");
			captureScreenShot(driver, "verifyLogin");
			Assert.assertTrue(false);
		}


	}
}

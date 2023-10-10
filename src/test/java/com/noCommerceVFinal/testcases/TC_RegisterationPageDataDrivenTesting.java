package com.noCommerceVFinal.testcases;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.noCommerceVFinal.pageobject.AccountCreationDetails;
import com.noCommerceVFinal.pageobject.IndexPage;
import com.noCommerceVFinal.pageobject.LoginPage;
import com.noCommerceVFinal.pageobject.RegisteredUser;
import com.noCommerceVFinal.utilities.ReadExcelFile;

public class TC_RegisterationPageDataDrivenTesting extends BaseClass{

	//@Test(enabled = false)
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
	
	@Test(dataProvider="loginDataProvider")
	public void verifyLogin(String userEmail, String UserPwd, String expectedValue) throws Exception {
		
		IndexPage first=new IndexPage(driver);
		first.clickOnlogin();
		logger.info("clicked on Login link");
		
		LoginPage lp=new LoginPage(driver);
		lp.enterEmail(UserPwd);
		logger.info("Email id is entered");

		lp.enterPassword(UserPwd);
		logger.info("Password is entered");
		
		lp.clickOnLoginButton();
		logger.info("Clicked on Login button");
		Thread.sleep(2000);
		
		RegisteredUser ru=new RegisteredUser(driver);
		String textvalue=ru.getValue();
		System.out.println("textvalue is "+textvalue);
		
		if(textvalue.equals(expectedValue)) {
			logger.info("verify login is passed");
			Thread.sleep(2000);

			Assert.assertTrue(true);
			ru.clickLogoutLink();
		}
		else {
			logger.info("verify login is failed");
			captureScreenShot(driver, "verifyLogin");
			Assert.assertTrue(false);
		}

	
		
	}
	
	
	@DataProvider(name="loginDataProvider")
	public String[][] loginDataProvider(){
		
			//System.out.println(System.getProperty("user.dir"));
			String fileName = System.getProperty("./Test Data/noCommerceDataExcel.xlsx");


			int ttlRows = ReadExcelFile.getRowCount(fileName, "Sheet1");
			int ttlColumns = ReadExcelFile.getColCount(fileName, "Sheet1");
		

			String data[][]=new String[ttlRows-1][ttlColumns];

			for(int i=1;i<ttlRows;i++)//rows =1,2
			{
				for(int j=0;j<ttlColumns;j++)//col=0, 1,2
				{

					data[i-1][j]=ReadExcelFile.getCellValue(fileName,"Sheet1", i,j);
				}

			}
			return data;
		}
	}


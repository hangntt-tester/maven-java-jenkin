package com.nopcommerce.user;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import commons.BaseTest;
import commons.PageGenerator;
import datatest.user.RegisterLogindata;
import pageObjects.nopcommerce.user.HomePO;
import pageObjects.nopcommerce.user.LoginPO;
import pageObjects.nopcommerce.user.MyAccountPO;

public class User_02_Login extends BaseTest {
	WebDriver driver;

	@Parameters({ "browser", "url" })
	@BeforeClass
	public void beforeClass(String browserName, String appUrl) {
		log.info("Pre-condition - Step 01: Open browser '" + browserName + "' and navigate to '" + appUrl + "'");
		driver = getBrowserDriver(browserName, appUrl);
		homePage = PageGenerator.getHomePage(driver);
		
		log.info("Pre-condition - Step 01: Click to 'Login' header link");
		homePage.clickToHeaderLinkByClass(driver, "ico-login");
		loginPage = PageGenerator.getLoginPage(driver);
	}

	@Test
	public void Login_01_Empty_Data() {
		log.info("Login_01_Empty_Data - Step 01: Click to Login button");
		loginPage.clickToButtonByText(driver, "Log in");
		
		log.info("Login_01_Empty_Data - Step 02: Verify message error at Email textbox is Displayed");
		verifyTrue(loginPage.isErorrMessageByLabelAndTextDisplayed(driver, "Email:", "Please enter your email"));
	}
	
	@Test
	public void Login_02_Invalid_Email() {
		log.info("Login_02_Invalid_Email - Step 01: Refresh page");
		loginPage.refreshToPage(driver);
		
		log.info("Login_02_Invalid_Email - Step 02: Enter invalid value to Email textbox");
		loginPage.enterToTextboxByID(driver, "Email", RegisterLogindata.RegisterLogin.INVALID_EMAIL);
		
		log.info("Login_02_Invalid_Email - Step 03: Enter value to Password textbox");
		loginPage.enterToTextboxByID(driver, "Password", RegisterLogindata.RegisterLogin.VALID_PASSWORD);
		
		log.info("Login_02_Invalid_Email - Step 04: Click to Login button");
		loginPage.clickToButtonByText(driver, "Log in");
		
		log.info("Login_02_Invalid_Email - Step 05: Verify message error at Email textbox is Displayed");
		verifyTrue(loginPage.isErorrMessageByLabelAndTextDisplayed(driver, "Email:", "Wrong email"));
	}
	
	@Test
	public void Login_03_Not_Registered_Email() {
		log.info("Login_03_Not_Registered_Email - Step 01: Click to 'Login' header link");
		loginPage.clickToHeaderLinkByClass(driver, "ico-login");
		
		log.info("Login_03_Not_Registered_Email - Step 02: Enter not registered value to Email textbox");
		loginPage.enterToTextboxByID(driver, "Email", RegisterLogindata.RegisterLogin.NOT_REGISTERED_EMAIL);
		
		log.info("Login_03_Not_Registered_Email - Step 03: Enter value to Password textbox");
		loginPage.enterToTextboxByID(driver, "Password", RegisterLogindata.RegisterLogin.VALID_PASSWORD);
		
		log.info("Login_03_Not_Registered_Email - Step 04: Click to Login button");
		loginPage.clickToButtonByText(driver, "Log in");
		
		log.info("Login_03_Not_Registered_Email - Step 05: Verify message error at Email textbox is Displayed");
		verifyEquals(loginPage.getTextMessageErrorLoginDisplayed(), "Login was unsuccessful. Please correct the errors and try again." + "\n" + "No customer account found");
	}
	
	@Test
	public void Login_04_Registered_Email_And_Empty_Password() {
		log.info("Login_04_Registered_Email_And_Empty_Password - Step 01: Click to 'Login' header link");
		loginPage.clickToHeaderLinkByClass(driver, "ico-login");
		
		log.info("Login_04_Registered_Email_And_Empty_Password - Step 02: Enter registered value to Email textbox");
		loginPage.enterToTextboxByID(driver, "Email", RegisterLogindata.RegisterLogin.VALID_EMAIL);
		
		log.info("Login_04_Registered_Email_And_Empty_Password - Step 03: Click to Login button");
		loginPage.clickToButtonByText(driver, "Log in");
		
		log.info("Login_04_Registered_Email_And_Empty_Password - Step 04: Verify message error at Email textbox is Displayed");
		verifyEquals(loginPage.getTextMessageErrorLoginDisplayed(), "Login was unsuccessful. Please correct the errors and try again." + "\n" + "The credentials provided are incorrect");
	}
	
	@Test
	public void Login_05_Registered_Email_And_Error_Password() {
		log.info("Login_05_Registered_Email_And_Error_Password - Step 01: Click to 'Login' header link");
		loginPage.clickToHeaderLinkByClass(driver, "ico-login");
		
		log.info("Login_05_Registered_Email_And_Error_Password - Step 02: Enter registered value to Email textbox");
		loginPage.enterToTextboxByID(driver, "Email", RegisterLogindata.RegisterLogin.VALID_EMAIL);
		
		log.info("Login_05_Registered_Email_And_Error_Password - Step 03: Enter value to Password textbox");
		loginPage.enterToTextboxByID(driver, "Password", RegisterLogindata.RegisterLogin.ERROR_PASSWORD);
		
		log.info("Login_05_Registered_Email_And_Error_Password - Step 04: Click to Login button");
		loginPage.clickToButtonByText(driver, "Log in");
		
		log.info("Login_05_Registered_Email_And_Error_Password - Step 05: Verify message error at Email textbox is Displayed");
		verifyEquals(loginPage.getTextMessageErrorLoginDisplayed(), "Login was unsuccessful. Please correct the errors and try again." + "\n" + "The credentials provided are incorrect");
	}
	
	@Test
	public void Login_06_Registered_Email_And_Valid_Password() {
		log.info("Login_06_Registered_Email_And_Valid_Password - Step 01: Click to 'Login' header link");
		loginPage.clickToHeaderLinkByClass(driver, "ico-login");
		
		log.info("Login_06_Registered_Email_And_Valid_Password - Step 02: Enter registered value to Email textbox");
		loginPage.enterToTextboxByID(driver, "Email", RegisterLogindata.RegisterLogin.VALID_EMAIL);
		
		log.info("Login_06_Registered_Email_And_Valid_Password - Step 03: Enter value to Password textbox");
		loginPage.enterToTextboxByID(driver, "Password", RegisterLogindata.RegisterLogin.VALID_PASSWORD);
		
		log.info("Login_06_Registered_Email_And_Valid_Password - Step 04: Click to Login button");
		loginPage.clickToButtonByText(driver, "Log in");
		
		log.info("Login_06_Registered_Email_And_Valid_Password - Step 05: Verify MyAccount Page is Displayed");
		myAccountPage = PageGenerator.getMyAccountPage(driver);
		verifyTrue(myAccountPage.isPageDisplayed(driver, "ico-account"));
		
	}
	
	
	@Parameters({ "browser" })
	@AfterClass(alwaysRun = true)
	public void cleanClass(String browserName) {
		log.info("Post-Condition: Close browser'" + browserName + "'");
		cleanDriverInstance();
	}
	
	HomePO homePage;
	LoginPO loginPage;
	MyAccountPO myAccountPage;
}

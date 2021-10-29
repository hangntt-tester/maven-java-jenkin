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
import pageObjects.nopcommerce.user.RegisterPO;

public class User_01_Register extends BaseTest {
	WebDriver driver;

	@Parameters({ "browser", "url" })
	@BeforeClass
	public void beforeClass(String browserName, String appUrl) {
		log.info("Pre-condition - Step 01: Open browser '" + browserName + "' and navigate to '" + appUrl + "'");
		driver = getBrowserDriver(browserName, appUrl);
		homePage = PageGenerator.getHomePage(driver);
		
		log.info("Pre-condition - Step 01: Click to 'Register' header link");
		homePage.clickToHeaderLinkByClass(driver, "ico-register");
		registerPage = PageGenerator.getRegisterPage(driver);
	}

	@Test
	public void Register_01_Empty_Data() {
		log.info("Register_01_Empty_Data - Step 01: Click to Register button");
		registerPage.clickToButtonByID(driver, "register-button");
		
		log.info("Register_01_Empty_Data - Step 02: Verify error message at Frist name field is Displayed");
		verifyTrue(registerPage.isErorrMessageByLabelAndTextDisplayed(driver, "First name:", "First name is required."));
		
		log.info("Register_01_Empty_Data - Step 03: Verify error message at Last name field is Displayed");
		verifyTrue(registerPage.isErorrMessageByLabelAndTextDisplayed(driver, "Last name:", "Last name is required."));
		
		log.info("Register_01_Empty_Data - Step 04: Verify error message at Email field is Displayed");
		verifyTrue(registerPage.isErorrMessageByLabelAndTextDisplayed(driver, "Email:", "Email is required."));
		
		log.info("Register_01_Empty_Data - Step 05: Verify error message at Password field is Displayed");
		verifyTrue(registerPage.isErorrMessageByLabelAndTextDisplayed(driver, "Password:", "Password is required."));
		
		log.info("Register_01_Empty_Data - Step 06: Verify error message at Confirm password field is Displayed");
		verifyTrue(registerPage.isErorrMessageByLabelAndTextDisplayed(driver, "Confirm password:", "Password is required."));
	}
	
	@Test
	public void Register_02_Invalid_Email() {
		log.info("Register_02_Invalid_Email - Step 01: Refresh page");
		registerPage.refreshToPage(driver);
		
		log.info("Register_02_Invalid_Email - Step 02: Click to Male radio button");
		registerPage.checkToRadioButtonByLabel(driver, "Male");
		
		log.info("Register_02_Invalid_Email - Step 03: Enter value to First name textbox");
		registerPage.enterToTextboxByID(driver, "FirstName", RegisterLogindata.RegisterLogin.FIRST_NAME);
		
		log.info("Register_02_Invalid_Email - Step 04: Enter value to Last name textbox");
		registerPage.enterToTextboxByID(driver, "LastName", RegisterLogindata.RegisterLogin.LAST_NAME);
		
		log.info("Register_02_Invalid_Email - Step 05: Select value to Day dropdown");
		registerPage.selectValueByNameDropdown(driver, "DateOfBirthDay", RegisterLogindata.RegisterLogin.DAY);
		
		log.info("Register_02_Invalid_Email - Step 06: Select value to Month dropdown");
		registerPage.selectValueByNameDropdown(driver, "DateOfBirthMonth", RegisterLogindata.RegisterLogin.MONTH);
		
		log.info("Register_02_Invalid_Email - Step 07: Select value to Year dropdown");
		registerPage.selectValueByNameDropdown(driver, "DateOfBirthYear", RegisterLogindata.RegisterLogin.YEAR);
		
		log.info("Register_02_Invalid_Email - Step 08: Enter value to Email textbox");
		registerPage.enterToTextboxByID(driver, "Email", RegisterLogindata.RegisterLogin.INVALID_EMAIL);
		
		log.info("Register_02_Invalid_Email - Step 09: Enter value to Company textbox");
		registerPage.enterToTextboxByID(driver, "Company", RegisterLogindata.RegisterLogin.COMPANY);
		
		log.info("Register_02_Invalid_Email - Step 10: Check to Newsletter checkbox");
		registerPage.checkToCheckboxByLabel(driver, "Newsletter:");
		
		log.info("Register_02_Invalid_Email - Step 11: Enter value to Password textbox");
		registerPage.enterToTextboxByID(driver, "Password", RegisterLogindata.RegisterLogin.VALID_PASSWORD);
		
		log.info("Register_02_Invalid_Email - Step 12: Enter value to Confirm Password textbox");
		registerPage.enterToTextboxByID(driver, "ConfirmPassword", RegisterLogindata.RegisterLogin.VALID_PASSWORD);
		
		log.info("Register_02_Invalid_Email - Step 13: Click to Register button");
		registerPage.clickToButtonByID(driver, "register-button");
		
		log.info("Register_02_Invalid_Email - Step 14: Verify error message at Email field is Displayed");
		verifyTrue(registerPage.isErorrMessageByLabelAndTextDisplayed(driver, "Email:", "Wrong email"));
	}
	
	@Test
	public void Register_03_Valid_Email() {
		log.info("Register_03_Valid_Email - Step 01: Refresh page");
		registerPage.refreshToPage(driver);
		
		log.info("Register_03_Valid_Email - Step 02: Click to Male radio button");
		registerPage.checkToRadioButtonByLabel(driver, "Male");
		
		log.info("Register_03_Valid_Email - Step 03: Enter value to First name textbox");
		registerPage.enterToTextboxByID(driver, "FirstName", RegisterLogindata.RegisterLogin.FIRST_NAME);
		
		log.info("Register_03_Valid_Email - Step 04: Enter value to Last name textbox");
		registerPage.enterToTextboxByID(driver, "LastName", RegisterLogindata.RegisterLogin.LAST_NAME);
		
		log.info("Register_03_Valid_Email - Step 05: Select value to Day dropdown");
		registerPage.selectValueByNameDropdown(driver, "DateOfBirthDay", RegisterLogindata.RegisterLogin.DAY);
		
		log.info("Register_03_Valid_Email - Step 06: Select value to Month dropdown");
		registerPage.selectValueByNameDropdown(driver, "DateOfBirthMonth", RegisterLogindata.RegisterLogin.MONTH);
		
		log.info("Register_03_Valid_Email - Step 07: Select value to Year dropdown");
		registerPage.selectValueByNameDropdown(driver, "DateOfBirthYear", RegisterLogindata.RegisterLogin.YEAR);
		
		log.info("Register_03_Valid_Email - Step 08: Enter value to Email textbox");
		registerPage.enterToTextboxByID(driver, "Email", RegisterLogindata.RegisterLogin.VALID_EMAIL);
		
		log.info("Register_03_Valid_Email - Step 09: Enter value to Company textbox");
		registerPage.enterToTextboxByID(driver, "Company", RegisterLogindata.RegisterLogin.COMPANY);
		
		log.info("Register_03_Valid_Email - Step 10: Check to Newsletter checkbox");
		registerPage.checkToCheckboxByLabel(driver, "Newsletter:");
		
		log.info("Register_03_Valid_Email - Step 11: Enter value to Password textbox");
		registerPage.enterToTextboxByID(driver, "Password", RegisterLogindata.RegisterLogin.VALID_PASSWORD);
		
		log.info("Register_03_Valid_Email - Step 12: Enter value to Confirm Password textbox");
		registerPage.enterToTextboxByID(driver, "ConfirmPassword", RegisterLogindata.RegisterLogin.VALID_PASSWORD);
		
		log.info("Register_03_Valid_Email - Step 13: Click to Register button");
		registerPage.clickToButtonByID(driver, "register-button");
		
		log.info("Register_03_Valid_Email - Step 14: Verify message success register is Displayed");
		verifyTrue(registerPage.isMessageSuccessRegisterDisplayed());
	
	}
	
	@Test
	public void Register_04_Registered_Email() {
		log.info("Register_04_Registered_Email - Step 01: Back to page");
		registerPage.backToPage(driver);
		
		log.info("Register_04_Registered_Email - Step 02: Click to Male radio button");
		registerPage.checkToRadioButtonByLabel(driver, "Male");
		
		log.info("Register_04_Registered_Email - Step 03: Enter value to First name textbox");
		registerPage.enterToTextboxByID(driver, "FirstName", RegisterLogindata.RegisterLogin.FIRST_NAME);
		
		log.info("Register_04_Registered_Email - Step 04: Enter value to Last name textbox");
		registerPage.enterToTextboxByID(driver, "LastName", RegisterLogindata.RegisterLogin.LAST_NAME);
		
		log.info("Register_04_Registered_Email - Step 05: Select value to Day dropdown");
		registerPage.selectValueByNameDropdown(driver, "DateOfBirthDay", RegisterLogindata.RegisterLogin.DAY);
		
		log.info("Register_04_Registered_Email - Step 06: Select value to Month dropdown");
		registerPage.selectValueByNameDropdown(driver, "DateOfBirthMonth", RegisterLogindata.RegisterLogin.MONTH);
		
		log.info("Register_04_Registered_Email - Step 07: Select value to Year dropdown");
		registerPage.selectValueByNameDropdown(driver, "DateOfBirthYear", RegisterLogindata.RegisterLogin.YEAR);
		
		log.info("Register_04_Registered_Email - Step 08: Enter value to Email textbox");
		registerPage.enterToTextboxByID(driver, "Email", RegisterLogindata.RegisterLogin.VALID_EMAIL);
		
		log.info("Register_04_Registered_Email - Step 09: Enter value to Company textbox");
		registerPage.enterToTextboxByID(driver, "Company", RegisterLogindata.RegisterLogin.COMPANY);
		
		log.info("Register_04_Registered_Email - Step 10: Check to Newsletter checkbox");
		registerPage.checkToCheckboxByLabel(driver, "Newsletter:");
		
		log.info("Register_04_Registered_Email - Step 11: Enter value to Password textbox");
		registerPage.enterToTextboxByID(driver, "Password", RegisterLogindata.RegisterLogin.VALID_PASSWORD);
		
		log.info("Register_04_Registered_Email - Step 12: Enter value to Confirm Password textbox");
		registerPage.enterToTextboxByID(driver, "ConfirmPassword", RegisterLogindata.RegisterLogin.VALID_PASSWORD);
		
		log.info("Register_04_Registered_Email - Step 13: Click to Register button");
		registerPage.clickToButtonByID(driver, "register-button");
		
		log.info("Register_04_Registered_Email - Step 14: Verify message success register is Displayed");
		verifyTrue(registerPage.isMessageErrorEmailExistDisplayed());
		
	}
	
	@Test
	public void Register_05_Invalid_Password() {
		log.info("Register_05_Invalid_Password - Click to 'Register' header link");
		registerPage.clickToHeaderLinkByClass(driver, "ico-register");
		
		log.info("Register_05_Invalid_Password - Step 02: Click to Male radio button");
		registerPage.checkToRadioButtonByLabel(driver, "Male");
		
		log.info("Register_05_Invalid_Password - Step 03: Enter value to First name textbox");
		registerPage.enterToTextboxByID(driver, "FirstName", RegisterLogindata.RegisterLogin.FIRST_NAME);
		
		log.info("Register_05_Invalid_Password - Step 04: Enter value to Last name textbox");
		registerPage.enterToTextboxByID(driver, "LastName", RegisterLogindata.RegisterLogin.LAST_NAME);
		
		log.info("Register_05_Invalid_Password - Step 05: Select value to Day dropdown");
		registerPage.selectValueByNameDropdown(driver, "DateOfBirthDay", RegisterLogindata.RegisterLogin.DAY);
		
		log.info("Register_05_Invalid_Password - Step 06: Select value to Month dropdown");
		registerPage.selectValueByNameDropdown(driver, "DateOfBirthMonth", RegisterLogindata.RegisterLogin.MONTH);
		
		log.info("Register_05_Invalid_Password - Step 07: Select value to Year dropdown");
		registerPage.selectValueByNameDropdown(driver, "DateOfBirthYear", RegisterLogindata.RegisterLogin.YEAR);
		
		log.info("Register_05_Invalid_Password - Step 08: Enter value to Email textbox");
		registerPage.enterToTextboxByID(driver, "Email", RegisterLogindata.RegisterLogin.VALID_EMAIL);
		
		log.info("Register_05_Invalid_Password - Step 09: Enter value to Company textbox");
		registerPage.enterToTextboxByID(driver, "Company", RegisterLogindata.RegisterLogin.COMPANY);
		
		log.info("Register_05_Invalid_Password - Step 10: Check to Newsletter checkbox");
		registerPage.checkToCheckboxByLabel(driver, "Newsletter:");
		
		log.info("Register_05_Invalid_Password - Step 11: Enter value to Password textbox");
		registerPage.enterToTextboxByID(driver, "Password", RegisterLogindata.RegisterLogin.INVALID_PASSWORD);
		
		log.info("Register_05_Invalid_Password - Step 12: Enter value to Confirm Password textbox");
		registerPage.enterToTextboxByID(driver, "ConfirmPassword", RegisterLogindata.RegisterLogin.INVALID_PASSWORD);
		
		log.info("Register_05_Invalid_Password - Step 13: Click to Register button");
		registerPage.clickToButtonByID(driver, "register-button");
		
		log.info("Register_05_Invalid_Password - Step 14: Verify message error 'Password must meet the following rules: must have at least 6 characters' is Displayed");
		verifyEquals(registerPage.getTextMessageErrorPasswordDisplayed(), "Password must meet the following rules:"+ "\n" + "must have at least 6 characters");
	}
	
	@Test
	public void Register_06_Invalid_Confirm_Password() {
		log.info("Register_06_Invalid_Confirm_Password - Click to 'Register' header link");
		registerPage.clickToHeaderLinkByClass(driver, "ico-register");
		
		log.info("Register_06_Invalid_Confirm_Password - Step 02: Click to Male radio button");
		registerPage.checkToRadioButtonByLabel(driver, "Male");
		
		log.info("Register_06_Invalid_Confirm_Password - Step 03: Enter value to First name textbox");
		registerPage.enterToTextboxByID(driver, "FirstName", RegisterLogindata.RegisterLogin.FIRST_NAME);
		
		log.info("Register_06_Invalid_Confirm_Password - Step 04: Enter value to Last name textbox");
		registerPage.enterToTextboxByID(driver, "LastName", RegisterLogindata.RegisterLogin.LAST_NAME);
		
		log.info("Register_06_Invalid_Confirm_Password - Step 05: Select value to Day dropdown");
		registerPage.selectValueByNameDropdown(driver, "DateOfBirthDay", RegisterLogindata.RegisterLogin.DAY);
		
		log.info("Register_06_Invalid_Confirm_Password - Step 06: Select value to Month dropdown");
		registerPage.selectValueByNameDropdown(driver, "DateOfBirthMonth", RegisterLogindata.RegisterLogin.MONTH);
		
		log.info("Register_06_Invalid_Confirm_Password - Step 07: Select value to Year dropdown");
		registerPage.selectValueByNameDropdown(driver, "DateOfBirthYear", RegisterLogindata.RegisterLogin.YEAR);
		
		log.info("Register_06_Invalid_Confirm_Password - Step 08: Enter value to Email textbox");
		registerPage.enterToTextboxByID(driver, "Email", RegisterLogindata.RegisterLogin.VALID_EMAIL);
		
		log.info("Register_06_Invalid_Confirm_Password - Step 09: Enter value to Company textbox");
		registerPage.enterToTextboxByID(driver, "Company", RegisterLogindata.RegisterLogin.COMPANY);
		
		log.info("Register_06_Invalid_Confirm_Password - Step 10: Check to Newsletter checkbox");
		registerPage.checkToCheckboxByLabel(driver, "Newsletter:");
		
		log.info("Register_06_Invalid_Confirm_Password - Step 11: Enter value to Password textbox");
		registerPage.enterToTextboxByID(driver, "Password", RegisterLogindata.RegisterLogin.VALID_PASSWORD);
		
		log.info("Register_06_Invalid_Confirm_Password - Step 12: Enter value to Confirm Password textbox");
		registerPage.enterToTextboxByID(driver, "ConfirmPassword", RegisterLogindata.RegisterLogin.INVALID_CONFIRM_PASSWORD);
		
		log.info("Register_06_Invalid_Confirm_Password - Step 13: Click to Register button");
		registerPage.clickToButtonByID(driver, "register-button");
		
		log.info("Register_06_Invalid_Confirm_Password - Step 14: Verify message error 'The password and confirmation password do not match.' is Displayed");
		verifyEquals(registerPage.getTextMessageErrorConfirmPasswordDisplayed(), "The password and confirmation password do not match.");
	}
	
	@Parameters({ "browser" })
	@AfterClass(alwaysRun = true)
	public void cleanClass(String browserName) {
		log.info("Post-Condition: Close browser'" + browserName + "'");
		cleanDriverInstance();
	}
	
	private HomePO homePage;
	private RegisterPO registerPage;
}

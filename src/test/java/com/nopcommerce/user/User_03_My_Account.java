package com.nopcommerce.user;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import commons.BaseTest;
import commons.PageGenerator;
import datatest.user.MyAccountdata;
import datatest.user.RegisterLogindata;
import pageObjects.nopcommerce.user.HomePO;
import pageObjects.nopcommerce.user.LoginPO;
import pageObjects.nopcommerce.user.MyAccountPO;

public class User_03_My_Account extends BaseTest {
	WebDriver driver;

	@Parameters({ "browser", "url" })
	@BeforeClass
	public void beforeClass(String browserName, String appUrl) {
		log.info("Pre-condition - Step 01: Open browser '" + browserName + "' and navigate to '" + appUrl + "'");
		driver = getBrowserDriver(browserName, appUrl);
		homePage = PageGenerator.getHomePage(driver);
		
		log.info("Pre-condition - Step 02: Click to 'Login' header link");
		homePage.clickToHeaderLinkByClass(driver, "ico-login");
		loginPage = PageGenerator.getLoginPage(driver);
		
		log.info("Pre-condition - Step 03: Enter registered value to Email textbox");
		loginPage.enterToTextboxByID(driver, "Email", RegisterLogindata.RegisterLogin.VALID_EMAIL);
		
		log.info("Pre-condition - Step 04: Enter value to Password textbox");
		loginPage.enterToTextboxByID(driver, "Password", RegisterLogindata.RegisterLogin.VALID_PASSWORD);
		
		log.info("Pre-condition - Step 05: Click to Login button");
		loginPage.clickToButtonByText(driver, "Log in");
		
		log.info("Pre-condition - Step 06: Verify MyAccount Page is Displayed");
		myAccountPage = PageGenerator.getMyAccountPage(driver);
		verifyTrue(myAccountPage.isPageDisplayed(driver, "ico-account"));
	}

	@Test
	public void My_Account_01_Customer_Info() {
		log.info("My_Account_01_Customer_Info - Step 01: Click to 'My Account' header link");
		myAccountPage.clickToHeaderLinkByClass(driver, "ico-account");
		
		log.info("My_Account_01_Customer_Info - Step 02: Verify 'My account - Customer info' is Displayed");
		verifyTrue(myAccountPage.isMyAccountCustomerInfoDisplayed());
		
		log.info("My_Account_01_Customer_Info - Step 03: Update to 'Gender' radio button");
		myAccountPage.checkToRadioButtonByLabel(driver, MyAccountdata.CustomerInfo.GENDER);
		
		log.info("My_Account_01_Customer_Info - Step 04: Update to 'FirstName' textbox");
		myAccountPage.enterToTextboxByID(driver, "FirstName", MyAccountdata.CustomerInfo.FIRST_NAME);
		
		log.info("My_Account_01_Customer_Info - Step 05: Update to 'LastName' textbox");
		myAccountPage.enterToTextboxByID(driver, "LastName", MyAccountdata.CustomerInfo.LAST_NAME);
		
		log.info("My_Account_01_Customer_Info - Step 06: Update to 'Day' dropdown");
		myAccountPage.selectValueByNameDropdown(driver, "DateOfBirthDay", MyAccountdata.CustomerInfo.DAY);
		
		log.info("My_Account_01_Customer_Info - Step 07: Update to 'Month' dropdown");
		myAccountPage.selectValueByNameDropdown(driver, "DateOfBirthMonth", MyAccountdata.CustomerInfo.MONTH);
		
		log.info("My_Account_01_Customer_Info - Step 08: Update to 'Year' dropdown");
		myAccountPage.selectValueByNameDropdown(driver, "DateOfBirthYear", MyAccountdata.CustomerInfo.YEAR);
		
		log.info("My_Account_01_Customer_Info - Step 09: Update to 'Email' textbox");
		myAccountPage.enterToTextboxByID(driver, "Email", MyAccountdata.CustomerInfo.EMAIL);
		
		log.info("My_Account_01_Customer_Info - Step 10: Update to 'Company' textbox");
		myAccountPage.enterToTextboxByID(driver, "Company", MyAccountdata.CustomerInfo.COMPANY);
		
		log.info("My_Account_01_Customer_Info - Step 11: Click to 'Save' button");
		myAccountPage.clickToButtonByID(driver, "save-info-button");
		
		log.info("My_Account_01_Customer_Info - Step 12: Verify value is updated success");
		verifyTrue(myAccountPage.isRadioButtonByLabelSelected(driver, MyAccountdata.CustomerInfo.GENDER));
		verifyEquals(myAccountPage.getTextboxValueByID(driver, "FirstName"), MyAccountdata.CustomerInfo.FIRST_NAME);
		verifyEquals(myAccountPage.getTextboxValueByID(driver, "LastName"), MyAccountdata.CustomerInfo.LAST_NAME);
		verifyEquals(myAccountPage.getSelectedValueInDropdownByName(driver, "DateOfBirthDay"), MyAccountdata.CustomerInfo.DAY);
		verifyEquals(myAccountPage.getSelectedValueInDropdownByName(driver, "DateOfBirthMonth"), MyAccountdata.CustomerInfo.MONTH);
		verifyEquals(myAccountPage.getSelectedValueInDropdownByName(driver, "DateOfBirthYear"), MyAccountdata.CustomerInfo.YEAR);
		verifyEquals(myAccountPage.getTextboxValueByID(driver, "Email"), MyAccountdata.CustomerInfo.EMAIL);
		verifyEquals(myAccountPage.getTextboxValueByID(driver, "Company"), MyAccountdata.CustomerInfo.COMPANY);
		verifyTrue(myAccountPage.isCheckboxByLabelSelected(driver, "Newsletter:"));
	}
	
	@Test
	public void My_Account_02_Customer_Info() {
		
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

package pageObjects.nopcommerce.user;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import pageUIs.nopcommerce.user.MyAccountPageUI;

public class MyAccountPO extends BasePage {
	private WebDriver driver;
	
	public MyAccountPO(WebDriver driver) {
		this.driver = driver;
	}

	public boolean isMyAccountCustomerInfoDisplayed() {
		waitForElementVisible(driver, MyAccountPageUI.CUSTOMER_INFO_TITLE);
		return isElementDisplayed(driver, MyAccountPageUI.CUSTOMER_INFO_TITLE);
	}	
	
	
	
}

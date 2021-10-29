package pageObjects.nopcommerce.user;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import pageUIs.nopcommerce.user.LoginPageUI;

public class LoginPO extends BasePage {
	private WebDriver driver;
	
	public LoginPO(WebDriver driver) {
		this.driver = driver;
	}

	public String getTextMessageErrorLoginDisplayed() {
		waitForElementVisible(driver, LoginPageUI.LOGIN_ERROR_MESSAGE);
		return getElementText(driver, LoginPageUI.LOGIN_ERROR_MESSAGE);
	}	
	
	
	
}

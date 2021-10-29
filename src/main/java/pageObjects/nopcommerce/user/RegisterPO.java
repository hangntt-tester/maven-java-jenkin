package pageObjects.nopcommerce.user;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import pageUIs.nopcommerce.user.RegisterPageUI;

public class RegisterPO extends BasePage {
	private WebDriver driver;
	
	public RegisterPO(WebDriver driver) {
		this.driver = driver;
	}	
	
	public boolean isMessageSuccessRegisterDisplayed() {
		waitForElementVisible(driver, RegisterPageUI.REGISTER_SUCCESS_MESSAGE);
		return isElementDisplayed(driver, RegisterPageUI.REGISTER_SUCCESS_MESSAGE);
	}
	
	public boolean isMessageErrorEmailExistDisplayed() {
		waitForElementVisible(driver, RegisterPageUI.EMAIL_EXIST_ERROR_MESSAGE);
		return isElementDisplayed(driver, RegisterPageUI.EMAIL_EXIST_ERROR_MESSAGE);
	}

	public String getTextMessageErrorPasswordDisplayed() {
		waitForElementVisible(driver, RegisterPageUI.PASSWORD_ERROR_MESSAGE);
		return getElementText(driver, RegisterPageUI.PASSWORD_ERROR_MESSAGE);
	}
	
	public String getTextMessageErrorConfirmPasswordDisplayed() {
		waitForElementVisible(driver, RegisterPageUI.CONFIRM_PASSWORD_ERROR_MESSAGE);
		return getElementText(driver, RegisterPageUI.CONFIRM_PASSWORD_ERROR_MESSAGE);
	}
	
}

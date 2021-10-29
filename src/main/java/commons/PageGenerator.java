package commons;

import org.openqa.selenium.WebDriver;

import pageObjects.nopcommerce.user.HomePO;
import pageObjects.nopcommerce.user.LoginPO;
import pageObjects.nopcommerce.user.MyAccountPO;
import pageObjects.nopcommerce.user.OrderPO;
import pageObjects.nopcommerce.user.RegisterPO;
import pageObjects.nopcommerce.user.SearchPO;
import pageObjects.nopcommerce.user.SortPO;
import pageObjects.nopcommerce.user.WishlistPO;

public class PageGenerator {
	private static HomePO homePage;
	private static RegisterPO registerPage;
	private static LoginPO loginPage;
	private static MyAccountPO myAccountPage;
	private static SearchPO searchPage;
	private static SortPO sortPage;
	private static WishlistPO wishlistPage;
	private static OrderPO orderPage;
	
	private PageGenerator() {
		
	}
	
	public static HomePO getHomePage(WebDriver driver) {
		homePage = new HomePO(driver);
		return homePage;
	}
	
	public static RegisterPO getRegisterPage(WebDriver driver) {
		registerPage = new RegisterPO(driver);
		return registerPage;
	}
	
	public static LoginPO getLoginPage(WebDriver driver) {
		loginPage = new LoginPO(driver);
		return loginPage;
	}
	
	public static MyAccountPO getMyAccountPage(WebDriver driver) {
		myAccountPage = new MyAccountPO(driver);
		return myAccountPage;
	}
	
	public static SearchPO getSearchPage(WebDriver driver) {
		searchPage = new SearchPO(driver);
		return searchPage;
	}
	
	public static SortPO getSortPage(WebDriver driver) {
		sortPage = new SortPO(driver);
		return sortPage;
	}
	
	public static WishlistPO getWishlistPage(WebDriver driver) {
		wishlistPage = new WishlistPO(driver);
		return wishlistPage;
	}
	
	public static OrderPO getOrderPage(WebDriver driver) {
		orderPage = new OrderPO(driver);
		return orderPage;
	}
	
}

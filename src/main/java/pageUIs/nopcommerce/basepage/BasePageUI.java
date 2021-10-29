package pageUIs.nopcommerce.basepage;

public class BasePageUI {
	public static final String HEADER_LINK_BY_CLASS ="//a[@class='%s']";
	public static final String BUTTON_BY_ID ="//button[@id='%s']";
	public static final String BUTTON_BY_TEXT ="//button[text()='%s']";
	public static final String MESSAGE_BY_LABEL_AND_TEXT ="//label[text()='%s']//following-sibling::span/span[text()='%s']";
	public static final String TEXTBOX_BY_ID ="//input[@id='%s']";
	
	public static final String RADIO_BUTTON_BY_LABEL = "//label[text()='%s']//preceding-sibling::input";
	public static final String CHECKBOX_BY_LABEL = "//label[text()='%s']//following-sibling::input";
	public static final String DROPDOWN_BY_NAME = "//select[@name='%s']";
	
}

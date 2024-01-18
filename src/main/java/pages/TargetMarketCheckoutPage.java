package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import utils.BrowserUtils;

public class TargetMarketCheckoutPage extends TargetMarketHomePage {

	@FindBy(id = "firstName")
	private WebElement nameField;

	@FindBy(id = "lastName")
	private WebElement lastNameField;

	@FindBy(id = "address")
	private WebElement addressField;

	@FindBy(id = "cardNumber")
	private WebElement cardNumberField;

	@FindBy(id = "phoneNumber")
	private WebElement phoneNumberField;

	@FindBy(css = "button.btn-success")
	private WebElement placeOrderButton;

	@FindBy(xpath = "//div[text()='First name is required']")
	private WebElement firstNameAlertMessage;

	@FindBy(xpath = "//div[text()='Last name is required']")
	private WebElement lastNameAlertMessage;

	@FindBy(xpath = "//div[text()='Address is required']")
	private WebElement addressAlertMessage;

	@FindBy(xpath = "//input[@id='cardNumber']/../div")
	private WebElement cardNumberAlertMessage;

	@FindBy(xpath = "(//div[@class='invalid-feedback'])[5]")
	private WebElement phoneNumberAlertMessage;

	@FindBy(xpath = "//h1[text()='Thanks!']")
	private WebElement processCompletedMessage;

	@FindBy(xpath = "(//a[@href='/target-market'])[1]")
	private WebElement iconOfImage;

	// Finding alternative web elements
	// @FindBy(xpath = "//div[text()='Card number must be 16 digits']")
	// private WebElement cardNumberMissingAlertMessage;
	//
	// @FindBy(xpath = "//div[text()='Phone number must be 10 digits']")
	// private WebElement phoneNumberMissingAlertMessage;

	public void enterFirstName(String firstName) {
		nameField.sendKeys(firstName);
	}

	public void enterLastName(String lastName) {
		lastNameField.sendKeys(lastName);
	}

	public void enterAddress(String address) {
		addressField.sendKeys(address);
	}

	public void enterCardNumber(String cardNumber) {
		cardNumberField.sendKeys(cardNumber);
	}

	public void enterPhoneNumber(String phoneNumber) {
		phoneNumberField.sendKeys(phoneNumber);
	}

	public void clickOnPlaceOrderButton() {
		placeOrderButton.click();
	}

	public void placeOrderProcess(String firstname, String lastName, String address, String cardNumber,
			String phoneNumber) {
		enterFirstName(firstname);
		enterLastName(lastName);
		enterAddress(address);
		enterCardNumber(cardNumber);
		BrowserUtils.scrollDownWithPageDown();
		enterPhoneNumber(phoneNumber);
		clickOnPlaceOrderButton();
		BrowserUtils.wait(2);
	}

	public String getThanksMessage() {
		return processCompletedMessage.getText();
	}

	public String getPhoneNumberAlertMessage() {
		return phoneNumberAlertMessage.getText();
	}

	public String getCardNumberAlertMessage() {
		return cardNumberAlertMessage.getText();
	}

	public String getAddressAlertMessage() {
		return addressAlertMessage.getText();
	}

	public void clickOnInarAcademyImage() {
		iconOfImage.click();
	}

}
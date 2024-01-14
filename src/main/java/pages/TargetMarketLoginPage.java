package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class TargetMarketLoginPage extends BasePage {

	@FindBy(id = "login-username-input")
	private WebElement usernameTextField;

	@FindBy(id = "login-password-input")
	private WebElement passwordTextField;

	@FindBy(id = "login-button")
	private WebElement loginButton;

	@FindBy(id = "username-error-alert")
	private WebElement lockedUserErrorMessage;

	@FindBy(id = "username-error-alert")
	private WebElement invalidUserNameErrorMessage;

	@FindBy(id = "password-error-alert")
	private WebElement invalidPasswordErrorMessage;

	public void enterUserName(String username) {
		usernameTextField.sendKeys(username);
	}

	public void enterPassword(String password) {
		passwordTextField.sendKeys(password);
	}

	public void clickOnLoginButton() {
		loginButton.click();
	}

	public void login(String username, String password) {
		enterUserName(username);
		enterPassword(password);
		clickOnLoginButton();
	}

	public String getLockedUserErrorMessage() {
		return lockedUserErrorMessage.getText();
	}

	public String getInvalidUsernameErrorMessage() {
		return invalidUserNameErrorMessage.getText();
	}

	public String getInvalidPasswordErrorMessage() {
		return invalidPasswordErrorMessage.getText();
	}

}

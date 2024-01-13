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
		if (username.equals("performance_glitch_user")) {
			try {
				Thread.sleep(20000);
			}
			catch (InterruptedException e) {
				throw new RuntimeException(e);
			}
		}
	}

}

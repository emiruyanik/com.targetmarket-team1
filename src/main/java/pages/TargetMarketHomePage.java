package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class TargetMarketHomePage extends BasePage {

	@FindBy(xpath = "//h5[@class='display-5']")
	private WebElement welcomeMessage;

	@FindBy(xpath = "//button[contains(text(),'Logout')]")
	private WebElement logoutButton;

	public TargetMarketHomePage() {
		super();
	}

	public String getWelcomeText() {
		wait.until(ExpectedConditions.visibilityOf(logoutButton));
		return welcomeMessage.getText();
	}

}

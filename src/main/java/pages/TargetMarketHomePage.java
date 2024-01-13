package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class TargetMarketHomePage extends BasePage {

	@FindBy(xpath = "//h5[@class='display-5']")
	private WebElement welcomeMessage;

	public TargetMarketHomePage() {
		super();
	}

	public String getWelcomeText() {
		return welcomeMessage.getText();
	}

}

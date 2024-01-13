package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage {

	@FindBy(linkText = "Target Market")
	private WebElement targetMarketLink;

	public HomePage() {
		super();
	}

	public void clickOnTargetMarketLink() {
		targetMarketLink.click();
	}

}

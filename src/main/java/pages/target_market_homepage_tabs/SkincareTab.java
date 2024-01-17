package pages.target_market_homepage_tabs;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.TargetMarketHomePage;

import java.util.List;

public class SkincareTab extends TargetMarketHomePage {

	@FindBy(css = "h5.card-title")
	private List<WebElement> skincareTitles;

	@FindBy(css = "strong.text-danger > i")
	private List<WebElement> skincarePrices;

	@FindBy(css = "button.btn-danger")
	private List<WebElement> addToCartButtons;

	public String placeOrder(String skincareName) {
		List<String> titles = skincareTitles.stream().map(WebElement::getText).toList();
		actions.moveToElement(addToCartButtons.get(titles.indexOf(skincareName)));
		try {
			addToCartButtons.get(titles.indexOf(skincareName)).click();
		}
		catch (Exception exception) {
			addToCartButtons.get(titles.indexOf(skincareName)).click();
		}
		return skincareName;
	}

	public boolean isSortedFromSmallToBigPrice() {
		for (int i = 0; i < getIntegerOfPrices().size() - 1; i++) {
			if (getIntegerOfPrices().get(i) > getIntegerOfPrices().get(i + 1)) {
				return false;
			}

		}
		return true;
	}

	public boolean isSortedFromBigToSmallPrice() {
		for (int i = 0; i < getIntegerOfPrices().size() - 1; i++) {
			if (getIntegerOfPrices().get(i) < getIntegerOfPrices().get(i + 1)) {
				return false;
			}

		}
		return true;
	}

	public List<Integer> getIntegerOfPrices() {
		return skincarePrices.stream().map(price -> Integer.parseInt(price.getText().substring(1))).toList();
	}

	public List<String> getStringOfTitles() {
		return skincareTitles.stream().map(title -> title.getText().toLowerCase()).toList();
	}

}

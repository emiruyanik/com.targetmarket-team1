package pages.target_market_homepage_tabs;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.TargetMarketHomePage;

import java.util.List;

public class TopsTab extends TargetMarketHomePage {

	@FindBy(css = ".card-title")
	private List<WebElement> topProductsTitles;

	@FindBy(css = "strong.text-danger>i")
	private List<WebElement> topProductsPrices;

	@FindBy(css = ".btn-danger")
	private List<WebElement> addToCartButton;

	public void placeOrder(String topProductName) {
		List<String> titles = topProductsTitles.stream().map(WebElement::getText).toList();
		actions.moveToElement(addToCartButton.get(titles.indexOf(topProductName)));
		try {
			addToCartButton.get(titles.indexOf(topProductName)).click();
		}
		catch (Exception ex) {
			addToCartButton.get(titles.indexOf(topProductName)).click();
		}
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
		return topProductsPrices.stream().map(price -> Integer.parseInt(price.getText().substring(1))).toList();
	}

	public List<String> getStringOfTitles() {
		return topProductsTitles.stream().map(title -> title.getText().toLowerCase()).toList();
	}

}

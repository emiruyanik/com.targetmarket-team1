package pages.target_market_homepage_tabs;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.TargetMarketHomePage;

import java.util.List;

public class GroceriesTab extends TargetMarketHomePage {

	@FindBy(css = ".card-body>h5")
	private List<WebElement> groceriesTitles;

	@FindBy(css = ".text-danger>i")
	private List<WebElement> groceriesPrices;

	@FindBy(css = ".btn-danger")
	private List<WebElement> addToCartButton;

	public void placeOrder(String groceryName) {
		List<String> groceries = groceriesTitles.stream().map(WebElement::getText).toList();
		actions.moveToElement(addToCartButton.get(groceries.indexOf(groceryName)));
		try {
			addToCartButton.get(groceries.indexOf(groceryName)).click();
		}
		catch (Exception ex) {
			addToCartButton.get(groceries.indexOf(groceryName)).click();
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
		return groceriesPrices.stream().map(price -> Integer.parseInt(price.getText().substring(1))).toList();
	}

	public List<String> getStringOfTitles() {
		return groceriesTitles.stream().map(title -> title.getText().toLowerCase()).toList();

	}

}

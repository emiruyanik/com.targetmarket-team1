package pages.target_market_homepage_tabs;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.TargetMarketHomePage;

import java.util.List;

public class HomeDecorationTab extends TargetMarketHomePage {

	@FindBy(css = ".card-title")
	protected List<WebElement> homeDecorationTitles;

	@FindBy(css = "strong.text-danger>i")
	protected List<WebElement> homeDecorationPrices;

	@FindBy(css = ".btn-danger")
	protected List<WebElement> addToCartButtons;

	public String placeOrder(String productName) {
		List<String> titles = homeDecorationTitles.stream().map(WebElement::getText).toList();
		actions.moveToElement(addToCartButtons.get(titles.indexOf(productName)));
		try {
			addToCartButtons.get(titles.indexOf(productName)).click();
		}
		catch (Exception ex) {
			addToCartButtons.get(titles.indexOf(productName)).click();
		}

		return productName;
	}

	public List<Integer> getPricesOfProductsInHomeDecoration() {
		return homeDecorationPrices.stream().map(price -> Integer.parseInt(price.getText().substring(1))).toList();
	}

	public List<String> getTitlesOfProductsInHomeDecoration() {
		return homeDecorationPrices.stream().map(WebElement::getText).toList();
	}

}

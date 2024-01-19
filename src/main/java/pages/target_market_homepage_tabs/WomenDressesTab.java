package pages.target_market_homepage_tabs;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.TargetMarketHomePage;

import java.util.List;
import java.util.Locale;

public class WomenDressesTab extends TargetMarketHomePage {

	@FindBy(css = "h5.card-title")
	private List<WebElement> womenDressTitles;

	@FindBy(css = "strong.text-danger>i")
	private List<WebElement> womenDressPrices;

	@FindBy(css = ".btn-danger")
	private List<WebElement> addToCartButtons;

	public String placeOrder(String womenDressesName) {
		List<String> titles = womenDressTitles.stream().map(WebElement::getText).toList();
		actions.moveToElement(addToCartButtons.get(titles.indexOf(womenDressesName)));
		try {
			addToCartButtons.get(titles.indexOf(womenDressesName)).click();
		}
		catch (Exception exception) {
			addToCartButtons.get(titles.indexOf(womenDressesName)).click();
		}
		return womenDressesName;
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
		return womenDressPrices.stream().map(price -> Integer.parseInt(price.getText().substring(1))).toList();
	}

	public List<String> getStringOfTitles() {
		return womenDressTitles.stream().map(title -> title.getText().toLowerCase(Locale.ROOT)).toList();
	}

}

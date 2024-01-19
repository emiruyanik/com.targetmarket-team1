package pages.target_market_homepage_tabs;

import pages.TargetMarketHomePage;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import java.util.List;
import java.util.Locale;

public class WomenShoesTab extends TargetMarketHomePage {

	@FindBy(css = ".card-title")
	private List<WebElement> womenShoesTitles;

	@FindBy(css = ".btn-danger")
	private List<WebElement> addTheChartButtons;

	@FindBy(css = ".text-danger > i")
	private List<WebElement> womenShoesPrices;

	public String placeOrder(String womenShoesNames) {
		List<String> shoesNames = womenShoesTitles.stream().map(WebElement::getText).toList();
		actions.moveToElement(addTheChartButtons.get(shoesNames.indexOf(womenShoesNames)));

		try {
			addTheChartButtons.get(shoesNames.indexOf(womenShoesNames)).click();
		}
		catch (Exception ex) {
			addTheChartButtons.get(shoesNames.indexOf(womenShoesNames)).click();
		}

		return womenShoesNames;
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
		return womenShoesPrices.stream().map(price -> Integer.parseInt(price.getText().substring(1))).toList();
	}

	public List<String> getStringOfTitles() {
		return womenShoesTitles.stream().map(title -> title.getText().toLowerCase(Locale.ROOT)).toList();
	}

}
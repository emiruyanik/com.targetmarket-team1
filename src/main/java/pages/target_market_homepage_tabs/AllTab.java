package pages.target_market_homepage_tabs;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.TargetMarketHomePage;

import java.util.List;
import java.util.Locale;

public class AllTab extends TargetMarketHomePage {

	@FindBy(css = ".card-title")
	private List<WebElement> allProductsTitles;

	@FindBy(css = "strong.text-danger>i")
	private List<WebElement> allProductsPrices;

	@FindBy(css = ".btn-danger")
	private List<WebElement> addToCartButtons;

	@FindBy(css = "button.btn-sm")
	private List<WebElement> changingCountButtons;

	@FindBy(xpath = "//button[@class='fs-4 ms-2 btn btn-outline-dark btn-sm']/../span")
	private List<WebElement> countOfProductsOnCart;

	@FindBy(css = "p.mb-0.fs-2")
	private WebElement totalPriceOnCart;

	public void placeOrder(String productName) {
		List<String> titles = allProductsTitles.stream().map(WebElement::getText).toList();
		actions.moveToElement(addToCartButtons.get(titles.indexOf(productName)));
		try {
			addToCartButtons.get(titles.indexOf(productName)).click();
		}
		catch (Exception ex) {
			addToCartButtons.get(titles.indexOf(productName)).click();
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
		return allProductsPrices.stream().map(price -> Integer.parseInt(price.getText().substring(1))).toList();
	}

	public List<String> getStringOfTitles() {
		return allProductsTitles.stream().map(title -> title.getText().toLowerCase(Locale.ROOT)).toList();
	}

	public void clickOnAmountChangerButtons(String productName, String changer) {
		List<String> list = changingCountButtons.stream().map(WebElement::getText).toList();
		changingCountButtons.get((list.indexOf(changer) % 2) + 2 * getProductsNamesOnCart().indexOf(productName))
			.click();
	}

	public int getCountOfProductOnCart(String productName) {
		return Integer.parseInt(countOfProductsOnCart.get(getProductsNamesOnCart().indexOf(productName)).getText());
	}

	public String getTotalPriceOnCart() {
		return totalPriceOnCart.getText();
	}

}

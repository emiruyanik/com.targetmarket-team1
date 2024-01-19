package pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import utils.BrowserUtils;

import java.util.List;

public class TargetMarketHomePage extends BasePage {

	@FindBy(xpath = "//h5[@class='display-5']")
	private WebElement welcomeMessage;

	@FindBy(css = ".logout")
	private WebElement logoutButton;

	@FindBy(css = "span.cat-name")
	private List<WebElement> categoriesTabs;

	@FindBy(css = ".mx-3.align-items-center")
	private WebElement cartButton;

	@FindBy(id = "sortType")
	private WebElement sortTypeSelector;

	@FindBy(css = ".display-1>strong")
	private WebElement categoryShowText;

	@FindBy(tagName = "h3")
	private List<WebElement> productsInCart;

	@FindBy(xpath = "//button[text()='Go to Checkout']")
	private WebElement goToCheckoutButton;

	@FindBy(xpath = "//button[text()='Close']")
	private WebElement closeButton;

	public TargetMarketHomePage() {
		super();
	}

	public String getWelcomeText() {
		wait.until(ExpectedConditions.visibilityOf(logoutButton));
		return welcomeMessage.getText();
	}

	public void clickOnCartButton() {
		cartButton.click();
	}

	public List<String> getProductsNamesOnCart() {
		return productsInCart.stream().map(WebElement::getText).toList();
	}

	public void selectSortType(String sortType) {
		Select select = new Select(sortTypeSelector);
		select.selectByVisibleText(sortType);

	}

	public void selectCategoryTab(String nameOfCategory) {
		wait.until(ExpectedConditions.visibilityOf(welcomeMessage));
		if (nameOfCategory.equalsIgnoreCase("Womens Shoes") || nameOfCategory.equalsIgnoreCase("Womens Dresses")) {
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript(
					"document.querySelector('#splide02-list').setAttribute('style', 'transform: translateX(-285px)');");
		}
		List<String> namesOfCat = categoriesTabs.stream().map(WebElement::getText).toList();
		actions.moveToElement(categoriesTabs.get(namesOfCat.indexOf(nameOfCategory)));
		BrowserUtils.wait(1);
		try {
			categoriesTabs.get(namesOfCat.indexOf(nameOfCategory)).click();
		}
		catch (Exception ex) {
			categoriesTabs.get(namesOfCat.indexOf(nameOfCategory)).click();
		}
	}

	public String getCategoryText() {
		BrowserUtils.scrollUpWithPageUp();
		wait.until(ExpectedConditions.visibilityOf(categoryShowText));
		return categoryShowText.getText();

	}

	public void clickGoToCheckoutButton() {
		goToCheckoutButton.click();
	}

	public void clickToCloseButton() {
		closeButton.click();
	}

	public void clickToLogoutButton() {
		logoutButton.click();
	}

}

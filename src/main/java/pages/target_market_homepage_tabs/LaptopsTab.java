package pages.target_market_homepage_tabs;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.TargetMarketHomePage;

import java.util.List;
import java.util.Locale;

public class LaptopsTab extends TargetMarketHomePage {
    @FindBy(css = ".card-title")
    protected List<WebElement> laptopTitles;

    @FindBy(css = "strong.text-danger>i")
    protected List<WebElement> laptopPrices;

    @FindBy(css = ".btn-danger")
    protected List<WebElement> addToCartButtons;

    public String placeOrder(String productName) {
        List<String> titles = laptopTitles.stream().map(WebElement::getText).toList();
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
        return laptopPrices.stream().map(price -> Integer.parseInt(price.getText().substring(1))).toList();
    }

    public List<String> getTitlesOfProductsInHomeDecoration() {
        return laptopTitles.stream().map(price -> price.getText().toLowerCase(Locale.ROOT)).toList();
    }
}

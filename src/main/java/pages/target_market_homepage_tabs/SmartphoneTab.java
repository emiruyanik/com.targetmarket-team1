package pages.target_market_homepage_tabs;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import pages.TargetMarketHomePage;
import utils.BrowserUtils;
import utils.DriverManager;

import java.util.ArrayList;
import java.util.List;

public class SmartphoneTab extends TargetMarketHomePage {
    @FindBy(css = ".card-title")
    private List<WebElement> smartPhoneTitles;
    @FindBy(css = "strong.text-danger>i")
    private List<WebElement> smartPhonesPrices;
    @FindBy(css = ".btn-danger")
    private List<WebElement> addToCartButton;


    public void placeOrder(String phoneName) {
        List<String> titles = smartPhoneTitles.stream().map(WebElement::getText).toList();
        actions.moveToElement(addToCartButton.get(titles.indexOf(phoneName)));
        try {
            addToCartButton.get(titles.indexOf(phoneName)).click();
        } catch (Exception ex) {
            addToCartButton.get(titles.indexOf(phoneName)).click();
        }
    }


    public boolean isSortedFromSmallToBigPrice() {

        for (int i = 0; i < getIntegerOfPrices().size()-1; i++) {
            if (getIntegerOfPrices().get(i) > getIntegerOfPrices().get(i + 1)) {
                return false;
            }

        }
        return true;
    }

    public boolean isSortedFromBigToSmallPrice() {

        for (int i = 0; i < getIntegerOfPrices().size()-1; i++) {
            if (getIntegerOfPrices().get(i) < getIntegerOfPrices().get(i + 1)) {
                return false;
            }

        }
        return true;
    }

    public List<Integer> getIntegerOfPrices() {
        return smartPhonesPrices.stream().map(price -> Integer.parseInt(price.getText().substring(1))).toList();
    }

    public Object[] getStringOfTitles(){
        return  smartPhoneTitles.stream().map(title -> title.getText().toLowerCase()).toArray();
    }


}

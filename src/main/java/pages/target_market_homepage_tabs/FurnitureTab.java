package pages.target_market_homepage_tabs;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.TargetMarketHomePage;

import java.util.List;

public class FurnitureTab extends TargetMarketHomePage {

    @FindBy(css = "h5.card-title")
    private List<WebElement> furnitureTitles;

    @FindBy(css = "strong.text-danger > i")
    private List<WebElement> furniturePrices;

    @FindBy(css = "button.btn-danger")
    private List<WebElement> addToCartButtons;

    public String PlaceOrder(String furnitureName){
        List<String> titles = furnitureTitles.stream().map(WebElement::getText).toList();
        actions.moveToElement(addToCartButtons.get(titles.indexOf(furnitureName)));
        try {
            addToCartButtons.get(titles.indexOf(furnitureName)).click();
        }catch (Exception exception){
            addToCartButtons.get(titles.indexOf(furnitureName)).click();
        }
        return furnitureName;
    }



}

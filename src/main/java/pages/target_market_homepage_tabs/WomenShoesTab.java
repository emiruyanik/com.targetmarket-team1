package pages.target_market_homepage_tabs;

import pages.TargetMarketHomePage;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import java.util.List;

public class WomenShoesTab extends TargetMarketHomePage {
    @FindBy(css = ".card-title")
    private List<WebElement> womenShoesTitles;

    @FindBy(css = ".btn-danger")
    private List<WebElement> addTheChartButtons;

    @FindBy(css = ".text-danger > i")
    private List<WebElement> womenShoesPrices;

    public String PlaceOrder(String womenShoesNames) {
        List<String> shoesNames = womenShoesTitles.stream().map(WebElement::getText).toList();
        actions.moveToElement(addTheChartButtons.get(shoesNames.indexOf(womenShoesNames)));

        try {
            addTheChartButtons.get(shoesNames.indexOf(womenShoesNames));
        } catch (Exception ex) {
            addTheChartButtons.get(shoesNames.indexOf(womenShoesNames));
        }

        return womenShoesNames;
    }
}

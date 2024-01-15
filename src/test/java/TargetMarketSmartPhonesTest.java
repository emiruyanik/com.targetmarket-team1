import base_test.Hooks;
import org.testng.annotations.Test;
import utils.BrowserUtils;

import java.util.ArrayList;
import java.util.List;

public class TargetMarketSmartPhonesTest extends Hooks {
    @Test(priority = 0)
    void testSmartPhone() {
        //navigate to target market link
        pages.getHomePage().clickOnTargetMarketLink();
        //enter login page
        pages.getTargetMarketLoginPage().login("standard_user", "secret_password");

        //click on smartphones
        pages.getTargetMarketHomePage().selectCategoryTab("Smartphones");

        //verify that smartphones page show up properly
        softAssert.assertEquals("Smartphones", pages.getTargetMarketHomePage().getCategoryText());


    }

    @Test(priority = 1)
    void isProductInCartPageTest() {
        //add products to the cart
        List<String> list = new ArrayList<>();
        list.add("Samsung Universe 9");
        list.add("iPhone X");
        pages.getSmartphoneTab().placeOrder("Samsung Universe 9");
        pages.getSmartphoneTab().placeOrder("iPhone X");

        //click on cart button
        pages.getSmartphoneTab().clickOnCartButton();

        //Verify added products on the card page
        softAssert.assertTrue(list.equals(pages.getSmartphoneTab().getProductsNamesOnCart()));
    }
}

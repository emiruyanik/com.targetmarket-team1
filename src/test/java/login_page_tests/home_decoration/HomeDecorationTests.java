package login_page_tests.home_decoration;

import base_test.Hooks;
import org.testng.Assert;
import org.testng.annotations.Test;
import utils.BrowserUtils;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class HomeDecorationTests extends Hooks {

    @Test(priority = 1)
    public void testThisIsTheHomeDecorationTab(){
        //Navigate to target market page
        pages.getHomePage().clickOnTargetMarketLink();

        //Login with valid credentialse that are username "standard_user and password "secret_password"
        pages.getTargetMarketLoginPage().login("standard_user", "secret_password");

        //Click on the "Home Decoration" tab on Target Market Home Page
        pages.getTargetMarketHomePage().selectCategoryTab("Home Decoration");

        //verify if this is the home decoration tab
        Assert.assertEquals("Home Decoration", pages.getHomeDecorationTab().getCategoryText());
    }

    @Test(priority = 2)
    public void testTheProductsAreSortedCorrectly(){
        //Sort prices from smallest to largest
        Object[] sortedPrice = pages.getHomeDecorationTab().getPricesOfProductsInHomeDecoration();
        Arrays.sort(sortedPrice);

        //Select "Lowest Price" from "Sort By";
        BrowserUtils.scrollDownWithPageDown();
        pages.getHomeDecorationTab().selectSortType("Lowest Price");

        //Verify that prices are sorted from smallest to largest
        Assert.assertEquals(sortedPrice, pages.getHomeDecorationTab().getPricesOfProductsInHomeDecoration());
    }

    @Test(priority = 3)
    public void testAreSelectedProductsInTheCart(){
        List<String> products = new ArrayList<>();
        products.add("Key Holder");
        products.add("Handcraft Chinese style");

        //Click on add to cart button for the product you want
        pages.getHomeDecorationTab().placeOrder("Key Holder");
        pages.getHomeDecorationTab().placeOrder("Handcraft Chinese style");

        //Click on cart button
        pages.getHomeDecorationTab().clickOnCartButton();

        //Verify that selected products are on the cart
        Assert.assertEquals(pages.getHomeDecorationTab().getProductsNamesOnCart(), products);
    }
}

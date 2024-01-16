import base_test.Hooks;
import org.openqa.selenium.JavascriptExecutor;
import org.testng.Assert;
import org.testng.annotations.Test;
import utils.BrowserUtils;
import utils.DriverManager;

import java.util.*;

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
    void isSortableFromSmallToBigPrices() {
        BrowserUtils.wait(2);
        pages.getTargetMarketHomePage().selectSortType("Lowest Price");
        boolean isSortable = pages.getSmartphoneTab().isSortedFromSmallToBigPrice();
        Assert.assertTrue(isSortable, "These prices not sortable from small to big!");

    }

    @Test(priority = 1)
    void isSortableFromBigToSmallPrices() {
        BrowserUtils.wait(2);
        pages.getTargetMarketHomePage().selectSortType("Highest Price");
        boolean isSortable = pages.getSmartphoneTab().isSortedFromBigToSmallPrice();
        Assert.assertTrue(isSortable, "These prices not sortable from big to small!");
    }

    @Test(priority = 1)
    void isSortableFromAToZTitles() {
        BrowserUtils.wait(2);
        Object[] list = pages.getSmartphoneTab().getStringOfTitles();
        Arrays.sort(list);
        pages.getTargetMarketHomePage().selectSortType("A-Z");
        Assert.assertEquals(list,pages.getSmartphoneTab().getStringOfTitles(), "These titles not sortable from A to Z!");
    }

    @Test(priority = 1)
    void isSortableFromZToATitles() {
        BrowserUtils.wait(2);
        Object[] list = pages.getSmartphoneTab().getStringOfTitles();
        Arrays.sort((String[])list, Comparator.reverseOrder());
        pages.getTargetMarketHomePage().selectSortType("Z-A");
        Assert.assertEquals(list,pages.getSmartphoneTab().getStringOfTitles(), "These titles not sortable from Z to A!");
    }

    @Test(priority = 2)
    void isProductInCartPageTest() {
        //add products to the cart
        List<String> list = new ArrayList<>();
        list.add("Samsung Universe 9");
        list.add("iPhone X");
        pages.getSmartphoneTab().placeOrder("Samsung Universe 9");
        pages.getSmartphoneTab().placeOrder("iPhone X");

        //click on cart button
        pages.getSmartphoneTab().clickOnCartButton();
        BrowserUtils.wait(1);

        //Verify added products on the card page
        softAssert.assertTrue(list.equals(pages.getSmartphoneTab().getProductsNamesOnCart()));
    }


}

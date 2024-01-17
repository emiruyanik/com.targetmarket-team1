import base_test.Hooks;
import org.testng.Assert;
import org.testng.annotations.Test;
import utils.BrowserUtils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class TargetMarketSkinCareTest extends Hooks {
    @Test(priority = 0)
    void testSkincare() {
        //navigate to target market link
        pages.getHomePage().clickOnTargetMarketLink();

        //enter login page
        pages.getTargetMarketLoginPage().login("standard_user", "secret_password");

        //click on skincare
        pages.getTargetMarketHomePage().selectCategoryTab("Skincare");

        //verify that skincare page show up properly
        softAssert.assertEquals("Skincare", pages.getTargetMarketHomePage().getCategoryText());

    }

    //Verify that sort 'Lowest price' functionality
    @Test(priority = 1)
    void isSortableFromSmallToBigPrices() {
        pages.getTargetMarketHomePage().selectSortType("Lowest Price");
        boolean isSortable = pages.getSkincareTab().isSortedFromSmallToBigPrice();
        Assert.assertTrue(isSortable, "These prices not sortable from small to big!");
    }

    //Verify that sort 'Highest price' functionality
    @Test(priority = 1)
    void isSortableFromBigToSmallPrices() {
        pages.getTargetMarketHomePage().selectSortType("Highest Price");
        boolean isSortable = pages.getSkincareTab().isSortedFromBigToSmallPrice();
        Assert.assertTrue(isSortable, "These prices not sortable from big to small!");
    }

    //Verify that sort 'A-Z price' functionality
    @Test(priority = 1)
    void isSortableFromAToZTitles() {
        List<String> list = new ArrayList<>(pages.getSkincareTab().getStringOfTitles());
        Collections.sort(list);

        // Select "A-Z" from "Sorted By" selector
        pages.getTargetMarketHomePage().selectSortType("A-Z");

        //Verify that this is sorted.
        Assert.assertEquals(list, pages.getSkincareTab().getStringOfTitles());
    }

    //Verify that sort 'Z-A price' functionality
    @Test(priority = 1)
    void isSortableFromZToATitles() {
        List<String> list = new ArrayList<>(pages.getSkincareTab().getStringOfTitles());
        list.sort(Comparator.reverseOrder());
        pages.getTargetMarketHomePage().selectSortType("Z-A");
        Assert.assertEquals(list, pages.getSkincareTab().getStringOfTitles());
    }

    @Test(priority = 2)
    void isProductInCartPageTest() {
        //add products to the cart
        List<String> list = new ArrayList<>();
        list.add("Hyaluronic Acid Serum");
        list.add("Tree Oil 30ml");
        pages.getSkincareTab().placeOrder("Hyaluronic Acid Serum");
        pages.getSkincareTab().placeOrder("Tree Oil 30ml");

        //click on cart button
        pages.getSmartphoneTab().clickOnCartButton();
        BrowserUtils.wait(1);

        //Verify added products on the card page
        softAssert.assertTrue(list.equals(pages.getSkincareTab().getProductsNamesOnCart()));
    }
}

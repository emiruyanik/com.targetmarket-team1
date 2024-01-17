import base_test.Hooks;
import org.testng.Assert;
import org.testng.annotations.Test;
import utils.BrowserUtils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class TargetMarketWomenDressesTest extends Hooks {
    @Test(priority = 0)
    void testWomenDresses() {
        // navigate to target market link
        pages.getHomePage().clickOnTargetMarketLink();

        // enter login page
        pages.getTargetMarketLoginPage().login("standard_user", "secret_password");

        // click on skincare
        pages.getTargetMarketHomePage().selectCategoryTab("Womens Dresses");

        // verify that skincare page show up properly
        softAssert.assertEquals("Womens Dresses", pages.getTargetMarketHomePage().getCategoryText());

    }

    // Verify that sort 'Lowest price' functionality
    @Test(priority = 1)
    void isSortableFromSmallToBigPrices() {
        pages.getTargetMarketHomePage().selectSortType("Lowest Price");
        boolean isSortable = pages.getWomenDressesTab().isSortedFromSmallToBigPrice();
        Assert.assertTrue(isSortable, "These prices not sortable from small to big!");
    }

    // Verify that sort 'Highest price' functionality
    @Test(priority = 1)
    void isSortableFromBigToSmallPrices() {
        pages.getTargetMarketHomePage().selectSortType("Highest Price");
        boolean isSortable = pages.getWomenDressesTab().isSortedFromBigToSmallPrice();
        Assert.assertTrue(isSortable, "These prices not sortable from big to small!");
    }

    // Verify that sort 'A-Z price' functionality
    @Test(priority = 1)
    void isSortableFromAToZTitles() {
        List<String> list = new ArrayList<>(pages.getWomenDressesTab().getStringOfTitles());
        Collections.sort(list);

        // Select "A-Z" from "Sorted By" selector
        pages.getTargetMarketHomePage().selectSortType("A-Z");

        // Verify that this is sorted.
        Assert.assertEquals(list, pages.getWomenDressesTab().getStringOfTitles());
    }

    // Verify that sort 'Z-A price' functionality
    @Test(priority = 1)
    void isSortableFromZToATitles() {
        List<String> list = new ArrayList<>(pages.getWomenDressesTab().getStringOfTitles());
        list.sort(Comparator.reverseOrder());
        pages.getTargetMarketHomePage().selectSortType("Z-A");
        Assert.assertEquals(list, pages.getWomenDressesTab().getStringOfTitles());
    }

    @Test(priority = 2)
    void isProductInCartPageTest() {
        // add products to the cart
        List<String> list = new ArrayList<>();
        list.add("frock gold printed");
        list.add("Stiched Kurta plus trouser");
        pages.getWomenDressesTab().placeOrder("frock gold printed");
        pages.getWomenDressesTab().placeOrder("Ladies Multicolored Dress");

        // click on cart button
        pages.getWomenDressesTab().clickOnCartButton();
        BrowserUtils.wait(1);

        // Verify added products on the card page
        softAssert.assertTrue(list.equals(pages.getWomenDressesTab().getProductsNamesOnCart()));
    }
}

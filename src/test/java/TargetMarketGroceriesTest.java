import base_test.Hooks;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class TargetMarketGroceriesTest extends Hooks {
    @Test(priority = 0)
    void testGrocery() {
        //navigate to target market link
        pages.getHomePage().clickOnTargetMarketLink();

        //enter login page
        pages.getTargetMarketLoginPage().login("standard_user", "secret_password");

        //click on grocery
        pages.getTargetMarketHomePage().selectCategoryTab("Groceries");

        //verify that groceries page show up properly
        softAssert.assertEquals("Groceries", pages.getTargetMarketHomePage().getCategoryText());

    }

    @Test(priority = 1)
    void isSortableFromSmallToBigPrices() {
        pages.getTargetMarketHomePage().selectSortType("Lowest Price");
        boolean isSorted = pages.getGroceriesTab().isSortedFromSmallToBigPrice();
        Assert.assertTrue(isSorted, "These prices not sortable from small to big!");
    }

    @Test(priority = 1)
    void isSortableFromBigToSmallPrices() {
        pages.getTargetMarketHomePage().selectSortType("Highest Price");
        boolean isSortable = pages.getSkincareTab().isSortedFromBigToSmallPrice();
        Assert.assertTrue(isSortable, "These prices not sortable from big to small!");
    }

    @Test(priority = 1)
    void isSortableFromAToZTitles() {
        List<String> list = new ArrayList<>(pages.getGroceriesTab().getStringOfTitles());
        Collections.sort(list);
        // Select "A-Z" from "Sorted By" selector
        pages.getTargetMarketHomePage().selectSortType("A-Z");

        //Verify that this is sorted.
        Assert.assertEquals(list, pages.getGroceriesTab().getStringOfTitles());
    }

    @Test(priority = 1)
    void isSortableFromZToATitles() {
        List<String> list = new ArrayList<>(pages.getGroceriesTab().getStringOfTitles());
        list.sort(Comparator.reverseOrder());

        // Select "Z-A" from "Sorted By" selector
        pages.getTargetMarketHomePage().selectSortType("Z-A");

        //Verify that this is sorted.
        Assert.assertEquals(list, pages.getGroceriesTab().getStringOfTitles());
    }

    @Test(priority = 2)
    void isProductInCartPageTest() {
        //add products to the cart
        List<String> list = new ArrayList<>();
        list.add("Gulab Powder 50 Gram");
        list.add("Elbow Macaroni - 400 gm");

        pages.getGroceriesTab().placeOrder("Gulab Powder 50 Gram");
        pages.getGroceriesTab().placeOrder("Elbow Macaroni - 400 gm");

        //  //click on cart button
        pages.getTargetMarketHomePage().clickOnCartButton();
        Assert.assertEquals(list, pages.getTargetMarketHomePage().getProductsNamesOnCart());
    }
}

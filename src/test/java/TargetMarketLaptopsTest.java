import base_test.Hooks;
import org.testng.Assert;
import org.testng.annotations.Test;
import utils.BrowserUtils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class TargetMarketLaptopsTest extends Hooks {
    @Test(priority = 1)
    public void testThisIsTheHomeDecorationTab() {
        // Navigate to target market page
        pages.getHomePage().clickOnTargetMarketLink();

        // Login with valid credentials that are username "standard_user and password "secret_password"
        pages.getTargetMarketLoginPage().login("standard_user", "secret_password");

        //Click on the "Laptops" tab on Target Market Home Page
        pages.getTargetMarketHomePage().selectCategoryTab("Laptops");

        //Verify that laptops page show up properly
        Assert.assertEquals("Laptops", pages.getHomeDecorationTab().getCategoryText());
    }

    // Verify that sort 'Lowest price' functionality
    @Test(priority = 2)
    public void testSortedFromSmallestToLargest() {
        //Sort prices from smallest to largest
        List<Integer> sortedPrice = new ArrayList<>(pages.getLaptopsTab().getPricesOfProductsInHomeDecoration());
        Collections.sort(sortedPrice);

        //Select "Lowest Price" from "Sort By";
        BrowserUtils.scrollDownWithPageDown();
        pages.getLaptopsTab().selectSortType("Lowest Price");

        //Verify that prices are sorted from smallest to largest
        Assert.assertEquals(sortedPrice, pages.getLaptopsTab().getPricesOfProductsInHomeDecoration());
    }

    //Verify that sort 'Highest price' functionality
    @Test(priority = 3)
    public void testSortedFromLargestToSmallest(){
        // Sort prices from largest to smallest
        List<Integer> sortedPrice = new ArrayList<>(pages.getLaptopsTab().getPricesOfProductsInHomeDecoration());
        sortedPrice.sort(Comparator.reverseOrder());

        //Select "Highest Price" from "Sort By"
        pages.getLaptopsTab().selectSortType("Highest Price");

        Assert.assertEquals(sortedPrice, pages.getLaptopsTab().getPricesOfProductsInHomeDecoration());
    }

    //Verify that sort 'A-Z' functionality
    @Test(priority = 4)
    public void testsortedTitlesFromAToZ(){
        //Sort titles from A to Z
        List<String> sortedTitles = new ArrayList<>(pages.getLaptopsTab().getTitlesOfProductsInHomeDecoration());
        Collections.sort(sortedTitles);

        //Select "A-Z" from "Sort By"
        pages.getLaptopsTab().selectSortType("A-Z");

        Assert.assertEquals(sortedTitles, pages.getLaptopsTab().getTitlesOfProductsInHomeDecoration());
    }

    //Verify that sort 'Z-A' functionality
    @Test(priority = 5)
    public void testsortedTitlesFromZToA(){
        //Sort titles from Z to A
        List<String> sortedTitles = new ArrayList<>(pages.getLaptopsTab().getTitlesOfProductsInHomeDecoration());
        sortedTitles.sort(Comparator.reverseOrder());

        //Select "Z-A" from "Sort By"
        pages.getLaptopsTab().selectSortType("Z-A");

        Assert.assertEquals(sortedTitles, pages.getLaptopsTab().getTitlesOfProductsInHomeDecoration());
    }

    @Test(priority = 6)
    public void testAreSelectedProductsInTheCart() {
        List<String> products = new ArrayList<>();

        //Click on add to cart button for the product you want
        products.add(pages.getLaptopsTab().placeOrder("HP Pavilion 15-DK1056WM"));
        products.add(pages.getLaptopsTab().placeOrder("Microsoft Surface Laptop 4"));

        //Click on cart button
        pages.getLaptopsTab().clickOnCartButton();
        BrowserUtils.wait(1);

        //Verify that selected products are on the cart
        Assert.assertEquals(pages.getLaptopsTab().getProductsNamesOnCart(), products);
    }
}

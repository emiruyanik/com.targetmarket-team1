import base_test.Hooks;
import org.testng.Assert;
import org.testng.annotations.Test;
import utils.BrowserUtils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class TargetMarketAllTabTest extends Hooks {

    @Test(priority = 0)
    void testSmartPhone() {
        //navigate to target market link
        pages.getHomePage().clickOnTargetMarketLink();
        //enter login page
        pages.getTargetMarketLoginPage().login("standard_user", "secret_password");

        //click on smartphones
        pages.getTargetMarketHomePage().selectCategoryTab("All");

        //verify that smartphones page show up properly
        softAssert.assertEquals("All", pages.getTargetMarketHomePage().getCategoryText());

    }

    @Test(priority = 1)
    void isSortableFromSmallToBigPrices() {
        List<Integer> list = new ArrayList<>(pages.getAllTab().getIntegerOfPrices());
        Collections.sort(list);
        pages.getTargetMarketHomePage().selectSortType("Lowest Price");
        Assert.assertEquals(list, pages.getAllTab().getIntegerOfPrices());

        //Assert.assertTrue(isSortable, "These prices not sortable from small to big!");
    }

    @Test(priority = 1)
    void isSortableFromBigToSmallPrices() {
        List<Integer> list = new ArrayList<>(pages.getAllTab().getIntegerOfPrices());
        list.sort(Comparator.reverseOrder());
        pages.getTargetMarketHomePage().selectSortType("Highest Price");

        Assert.assertEquals(list, pages.getAllTab().getIntegerOfPrices(), "These prices not sortable from big to small!");
    }

    @Test(priority = 1)
    void isSortableFromAToZTitles() {
        List<String> list = new ArrayList<>(pages.getAllTab().getStringOfTitles());
        Collections.sort(list);

        // Select "A-Z" from "Sorted By" selector
        pages.getTargetMarketHomePage().selectSortType("A-Z");

        //Verify that this is sorted.
        Assert.assertEquals(list, pages.getAllTab().getStringOfTitles());
    }

    @Test(priority = 1)
    void isSortableFromZToATitles() {
        List<String> list = new ArrayList<>(pages.getAllTab().getStringOfTitles());
        list.sort(Comparator.reverseOrder());
        pages.getTargetMarketHomePage().selectSortType("Z-A");
        Assert.assertEquals(list, pages.getAllTab().getStringOfTitles());
    }

    @Test(priority = 2)
    void isProductInCartPageTest() {
        //add products to the cart
        List<String> list = new ArrayList<>();
        list.add("Samsung Universe 9");
        list.add("Sneaker shoes");

        pages.getAllTab().placeOrder("Samsung Universe 9");
        pages.getAllTab().placeOrder("Sneaker shoes");
        pages.getAllTab().placeOrder("Malai Maxi Dress");


        //click on cart button
        pages.getAllTab().clickOnCartButton();
        BrowserUtils.wait(1);

        //Verify added products on the card page
        softAssert.assertTrue(list.equals(pages.getAllTab().getProductsNamesOnCart()));
    }

    //TODO
    @Test(priority = 3)
    void testMinusAndPlusButtonsOnCartFunctionality(){
        int initialCount = pages.getAllTab().getCountOfProductOnCart();
        pages.getAllTab().clickOnAmountChangerButtons("Samsung Universe 9","+");
        int finalCount = pages.getAllTab().getCountOfProductOnCart();
        BrowserUtils.wait(2);
      //softAssert.assertTrue(finalCount > initialCount);

        pages.getAllTab().clickOnAmountChangerButtons("Sneaker shoes","-");
        BrowserUtils.wait(2);

        pages.getAllTab().clickOnAmountChangerButtons("Malai Maxi Dress","+");
        BrowserUtils.wait(2);


        finalCount = pages.getAllTab().getCountOfProductOnCart();

        //softAssert.assertEquals(initialCount, finalCount);

    }

}

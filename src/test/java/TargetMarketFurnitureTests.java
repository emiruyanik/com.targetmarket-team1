import base_test.Hooks;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

public class TargetMarketFurnitureTests extends Hooks {
    List<String> productsName  = new ArrayList<>();
    /**
     * 1- Go to https://test.inar-academy.com/target-market.
     * 2- Enter a valid username and valid password in the username box.
     * 3- Click on the "Login" button.
     * 4. Click on furniture tab.
     * 5- Verify this is furniture tab.
     * 6- Click on cart of Mornadi Velvet Bed and Sofa for Coffe Cafe.
     * 7- Click on cart button.
     * 8- Verify products are displayed on the cart.
     */
    @Test(priority = 1)
    void testFurnitureTab(){
        // 1- Go to https://test.inar-academy.com/target-market.
        pages.getHomePage().clickOnTargetMarketLink();

        // 2- Enter a valid username and valid password in the username box.
        // 3- Click on the "Login" button.
        pages.getTargetMarketLoginPage().login("standard_user","secret_password");

        // 4- Click on furniture tab.
        pages.getTargetMarketHomePage().selectCategoryTab("Furniture");

        //5- Verify this is furniture tab.
        String actual= pages.getTargetMarketHomePage().getCategoryText();
        Assert.assertEquals(actual,"Furniture","Wrong text message!");

    }

    @Test(priority = 2)
    void testDisplayedOnTheCart(){
        // 6- Click on cart of Mornadi Velvet Bed and Sofa for Coffe Cafe.
       productsName.add(pages.getFurnitureTab().placeOrder("Mornadi Velvet Bed"));
       productsName.add(pages.getFurnitureTab().placeOrder("Sofa for Coffe Cafe"));

        // 7- Click on cart button.
        pages.getFurnitureTab().clickOnCartButton();

        // 8- Verify products are displayed on the cart.
        List<String> list = pages.getFurnitureTab().getProductsNamesOnCart();
        Assert.assertEquals(productsName,list,"The products aren't displayed on the cart.");

    }

}

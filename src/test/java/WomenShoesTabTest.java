import base_test.Hooks;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

public class WomenShoesTabTest extends Hooks {
    /*
     * 1- Go to https://test.inar-academy.com/target-market.
     * 2- Enter a valid username and valid password in the username box.
     * 3- Click on the "Login" button.
     * 4. Click on women shoes tab.
     * 5- Verify this is women shoes tab.
     * 6- Click on cart of Mornadi Velvet Bed and Sofa for Coffe Cafe.
     * 7- Click on cart button.
     * 8- Verify products are displayed on the cart.
     */

    List<String> productNames = new ArrayList<>();

    @Test
    void testWomenShoesTab() {
        // Go to https://test.inar-academy.com/target-market.
        pages.getHomePage().clickOnTargetMarketLink();

        //Enter a valid username and valid password in the username box.
        //Click on the "Login" button.
        pages.getTargetMarketLoginPage().login("standard_user", "secret_password");

        //Click on women shoes tab.
        pages.getTargetMarketHomePage().selectCategoryTab("Womens Shoes");

        //Verify this is women shoes tab.
        Assert.assertEquals(pages.getTargetMarketHomePage().getCategoryText(), "Womens Shoes", "Wrong text message!");

    }


}

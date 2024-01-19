import base_test.Hooks;
import org.testng.Assert;
import org.testng.annotations.Test;
import utils.BrowserUtils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class TargetMarketWomenShoesTest extends Hooks {

	/*
	 * 1- Go to https://test.inar-academy.com/target-market. 2- Enter a valid username and
	 * valid password in the username box. 3- Click on the "Login" button. 4. Click on
	 * women shoes tab. 5- Verify this is women shoes tab. 6- Click on cart of Mornadi
	 * Velvet Bed and Sofa for Coffe Cafe. 7- Click on cart button. 8- Verify products are
	 * displayed on the cart.
	 */

	List<String> productNames = new ArrayList<>();

	@Test
	void testWomenShoesTab() {
		// Go to https://test.inar-academy.com/target-market.
		pages.getHomePage().clickOnTargetMarketLink();

		// Enter a valid username and valid password in the username box.
		// Click on the "Login" button.
		pages.getTargetMarketLoginPage().login("standard_user", "secret_password");

		// Click on women shoes tab.
		pages.getTargetMarketHomePage().selectCategoryTab("Womens Shoes");

		// Verify this is women shoes tab.
		Assert.assertEquals(pages.getTargetMarketHomePage().getCategoryText(), "Womens Shoes", "Wrong text message!");

	}

	// Verify that sort 'Lowest price' functionality
	@Test(priority = 1)
	void isSortableFromSmallToBigPrices() {
		pages.getTargetMarketHomePage().selectSortType("Lowest Price");
		boolean isSortable = pages.getWomenShoesTab().isSortedFromSmallToBigPrice();
		Assert.assertTrue(isSortable, "These prices not sortable from small to big!");
	}

	// Verify that sort 'Highest price' functionality
	@Test(priority = 1)
	void isSortableFromBigToSmallPrices() {
		pages.getTargetMarketHomePage().selectSortType("Highest Price");
		boolean isSortable = pages.getWomenShoesTab().isSortedFromBigToSmallPrice();
		Assert.assertTrue(isSortable, "These prices not sortable from big to small!");
	}

	// Verify that sort 'A-Z price' functionality
	@Test(priority = 1)
	void isSortableFromAToZTitles() {
		List<String> list = new ArrayList<>(pages.getWomenShoesTab().getStringOfTitles());
		Collections.sort(list);

		// Select "A-Z" from "Sorted By" selector
		pages.getTargetMarketHomePage().selectSortType("A-Z");

		// Verify that this is sorted.
		Assert.assertEquals(list, pages.getWomenShoesTab().getStringOfTitles());
	}

	// Verify that sort 'Z-A price' functionality
	@Test(priority = 1)
	void isSortableFromZToATitles() {
		List<String> list = new ArrayList<>(pages.getWomenShoesTab().getStringOfTitles());
		list.sort(Comparator.reverseOrder());
		pages.getTargetMarketHomePage().selectSortType("Z-A");
		Assert.assertEquals(list, pages.getWomenShoesTab().getStringOfTitles());
	}

	@Test(priority = 2)
	void isProductInCartPageTest() {
		// add products to the cart
		List<String> list = new ArrayList<>();
		list.add(pages.getWomenShoesTab().placeOrder("Chappals & Shoe Ladies Metallic"));
		list.add(pages.getWomenShoesTab().placeOrder("Women Strip Heel"));

		// click on cart button
		pages.getWomenShoesTab().clickOnCartButton();
		BrowserUtils.wait(1);

		// Verify added products on the card page
		softAssert.assertTrue(list.equals(pages.getWomenShoesTab().getProductsNamesOnCart()));
	}

}

import base_test.Hooks;
import org.testng.Assert;
import org.testng.annotations.Test;
import utils.BrowserUtils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class TargetMarketTopsTabTest extends Hooks {

	@Test(priority = 0)
	void testTopsTab() {
		// navigate to target market link
		pages.getHomePage().clickOnTargetMarketLink();
		// enter login page
		pages.getTargetMarketLoginPage().login("standard_user", "secret_password");

		// click on Tops
		pages.getTargetMarketHomePage().selectCategoryTab("Tops");

		// verify that smartphones page show up properly
		softAssert.assertEquals("Tops", pages.getTargetMarketHomePage().getCategoryText());
	}

	@Test(priority = 1)
	void isSortableFromSmallToBigPrices() {
		pages.getTargetMarketHomePage().selectSortType("Lowest Price");
		boolean isSortable = pages.getTopsTab().isSortedFromSmallToBigPrice();
		Assert.assertTrue(isSortable, "These prices not sortable from small to big!");
	}

	@Test(priority = 1)
	void isSortableFromBigToSmallPrices() {
		pages.getTargetMarketHomePage().selectSortType("Highest Price");
		boolean isSortable = pages.getTopsTab().isSortedFromBigToSmallPrice();
		Assert.assertTrue(isSortable, "These prices not sortable from big to small!");
	}

	@Test(priority = 1)
	void isSortableFromAToZTitles() {
		List<String> list = new ArrayList<>(pages.getTopsTab().getStringOfTitles());
		Collections.sort(list);

		// Select "A-Z" from "Sorted By" selector
		pages.getTargetMarketHomePage().selectSortType("A-Z");

		// Verify that this is sorted.
		Assert.assertEquals(list, pages.getTopsTab().getStringOfTitles());
	}

	@Test(priority = 1)
	void isSortableFromZToATitles() {
		List<String> list = new ArrayList<>(pages.getTopsTab().getStringOfTitles());
		list.sort(Comparator.reverseOrder());
		pages.getTargetMarketHomePage().selectSortType("Z-A");
		Assert.assertEquals(list, pages.getTopsTab().getStringOfTitles());
	}

	@Test(priority = 2)
	void isProductInCartPageTest() {
		// add products to the cart
		List<String> list = new ArrayList<>();
		list.add("sublimation plain kids tank");
		list.add("Women Sweaters Wool");
		pages.getTopsTab().placeOrder("sublimation plain kids tank");
		pages.getTopsTab().placeOrder("Women Sweaters Wool");

		// click on cart button
		pages.getTopsTab().clickOnCartButton();
		BrowserUtils.wait(1);

		// Verify added products on the card page
		softAssert.assertTrue(list.equals(pages.getTopsTab().getProductsNamesOnCart()));
	}

}

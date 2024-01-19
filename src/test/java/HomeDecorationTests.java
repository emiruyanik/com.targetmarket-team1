import base_test.Hooks;
import org.testng.Assert;
import org.testng.annotations.Test;
import utils.BrowserUtils;

import java.util.*;

public class HomeDecorationTests extends Hooks {

	@Test(priority = 1)
	public void testThisIsTheHomeDecorationTab() {
		// Navigate to target market page
		pages.getHomePage().clickOnTargetMarketLink();

		// Login with valid credentials that are username "standard_user and password
		// "secret_password"
		pages.getTargetMarketLoginPage().login("standard_user", "secret_password");

		// Click on the "Home Decoration" tab on Target Market Home Page
		pages.getTargetMarketHomePage().selectCategoryTab("Home Decoration");

		// Verify that home decoration page show up properly
		Assert.assertEquals("Home Decoration", pages.getHomeDecorationTab().getCategoryText());
	}

	@Test(priority = 2)
	public void testSortedFromSmallestToLargest() {
		// Sort prices from smallest to largest
		List<Integer> sortedPrice = new ArrayList<>(pages.getHomeDecorationTab().getPricesOfProductsInHomeDecoration());
		Collections.sort(sortedPrice);

		// Select "Lowest Price" from "Sort By"
		BrowserUtils.scrollDownWithPageDown();
		pages.getHomeDecorationTab().selectSortType("Lowest Price");

		// Verify that "Lowest Price" functionality
		Assert.assertEquals(sortedPrice, pages.getHomeDecorationTab().getPricesOfProductsInHomeDecoration());
	}

	@Test(priority = 3)
	public void testSortedFromLargestToSmallest() {
		// Sort prices from largest to smallest
		List<Integer> sortedPrice = new ArrayList<>(pages.getHomeDecorationTab().getPricesOfProductsInHomeDecoration());
		sortedPrice.sort(Comparator.reverseOrder());

		// Select "Highest Price" from "Sort By"
		pages.getHomeDecorationTab().selectSortType("Highest Price");

		// Verify that "Highest Price" functionality
		Assert.assertEquals(sortedPrice, pages.getHomeDecorationTab().getPricesOfProductsInHomeDecoration());
	}

	@Test(priority = 4)
	public void testSortedTitlesFromAToZ() {
		// Sort titles from A to Z
		List<String> sortedTitles = new ArrayList<>(pages.getHomeDecorationTab().getTitlesOfProductsInHomeDecoration());
		Collections.sort(sortedTitles);

		// Select "A-Z" from "Sort By"
		pages.getHomeDecorationTab().selectSortType("A-Z");

		// Verify that "A-Z" functionality
		Assert.assertEquals(sortedTitles, pages.getHomeDecorationTab().getTitlesOfProductsInHomeDecoration());
	}

	@Test(priority = 5)
	public void testSortedTitlesFromZToA() {
		// Sort titles from Z to A
		List<String> sortedTitles = new ArrayList<>(pages.getHomeDecorationTab().getTitlesOfProductsInHomeDecoration());
		sortedTitles.sort(Comparator.reverseOrder());

		// Select "Z-A" from "Sort By"
		pages.getHomeDecorationTab().selectSortType("Z-A");

		// Verify that "Z-A" functionality
		Assert.assertEquals(sortedTitles, pages.getHomeDecorationTab().getTitlesOfProductsInHomeDecoration());
	}

	@Test(priority = 6)
	public void testAreSelectedProductsInTheCart() {
		List<String> products = new ArrayList<>();

		// Click on add to cart button for the product you want
		products.add(pages.getHomeDecorationTab().placeOrder("3D Embellishment Art Lamp"));


		// Click on cart button
		pages.getHomeDecorationTab().clickOnCartButton();
		BrowserUtils.wait(1);

		// Verify that selected products are on the cart
		Assert.assertEquals(pages.getHomeDecorationTab().getProductsNamesOnCart(), products);
	}

}

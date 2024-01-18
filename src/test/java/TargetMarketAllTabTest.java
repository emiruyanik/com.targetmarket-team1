import base_test.Hooks;
import org.testng.Assert;
import org.testng.annotations.Test;
import utils.BrowserUtils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import static org.testng.AssertJUnit.assertFalse;

public class TargetMarketAllTabTest extends Hooks {

	@Test(priority = 0)
	void testAllCategoriesTabNameExhibition() {
		// 1.Navigate to target market link
		pages.getHomePage().clickOnTargetMarketLink();

		// 2.Enter login page
		pages.getTargetMarketLoginPage().login("standard_user", "secret_password");

		// 3.Click on smartphones
		pages.getTargetMarketHomePage().selectCategoryTab("All");

		// 4.Verify that smartphones page show up properly
		softAssert.assertEquals("All", pages.getTargetMarketHomePage().getCategoryText());

	}

	@Test(priority = 1)
	void testIsProductsSortableFromLowestToHighestPrice() {
		// 1.Get prices of products in initial queue
		List<Integer> expectedList = new ArrayList<>(pages.getAllTab().getIntegerOfPrices());

		// 2.Sort prices of products by using Collections sort method
		Collections.sort(expectedList);

		// 3.Get prices of products from website after selecting sort type
		pages.getTargetMarketHomePage().selectSortType("Lowest Price");
		List<Integer> actualList = pages.getAllTab().getIntegerOfPrices();

		// 4.Verify that prices of products are sorted from lowest to highest
		Assert.assertEquals(expectedList, actualList, "Products are not sorted from lowest to highest");

	}

	@Test(priority = 1)
	void testIsProductsSortableFromHighestToLowestPrice() {
		// 1.Get prices of products in initial queue
		List<Integer> expectedList = new ArrayList<>(pages.getAllTab().getIntegerOfPrices());

		// 2.Sort prices of products reversely by using Collections sort method
		expectedList.sort(Comparator.reverseOrder());

		// 3.Get prices of products from website after selecting sort type
		pages.getTargetMarketHomePage().selectSortType("Highest Price");
		List<Integer> actualList = pages.getAllTab().getIntegerOfPrices();

		// 4.Verify that prices of products are sorted from highest to lowest
		Assert.assertEquals(expectedList, actualList, "Products are not sorted from big to small!");
	}

	@Test(priority = 1)
	void testIsProductsTitlesSortableFromAToZ() {
		// 1.Get prices of products in initial queue
		List<String> expectedList = new ArrayList<>(pages.getAllTab().getStringOfTitles());

		// 2.Sort prices of products by using Collections sort method
		Collections.sort(expectedList);

		// 3.Get titles of products from website after selecting sort type
		pages.getTargetMarketHomePage().selectSortType("A-Z");
		List<String> actualList = pages.getAllTab().getStringOfTitles();

		// 4.Verify that prices of products are sorted from A to Z
		Assert.assertEquals(expectedList, actualList, "Products are not sorted from A to Z!");
	}

	@Test(priority = 1)
	void testIsProductsTitlesSortableFromZToA() {
		// 1.Get prices of products in initial queue
		List<String> expectedList = new ArrayList<>(pages.getAllTab().getStringOfTitles());

		// 2.Sort prices of products reversely by using Collections sort method
		expectedList.sort(Comparator.reverseOrder());

		// 3.Get titles of products from website after selecting sort type
		pages.getTargetMarketHomePage().selectSortType("Z-A");
		List<String> actualList = pages.getAllTab().getStringOfTitles();

		// 4.Verify that prices of products are sorted from Z to A
		Assert.assertEquals(expectedList, actualList, "Products are not sorted from Z to A!");
	}

	@Test(priority = 2)
	void isProductInCartPageTest() {
		// 1.Add products to the cart
		List<String> list = new ArrayList<>();
		list.add("Samsung Universe 9");
		list.add("Samsung Galaxy Book");
		list.add("Malai Maxi Dress");

		pages.getAllTab().placeOrder("Samsung Universe 9");
		pages.getAllTab().placeOrder("Samsung Galaxy Book");
		pages.getAllTab().placeOrder("Malai Maxi Dress");

		// click on cart button
		pages.getAllTab().clickOnCartButton();
		BrowserUtils.wait(1);

		// Verify added products on the card page
		softAssert.assertTrue(list.equals(pages.getAllTab().getProductsNamesOnCart()));
	}

	@Test(priority = 3)
	void testMinusAndPlusButtonsOnCartFunctionality() {
		// 1.Get initial count of 'Samsung Universe 9'
		int initialCount = pages.getAllTab().getCountOfProductOnCart("Samsung Universe 9");

		// 2.Click on plus button on cart for 'Samsung Universe 9'
		pages.getAllTab().clickOnAmountChangerButtons("Samsung Universe 9", "+");

		// 3.Get final count of 'Samsung Universe 9'
		int finalCount = pages.getAllTab().getCountOfProductOnCart("Samsung Universe 9");

		// 4.Verify that final count is bigger than initial count
		softAssert.assertTrue(finalCount > initialCount);

		// 5.Click on minus button on cart for 'Samsung Galaxy Book'
		pages.getAllTab().clickOnAmountChangerButtons("Samsung Galaxy Book", "-");
		BrowserUtils.wait(1);

		// 6.Verify that 'Samsung Galaxy Book' is not displayed on the cart
		Assert.assertFalse(pages.getTargetMarketHomePage().getProductsNamesOnCart().contains("Samsung Galaxy Book"));

		// 7.Get initial count of 'Malai Maxi Dress'
		initialCount = pages.getAllTab().getCountOfProductOnCart("Malai Maxi Dress");

		// 8.Click on plus button on cart for 'Malai Maxi Dress'
		pages.getAllTab().clickOnAmountChangerButtons("Malai Maxi Dress", "+");
		BrowserUtils.wait(1);

		// 9.Get final count of 'Malai Maxi Dress'
		finalCount = pages.getAllTab().getCountOfProductOnCart("Malai Maxi Dress");

		// 10.Verify that final count is bigger than initial count
		softAssert.assertTrue(finalCount > initialCount);

		softAssert.assertAll();

	}

}

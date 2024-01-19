package checkout_process_tests;

import base_test.Hooks;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TargetMarketCheckoutPageTest extends Hooks {

	@Test
	void testCheckoutProcessWithValidCredentials() {
		// * 1-Go to https://test.inar-academy.com/target-market
		pages.getHomePage().clickOnTargetMarketLink();
		pages.getTargetMarketLoginPage().login("standard_user", "secret_password");

		// click on smartphones
		pages.getTargetMarketHomePage().selectCategoryTab("Smartphones");

		// add products to the cart
		pages.getSmartphoneTab().placeOrder("Samsung Universe 9");
		pages.getSmartphoneTab().placeOrder("iPhone X");

		pages.getSmartphoneTab().clickOnCartButton();

		pages.getTargetMarketHomePage().clickGoToCheckoutButton();

		pages.getTargetMarketCheckoutPage()
			.placeOrderProcess("John", "Sanchez", "Main Strett 15D 07560", "4938281746192845", "5457894231");

		String expectedMessage = "Thanks!";
		String actualMessage = pages.getTargetMarketCheckoutPage().getThanksMessage();

		Assert.assertEquals(expectedMessage, actualMessage);
	}

}

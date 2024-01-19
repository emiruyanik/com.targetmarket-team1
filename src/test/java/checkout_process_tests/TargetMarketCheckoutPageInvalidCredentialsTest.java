package checkout_process_tests;

import base_test.Hooks;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TargetMarketCheckoutPageInvalidCredentialsTest extends Hooks {

	@Test(priority = 1)
	void checkoutProcessWithInvalidPhoneNumberTest() {
		// * 1-Go to https://test.inar-academy.com/target-market
		pages.getHomePage().clickOnTargetMarketLink();
		pages.getTargetMarketLoginPage().login("standard_user", "secret_password");

		// click on smartphones
		pages.getTargetMarketHomePage().selectCategoryTab("Smartphones");

		// add products to the cart
		pages.getSmartphoneTab().placeOrder("Samsung Universe 9");
		pages.getSmartphoneTab().placeOrder("iPhone X");

		pages.getSmartphoneTab().clickOnCartButton();

		pages.getSmartphoneTab().clickGoToCheckoutButton();

		// John Sanchez Main Strett 15D 07560 4938281746192845 545789423

		// Enter valid credentials with invalid phone number
		pages.getTargetMarketCheckoutPage()
			.placeOrderProcess("John", "Sanchez", "Main Strett 15D 07560", "4938281746192845", "545789423");

		String expectedMessage = "Phone number must be 10 digits";
		String actualMessage = pages.getTargetMarketCheckoutPage().getPhoneNumberAlertMessage();

		Assert.assertEquals(expectedMessage, actualMessage);

	}

	@Test(priority = 2)
	void checkoutProcessWithInvalidCardNumberTest() {
		pages.getTargetMarketCheckoutPage().clickOnInarAcademyImage();

		pages.getSmartphoneTab().clickOnCartButton();

		pages.getTargetMarketHomePage().clickGoToCheckoutButton();

		// Enter valid credentials with invalid card number
		pages.getTargetMarketCheckoutPage()
			.placeOrderProcess("John", "Sanchez", "Main Strett 15D 07560", "493828174619284", "5457894231");

		String expectedMessage = "Card number must be 16 digits";
		String actualMessage = pages.getTargetMarketCheckoutPage().getCardNumberAlertMessage();

		Assert.assertEquals(expectedMessage, actualMessage);

	}

	@Test(priority = 3)
	void checkoutProcessWithMissingAddressTest() {
		pages.getTargetMarketCheckoutPage().clickOnInarAcademyImage();

		pages.getSmartphoneTab().clickOnCartButton();

		pages.getTargetMarketHomePage().clickGoToCheckoutButton();

		// Enter valid credentials with missing address
		pages.getTargetMarketCheckoutPage().placeOrderProcess("John", "Sanchez", "", "4938281746192845", "5457894231");

		String expectedMessage = "Address is required";
		String actualMessage = pages.getTargetMarketCheckoutPage().getAddressAlertMessage();

		// Verify the message
		Assert.assertEquals(expectedMessage, actualMessage);
	}

}

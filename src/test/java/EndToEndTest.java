import base_test.Hooks;
import freemarker.template.Configuration;
import org.testng.annotations.Test;
import utils.BrowserUtils;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class EndToEndTest extends Hooks {

	List<String> list = new ArrayList<>();

	@Test
	void endToEndTest() {

		// Login Process Test
		pages.getHomePage().clickOnTargetMarketLink();

		pages.getTargetMarketLoginPage().login("standard_user", "secret_password");

		String welcomeText = "Welcome to the Target Market, standard_user!";

		softAssert.assertEquals(welcomeText, pages.getTargetMarketHomePage().getWelcomeText(), "Wrong Message!");

		// Home Page Test
		pages.getTargetMarketHomePage().selectCategoryTab("Womens Shoes");

		softAssert.assertEquals(pages.getTargetMarketHomePage().getCategoryText(), "Womens Shoes",
				"Wrong text message!");

		pages.getWomenShoesTab().placeOrder("Chappals & Shoe Ladies Metallic");

		list.add("Chappals & Shoe Ladies Metallic");

		pages.getWomenShoesTab().clickOnCartButton();
		BrowserUtils.wait(1);

		softAssert.assertEquals(list, pages.getWomenShoesTab().getProductsNamesOnCart(),
				"The product that is on the cart is not selected product!");

		// Checkout Page Test

		pages.getTargetMarketHomePage().clickGoToCheckoutButton();
		pages.getTargetMarketCheckoutPage()
			.placeOrderProcess("John", "Sanchez", "Main Strett 15D 07560", "4938281746192845", "5457894231");

		String expectedMessage = "Thanks!";
		String actualMessage = pages.getTargetMarketCheckoutPage().getThanksMessage();

		softAssert.assertEquals(expectedMessage, actualMessage);

		pages.getTargetMarketCheckoutPage().clickOnCloseButtonOfThanksMessage();

		// Logout Page Text

		pages.getTargetMarketHomePage().clickToLogoutButton();

		String text = pages.getTargetMarketLoginPage().getLoginText();
		softAssert.assertEquals(text, "Login", "You couldn't logout!");

		softAssert.assertAll();

	}

}

/**
 * 1-Go to https://test.inar-academy.com/target-market.
 * 2-Enter all username in the username box.
 * 3-Enter a valid password :secret_password in the password box.
 * 4-Click on the "Login" button.
 */

package login_page_tests;

import base_test.Hooks;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class LoginProcessTest extends Hooks {

	@Test(dataProvider = "users")
	public void testLoginProcess(String username, String welcomeText) {
		// 1-Go to https://test.inar-academy.com/target-market.
		pages.getHomePage().clickOnTargetMarketLink();

		// Enter valid usernames (standard_user, problem_user, performance_glitch_user)
		// and valid password "secret_password"
		pages.getTargetMarketLoginPage().login(username, "secret_password");

		// Verify that login process is completed properly
		Assert.assertEquals(welcomeText, pages.getTargetMarketHomePage().getWelcomeText(), "Wrong Message!");

	}

	@DataProvider(name = "users")
	public Object[][] users() {
		return new Object[][] { { "standard_user", "Welcome to the Target Market, standard_user!" },
				{ "problem_user", "Welcome to the Target Market, problem_user!" },
				{ "performance_glitch_user", "Welcome to the Target Market, performance_glitch_user!" } };
	}

}

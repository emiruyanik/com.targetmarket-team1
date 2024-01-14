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
	public void testLoginProcessWithValidCredentials(String username, String welcomeText) {
		// 1-Go to https://test.inar-academy.com/target-market.
		pages.getHomePage().clickOnTargetMarketLink();

		// Enter valid usernames (standard_user, problem_user, performance_glitch_user)
		// and valid password "secret_password"
		pages.getTargetMarketLoginPage().login(username, "secret_password");

		// Verify that login process is completed properly
		Assert.assertEquals(welcomeText, pages.getTargetMarketHomePage().getWelcomeText(), "Wrong Message!");

	}

	@Test
	public void testLoginProcessWithLockedUsername() {
		// 1-Go to https://test.inar-academy.com/target-market.
		pages.getHomePage().clickOnTargetMarketLink();

		// Enter LockedUsername
		pages.getTargetMarketLoginPage().login("locked_out_user", "secret_password");

		// Verify that 'Your account is locked.' error message is displayed
		String expectedMessage = "Your account is locked.";
		String actualMessage = pages.getTargetMarketLoginPage().getLockedUserErrorMessage();
		Assert.assertEquals(expectedMessage, actualMessage, "Wrong Error message!");
	}

	@Test(dataProvider = "invalidCredentials")
	public void testLoginProcessWithInvalidCredentials(String userName, String password, String userNameErrorMessage,
			String passwordErrorMessage) {

		// 1-Go to https://test.inar-academy.com/target-market.
		pages.getHomePage().clickOnTargetMarketLink();

		// 2-Login with invalid credentials
		pages.getTargetMarketLoginPage().login(userName, password);

		// 3-Verify that invalid username and invalid password error messages are
		// displayed
		softAssert.assertEquals(userNameErrorMessage, pages.getTargetMarketLoginPage().getInvalidUsernameErrorMessage(),
				"Wrong message!");
		softAssert.assertEquals(passwordErrorMessage, pages.getTargetMarketLoginPage().getInvalidPasswordErrorMessage(),
				"Wrong message!");

		softAssert.assertAll();
	}

	@DataProvider(name = "users")
	public Object[][] users() {
		return new Object[][] { { "standard_user", "Welcome to the Target Market, standard_user!" },
				{ "problem_user", "Welcome to the Target Market, problem_user!" },
				{ "performance_glitch_user", "Welcome to the Target Market, performance_glitch_user!" } };
	}

	@DataProvider(name = "invalidCredentials")
	public Object[][] invalidCredentials() {
		return new Object[][] { { "standard_user", "wrong_password", "Invalid username", "Invalid password" },
				{ "wrong_username", "secret_password", "Invalid username", "Invalid password" },
				{ "wrong_username", "wrong_password", "Invalid username", "Invalid password" } };
	}

}

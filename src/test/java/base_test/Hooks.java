package base_test;

import org.testng.annotations.*;
import org.testng.annotations.Parameters;
import org.testng.asserts.SoftAssert;
import utils.DriverManager;
import utils.Pages;

public class Hooks {

	public Pages pages = new Pages();

	public SoftAssert softAssert = new SoftAssert();

	@Parameters("browser")
	@BeforeMethod
	public void setUpTestEnvironment(String browserType) {
		DriverManager.getWebDriver(browserType);
	}

	@AfterMethod
	public void tearDownTestEnvironment() {
		DriverManager.closeDriver();
	}

}

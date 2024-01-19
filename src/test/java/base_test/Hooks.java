package base_test;

import org.testng.annotations.*;
import org.testng.annotations.Parameters;
import org.testng.asserts.SoftAssert;
import utils.DriverManager;
import utils.Pages;

public class Hooks {

	protected Pages pages;

	public SoftAssert softAssert = new SoftAssert();


	@Parameters("browser")
	@BeforeClass
	public void setUpTestEnvironment(String browserType) {
		DriverManager.getWebDriver(browserType);
		pages = new Pages();
	}

	@AfterClass
	public void tearDownTestEnvironment() {
		DriverManager.closeDriver();
	}

}

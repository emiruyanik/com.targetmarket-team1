package base_test;

import org.testng.annotations.*;
import org.testng.annotations.Parameters;
import org.testng.asserts.SoftAssert;
import utils.DriverManager;
import utils.Pages;

public class Hooks {

	public Pages pages = new Pages();

	public SoftAssert softAssert = new SoftAssert();

//	@Parameters("browser")
	@BeforeClass
	public void setUpTestEnvironment() {
		DriverManager.getWebDriver();
	}

	@AfterClass
	public void tearDownTestEnvironment() {
		DriverManager.closeDriver();
	}

}

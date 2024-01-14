package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.DriverManager;

import java.time.Duration;

public abstract class BasePage {

	protected WebDriver driver = DriverManager.getWebDriver();

	public Actions actions = new Actions(driver);

	protected WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

	public BasePage() {
		PageFactory.initElements(driver, this);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}

}

package utils;

import pages.HomePage;
import pages.TargetMarketHomePage;
import pages.TargetMarketLoginPage;

public class Pages {

	public HomePage getHomePage() {
		return new HomePage();
	}

	public TargetMarketLoginPage getTargetMarketLoginPage() {
		return new TargetMarketLoginPage();
	}

	public TargetMarketHomePage getTargetMarketHomePage() {
		return new TargetMarketHomePage();
	}

}

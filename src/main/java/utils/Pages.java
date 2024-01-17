package utils;

import pages.HomePage;
import pages.TargetMarketHomePage;
import pages.TargetMarketLoginPage;
import pages.target_market_homepage_tabs.FurnitureTab;
import pages.target_market_homepage_tabs.HomeDecorationTab;
import pages.target_market_homepage_tabs.SkincareTab;
import pages.target_market_homepage_tabs.SmartphoneTab;

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

    public SmartphoneTab getSmartphoneTab() {
        return new SmartphoneTab();
    }

    public HomeDecorationTab getHomeDecorationTab(){
        return new HomeDecorationTab();
    }

    public FurnitureTab getFurnitureTab(){return new FurnitureTab();}
    public SkincareTab getSkincareTab(){return new SkincareTab();}

}

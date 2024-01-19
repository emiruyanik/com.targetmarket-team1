package utils;

import pages.HomePage;
import pages.TargetMarketCheckoutPage;
import pages.TargetMarketHomePage;
import pages.TargetMarketLoginPage;
import pages.target_market_homepage_tabs.*;

public class Pages {

	private HomePage homePage;

	private TargetMarketLoginPage targetMarketLoginPage;

	private TargetMarketHomePage targetMarketHomePage;

	private AllTab allTab;

	private SmartphoneTab smartphoneTab;

	private HomeDecorationTab homeDecorationTab;

	private FurnitureTab furnitureTab;

	private SkincareTab skincareTab;

	private GroceriesTab groceriesTab;

	private WomenDressesTab womenDressesTab;

	private WomenShoesTab womenShoesTab;

	private TargetMarketCheckoutPage targetMarketCheckoutPage;

	private LaptopsTab laptopsTab;

	private TopsTab topsTab;

	public Pages() {
		this.homePage = new HomePage();
		this.targetMarketHomePage = new TargetMarketHomePage();
		this.targetMarketLoginPage = new TargetMarketLoginPage();
		this.allTab = new AllTab();
		this.smartphoneTab = new SmartphoneTab();
		this.homeDecorationTab = new HomeDecorationTab();
		this.furnitureTab = new FurnitureTab();
		this.skincareTab = new SkincareTab();
		this.groceriesTab = new GroceriesTab();
		this.womenDressesTab = new WomenDressesTab();
		this.womenShoesTab = new WomenShoesTab();
		this.targetMarketCheckoutPage = new TargetMarketCheckoutPage();
		this.laptopsTab = new LaptopsTab();
		this.topsTab = new TopsTab();
	}

	public HomePage getHomePage() {
		return homePage;
	}

	public TargetMarketLoginPage getTargetMarketLoginPage() {
		return targetMarketLoginPage;
	}

	public TargetMarketHomePage getTargetMarketHomePage() {
		return targetMarketHomePage;
	}

	public AllTab getAllTab() {
		return allTab;
	}

	public SmartphoneTab getSmartphoneTab() {
		return smartphoneTab;
	}

	public HomeDecorationTab getHomeDecorationTab() {
		return homeDecorationTab;
	}

	public FurnitureTab getFurnitureTab() {
		return furnitureTab;
	}

	public SkincareTab getSkincareTab() {
		return skincareTab;
	}

	public GroceriesTab getGroceriesTab() {
		return groceriesTab;
	}

	public WomenDressesTab getWomenDressesTab() {
		return womenDressesTab;
	}

	public WomenShoesTab getWomenShoesTab() {
		return womenShoesTab;
	}

	public TargetMarketCheckoutPage getTargetMarketCheckoutPage() {
		return targetMarketCheckoutPage;
	}

	public LaptopsTab getLaptopsTab() {
		return laptopsTab;
	}

	public TopsTab getTopsTab() {
		return topsTab;
	}

}

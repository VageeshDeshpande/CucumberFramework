/**
 *
 *@author Vageesh Deshpande
 *
 *@version 
 */
package stepDefinations;

import io.cucumber.java.en.*;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import PageObjects.LandingPage;
import PageObjects.OffersPage;
import PageObjects.PageObjectManager;
import Utils.TestContextSetup;

/**
 * @author Vageesh Deshpande created on 27-Sept-2024
 */
public class OfferPageStepDefination {
	public WebDriver driver;
	public String homePageProductName;
	public String offerPageProductName;
	public OffersPage offersPage;
	TestContextSetup tcs;
	PageObjectManager pom;

	public OfferPageStepDefination(TestContextSetup tcs) {
		this.tcs = tcs;
		this.offersPage = tcs.pom.getOffersPage();

	}

	@Then("^User search for (.+) in offer page$")
	public void user_search_for_in_offer_page_to_check_if_product_exist_with_same_name(String shortName)
			throws InterruptedException {

		switchToOffersPage();

		offersPage.searchItem(shortName);
		System.out.println("User searched for " + shortName);
		// tcs.driver.findElement(By.xpath("//input[@id='search-field']")).sendKeys(shortName);
		offerPageProductName = offersPage.getProductName();
		Thread.sleep(2000);
		offerPageProductName = offersPage.getProductName();
	}

	public void switchToOffersPage() {
		// if(tcs.driver.getCurrentUrl().equals)

		LandingPage landingPage = tcs.pom.getLandingPage();
		landingPage.selectTopDeals();
		tcs.gu.SwitchWindowToChild();
		System.out.println("Switched to Child Window");

	}

	@Then("Validate product name in offers page matches with Landing page")
	public void Validate_product_name_in_offers_page_matches_with_Landing_page() {
		Assert.assertEquals(offerPageProductName, tcs.homePageProductName);

	}

}

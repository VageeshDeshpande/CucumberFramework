/**
 *
 *@author Vageesh Deshpande
 *
 *@version 
 */
package stepDefinations;

import io.cucumber.java.en.*;

import org.checkerframework.common.value.qual.IntVal;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import PageObjects.LandingPage;
import Utils.TestContextSetup;

/**
 * @author Vageesh Deshpande created on 27-Sept-2024
 */
public class LandingPageStepDefination {
	public WebDriver driver;
	public String homePageProductName;
	public String offerPageProductName;
	public LandingPage landingPage;
	public TestContextSetup tcs;

	public LandingPageStepDefination(TestContextSetup tcs) {
		this.tcs = tcs;
		this.landingPage = tcs.pom.getLandingPage();

	}

	@Given("User is on GreenCart landing page")
	public void User_is_on_GreenCart_landing_page() {

		Assert.assertTrue(landingPage.getTitleLandingPage().contains("GreenKart"));

		System.out.println("User is on Landing Page");
	}

	@When("^User searched with shortname (.+) and extracted actual name of the product$")
	public void User_searched_with_shortname_and_extracted_actual_name_of_the_product(String shortName) {

		landingPage.searchItem(shortName);
		System.out.println("User Searched for " + shortName);
		// tcs.driver.findElement(By.xpath("//*[@type =
		// 'search']")).sendKeys(shortName);
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		tcs.homePageProductName = landingPage.getProductName().split("-")[0].trim();
		System.out.println(tcs.homePageProductName + " is extracted from the home page");
	}

	@When("Add {string} items of the selected product to cart")
	public void add_items_to_cart(String quantity) {
		int intValue = 0;
		try {
			intValue = Integer.parseInt(quantity);
			System.out.println("Converted integer: " + quantity);
		} catch (NumberFormatException e) {
			System.out.println("Error: Unable to convert to an integer. The string might not contain a valid number.");
		}

		landingPage.pressIncrementBtn(intValue);
		landingPage.addToCart();
		landingPage.ChectoutItems();
		// Thread.sleep(2000);

	}

}

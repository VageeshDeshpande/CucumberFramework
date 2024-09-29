/**
 *
 *@author Vageesh Deshpande
 *
 *@version 
 */
package stepDefinations;

import io.cucumber.java.en.*;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import PageObjects.CheckoutPage;
import PageObjects.LandingPage;
import Utils.TestContextSetup;

/**
 * @author Vageesh Deshpande created on 27-Sept-2024
 */
public class CheckoutPageStepDefination {
	public WebDriver driver;
	public String homePageProductName;
	public String offerPageProductName;
	public String checkoutPageProductName;
	public CheckoutPage checkoutPage;
	public TestContextSetup tcs;

	public CheckoutPageStepDefination(TestContextSetup tcs) {
		this.tcs = tcs;
		this.checkoutPage = tcs.pom.getCheckoutPage();

	}

	@Then("verify user has ability to enter promocode and place the order")
	public void verify_user_has_ability_to_enter_promocode_and_place_the_order() {

		Assert.assertTrue(checkoutPage.VerifyPromoBtn(), "Apply button is not present");
		System.out.println("Apply button is present");

		Assert.assertTrue(checkoutPage.VerifyPlaceOrderBtn(), "Place Order button is not present");
		System.out.println("Place Order button is present");
	}

	@Then("^User proceeds to checkout and validate the (.+) items in checkout page$")
	public void User_proceeds_to_checkout_and_validate_the_items(String name) {

		checkoutPageProductName = checkoutPage.getProductName().split("-")[0].trim();
		System.out.println(checkoutPageProductName);

		Assert.assertEquals(checkoutPageProductName, tcs.homePageProductName);
	}
}

/**
 *
 *@author Vageesh Deshpande
 *
 *@version 
 */
package PageObjects;

import org.openqa.selenium.WebDriver;

/**
 * @author Vageesh Deshpande created on 28-Sept-2024
 */
public class PageObjectManager {

	public LandingPage landingPage;
	public OffersPage offersPage;
	public CheckoutPage checkoutPage;
	public WebDriver driver;

	public PageObjectManager(WebDriver driver) {
		this.driver = driver;
	}

	public LandingPage getLandingPage() {
		landingPage = new LandingPage(driver);
		return landingPage;
	}

	public OffersPage getOffersPage() {
		offersPage = new OffersPage(driver);
		return offersPage;
	}

	public CheckoutPage getCheckoutPage() {
		return checkoutPage = new CheckoutPage(driver);
	}

}

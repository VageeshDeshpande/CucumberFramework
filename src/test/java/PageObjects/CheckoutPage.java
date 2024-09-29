/**
 *
 *@author Vageesh Deshpande
 *
 *@version 
 */
package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 * @author Vageesh Deshpande created on 28-Sept-2024
 */
public class CheckoutPage {

	public WebDriver driver;

	public CheckoutPage(WebDriver driver) {
		this.driver = driver;
	}

	By promoBtn = By.xpath("//button[@class = 'promoBtn']");
	By placeOrder = By.xpath("//*[contains(text(),'Place Order')]");
	By cartPageProductName = By.xpath("(//p[@class = 'product-name'])[1]");

	public boolean VerifyPromoBtn() {
		return driver.findElement(promoBtn).isDisplayed();
	}

	public boolean VerifyPlaceOrderBtn() {
		return driver.findElement(placeOrder).isDisplayed();
	}

	public String getProductName() {
		return driver.findElement(cartPageProductName).getText();
	}
}

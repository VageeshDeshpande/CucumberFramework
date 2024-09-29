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
public class LandingPage {

	public WebDriver driver;

	public LandingPage(WebDriver driver) {
		this.driver = driver;
	}

	By search = By.xpath("//*[@type = 'search']");
	By productName = By.cssSelector("h4.product-name");
	By topDeals = By.xpath("//*[@href='#/offers']");
	By cart = By.xpath("//img[@alt='Cart']");
	By checkoutBtn = By.xpath("//button[contains(text(),'PROCEED TO CHECKOUT')]");
	By incrementBtn = By.xpath("//a[@class = 'increment']");
	By addToCartBtn = By.xpath("//*[contains(text(),'ADD TO CART')]");

	public void searchItem(String name) {
		driver.findElement(search).sendKeys(name);

	}

	public String getProductName() {
		return driver.findElement(productName).getText();
	}

	public void selectTopDeals() {
		driver.findElement(topDeals).click();
	}

	public void ChectoutItems() {
		driver.findElement(cart).click();
		driver.findElement(checkoutBtn).click();
	}

	public String getTitleLandingPage() {
		return driver.getTitle().toString();

	}

	public void pressIncrementBtn(int n) {
		for (int i = 1; i < n; i++) {
			driver.findElement(incrementBtn).click();
		}
	}

	public void addToCart() {
		driver.findElement(addToCartBtn).click();
	}
}

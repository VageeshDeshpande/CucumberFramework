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
public class OffersPage {

	public WebDriver driver;

	public OffersPage(WebDriver driver) {
		this.driver = driver;
	}

	private By offerPageProductName = By.cssSelector("tr td:nth-child(1)");
	private By search = By.xpath("//*[@type = 'search']");

	public void searchItem(String name) {
		driver.findElement(search).sendKeys(name);

	}

	public String getProductName() {
		return driver.findElement(offerPageProductName).getText();
	}
}

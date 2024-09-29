/**
 *
 *@author Vageesh Deshpande
 *
 *@version 
 */
package Utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

/**
 * @author Vageesh Deshpande created on 28-Sept-2024
 */
public class TestBase {

	public WebDriver driver;

	public WebDriver WebDriverManager() throws IOException {

		FileInputStream fis = new FileInputStream(
				System.getProperty("user.dir") + "\\src\\test\\resources\\global.properties");
		Properties prop = new Properties();
		prop.load(fis);
		String url = prop.getProperty("qaurl");
		String browser_properties = prop.getProperty("browser");
		String browser_maven = System.getProperty("browser");
		// result = testcondition ? value1: value2

		String browser = browser_maven != null ? browser_maven : browser_properties;

		if (driver == null) {

			if (browser.equalsIgnoreCase("Chrome")) {

				driver = new ChromeDriver();
			} else if (browser.equalsIgnoreCase("Edge")) {
				driver = new EdgeDriver();
			}
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
			driver.get(url);
		}
		return driver;
	}
}

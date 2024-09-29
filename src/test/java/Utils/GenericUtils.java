/**
 *
 *@author Vageesh Deshpande
 *
 *@version 
 */
package Utils;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.WebDriver;

/**
 * @author Vageesh Deshpande created on 28-Sept-2024
 */
public class GenericUtils {

	WebDriver driver;

	public GenericUtils(WebDriver driver) {
		this.driver = driver;

	}

	public void SwitchWindowToChild() {
		Set<String> s1 = driver.getWindowHandles();
		Iterator<String> i1 = s1.iterator();
		String parentWindow = i1.next();
		String childWindow = i1.next();
		driver.switchTo().window(childWindow);
	}

	public void QuitDriver() {
		driver.quit();
	}

	public static String TimeStamp() {
		Date date = new Date();
		SimpleDateFormat dateFormat = new SimpleDateFormat("ddMMyyyy_HHmmss");
		String timestamp = dateFormat.format(date);
		return timestamp;

	}

}

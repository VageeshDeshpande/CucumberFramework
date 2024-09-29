/**
 *
 *@author Vageesh Deshpande
 *
 *@version 
 */
package stepDefinations;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import Utils.GenericUtils;
import Utils.TestContextSetup;
import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Scenario;

/**
 * @author Vageesh Deshpande created on 28-Sept-2024
 */
public class Hooks {
	TestContextSetup tcs;

	public Hooks(TestContextSetup tcs) {
		this.tcs = tcs;

	}

	@After
	public void AfterScenario() throws Exception {

		System.out.println("*******************************");

		Thread.sleep(2000);
		tcs.testBase.WebDriverManager().quit();

	}

	@AfterStep
	public void addScreenshot(Scenario scenario) throws IOException {
		WebDriver driver = tcs.testBase.WebDriverManager();
		if (scenario.isFailed()) {
			File sourcePath = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
			byte[] fileContent = FileUtils.readFileToByteArray(sourcePath);
			scenario.attach(fileContent, "image/png", GenericUtils.TimeStamp());
		}
	}

}

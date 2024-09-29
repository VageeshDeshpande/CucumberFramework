/**
 *
 *@author Vageesh Deshpande
 *
 *@version 
 */
package cucumberOptions;

import org.testng.annotations.DataProvider;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

/**
 * @author Vageesh Deshpande created on 28-Sept-2024
 */

@CucumberOptions(features = "@target/failed_scenarios.txt",

		glue = "stepDefinations",

		monochrome = true,

		plugin = { "html:target/cucumber.html", "json:target/cucumber.json",
				"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:" })
public class FailedTestRunner extends AbstractTestNGCucumberTests {

	@Override
	@DataProvider(parallel = true)
	public Object[][] scenarios() {
		return super.scenarios();
	}

}

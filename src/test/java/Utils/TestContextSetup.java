package Utils;

import java.io.IOException;

import org.openqa.selenium.WebDriver;

import PageObjects.PageObjectManager;

public class TestContextSetup {
	public WebDriver driver;
	public String homePageProductName;
	public PageObjectManager pom;
	public TestBase testBase;
	public GenericUtils gu;

	public TestContextSetup() throws IOException {

		testBase = new TestBase();
		pom = new PageObjectManager(testBase.WebDriverManager());
		gu = new GenericUtils(testBase.WebDriverManager());

	}
}

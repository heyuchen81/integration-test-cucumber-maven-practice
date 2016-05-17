package com.ingenta.cubmvnprac;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class GoogleSteps {
	private WebDriver driver;

//	@Before
//	public void openBrowser() {
//		// Create a new instance of the Firefox driver
//		driver = new FirefoxDriver();
//	}

	@Given("^Google UK url : \"(.*?)\"$")
	public void google_UK_url(String url) throws Throwable {
		driver.get(url); 
		Thread.sleep(3000);
	}

	@When("^Google UK is running$")
	public void google_UK_is_running() throws Throwable {
		driver.findElement(By.name("q"));
	}

	@When("^Input keywords in Google UK$")
	public void input_keywords_in_Google_UK() throws Throwable {
		// Find the text input element by its name
		WebElement element = driver.findElement(By.name("q"));

		// Enter something to search for
		element.sendKeys("Honey");

		// Now submit the form. WebDriver will find the form for us from the
		// element
		element.submit();
	}

	@Then("^Google UK finds search results$")
	public void google_UK_finds_search_results() throws Throwable {
		Thread.sleep(5000);
		Assert.assertEquals("Honey - Google Search", driver.getTitle());
	}

//	@After
//	public void releaseBrowser() {
//		if (driver != null)
//			driver.quit();
//	}
}

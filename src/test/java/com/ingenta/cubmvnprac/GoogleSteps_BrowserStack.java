package com.ingenta.cubmvnprac;

import java.net.URL;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class GoogleSteps_BrowserStack {
	
	private WebDriver driver;
	
	@Given("^BrowserStack account is running$")
	public void browserstack_account_is_running() throws Throwable {
//		String exePath = "C:\\Software and Frameworks\\Java\\Selenium\\WebDriver Java client\\drivers\\chromedriver.exe";
//		System.setProperty("webdriver.chrome.driver", exePath);
//		driver = new ChromeDriver();
		
		String USERNAME = System.getenv("USERNAME");
		String AUTOMATE_KEY = System.getenv("AUTOMATE_KEY");
        String URL = "https://" + USERNAME + ":" + AUTOMATE_KEY + "@hub.browserstack.com/wd/hub";
      
		DesiredCapabilities caps = new DesiredCapabilities();
	    caps.setCapability("browserstack.debug", "true");
	    
	    caps.setCapability("browser", "Opera");
	    caps.setCapability("browser_version", "12.15");
	    caps.setCapability("os", "Windows");
	    caps.setCapability("os_version", "8.1");
	    caps.setCapability("resolution", "1366x768");

	    driver = new RemoteWebDriver(new URL(URL), caps);
	}

	@Given("^Google UK url in BrowserStack : \"(.*?)\"$")
	public void google_UK_url_in_BrowserStack(String url) throws Throwable {
		driver.get(url); 
		Thread.sleep(3000);
	}

	@When("^Google UK is running in BrowserStack$")
	public void google_UK_is_running_in_BrowserStack() throws Throwable {
		driver.findElement(By.name("q"));
	}

	@When("^Input keywords in Google UK in BrowserStack$")
	public void input_keywords_in_Google_UK_in_BrowserStack() throws Throwable {
		// Find the text input element by its name
		WebElement element = driver.findElement(By.name("q"));

		// Enter something to search for
		element.sendKeys("Replicon");

		// Now submit the form. WebDriver will find the form for us from the
		// element
		element.submit();
	}

	@Then("^Google UK finds search results in BrowserStack$")
	public void google_UK_finds_search_results_in_BrowserStack() throws Throwable {
		Thread.sleep(5000);
//		Assert.assertEquals("Ingenta - Google Search", driver.getTitle());
//		try {
		    Assert.assertTrue(driver.getTitle().contains("Replicongfds"));	    	
//	    }catch (Throwable ex) {
//	    	System.out.println("I have found an error!!!");
//	    	System.out.println("ERROR MESSAGE CAPTURED BY XIN HE is: " + ex.getMessage());
//		    Thread.sleep(1000);
//	    	Assert.fail("Oh my god! It's wrong!");
//	    }
	    Thread.sleep(1000);		
	}

	@After
	public void browserstack_account_is_closing() throws Throwable {
		if (driver != null)
			driver.quit();
	}
}

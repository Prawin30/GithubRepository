package stepDefinitions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;


public class ExpandTesting {
	WebDriver driver;

	@Given("I am on the search page {string}")
	public void i_am_on_the_search_page(String string) throws InterruptedException {
	    driver=new ChromeDriver();
	    driver.get(string);
	    Thread.sleep(2000);
	}
	@When("I search for {string}")
	public void i_search_for(String string) throws InterruptedException {
		driver.findElement(By.id("search-input")).sendKeys(string);
		//driver.findElement(By.id("search-button")).click();
		Thread.sleep(2000);
	    
	}
	@Then("I should see search results displayed")
	public void i_should_see_search_results_displayed() throws InterruptedException {
		String actual = driver.findElement(By.cssSelector("#examples > div > div > div > div.card-body > h3 > a")).getText();
		String expected = "File Upload";
		Thread.sleep(2000);
		driver.close();
		Assert.assertEquals(actual,expected);
	   
	}

}

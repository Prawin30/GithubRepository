package stepDefinitions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
//task1,6,12
public class Heroku {
	WebDriver driver;
	
	@Given("I am on the login page {string}")
	public void i_am_on_the_login_page(String string) throws InterruptedException {
		driver = new ChromeDriver();
		driver.get("https://the-internet.herokuapp.com/login");
		Thread.sleep(2000);
	   
	}
	@When("I enter username {string} and password {string}")
	public void i_enter_username_and_password(String username, String password) throws InterruptedException {
		driver.findElement(By.id("username")).sendKeys(username);
		driver.findElement(By.id("password")).sendKeys(password);
		Thread.sleep(1000);
	    
	}
	@When("I click the login button")
	public void i_click_the_login_button() throws InterruptedException {
		driver.findElement(By.className("radius")).click();
		Thread.sleep(2000);
	    
	}
	@Then("I should see a success message {string}")
	public void i_should_see_a_success_message(String successmsg) {
		String actualText = driver.findElement(By.id("flash")).getText();
		//System.out.println(actualText);
		driver.close();
		Assert.assertTrue(actualText.contains(successmsg),"login failed");
	   
	}
	
	@Given("I am on the password reset page {string}")
	public void i_am_on_the_password_reset_page(String string) {
		driver= new ChromeDriver();
		driver.navigate().to(string);
		
	    
	}
	@When("I enter my email and request a reset")
	public void i_enter_my_email_and_request_a_reset() throws InterruptedException {
		driver.findElement(By.id("email")).sendKeys("prawin0208@gmail.com");
		Thread.sleep(2000);
		driver.findElement(By.className("radius")).click();
	   
	}
	@Then("I should see a confirmation message")
	public void i_should_see_a_confirmation_message() throws InterruptedException {
		String actualText = driver.findElement(By.tagName("h1")).getText();
		String expectedText = "Password reset mail sent to ur email";
		Thread.sleep(2000);
		driver.close();
		Assert.assertEquals(actualText, expectedText,"Password Retrification failed!");
	    
	}
	
	@Given("I am on the Terms and Conditions page {string}")
	public void i_am_on_the_terms_and_conditions_page(String string) throws InterruptedException {
		driver = new ChromeDriver();
		driver.navigate().to("https://the-internet.herokuapp.com/terms");
		Thread.sleep(2000);
	   
	}
	@Then("I should see the Terms and Conditions")
	public void i_should_see_the_terms_and_conditions() {
		String expected = "The terms and conditions are ";
		String actual = driver.findElement(By.tagName("h1")).getText();
		driver.quit();
		Assert.assertTrue(actual.contains(expected),"Viewing Terms and Condtions Failed");
	    
	}

}

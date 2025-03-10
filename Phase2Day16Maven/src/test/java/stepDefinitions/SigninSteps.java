package stepDefinitions;

import java.util.NoSuchElementException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class SigninSteps {
	WebDriver driver;
	boolean loginDisp;
	
	@Given("I am in the login page {string}")
	public void user_is_in_login_page(String url) {
	driver = new ChromeDriver();
	driver.get(url);
	}
	
	@When("User enter {string} and {string}")
	public void user_enter_UserName_and_Password(String username,String password) {
	driver.findElement(By.id("username")).sendKeys(username);
	driver.findElement(By.id("password")).sendKeys(password);
	}
	
	@And("I click on the login button")
	public void user_clicks_login_button()throws InterruptedException{
		Thread.sleep(2000);
		driver.findElement(By.id("login")).click();
		Thread.sleep(3000);
	}
	
	@Then("Login Successful")
	public void message_displayed_Login_Successfully() throws InterruptedException {
		try {
            WebElement loginButton = driver.findElement(By.id("login"));
            if (loginButton.isDisplayed()) {
                loginDisp = true;  // Set before clicking
                loginButton.click();
                Thread.sleep(3000);
            }
        } catch (NoSuchElementException e) {
            loginDisp = false;  // If button is missing, login fails
            System.out.println("❌ Login button is NOT found.");
        }
		Assert.assertTrue(loginDisp,"Login failed");
		System.out.println("login successful");
		driver.quit();
	}

}

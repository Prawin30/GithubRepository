package stepDefinitions;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.And;



public class DemoBlaze {
	WebDriver driver;
	
	@Given("I am on the registration page {string}")
	public void i_am_on_the_registration_page(String string) throws InterruptedException {
		driver = new ChromeDriver();
		driver.get(string);
		Thread.sleep(2000);
	    
	}
	@When("I enter valid registration details")
	public void i_enter_valid_registration_details() throws InterruptedException {
//		
////		also by explicitwait
////		 WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
////		 WebElement signupButton = wait.until(ExpectedConditions.elementToBeClickable(By.id("signin2")));
////		 signupButton.click();
////
////		 WebElement usernameField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("sign-username")));
////		 usernameField.sendKeys("prawin02");
////
////		 WebElement passwordField = driver.findElement(By.id("sign-password"));
////		 passwordField.sendKeys("prawin03");
		driver.findElement(By.id("signin2")).click();
		Thread.sleep(1000);
		driver.findElement(By.id("sign-username")).sendKeys("prawinsuperman");
		driver.findElement(By.id("sign-password")).sendKeys("spiderman!123");
	    
	}
	@And("I submit the registration form")
	public void i_submit_the_registration_form() throws InterruptedException {
		Thread.sleep(2000);
		driver.findElement(By.cssSelector("#signInModal > div > div > div.modal-footer > button.btn.btn-primary")).click();

	    
	}
	@Then("I should see a successful registration message")
	public void i_should_see_a_successful_registration_message() throws InterruptedException {
		Thread.sleep(4000);
		Alert at = driver.switchTo().alert();
		String actualMsg = at.getText();
		Thread.sleep(2000);
		at.accept();
		String expectedMsg = "Sign up successful.";
		Thread.sleep(2000);
		driver.close();
		Assert.assertEquals(actualMsg,expectedMsg,"signup failed");
	   
	}
	
	
	@Given("I am on the wishlist page {string}")
	public void i_am_on_the_wishlist_page(String string) throws InterruptedException {
		driver = new ChromeDriver();
		driver.get(string);
		Thread.sleep(2000);
	}
	@When("I add a product to my wishlist")
	public void i_add_a_product_to_my_wishlist() throws InterruptedException {
	   driver.findElement(By.id("login2")).click();
	   Thread.sleep(2000);
	   driver.findElement(By.id("loginusername")).sendKeys("prawinsuperman");
	   driver.findElement(By.id("loginpassword")).sendKeys("spiderman!123");
	   driver.findElement(By.cssSelector("#logInModal > div > div > div.modal-footer > button.btn.btn-primary")).click();
	   Thread.sleep(2000);
	   driver.findElement(By.cssSelector("#tbodyid > div:nth-child(1) > div > div > h4 > a")).click();
	   Thread.sleep(3000);
	   driver.findElement(By.className("btn-lg")).click();
	   Thread.sleep(2000);
	}
	@Then("Product should be added successfully")
	public void the_product_should_be_added_successfully() throws InterruptedException {
		Alert pr = driver.switchTo().alert();
		String actualMsg = pr.getText();
		Thread.sleep(2000);
		pr.accept();
		String expectedMsg = "Product added.";
		Thread.sleep(3000);
		driver.close();
		Assert.assertEquals(actualMsg, expectedMsg,"product is not added to the cart");
		
	}


}

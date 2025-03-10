package stepDefinitions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class SauceDemo {
	WebDriver driver;
	@Given("I am on the product page {string}")
	public void i_am_on_the_product_page(String string) throws InterruptedException {
	   driver= new ChromeDriver();
	   driver.get(string);
	   Thread.sleep(2000);
	   driver.findElement(By.id("user-name")).sendKeys("standard_user");
	   driver.findElement(By.id("password")).sendKeys("secret_sauce");
	   driver.findElement(By.id("login-button")).click();
	   Thread.sleep(2000);
	}
	@When("I add a product to the cart")
	public void i_add_a_product_to_the_cart() throws InterruptedException {
		driver.findElement(By.id("add-to-cart-sauce-labs-bike-light")).click();
		Thread.sleep(2000);
	   
	}
	@Then("the product should be added successfully")
	public void the_product_should_be_added_successfully() throws InterruptedException {
		String actual = driver.findElement(By.id("remove-sauce-labs-bike-light")).getText();
		String expected = "Remove";
		Thread.sleep(2000);
		driver.close();
		Assert.assertEquals(actual,expected,"itam not addes in the cart");
	}
	
	@Given("I am on the checkout page {string}")
	public void i_am_on_the_checkout_page(String string) throws InterruptedException {
		driver= new ChromeDriver();
		driver.get(string);
		Thread.sleep(2000);
		driver.findElement(By.id("user-name")).sendKeys("standard_user");
		driver.findElement(By.id("password")).sendKeys("secret_sauce");
		driver.findElement(By.id("login-button")).click();
		driver.findElement(By.id("add-to-cart-sauce-labs-bike-light")).click();
		driver.findElement(By.className("shopping_cart_link")).click();
		driver.findElement(By.id("checkout")).click();
		Thread.sleep(2000);
	}
	@When("I enter checkout details and proceed")
	public void i_enter_checkout_details_and_proceed() throws InterruptedException {
		
		driver.findElement(By.id("first-name")).sendKeys("Praveen");
		driver.findElement(By.id("last-name")).sendKeys("K");
		driver.findElement(By.id("postal-code")).sendKeys("609313");
		driver.findElement(By.id("continue")).click();
	 	driver.findElement(By.id("finish")).click();
		Thread.sleep(3000);
   
	}
	@Then("I should see the order confirmation message")
	public void i_should_see_the_order_confirmation_message() throws InterruptedException {
	  String actualText =  driver.findElement(By.className("complete-header")).getText();
	  String expectedText = "Thank you for your order!";
	  Thread.sleep(2000);
	  driver.close();
	  Assert.assertEquals(actualText, expectedText,"Placing order Failed");
	}
	
	@Given("I am on the product filter page {string}")
	public void i_am_on_the_product_filter_page(String string) throws InterruptedException {
		driver= new ChromeDriver();
		driver.get(string);
		Thread.sleep(2000);
		driver.findElement(By.id("user-name")).sendKeys("standard_user");
		driver.findElement(By.id("password")).sendKeys("secret_sauce");
		driver.findElement(By.id("login-button")).click();
		Thread.sleep(2000);
	}
	@When("I apply a specific filter")
	public void i_apply_a_specific_filter() throws InterruptedException {
		driver.findElement(By.className("product_sort_container")).click();
		Select se = new Select(driver.findElement(By.className("product_sort_container")));
		se.selectByIndex(2);
		Thread.sleep(2000);
		
	   
	}
	@Then("I should see the filtered products")
	public void i_should_see_the_filtered_products() throws InterruptedException {
		String actual = driver.findElement(By.cssSelector("#item_2_title_link > div")).getText();
		String Expected = "Sauce Labs Onesie";
		Thread.sleep(2000);
		driver.close();
		Assert.assertEquals(actual, Expected,"Applying filters and seeing the results failed");
	}
	
	@Given("I am on the e-commerce site {string}")
	public void i_am_on_the_e_commerce_site(String string) throws InterruptedException {
		driver= new ChromeDriver();
		driver.get(string);
		Thread.sleep(2000);
		driver.findElement(By.id("user-name")).sendKeys("standard_user");
		driver.findElement(By.id("password")).sendKeys("secret_sauce");
		driver.findElement(By.id("login-button")).click();
		Thread.sleep(2000);
	}
	@When("I search for a product and view details")
	public void i_search_for_a_product_and_view_details() throws InterruptedException {
		driver.findElement(By.cssSelector("#item_4_title_link > div")).click();
		Thread.sleep(2000);

	}
	@When("I add the product to the cart and proceed to checkout")
	public void i_add_the_product_to_the_cart_and_proceed_to_checkout() throws InterruptedException {
		driver.findElement(By.id("add-to-cart")).click();
		driver.findElement(By.className("shopping_cart_link")).click();
		driver.findElement(By.id("checkout")).click();
		driver.findElement(By.id("first-name")).sendKeys("Praveen");
		driver.findElement(By.id("last-name")).sendKeys("K");
		driver.findElement(By.id("postal-code")).sendKeys("609313");
		driver.findElement(By.id("continue")).click();
		driver.findElement(By.id("finish")).click();
		Thread.sleep(2000);
	 
	}
	@Then("I should see the purchase confirmation message")
	public void i_should_see_the_purchase_confirmation_message() throws InterruptedException {
		 String actualText =  driver.findElement(By.className("complete-header")).getText();
		 String expectedText = "Thank you for your order!";
		 Thread.sleep(2000);
		 driver.findElement(By.id("back-to-products")).click();
		 Thread.sleep(2000);
		 driver.close();
		 Assert.assertEquals(actualText, expectedText,"Placing order Failed");
	    
	}

	
}

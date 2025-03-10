Feature: Scenarios for Saucedemo Website
@CartTest
  Scenario: User adds a product to the cart
    Given I am on the product page
    When I add a product to the cart
    Then the product should be added successfully
    
    
@CheckoutTest
  Scenario: User completes the checkout process
    Given I am on the checkout page
    When I enter checkout details and proceed
    Then I should see the order confirmation message
    
    
@FilterTest
  Scenario: User applies product filters
    Given I am on the product filter page
    When I apply a specific filter
    Then I should see the filtered products
    
 @PurchaseTest
  Scenario: User completes an e-commerce product purchase
    Given I am on the e-commerce site
    When I search for a product and view details
    And I add the product to the cart and proceed to checkout
    Then I should see the purchase confirmation message
 
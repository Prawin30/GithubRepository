Feature: Scenarios for DemoBlaze Website
 
@RegistrationTest
  Scenario: User registers with valid details
    Given I am on the registration page "https://www.demoblaze.com"
    When I enter valid registration details
    And I submit the registration form
    Then I should see a successful registration message
    
    
@WishlistTest
  Scenario: User adds product to wishlist
    Given I am on the wishlist page "https://www.demoblaze.com"
    When I add a product to my wishlist
    Then Product should be added successfully
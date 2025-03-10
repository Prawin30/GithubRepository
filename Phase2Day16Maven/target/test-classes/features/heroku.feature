Feature: Scenarios for Heroku Website


  Scenario: User logs in with valid credentials
    Given I am on the login page "https://the-internet.herokuapp.com/login"
    When I enter username "<username>" and password "<password>"
    And I click the login button
    Then I should see a success message "You logged into a secure area!"
    
    Examples:
    |username|password|
    |tomsmith|SuperSecretPassword!|
    |prawin|newpassword|
  
  Scenario: User resets password
    Given I am on the password reset page "https://the-internet.herokuapp.com/forgot_password"
    When I enter my email and request a reset
    Then I should see a confirmation message
  
 
  Scenario: User views Terms and Conditions
    Given I am on the Terms and Conditions page "https://the-internet.herokuapp.com/terms"
    Then I should see the Terms and Conditions

  
Feature: Signup functionality

 

  Scenario: Successful login with valid credentials

    Given I am in the login page "http://www.adactin.com/HotelApp/"

    When User enter "vengat16" and "Karthick"

    And I click on the login button

    Then Login Successful
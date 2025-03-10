Feature: Scenarios for ExpandTesting Website

 @SearchTest
  Scenario: User searches for a Testing Interface
    Given I am on the search page "https://practice.expandtesting.com/?form=MG0AV3"
    When I search for "File upload"
    Then I should see search results displayed

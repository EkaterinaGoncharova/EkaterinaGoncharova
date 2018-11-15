Feature: Home Page tests

  Scenario: Home Page Interface check
    Given I am on "Home Page"
    Then The browser title is Home Page
    When I login as user "Piter Chailovskii"
    Then "Piter Chailovskii" user icon is displayed on the header
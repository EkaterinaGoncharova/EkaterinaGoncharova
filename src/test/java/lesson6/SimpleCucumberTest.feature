Feature: Home Page tests

  Scenario: Home Page interface check
    Given I'm on Home Page
    Then Browser title is Home Page
    When I loin as user epam with password 1234
    Then The user icon is displayed on the header
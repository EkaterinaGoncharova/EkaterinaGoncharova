Feature: Service Page Interface tests

  Scenario: Different Elements Page check
    Given I am on "Home Page"
    Then The browser title is Home Page
    When I login as user "Piter Chailovskii"
    Then "Piter Chailovskii" user icon is displayed on the header
    And 4 pictures are displayed on the Home Page
    And 4 texts are displayed on the Home Page
    And headline and description are displayed on the Home Page
    When I click on "Service" button in Header
    Then Service menu in the header contains options:
      | Support            |
      | Dates              |
      | Complex Table      |
      | Simple Table       |
      | User Table         |
      | Table With Pages   |
      | Different Elements |
      | Performance        |
    When I click on Service subcategory in the left section
    Then Service menu in the left section contains options:
      | Support            |
      | Dates              |
      | Complex Table      |
      | Simple Table       |
      | User Table         |
      | Table With Pages   |
      | Different Elements |
      | Performance        |
    When I click on "Service" button in Header
    And I click on "Different Elements" button in Service dropdown
    Then Different Elements page is opened
    And 4 checkboxes are displayed on the Different Elements Page
    And 4 radios are displayed on the Different Elements Page
    And dropdown and buttons are displayed on the Different Elements Page
    And right section is displayed
    And left section is displayed
    When select checkboxes:
      | Water |
      | Wind  |
    Then log contains rows that checkboxes are set to true:
      | Water |
      | Wind  |
    When select Selen radio
    Then log contains row about Selen radio
    When select Yellow dropdown item
    Then log contains row about Yellow dropdown item
    When select checkboxes:
      | Water |
      | Wind  |
    Then log contains rows that checkboxes are set to false:
      | Water |
      | Wind  |

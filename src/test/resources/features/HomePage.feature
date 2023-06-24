Feature: validate home page

  Background: 
    Given open a browser
    When launch a site
    Then check home page display or not
     

  Scenario Outline: validate the home page search box enter valid product name
    When Enter a valid product "<name>" in search box
    Then click on search button
    And check the displayed product "<name>" your search product same or not

    Examples: 
      | name    |
      | nokia   |
      | samsung |
      | iphone  |

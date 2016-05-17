
Feature: Google Search Tests

  Scenario Outline: Check Google Search - Simple Keywords
    Given Google UK url : <url>
    When Google UK is running
    And Input keywords in Google UK
    Then Google UK finds search results

    Examples: 
      | url                         |
      | "https://www.google.co.uk/" |
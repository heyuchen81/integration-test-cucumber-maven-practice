@browser-stack
Feature: Google Search Tests

  Scenario Outline: Check Google Search - Simple Keywords
    Given BrowserStack account is running
    Given Google UK url in BrowserStack : <url>
    When Google UK is running in BrowserStack
    And Input keywords in Google UK in BrowserStack
    Then Google UK finds search results in BrowserStack
#    And BrowserStack account is closing

    Examples: 
      | url                         |
      | "https://www.google.co.uk/" |
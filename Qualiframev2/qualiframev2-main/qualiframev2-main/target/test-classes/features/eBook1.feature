@E2ETest
Feature: Functionality of E-Book

  @LoginTest
  Scenario Outline: Successful Login with Valid Credentials
    Given Launch Application using "<tc_id>"
    When I click on acceptAll button
    When User enters user credentials in the text field
    And I click on signIn button
    Examples:
      | tc_id    |
      | CWQA2405 |

  @ImageAndExternalLinksScrapingUtilityTest
  Scenario Outline: Verification Of Image and External Links
    Given Launch Application using "<tc_id>"
    When I click on acceptAll button
    When User enters user credentials in the text field
    And I click on signIn button
    And Image and External Links Scraping Utility
    Examples:
      | tc_id    |
      | CWQA2405 |
Feature: Login
  As a user, I want to be able to login to the application
  when I present valid credentials

  @Regression1
  Scenario Outline: Login with valid username and valid password
    Given Launch Application using "<tc_id>"
    Then verify home page displayed successfully
    When enter automation practice form details
    And submit the entered details

    Examples: 
      | tc_id                 |
      | SeleniumPracticeTest1 |
      | SeleniumPracticeTest2 |

  @WebCrawlerQF
  Scenario Outline: Automation Script Executor <name>
    Given run functional test script for "<name>" from "<file>"
    Examples: 
      | name                                                     | file       |
      | TestCase - 024 Equity, Diversity & Inclusion at Unilever | webcrawler |
      | TestCase - 01 Our company                                | webcrawler |

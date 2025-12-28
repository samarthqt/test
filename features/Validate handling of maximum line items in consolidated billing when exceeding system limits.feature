Feature: Validate handling of maximum line items in consolidated billing when exceeding system limits

  @TC-167
  Scenario Outline: Validate system behavior when the number of line items exceeds the defined system limits
    Given user is logged into the SAP S/4HANA Cloud system with access to the Finance module
    When user navigates to the Billing Due Program
    And user inputs Attribute 1 as "<Attribute1>" and Attribute 2 as "<Attribute2>"
    And user loads test data with "<LineItems>" line items
    And user attempts to execute the Billing Due Program
    Then the system should display an error message indicating that the line item limit has been exceeded
    And system logs should contain detailed information about the line item limit error
    And an error report should be generated accurately reflecting the line item limit issue

    Examples:
      | Attribute1 | Attribute2 | LineItems |
      | ZC         | 30         | 10000     |

  @TC-167
  Scenario Outline: Validate system behavior when the number of line items is within the defined system limits
    Given user is logged into the SAP S/4HANA Cloud system with access to the Finance module
    When user navigates to the Billing Due Program
    And user inputs Attribute 1 as "<Attribute1>" and Attribute 2 as "<Attribute2>"
    And user loads test data with "<LineItems>" line items
    And user attempts to execute the Billing Due Program
    Then the system should successfully execute the program without errors

    Examples:
      | Attribute1 | Attribute2 | LineItems |
      | ZC         | 30         | 5000      |
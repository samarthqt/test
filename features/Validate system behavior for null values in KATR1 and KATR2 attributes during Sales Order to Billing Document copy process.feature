Feature: Validate system behavior for null values in KATR1 and KATR2 attributes during Sales Order to Billing Document copy process

  @TC-450
  Scenario Outline: Test null values for KATR1 and KATR2 attributes during the Sales Order to Billing Document copy process
    Given user is logged into the SAP S/4HANA system
    When user navigates to the Sales Order module and selects the option to create a new Sales Order
    And user enters the required details for the Sales Order with KATR1 as <KATR1> and KATR2 as <KATR2>
    And user saves the Sales Order and notes the Sales Order number
    And user navigates to the Billing module and selects the option to create a Billing Document
    And user enters the Sales Order number created in the previous step
    And user executes the process to copy the Sales Order to a Billing Document
    Then the system processes the Sales Order and identifies null attribute values
    And the system displays <system_behavior>
    And the Billing Document is <billing_document_status>

    Examples:
      | KATR1  | KATR2  | system_behavior                     | billing_document_status |
      | null   | null   | error message displayed             | not created             |
      | null   | valid  | error message displayed             | not created             |
      | valid  | null   | error message displayed             | not created             |
      | valid  | valid  | no error message; processed normally | created                 |

  @TC-450
  Scenario: Verify consistent handling of null values for multiple Sales Orders
    Given user is logged into the SAP S/4HANA system
    When user repeats the process for multiple Sales Orders with KATR1 and KATR2 attributes set to null
    Then the system consistently handles null values as expected

  @TC-450
  Scenario: Log out of the SAP system
    Given user is logged into the SAP S/4HANA system
    When user logs out of the system
    Then user is successfully logged out of the system

  @TC-450
  Scenario: Document system behavior and error messages for null values
    Given user has observed system behavior during the Sales Order to Billing Document copy process
    When user documents the system behavior and error messages for null values
    Then system behavior and error messages are documented for review
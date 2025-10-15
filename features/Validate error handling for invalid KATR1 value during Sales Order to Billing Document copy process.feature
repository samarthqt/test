Feature: Validate error handling for invalid KATR1 value during Sales Order to Billing Document copy process

  @TC-579
  Scenario Outline: Verify system behavior for invalid and valid KATR1 values during the copy process
    Given user logs in to SAP S/4HANA Cloud with appropriate credentials
    And user navigates to the Sales Order to Billing Document copy process
    When user selects the Sales Order with KATR1 value "<KATR1>"
    And user initiates the copy process to create the Billing Document
    Then the system displays the message "<errorMessage>"
    And audit trail logs the error occurrence if applicable
    And system logs confirm the error details if applicable
    And mapping rules for KATR1 values in the system configuration are validated
    And downstream systems handle the error appropriately if applicable

    Examples:
      | KATR1      | errorMessage                      |
      | INVALID    | Invalid KATR1 value              |
      | VALID      | Copy process completed successfully |

  @TC-579
  Scenario: Generate a report of failed copy attempts for auditing purposes
    Given user logs in to SAP S/4HANA Cloud with appropriate credentials
    And user navigates to the Sales Order to Billing Document copy process
    When user generates a report of failed copy attempts
    Then the report is generated successfully with error details

  @TC-579
  Scenario: Verify user logout and system behavior
    Given user logs in to SAP S/4HANA Cloud with appropriate credentials
    When user logs out of the system
    Then user is logged out successfully
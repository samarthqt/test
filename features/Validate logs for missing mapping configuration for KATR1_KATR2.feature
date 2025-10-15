Feature: Validate logs for missing mapping configuration for KATR1/KATR2

  @TC-453
  Scenario Outline: Verify system logs for missing KATR1/KATR2 mapping configuration
    Given the user logs into the SAP S/4HANA Cloud system with valid credentials
    When the user navigates to the Sales Order to Billing Document copy process screen
    And the user selects a Sales Order with KATR1 value "<KATR1>" and KATR2 value "<KATR2>"
    And the user initiates the copy process to generate a billing document
    And the user navigates to the system logs to verify entries for missing configuration
    Then the logs should capture detailed entries regarding the absence of mapping rules for the selected Sales Order
    And the logs should include KATR1 value "<KATR1>", KATR2 value "<KATR2>", and the impacted document type

    Examples:
      | KATR1 | KATR2 |
      | M     | N     |
      | O     | P     |

  @TC-453
  Scenario: Document log details for each Sales Order
    Given the user has verified the logs for missing mapping configuration for all Sales Orders
    When the user documents the log details for each Sales Order
    Then the log details should be documented successfully

  @TC-453
  Scenario: Log out of the SAP S/4HANA Cloud system
    Given the user has completed all validations and documentation
    When the user logs out of the SAP S/4HANA Cloud system
    Then the user should be logged out successfully

  @TC-453
  Scenario: Submit test results for review
    Given the user has completed the validation and documentation process
    When the user submits the test results for review
    Then the test results should be submitted successfully
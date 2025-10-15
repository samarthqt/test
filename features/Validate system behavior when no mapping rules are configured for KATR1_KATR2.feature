Feature: Validate system behavior when no mapping rules are configured for KATR1/KATR2

  @TC-452
  Scenario Outline: Validate error generation when mapping rules for KATR1/KATR2 are missing
    Given the user is logged into the SAP S/4HANA Cloud system
    And the user navigates to the Sales Order to Billing Document copy process screen
    When the user selects a sales order with KATR1 "<KATR1>" and KATR2 "<KATR2>"
    And the user initiates the copy process to generate a billing document
    Then the system generates a meaningful error message indicating missing mapping rules for KATR1 "<KATR1>" and KATR2 "<KATR2>"

    Examples:
      | KATR1 | KATR2 |
      | X     | Y     |
      | Z     | W     |
      | P     | Q     |

  @TC-452
  Scenario: Verify system logs capture missing configuration entries
    Given the user is logged into the SAP S/4HANA Cloud system
    And the user navigates to the system logs
    When the user verifies the logs for missing configuration entries
    Then the logs capture the missing configuration for troubleshooting

  @TC-452
  Scenario: Validate error messages or warnings in system logs
    Given the user is logged into the SAP S/4HANA Cloud system
    And the user navigates to the system logs
    When the user reviews the error messages or warnings displayed in the logs
    Then the error messages or warnings clearly indicate the absence of mapping rules for KATR1/KATR2

  @TC-452
  Scenario: Document results of the test cases
    Given the user has completed the validation of error messages and system logs
    When the user documents the results of the test cases for each sales order
    Then the results are documented successfully

  @TC-452
  Scenario: Log out and submit test results
    Given the user has completed documenting the test results
    When the user logs out of the SAP S/4HANA Cloud system
    And the user submits the test results for review
    Then the test results are submitted successfully
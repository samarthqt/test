Feature: Validate error handling for missing KATR2 value during Sales Order to Billing Document copy process

  @TC-580
  Scenario Outline: Ensure the system throws an error when KATR2 is missing during the copy process
    Given the user logs into SAP S/4HANA Cloud with appropriate credentials
    And the user navigates to the Sales Order to Billing Document copy process
    When the user selects a Sales Order with KATR1 as "<KATR1>" and KATR2 as "<KATR2>"
    And the user initiates the copy process to create the Billing Document
    Then the system displays an error message "<ErrorMessage>"
    And the audit trail logs the error with details
    And the system logs confirm the missing KATR2 value caused the error

    Examples:
      | KATR1 | KATR2 | ErrorMessage            |
      | ZC    |       | Missing KATR2 value    |

  @TC-580
  Scenario: Verify the system enforces mandatory KATR2 values in mapping rules
    Given the user validates the mapping rules for KATR2 values in the system configuration
    Then the mapping rules correctly enforce mandatory KATR2 values

  @TC-580
  Scenario: Retry the copy process with valid KATR2 values
    Given the user selects a Sales Order with KATR1 as "ZC" and KATR2 as "ValidValue"
    When the user initiates the copy process to create the Billing Document
    Then the copy process completes successfully with valid KATR2 values

  @TC-580
  Scenario: Generate a report of failed copy attempts for auditing purposes
    Given the user generates a report of failed copy attempts
    Then the report is generated successfully with error details

  @TC-580
  Scenario: Verify error handling mechanism in downstream systems
    Given the user verifies the error handling mechanism in downstream systems
    Then the downstream systems correctly prevent processing of invalid values

  @TC-580
  Scenario: Log out of the system
    Given the user logs out of the system
    Then the user is logged out successfully
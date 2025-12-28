Feature: Validate system behavior for edge case with missing correction type

  @TC-80
  Scenario Outline: Verify system response when generating a billing correction output form with missing correction type
    Given the user is logged into the SAP S/4HANA system with valid credentials
    And the user navigates to the Billing Correction Output form generation screen
    And the user selects an Invoice Correction Request with the following details:
      | Invoice Correction Request ID | Correction Type |
      | <Invoice Correction Request ID> | <Correction Type> |
    When the user attempts to generate a billing correction output form
    Then the system prevents form generation
    And the system displays an error message indicating the missing correction type
    And the error message explicitly states the missing correction type
    And the system logs contain relevant error details for troubleshooting

    Examples:
      | Invoice Correction Request ID | Correction Type |
      | 11111                         | Missing         |
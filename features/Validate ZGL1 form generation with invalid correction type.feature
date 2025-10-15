Feature: Validate ZGL1 form generation with invalid correction type

  @TC-77
  Scenario Outline: Verify that the system prevents ZGL1 form generation when the correction type is invalid or missing
    Given the user logs into the SAP S/4HANA system with valid credentials
    And the user navigates to the Billing Correction Output form generation screen
    When the user selects the Invoice Correction Request with a correction type "<correction_type>"
    And the user attempts to generate a ZGL1 form
    Then the system should prevent form generation
    And the system should display an error message "<error_message>"
    And the user should verify the system logs for relevant error details

    Examples:
      | correction_type | error_message                                       |
      | Invalid         | Correction type is invalid                         |
      | Missing         | Correction type is missing                         |
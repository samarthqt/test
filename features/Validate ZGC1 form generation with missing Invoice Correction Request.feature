Feature: Validate ZGC1 form generation with missing Invoice Correction Request

  @TC-76
  Scenario: User logs into the SAP S/4HANA system
    Given the user has appropriate credentials
    When the user logs into the SAP S/4HANA system
    Then the user is successfully logged into the system

  @TC-76
  Scenario: User navigates to the Billing Correction Output form generation screen
    Given the user is logged into the SAP S/4HANA system
    When the user navigates to the Billing Correction Output form generation screen
    Then the Billing Correction Output form generation screen is displayed

  @TC-76
  Scenario Outline: Attempt to generate a ZGC1 form without providing an Invoice Correction Request ID
    Given the user is on the Billing Correction Output form generation screen
    When the user attempts to generate a ZGC1 form with the following details:
      | Invoice Correction Request ID | Billing Document Reference |
      | <Invoice Correction Request ID> | <Billing Document Reference> |
    Then the system prevents form generation and displays the error message "<Error Message>"

    Examples:
      | Invoice Correction Request ID | Billing Document Reference | Error Message                              |
      | None                          | Valid                      | Invoice Correction Request is missing      |
      | Blank                         | Valid                      | Invoice Correction Request is missing      |

  @TC-76
  Scenario: Verify the error message content for missing Invoice Correction Request
    Given the user attempts to generate a ZGC1 form without providing an Invoice Correction Request ID
    When the error message is displayed
    Then the error message explicitly states that the Invoice Correction Request is missing

  @TC-76
  Scenario: Check the system logs for additional error details
    Given the user encounters an error while generating a ZGC1 form
    When the user checks the system logs
    Then the system logs contain relevant error details for troubleshooting
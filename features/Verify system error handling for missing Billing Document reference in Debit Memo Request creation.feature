Feature: Verify system error handling for missing Billing Document reference in Debit Memo Request creation

  @TC-229
  Scenario: User logs into the SAP Fiori app successfully
    Given the user has valid credentials
    When the user logs into the SAP Fiori app
    Then the user should be able to access the app

  @TC-229
  Scenario: User navigates to the Debit Memo Request creation section
    Given the user has accessed the SAP Fiori app
    When the user navigates to the Debit Memo Request creation section
    Then the Debit Memo Request creation screen should be displayed

  @TC-229
  Scenario Outline: Verify system validation for missing or invalid Billing Document reference
    Given the user is on the Debit Memo Request creation screen
    When the user attempts to create a Debit Memo Request with "<Billing Document Reference>"
    Then the system should display an error message "<Error Message>"
    And the system should prevent submission of the Debit Memo Request

    Examples:
      | Billing Document Reference | Error Message                                      |
      |                            | Billing Document reference is mandatory            |
      | InvalidReference           | Invalid Billing Document reference                 |

  @TC-229
  Scenario: Verify system prevents saving incomplete Debit Memo Requests
    Given the user is on the Debit Memo Request creation screen
    When the user attempts to save the Debit Memo Request without completing mandatory fields
    Then the system should prevent saving the request
    And the system should display an error message

  @TC-229
  Scenario: Verify system prevents submission of incomplete Debit Memo Requests
    Given the user is on the Debit Memo Request creation screen
    When the user attempts to submit the Debit Memo Request without completing mandatory fields
    Then the system should prevent submission of the request
    And the system should display a detailed error message

  @TC-229
  Scenario: Verify status of incomplete Debit Memo Request remains "Incomplete"
    Given the user has attempted to create an incomplete Debit Memo Request
    When the user checks the status of the request in the system
    Then the request status should remain "Incomplete"

  @TC-229
  Scenario: Verify system logs validation errors for missing Billing Document reference
    Given the user has attempted to create a Debit Memo Request without a Billing Document reference
    When the user checks the system logs
    Then the system logs should indicate validation failure due to missing Billing Document reference

  @TC-229
  Scenario: Verify system logs validation errors for invalid Billing Document reference
    Given the user has attempted to create a Debit Memo Request with an invalid Billing Document reference
    When the user checks the system logs
    Then the system logs should indicate validation failure due to invalid Billing Document reference

  @TC-229
  Scenario: Validate error handling process for missing mandatory fields
    Given the user has attempted to create a Debit Memo Request without completing mandatory fields
    When the system processes the request
    Then the system should ensure compliance by preventing incomplete requests

  @TC-229
  Scenario: Validate error handling process for invalid Billing Document references
    Given the user has attempted to create a Debit Memo Request with an invalid Billing Document reference
    When the system processes the request
    Then the system should log all errors related to invalid references
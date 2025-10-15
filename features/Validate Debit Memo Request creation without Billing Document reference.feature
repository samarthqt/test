Feature: Validate Debit Memo Request creation without Billing Document reference

  @TC-227
  Scenario: User logs in to the SAP Fiori app
    Given user has valid credentials
    When user logs in to the SAP Fiori app
    Then user successfully accesses the app

  @TC-227
  Scenario: User navigates to the Debit Memo Request creation section
    Given user is logged into the SAP Fiori app
    When user navigates to the Debit Memo Request creation section
    Then the Debit Memo Request creation screen is displayed

  @TC-227
  Scenario Outline: Validate system behavior when creating Debit Memo Request with or without Billing Document reference
    Given user is on the Debit Memo Request creation screen
    When user enters header details such as customer name, request type, and date
    And user enters item details such as quantity, price, and description
    And user provides a Billing Document reference as "<Billing Document Reference>"
    And user submits the Debit Memo Request
    Then the system displays "<System Message>"

    Examples:
      | Billing Document Reference | System Message                                    |
      |                            | Error: Billing Document reference is mandatory   |
      | ValidBillingDoc123         | Debit Memo Request submitted successfully        |

  @TC-227
  Scenario: Validate system logs for validation messages
    Given user attempts to create a Debit Memo Request without providing a Billing Document reference
    When user checks the system logs
    Then system logs indicate an error and validation failure due to missing Billing Document reference

  @TC-227
  Scenario: Validate save functionality for incomplete Debit Memo Request
    Given user attempts to create a Debit Memo Request without providing a Billing Document reference
    When user attempts to save the incomplete Debit Memo Request
    Then the system prevents saving and displays a detailed error message

  @TC-227
  Scenario: Validate successful Debit Memo Request submission with a valid Billing Document reference
    Given user is on the Debit Memo Request creation screen
    When user enters valid header and item details
    And user provides a valid Billing Document reference
    And user submits the Debit Memo Request
    Then the system accepts the request and processes it successfully

  @TC-227
  Scenario: Verify workflow initiation for a valid Debit Memo Request
    Given user has successfully submitted a Debit Memo Request with a valid Billing Document reference
    When user verifies the workflow initiation for the submitted request
    Then the workflow is triggered successfully for the valid request

  @TC-227
  Scenario: Check the status of the Debit Memo Request in the system
    Given user has successfully submitted a Debit Memo Request
    When user checks the status of the Debit Memo Request in the system
    Then the request status is updated to "Submitted"

  @TC-227
  Scenario: Validate error handling process for missing mandatory fields
    Given user attempts to create a Debit Memo Request without providing mandatory fields
    When user submits the request
    Then the system ensures compliance by preventing incomplete requests
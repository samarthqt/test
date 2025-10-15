Feature: Verify system behavior when attempting to edit a Credit Memo Request during approval workflow

  @TC-486
  Scenario: User successfully logs into the SAP system
    Given the user has a valid account with permissions to create Credit Memo Requests
    When the user logs into the SAP system
    Then the user is successfully logged into the SAP system

  @TC-486
  Scenario: User navigates to the transaction for creating a Credit Memo Request
    Given the user is logged into the SAP system
    When the user navigates to the transaction for creating a Credit Memo Request
    Then the Credit Memo Request creation screen is displayed

  @TC-486
  Scenario Outline: User creates and saves a Credit Memo Request
    Given the user is on the Credit Memo Request creation screen
    When the user enters the required fields "<referenceBillingDocument>" and "<reasonForRequest>"
    And the user saves the Credit Memo Request
    Then the Credit Memo Request is successfully created
    And a unique document number is generated

    Examples:
      | referenceBillingDocument | reasonForRequest  |
      | REF12345                 | Price Adjustment  |
      | REF67890                 | Incorrect Billing |

  @TC-486
  Scenario: User submits the Credit Memo Request for approval
    Given the Credit Memo Request is successfully created
    When the user submits the Credit Memo Request for approval
    Then the Credit Memo Request is successfully submitted for approval

  @TC-486
  Scenario: System prevents edits to a Credit Memo Request during the approval workflow
    Given the Credit Memo Request is in the approval workflow
    When the user attempts to edit the Credit Memo Request
    Then the system prevents edits to the Credit Memo Request
    And the system displays an error message indicating the document is locked

  @TC-486
  Scenario: System prevents unauthorized changes during the approval workflow
    Given the Credit Memo Request is in the approval workflow
    When the user attempts unauthorized changes to the Credit Memo Request
    Then the system successfully prevents unauthorized changes

  @TC-486
  Scenario: Verify clarity of the error message for locked Credit Memo Request
    Given the Credit Memo Request is in the approval workflow
    When the user attempts to edit the Credit Memo Request
    Then the error message clearly states that the Credit Memo Request is locked for editing until the workflow process is completed

  @TC-486
  Scenario: Validate system logs for unauthorized edit attempts
    Given the Credit Memo Request is in the approval workflow
    When the user attempts to edit the Credit Memo Request
    Then the system logs show no unauthorized edits were made during the workflow process

  @TC-486
  Scenario: System prevents direct edits via backend access
    Given the Credit Memo Request is in the approval workflow
    When the user attempts to bypass the approval workflow and directly edit the Credit Memo Request through backend access
    Then the system prevents direct edits and maintains the integrity of the Credit Memo Request

  @TC-486
  Scenario: System maintains a record of all edit attempts during the workflow
    Given the Credit Memo Request is in the approval workflow
    When the user attempts to edit the Credit Memo Request
    Then the system maintains a complete record of all attempts to edit the Credit Memo Request during the workflow process

  @TC-486
  Scenario: System prevents any changes to Credit Memo Request data during the workflow
    Given the Credit Memo Request is in the approval workflow
    When the user attempts to make changes to the Credit Memo Request data
    Then the system successfully prevents any changes to the Credit Memo Request data during the workflow process

  @TC-486
  Scenario: System displays notification that Credit Memo Request is locked
    Given the Credit Memo Request is in the approval workflow
    When the user attempts to edit the Credit Memo Request
    Then the system displays a notification indicating that the Credit Memo Request is locked for editing
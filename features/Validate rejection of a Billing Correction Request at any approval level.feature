Feature: Validate rejection of a Billing Correction Request at any approval level

  @TC-479
  Scenario Outline: User creates and submits a Billing Correction Request with specified document type and value
    Given the user is authorized to create Billing Correction Requests
    When the user navigates to the Credit Memo Request creation screen
    And the user selects document type "<document_type>"
    And the user inputs the request details with a value of "<request_value>"
    And the user submits the request for workflow routing
    Then the system accepts the request details without errors
    And the system displays a confirmation message

    Examples:
      | document_type | request_value |
      | ZRK           | 5000          |

  @TC-479
  Scenario: User logs in as the designated Reviewer for the first approval level
    Given the user is the designated Reviewer for the first approval level
    When the user logs in to the system
    Then the user is able to view the Billing Correction Request in their workflow inbox

  @TC-479
  Scenario: Reviewer rejects the Billing Correction Request at the first approval level
    Given the user is logged in as the first-level Reviewer
    When the user rejects the Billing Correction Request
    Then the request is marked as rejected
    And a rejection code is assigned to the request

  @TC-479
  Scenario: Verify workflow history displays rejection at the first approval level
    Given the Billing Correction Request is rejected at the first approval level
    When the user views the workflow history
    Then the workflow history displays the rejection at the first approval level

  @TC-479
  Scenario: Verify the request does not proceed to the next approval level
    Given the Billing Correction Request is rejected at the first approval level
    When the user checks the request status
    Then the request is not routed further
    And the request status is marked as rejected

  @TC-479
  Scenario: System prevents modifications to the rejected request
    Given the Billing Correction Request is in a rejected state
    When the user attempts to modify the rejected request
    Then the system prevents modifications to the request

  @TC-479
  Scenario: Verify rejection code is visible in the request details
    Given the Billing Correction Request is rejected
    When the user views the request details
    Then the rejection code and reason are displayed in the request details

  @TC-479
  Scenario: System prevents resubmission of the rejected request without corrections
    Given the Billing Correction Request is in a rejected state
    When the user attempts to resubmit the rejected request without corrections
    Then the system prevents the resubmission of the request

  @TC-479
  Scenario: Verify the request remains in the rejected state
    Given the Billing Correction Request is in a rejected state
    When the user checks the request status
    Then the request status remains as rejected
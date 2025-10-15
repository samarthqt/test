Feature: Validate workflow routing for a value exactly at the lower boundary of two approval levels

  @TC-483
  Scenario Outline: Validate the workflow routing for a Billing Correction Request based on the lower boundary value of approval levels
    Given the user is logged into the SAP system with authorization to create Billing Correction Requests
    And the user navigates to the Credit Memo Request creation screen and selects document type "<Document Type>"
    When the user inputs the request details with a value of "<Request Value>"
    And the user submits the request for workflow routing
    Then the request is successfully submitted, and a confirmation message is displayed
    When the designated Reviewer for the first approval level logs in
    Then the Reviewer is able to view the request in their workflow inbox
    When the Reviewer approves the request at the first approval level
    Then the request moves to the next approval level
    When the designated Approver for the second approval level logs in
    Then the Approver is able to view the request in their workflow inbox
    When the Approver approves the request at the second approval level
    Then the request is fully approved and proceeds to the billing stage
    And the workflow history shows the request was routed to the appropriate approval levels
    And the request status is updated as "Approved" at each approval level
    And the request is successfully processed for billing
    And the system consistently handles the boundary value across different scenarios

    Examples:
      | Document Type | Request Value |
      | ZRK           | 1000          |
      | ZRK1          | 1000          |
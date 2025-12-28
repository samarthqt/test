Feature: Validate workflow routing for a Debit Memo Request at the boundary value between two approval levels

  @TC-480
  Scenario Outline: Validate the creation and routing of a Debit Memo Request based on boundary values for approval levels
    Given the user is logged into the SAP system with authorization to create Debit Memo Requests
    And the user navigates to the Debit Memo Request creation screen
    And the user selects the document type "<DocumentType>"
    When the user enters request details with a value of "<RequestValue>"
    And the user submits the request for workflow routing
    Then the request is successfully submitted with a confirmation message
    When the designated Reviewer for the first approval level logs in
    Then the Reviewer can view the request in their workflow inbox
    When the Reviewer approves the request
    Then the request moves to the next approval level
    When the designated Approver for the second approval level logs in
    Then the Approver can view the request in their workflow inbox
    When the Approver approves the request
    Then the request moves to the third approval level if applicable
    When the designated Approver for the third approval level logs in (if applicable)
    Then the Approver can view the request in their workflow inbox
    When the Approver approves the request as the third-level Approver
    Then the request is fully approved and proceeds to the billing stage
    And the workflow history shows the request was routed to the appropriate approval levels
    And the request is successfully processed for billing

    Examples:
      | DocumentType | RequestValue |
      | ZRK          | 5000         |
      | ZRK1         | 5000         |
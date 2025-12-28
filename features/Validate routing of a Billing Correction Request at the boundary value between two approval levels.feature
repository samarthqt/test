Feature: Validate routing of a Billing Correction Request at the boundary value between two approval levels

  @TC-478
  Scenario Outline: Validate routing based on boundary value between two and three approval levels
    Given the user is logged into the SAP system with authorization to create Billing Correction Requests
    And the user navigates to the Credit Memo Request creation screen and selects document type "<document_type>"
    When the user inputs request details including a value of "<boundary_value>"
    And the user submits the request for workflow routing
    Then the request should be successfully submitted with a confirmation message
    And the workflow should route the request to the "<approval_level>" approval levels based on the boundary value
    And the workflow history should show the request routed correctly
    And the request should proceed to billing after final approval

    Examples:
      | document_type | boundary_value | approval_level  |
      | ZRK           | 5000           | two             |
      | ZRK1          | 5000           | three           |

  @TC-478
  Scenario: Review and approve the request at the first approval level
    Given the user logs in as the designated Reviewer for the first approval level
    And the Reviewer views the request in their workflow inbox
    When the Reviewer approves the request
    Then the request should move to the next approval level

  @TC-478
  Scenario: Review and approve the request at the second approval level
    Given the user logs in as the designated Approver for the second approval level
    And the Approver views the request in their workflow inbox
    When the Approver approves the request
    Then the request should move to the final approval level if required

  @TC-478
  Scenario Outline: Review and approve the request at the third approval level (if applicable)
    Given the user logs in as the designated Approver for the third approval level
    And the Approver views the request in their workflow inbox
    When the Approver approves the request
    Then the request should be fully approved and proceed to the billing stage

    Examples:
      | approval_level |
      | third          |

  @TC-478
  Scenario: Verify workflow history and billing processing
    Given the user verifies the workflow history
    Then the workflow history should show the request routed to the appropriate approval levels
    And the request should be successfully processed for billing
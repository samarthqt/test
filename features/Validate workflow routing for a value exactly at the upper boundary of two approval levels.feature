Feature: Validate workflow routing for a value exactly at the upper boundary of two approval levels

  @TC-484
  Scenario: User logs in to the SAP system to create Billing Correction Requests
    Given the user is authorized to create Billing Correction Requests
    When the user logs in to the SAP system
    Then the user is successfully logged in and has access to the Billing Correction Request creation screen

  @TC-484
  Scenario: User navigates to the Credit Memo Request creation screen and selects document type ZRK
    Given the user is on the Billing Correction Request creation screen
    When the user navigates to the Credit Memo Request creation screen
    And the user selects document type ZRK
    Then the Credit Memo Request creation screen is displayed with fields to input details

  @TC-484
  Scenario Outline: User inputs request details including the value at the upper boundary
    Given the user is authorized to create and process Billing Correction Requests
    When the user inputs the request details including the value "<value>"
    Then the request details are entered, and the value is accepted without errors

    Examples:
      | value |
      | 5000  |

  @TC-484
  Scenario: User submits the request for workflow routing
    Given the user has entered valid request details
    When the user submits the request for workflow routing
    Then the request is successfully submitted, and a confirmation message is displayed

  @TC-484
  Scenario: Reviewer logs in and views the request in the workflow inbox
    Given the request is submitted for workflow routing
    When the designated Reviewer logs in to the SAP system
    Then the Reviewer is able to view the request in their workflow inbox

  @TC-484
  Scenario: Reviewer approves the request at the first approval level
    Given the Reviewer is viewing the request in their workflow inbox
    When the Reviewer approves the request
    Then the request is approved and moves to the next approval level

  @TC-484
  Scenario: Approver logs in and views the request in the workflow inbox
    Given the request is at the second approval level
    When the designated Approver logs in to the SAP system
    Then the Approver is able to view the request in their workflow inbox

  @TC-484
  Scenario: Approver approves the request at the second approval level
    Given the Approver is viewing the request in their workflow inbox
    When the Approver approves the request
    Then the request is fully approved and proceeds to the billing stage

  @TC-484
  Scenario: User verifies the workflow history for correct routing
    Given the request has passed through all approval levels
    When the user views the workflow history
    Then the workflow history shows the request was routed to the appropriate approval levels

  @TC-484
  Scenario: User verifies the request proceeds to billing after final approval
    Given the request is fully approved
    When the user checks the billing process
    Then the request is successfully processed for billing

  @TC-484
  Scenario Outline: User checks system consistency for boundary value routing
    Given the workflow rules are configured for boundary values
    When the user inputs a request with value "<value>"
    Then the system consistently routes requests at the upper boundary value

    Examples:
      | value |
      | 5000  |

  @TC-484
  Scenario: User validates request status updates at each approval level
    Given the request has passed through each approval level
    When the user checks the request status
    Then the request status is updated as 'Approved' at each level
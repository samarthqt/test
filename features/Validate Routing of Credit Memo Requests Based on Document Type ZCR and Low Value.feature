Feature: Validate Routing of Credit Memo Requests Based on Document Type ZCR and Low Value

  @TC-232
  Scenario Outline: Validate the creation and routing of Credit Memo Requests with Doc Type ZCR and specific value thresholds
    Given the user logs in to the SAP Fiori app with appropriate credentials
    And the user navigates to the app for creating Credit Memo Requests
    When the user enters the Doc Type as "<DocType>" and Value as "<Value>"
    Then the system accepts the document type and value inputs
    And the user submits the Credit Memo Request to trigger the workflow
    Then the workflow is triggered successfully and routed to the correct Reviewer "<Reviewer>" and Approver "<Approver>"
    When the user logs in as Reviewer "<Reviewer>"
    Then the Reviewer is able to view the Credit Memo Request in their workflow inbox
    When the Reviewer reviews and approves the Credit Memo Request
    Then the request is approved by the Reviewer and forwarded to the Approver "<Approver>"
    When the user logs in as Approver "<Approver>"
    Then the Approver is able to view the Credit Memo Request in their workflow inbox
    When the Approver approves the Credit Memo Request
    Then the Credit Memo Request is approved and released for billing
    And the system routes the Credit Memo Request correctly based on the value thresholds
    And no errors or warnings are found in the workflow logs
    And the Credit Memo Request is successfully released for billing
    And the process complies with financial policies and routing configurations

    Examples:
      | DocType | Value  | Reviewer  | Approver |
      | ZCR     | 10000  | Laura T   | Ian W    |
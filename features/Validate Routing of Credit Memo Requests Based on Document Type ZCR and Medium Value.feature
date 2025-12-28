Feature: Validate Routing of Credit Memo Requests Based on Document Type ZCR and Medium Value

  @TC-231
  Scenario Outline: Validate Credit Memo Request routing based on document type and value
    Given the user logs in to the SAP Fiori app with appropriate credentials
    And the user navigates to the app for creating Credit Memo Requests
    When the user enters the document type as "<Document Type>" and value as "<Value>"
    And the user submits the Credit Memo Request to trigger the workflow
    Then the system routes the request to the correct reviewer "<Reviewer>" and approver "<Approver>"
    And the workflow is triggered successfully

    Examples:
      | Document Type | Value   | Reviewer | Approver |
      | ZCR           | 50000  | Laura T  | Ian W    |

  @TC-231
  Scenario: Reviewer reviews and approves the Credit Memo Request
    Given the reviewer "Laura T" logs in to the SAP Fiori app
    And the reviewer views the Credit Memo Request in their workflow inbox
    When the reviewer reviews and approves the Credit Memo Request
    Then the request is forwarded to the approver "Ian W"

  @TC-231
  Scenario: Approver approves the Credit Memo Request
    Given the approver "Ian W" logs in to the SAP Fiori app
    And the approver views the Credit Memo Request in their workflow inbox
    When the approver approves the Credit Memo Request
    Then the Credit Memo Request is approved and released for billing

  @TC-231
  Scenario: Verify system routing and workflow logs
    Given the Credit Memo Request has been routed and processed
    When the user verifies the system routing based on value thresholds
    Then the Credit Memo Request is routed to the correct Reviewer and Approver
    And no errors or warnings are found in the workflow logs

  @TC-231
  Scenario: Verify compliance with financial policies and configurations
    Given the Credit Memo Request is approved and released for billing
    When the user verifies compliance with financial policies and routing configurations
    Then the process complies with financial policies and routing configurations
Feature: Validate routing of Credit Memo Requests based on document type ZCR and high value

  @TC-230
  Scenario Outline: Ensure Credit Memo Requests with Doc Type ZCR and value of 100,000 are routed to the correct Reviewer and Approver
    Given the user is logged in to the SAP Fiori app with appropriate credentials
    When the user navigates to the app for creating Credit Memo Requests
    And the user enters the Doc Type as <DocType> and Value as <Value>
    And the user submits the Credit Memo Request to trigger the workflow
    Then the workflow is triggered successfully
    And the Credit Memo Request is routed to Reviewer <Reviewer> and Approver <Approver>

    Examples:
      | DocType | Value   | Reviewer  | Approver |
      | ZCR     | 100000  | Laura T   | Ian W    |

  @TC-230
  Scenario: Reviewer reviews and approves the Credit Memo Request
    Given the user logs in as Reviewer Laura T
    When the user views the Credit Memo Request in their workflow inbox
    And the user reviews the Credit Memo Request and approves it
    Then the request is approved by Laura T and forwarded to Approver Ian W

  @TC-230
  Scenario: Approver approves the Credit Memo Request
    Given the user logs in as Approver Ian W
    When the user views the Credit Memo Request in their workflow inbox
    And the user approves the Credit Memo Request
    Then the Credit Memo Request is approved and released for billing

  @TC-230
  Scenario Outline: Verify the system routing and workflow logs for Credit Memo Requests
    Given the Credit Memo Request with Doc Type <DocType> and Value <Value> has been submitted
    When the user verifies the system routing based on value thresholds
    Then the Credit Memo Request is routed to the correct Reviewer and Approver
    And the user checks the workflow logs for any errors or warnings
    Then no errors or warnings are found in the workflow logs

    Examples:
      | DocType | Value   |
      | ZCR     | 100000  |

  @TC-230
  Scenario: Verify the Credit Memo Request is released for billing
    Given the Credit Memo Request has been approved by the Approver
    When the user verifies the billing release status
    Then the Credit Memo Request is successfully released for billing

  @TC-230
  Scenario: Ensure compliance with financial policies and routing configurations
    Given the Credit Memo Request workflow has been completed
    When the user verifies compliance with financial policies and routing configurations
    Then the process complies with financial policies and routing configurations
Feature: Validate routing of Credit Memo Requests above threshold

  Ensure that Credit Memo Requests exceeding the threshold value are routed to the correct approvers. Workflow configuration for Credit Memo Requests must be set up as per the policy.

  @TC-234
  Scenario: User logs in to the SAP Fiori app and navigates to the dashboard
    Given the user has appropriate credentials
    When the user logs in to the SAP Fiori app
    Then the user is successfully logged in and navigates to the SAP Fiori dashboard

  @TC-234
  Scenario Outline: Create and submit a Credit Memo Request exceeding the threshold value
    Given the user navigates to the Credit Memo Request creation app
    When the user selects Document Type as "<DocumentType>" and enters a value of "<Value>"
    And the user submits the Credit Memo Request
    Then the system routes the request to Reviewer "<Reviewer>" and Approver "<Approver>" for three-level approval

    Examples:
      | DocumentType | Value   | Reviewer | Approver |
      | ZCR          | 300000 | Laura T  | Kim B    |

  @TC-234
  Scenario: Reviewer approves the Credit Memo Request
    Given the user logs in as Reviewer Laura T
    When the user accesses the workflow inbox
    Then the Credit Memo Request is visible in the workflow inbox
    When the user reviews the Credit Memo Request details and approves it
    Then the request is successfully approved by Reviewer Laura T

  @TC-234
  Scenario: Approver approves the Credit Memo Request
    Given the user logs in as Approver Kim B
    When the user accesses the workflow inbox
    Then the Credit Memo Request is visible in the workflow inbox
    When the user reviews the Credit Memo Request details and approves it
    Then the request is successfully approved by Approver Kim B

  @TC-234
  Scenario: Verify the status of the Credit Memo Request
    Given the Credit Memo Request has been approved by all required parties
    When the user verifies the status of the Credit Memo Request
    Then the status of the Credit Memo Request is updated to 'Released for Billing'

  @TC-234
  Scenario: Validate the workflow log for routing sequence
    Given the Credit Memo Request has been processed
    When the user checks the workflow log
    Then the workflow log shows that the request was routed to the correct Reviewer and Approver

  @TC-234
  Scenario: Verify the document flow for the Credit Memo Request
    Given the Credit Memo Request has been processed
    When the user verifies the document flow
    Then the document flow shows the correct linkage and statuses

  @TC-234
  Scenario: Validate the Credit Memo Request in the billing due list
    Given the Credit Memo Request has been released for billing
    When the user checks the billing due list
    Then the Credit Memo Request is listed in the billing due list for further processing
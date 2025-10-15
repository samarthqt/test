Feature: Debit Memo Request Workflow - Approval Process Validation

  To validate that the workflow for Debit Memo Requests functions correctly, including Reviewer and Approver approvals.

  @TC-470
  Scenario: User logs into SAP Fiori with the creator's credentials
    Given the user has appropriate authorization to create and approve Debit Memo Requests
    When the user logs into SAP Fiori with the creator's credentials
    Then the user is successfully logged into the SAP Fiori system

  @TC-470
  Scenario: User navigates to the app for creating Debit Memo Requests
    Given the user is logged into SAP Fiori
    When the user navigates to the app for creating Debit Memo Requests
    Then the Debit Memo Request creation screen is displayed

  @TC-470
  Scenario Outline: User enters the Billing Document number as a reference
    Given the user is on the Debit Memo Request creation screen
    When the user enters the Billing Document number "<Billing Document Number>" as a reference
    Then the system accepts the Billing Document number and moves to the next step

    Examples:
      | Billing Document Number |
      | BD-11223                |

  @TC-470
  Scenario: User submits the Debit Memo Request
    Given the user has entered the Billing Document number as a reference
    When the user submits the Debit Memo Request
    Then the Debit Memo Request is submitted successfully, triggering the workflow

  @TC-470
  Scenario: Reviewer logs in and reviews the Debit Memo Request
    Given the Debit Memo Request workflow is triggered
    When the user logs in as the Reviewer
    Then the Reviewer is able to view and review the Debit Memo Request

  @TC-470
  Scenario: Reviewer approves the Debit Memo Request
    Given the Reviewer has reviewed the Debit Memo Request
    When the Reviewer approves the Debit Memo Request
    Then the Debit Memo Request is approved by the Reviewer and moves to the Approver

  @TC-470
  Scenario: Approver logs in and reviews the Debit Memo Request
    Given the Debit Memo Request is pending approval from the Approver
    When the user logs in as the Approver
    Then the Approver is able to view and review the Debit Memo Request

  @TC-470
  Scenario: Approver approves the Debit Memo Request
    Given the Approver has reviewed the Debit Memo Request
    When the Approver approves the Debit Memo Request
    Then the Debit Memo Request is approved by the Approver and is released for billing

  @TC-470
  Scenario: Verify Debit Memo Request visibility in the billing queue
    Given the Debit Memo Request is approved by the Approver
    When the user checks the billing queue
    Then the Debit Memo Request is visible in the billing queue

  @TC-470
  Scenario: Check workflow logs for successful completion
    Given the Debit Memo Request is approved and released for billing
    When the user checks the workflow logs
    Then the workflow logs indicate successful completion of all steps

  @TC-470
  Scenario: Verify workflow notifications were sent
    Given the Debit Memo Request workflow is configured
    When the user verifies the notifications
    Then notifications were sent to the Reviewer and Approver as per the workflow configuration

  @TC-470
  Scenario: Verify workflow status is updated to 'Completed'
    Given all approvals for the Debit Memo Request are completed
    When the user verifies the workflow status
    Then the workflow status is updated to 'Completed'
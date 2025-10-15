Feature: Creation of Debit Memo Request with Reference to Original Billing Document

  @TC-468
  Scenario: User logs into SAP Fiori with valid credentials
    Given user has appropriate credentials
    When user logs into SAP Fiori
    Then user is successfully logged into the SAP Fiori system

  @TC-468
  Scenario: User navigates to the app for creating Debit Memo Requests
    Given user has appropriate authorization to create Debit Memo Requests
    When user navigates to the app for creating Debit Memo Requests
    Then the Debit Memo Request creation screen is displayed

  @TC-468
  Scenario Outline: User enters Billing Document number as a reference
    Given user navigates to the Debit Memo Request creation screen
    When user enters the Billing Document number "<Billing Document Number>" as a reference
    Then the system accepts the Billing Document number and moves to the next step

    Examples:
      | Billing Document Number |
      | BD-12345               |

  @TC-468
  Scenario: System auto-populates header and item details from referenced Billing Document
    Given user has entered a valid Billing Document number as a reference
    When user verifies the auto-populated header and item details
    Then header and item details are correctly populated based on the referenced Billing Document

  @TC-468
  Scenario: User submits the Debit Memo Request
    Given user has verified the auto-populated details
    When user submits the Debit Memo Request
    Then the Debit Memo Request is submitted and the workflow is triggered

  @TC-468
  Scenario: Reviewer reviews the Debit Memo Request
    Given user logs in as the Reviewer (User A)
    When user reviews the Debit Memo Request
    Then Reviewer is able to view and review the Debit Memo Request

  @TC-468
  Scenario: Reviewer approves the Debit Memo Request
    Given Reviewer has reviewed the Debit Memo Request
    When Reviewer approves the Debit Memo Request
    Then the Debit Memo Request is approved by the Reviewer and moves to the Approver

  @TC-468
  Scenario: Approver reviews the Debit Memo Request
    Given user logs in as the Approver (User B)
    When user reviews the Debit Memo Request
    Then Approver is able to view and review the Debit Memo Request

  @TC-468
  Scenario: Approver approves the Debit Memo Request
    Given Approver has reviewed the Debit Memo Request
    When Approver approves the Debit Memo Request
    Then the Debit Memo Request is approved by the Approver and is released for billing

  @TC-468
  Scenario: Verify Debit Memo Request is released for billing
    Given the Debit Memo Request has been approved by the Approver
    When user verifies the status of the Debit Memo Request
    Then the system shows the Debit Memo Request as released for Billing

  @TC-468
  Scenario: Verify workflow logs for successful completion
    Given the Debit Memo Request has been processed through the workflow
    When user checks the workflow logs
    Then workflow logs confirm successful completion of all steps

  @TC-468
  Scenario: Verify Debit Memo Request is visible in the billing queue
    Given the Debit Memo Request is released for billing
    When user checks the billing queue
    Then the Debit Memo Request appears in the billing queue, ready for further processing
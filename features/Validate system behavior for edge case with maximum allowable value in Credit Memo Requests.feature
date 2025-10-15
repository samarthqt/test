Feature: Validate system behavior for edge case with maximum allowable value in Credit Memo Requests

  @TC-477
  Scenario: User logs in to SAP Fiori with valid credentials
    Given the user has valid credentials
    When the user logs into SAP Fiori
    Then the user is successfully logged in and navigates to the SAP Fiori homepage

  @TC-477
  Scenario: User navigates to the Credit Memo Request creation application
    Given the user is on the SAP Fiori homepage
    When the user navigates to the Credit Memo Request creation application
    Then the Credit Memo Request creation application is displayed

  @TC-477
  Scenario: User selects Document Type ZCR
    Given the user is in the Credit Memo Request creation application
    When the user selects Document Type ZCR
    Then Document Type ZCR is selected successfully

  @TC-477
  Scenario Outline: User enters value in the Credit Memo Request
    Given the user has selected Document Type ZCR
    When the user enters "<value>" in the value field
    Then the value is entered successfully

    Examples:
      | value          |
      | 1000000000     | # Maximum allowable value

  @TC-477
  Scenario: User submits the Credit Memo Request
    Given the user has entered the maximum allowable value
    When the user submits the Credit Memo Request
    Then the system accepts the submission and triggers the workflow

  @TC-477
  Scenario: Verify workflow is triggered and request is routed for approval
    Given the Credit Memo Request has been submitted
    When the user verifies the workflow
    Then the workflow is triggered successfully and the request is routed to the designated approver

  @TC-477
  Scenario: Approver logs in and reviews the submitted Credit Memo Request
    Given the approver has valid credentials
    When the approver logs in and navigates to the submitted Credit Memo Request
    Then the approver is able to view and review the submitted request

  @TC-477
  Scenario: Approver approves the Credit Memo Request
    Given the approver has reviewed the Credit Memo Request
    When the approver approves the request
    Then the request is approved successfully and the status is updated

  @TC-477
  Scenario: Verify approved request proceeds to the next stage in the workflow
    Given the Credit Memo Request has been approved
    When the user verifies the workflow progression
    Then the request proceeds to the next stage successfully

  @TC-477
  Scenario: Confirm request visibility in the system with updated status
    Given the request has proceeded to the next stage
    When the user checks the system for the request
    Then the request is visible with updated status and no errors

  @TC-477
  Scenario: Verify request is processed further in the financial system
    Given the request is visible in the system with updated status
    When the user verifies processing in the financial system
    Then the request is processed successfully without errors

  @TC-477
  Scenario: Check the audit log for the workflow
    Given the request has been processed in the financial system
    When the user checks the audit log for the workflow
    Then the audit log displays all actions taken on the request with timestamps
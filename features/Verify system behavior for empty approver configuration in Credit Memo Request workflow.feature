Feature: Verify system behavior for empty approver configuration in Credit Memo Request workflow

  @TC-467
  Scenario: User logs into the SAP S/4HANA Cloud system
    Given the user has valid credentials
    When the user logs into the SAP S/4HANA Cloud system
    Then the user is successfully logged into the system

  @TC-467
  Scenario: User navigates to the 'Create Credit Memo Request' application
    Given the user is logged into the SAP S/4HANA Cloud system
    When the user navigates to the 'Create Credit Memo Request' application
    Then the application for creating Credit Memo Requests is displayed

  @TC-467
  Scenario Outline: User enters Credit Memo Request details
    Given the user is on the 'Create Credit Memo Request' application
    When the user enters the Credit Memo Request type as "<CreditMemoRequestType>"
    And the user enters the Customer ID as "<CustomerID>"
    And the user enters the request value as "<RequestValue>"
    Then the system accepts the Credit Memo Request type
    And the system validates and accepts the Customer ID
    And the system accepts the request value

    Examples:
      | CreditMemoRequestType | CustomerID | RequestValue |
      | ZCR                  | CUST007    | 800          |

  @TC-467
  Scenario: User submits the Credit Memo Request
    Given the user has entered valid Credit Memo Request details
    When the user submits the Credit Memo Request
    Then the Credit Memo Request is successfully submitted

  @TC-467
  Scenario: Verify workflow request is not triggered due to missing approver configuration
    Given the approver configuration is intentionally left empty
    When the user submits the Credit Memo Request
    Then no workflow request is triggered

  @TC-467
  Scenario: Check system logs for errors related to workflow triggering
    Given the workflow request is not triggered
    When the user checks the system logs
    Then an error is logged indicating the absence of approver configuration

  @TC-467
  Scenario: Verify user notification about workflow failure
    Given the workflow request is not triggered
    When the user reviews system notifications
    Then the user is notified about the workflow failure

  @TC-467
  Scenario: Attempt to proceed to the next stage of the request without workflow approval
    Given the workflow request is not triggered
    When the user attempts to proceed to the next stage of the request
    Then the system prevents the request from proceeding to the next stage

  @TC-467
  Scenario: Configure approvers and resubmit the Credit Memo Request
    Given the user configures approvers in the system
    When the user resubmits the Credit Memo Request
    Then the workflow is triggered successfully

  @TC-467
  Scenario: User logs out of the system
    Given the user has completed their actions
    When the user logs out of the SAP S/4HANA Cloud system
    Then the user is logged out successfully
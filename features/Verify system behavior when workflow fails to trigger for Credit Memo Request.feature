Feature: Verify system behavior when workflow fails to trigger for Credit Memo Request

  @TC-464
  Scenario Outline: Validate the creation and submission of a Credit Memo Request with various inputs
    Given the user logs into the SAP S/4HANA Cloud system with valid credentials
    When the user navigates to the "Create Credit Memo Request" application
    And the user enters the Credit Memo Request type as "<CreditMemoRequestType>"
    And the user enters the Customer ID as "<CustomerID>"
    And the user enters the request value as "<RequestValue>"
    Then the system accepts the Credit Memo Request type
    And the system validates and accepts the Customer ID
    And the system accepts the request value
    When the user submits the Credit Memo Request
    Then the Credit Memo Request is successfully submitted

    Examples:
      | CreditMemoRequestType | CustomerID | RequestValue |
      | ZCR                  | CUST004    | 700          |

  @TC-464
  Scenario: Verify system logs an error and notifies the user when workflow fails to trigger
    Given the user logs into the SAP S/4HANA Cloud system with valid credentials
    And the user navigates to the "Create Credit Memo Request" application
    And the user enters the Credit Memo Request type as "ZCR"
    And the user enters the Customer ID as "CUST004"
    And the user enters the request value as "700"
    When the user submits the Credit Memo Request
    And a system misconfiguration prevents workflow triggering
    Then no workflow request is triggered
    And an error is logged indicating the failure to trigger the workflow
    And the user is notified about the workflow failure

  @TC-464
  Scenario: Verify system prevents proceeding to the next stage without workflow approval
    Given the user logs into the SAP S/4HANA Cloud system with valid credentials
    And the user navigates to the "Create Credit Memo Request" application
    And the user enters the Credit Memo Request type as "ZCR"
    And the user enters the Customer ID as "CUST004"
    And the user enters the request value as "700"
    When the user submits the Credit Memo Request
    And a system misconfiguration prevents workflow triggering
    Then the system prevents the request from proceeding to the next stage

  @TC-464
  Scenario: Verify workflow is triggered successfully after correcting the misconfiguration
    Given the user logs into the SAP S/4HANA Cloud system with valid credentials
    And the user navigates to the "Create Credit Memo Request" application
    And the user enters the Credit Memo Request type as "ZCR"
    And the user enters the Customer ID as "CUST004"
    And the user enters the request value as "700"
    When the user corrects the misconfiguration and resubmits the request
    Then the workflow is triggered successfully

  @TC-464
  Scenario: Verify user logs out of the system successfully
    Given the user logs into the SAP S/4HANA Cloud system with valid credentials
    When the user logs out of the system
    Then the user is logged out successfully
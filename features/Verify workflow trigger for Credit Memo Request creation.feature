Feature: Verify workflow trigger for Credit Memo Request creation  
  Ensure that a workflow is triggered upon the creation of a Credit Memo Request. Workflow configuration is active for Credit Memo Requests.

  @TC-461
  Scenario Outline: Validate the creation of a Credit Memo Request and workflow trigger
    Given the user is logged into the SAP S/4HANA Cloud system
    When the user navigates to the "Create Credit Memo Request" application
    And the user enters the Credit Memo Request type as "<CreditMemoRequestType>"
    And the user enters the Customer ID as "<CustomerID>"
    And the user enters the request value as "<RequestValue>"
    And the user submits the Credit Memo Request
    Then a workflow request should be triggered for the Credit Memo Request
    And the workflow should contain the correct approver details "<ApproverDetails>"
    And the workflow should adhere to the configured approval process
    And the system logs should not contain any errors during the workflow triggering process
    And the approver should be notified successfully

    Examples:
      | CreditMemoRequestType | CustomerID | RequestValue | ApproverDetails |
      | ZCR                  | CUST001    | 500          | Approver1       |

  @TC-461
  Scenario: Verify user login and logout functionality
    Given the user is logged into the SAP S/4HANA Cloud system
    When the user logs out of the system
    Then the user should be logged out successfully
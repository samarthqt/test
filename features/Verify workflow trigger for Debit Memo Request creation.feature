Feature: Verify workflow trigger for Debit Memo Request creation  
  Ensure that a workflow is triggered upon the creation of a Debit Memo Request. Workflow configuration is active for Debit Memo Requests.

  @TC-462
  Scenario Outline: Validate Debit Memo Request creation and workflow triggering  
    Given the user is logged into the SAP S/4HANA Cloud system with valid credentials  
    When the user navigates to the "Create Debit Memo Request" application  
    And the user enters the Debit Memo Request type as "<DebitMemoRequestType>"  
    And the user enters the Customer ID as "<CustomerID>"  
    And the user enters the request value as "<RequestValue>"  
    And the user submits the Debit Memo Request  
    Then a workflow request is triggered for the Debit Memo Request  
    And the workflow contains the correct approver details "<ApproverDetails>"  
    And the workflow adheres to the configured approval process  
    And no errors are found in the system logs  
    And the approver is notified successfully  

    Examples:  
      | DebitMemoRequestType | CustomerID | RequestValue | ApproverDetails |  
      | ZDR                 | CUST002    | 1000         | Approver2       |  

  @TC-462
  Scenario: Verify user logout  
    Given the user is logged into the SAP S/4HANA Cloud system  
    When the user logs out of the system  
    Then the user is logged out successfully
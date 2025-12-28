Feature: Verify workflow trigger for maximum allowable Credit Memo Request value

  @TC-466
  Scenario Outline: User creates a Credit Memo Request with maximum allowable value and verifies workflow trigger
    Given the user is logged into the SAP S/4HANA Cloud system with valid credentials
    When the user navigates to the "Create Credit Memo Request" application
    And the user enters the Credit Memo Request type as "<CreditMemoRequestType>"
    And the user enters the Customer ID as "<CustomerID>"
    And the user enters the request value as "<RequestValue>"
    And the user submits the Credit Memo Request
    Then a workflow request is triggered for the Credit Memo Request
    And the workflow contains the correct approver details "<ApproverDetails>"
    And the workflow adheres to the configured approval process
    And no errors are found in the system logs during the workflow triggering process
    And the approver is notified successfully
    And the user logs out of the system successfully

    Examples:
      | CreditMemoRequestType | CustomerID | RequestValue | ApproverDetails |
      | ZCR                  | CUST006    | 999999       | Approver4       |
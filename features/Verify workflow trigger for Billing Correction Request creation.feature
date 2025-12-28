Feature: Verify workflow trigger for Billing Correction Request creation

  @TC-463
  Scenario Outline: Validate the creation and workflow triggering of a Billing Correction Request
    Given the user logs into the SAP S/4HANA Cloud system with valid credentials
    When the user navigates to the 'Create Billing Correction Request' application
    And the user enters the Billing Correction Request type as "<BillingCorrectionRequestType>"
    And the user enters the Customer ID as "<CustomerID>"
    And the user enters the request value as "<RequestValue>"
    And the user submits the Billing Correction Request
    Then a workflow request is triggered for the Billing Correction Request
    And the workflow contains the correct approver details "<ApproverDetails>"
    And the workflow adheres to the configured approval process
    And the system logs show no errors during the workflow triggering process
    And the approver is notified successfully

    Examples:
      | BillingCorrectionRequestType | CustomerID | RequestValue | ApproverDetails |
      | ZRK                          | CUST003    | 1500         | Approver3       |

  @TC-463
  Scenario: Verify user logout after workflow submission
    Given the user is logged into the SAP S/4HANA Cloud system
    When the user logs out of the system
    Then the user is logged out successfully
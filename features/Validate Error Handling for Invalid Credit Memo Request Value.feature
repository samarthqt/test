Feature: Validate Error Handling for Invalid Credit Memo Request Value

  @TC-236
  Scenario Outline: Validate system behavior when submitting Credit Memo Requests with invalid values
    Given the user is logged into the SAP Fiori app with appropriate credentials
    And the user navigates to the Credit Memo Request creation app
    When the user selects Document Type as "<Document Type>" and enters a value of "<Value>"
    Then the system displays an error message indicating that the value is invalid
    When the user attempts to submit the Credit Memo Request
    Then the system prevents submission and displays an error message
    And the invalid Credit Memo Request is not routed to any approvers
    And the error log contains details of the invalid submission attempt
    And the invalid Credit Memo Request does not appear in the billing due list

    Examples:
      | Document Type | Value     |
      | ZCR           | -100000  |
      | ZCR           |          |
      | ZCR           | ABC123   |
      | ZCR           | 0        |
      | ZCR           | 10000000 |
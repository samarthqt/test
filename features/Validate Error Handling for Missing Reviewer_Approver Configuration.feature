Feature: Validate Error Handling for Missing Reviewer/Approver Configuration

  @TC-237
  Scenario: User logs in to the SAP Fiori app
    Given the user has appropriate credentials
    When the user logs in to the SAP Fiori app
    Then the user is successfully logged in and navigates to the SAP Fiori dashboard

  @TC-237
  Scenario Outline: Validate submission of Credit Memo Request with missing Reviewer/Approver configuration
    Given the user has appropriate authorization to create Credit Memo Requests
    And the user navigates to the Credit Memo Request creation app
    When the user selects Document Type as "<Document Type>" and enters a value of "<Value>"
    And the user submits the Credit Memo Request
    Then the system displays an error message indicating that the Reviewer/Approver configuration is missing
    And the Credit Memo Request is not routed to any approvers
    And no workflow is triggered for the request
    And the error log contains details of the missing configuration
    And the Credit Memo Request does not appear in the billing due list

    Examples:
      | Document Type | Value    |
      | ZCR           | 250,000 |
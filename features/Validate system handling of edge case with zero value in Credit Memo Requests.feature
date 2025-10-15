Feature: Validate system handling of edge case with zero value in Credit Memo Requests

  @TC-476
  Scenario Outline: Validate submission of Credit Memo Request with various values
    Given user is logged in to SAP Fiori with valid credentials
    And user navigates to the Credit Memo Request creation application
    And user selects Document Type "<document_type>"
    When user enters a value of "<value>" in the value field
    And user submits the Credit Memo Request
    Then the system "<expected_result>"

    Examples:
      | document_type | value   | expected_result                       |
      | ZCR           | 0       | rejects the submission and displays an error message indicating that zero values are not allowed |
      | ZCR           | 10000   | accepts the request and triggers the workflow |

  @TC-476
  Scenario: Verify workflow is triggered and routed for approval
    Given user has submitted a valid Credit Memo Request
    Then the workflow is triggered successfully
    And the request is routed to the designated approver

  @TC-476
  Scenario: Approver reviews and approves the Credit Memo Request
    Given user logs in as the approver
    And user reviews the submitted Credit Memo Request
    When user approves the Credit Memo Request
    Then the request status is updated successfully

  @TC-476
  Scenario: Verify approved request proceeds to the next stage in the workflow
    Given user has approved the Credit Memo Request
    Then the request proceeds to the next stage successfully
    And the request is visible in the system with updated status and no errors
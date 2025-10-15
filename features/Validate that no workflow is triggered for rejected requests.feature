Feature: Validate that no workflow is triggered for rejected requests

  @TC-242
  Scenario Outline: Validate system behavior for Billing Correction Requests with invalid or missing value buckets
    Given the user is logged into the SAP system with authorized credentials
    When the user navigates to the Billing Correction Request creation module
    And the user creates a "<document_type>" request with a "<value_bucket_status>" value bucket
    And the user submits the "<document_type>" request for workflow routing
    Then the system rejects the "<document_type>" request and displays an error message "<error_message>"
    And no workflow is triggered for the "<document_type>" request

    Examples:
      | document_type | value_bucket_status | error_message                               |
      | ZRK           | missing             | Missing value bucket                       |
      | ZRK1          | invalid             | Invalid value bucket                       |

  @TC-242
  Scenario: Verify no workflows are triggered for rejected requests
    Given the user has submitted ZRK and ZRK1 requests with invalid or missing value buckets
    When the user checks the workflow status for both requests
    Then no workflows are triggered for either request

  @TC-242
  Scenario: Review system logs for error details
    Given the user has submitted ZRK and ZRK1 requests with invalid or missing value buckets
    When the user reviews the system logs
    Then error details for both requests are logged in the system

  @TC-242
  Scenario Outline: Validate system behavior for resubmitting corrected requests
    Given the user has corrected the value bucket configurations for "<document_type>" requests
    When the user resubmits the corrected "<document_type>" request
    Then the system allows resubmission of the corrected "<document_type>" request
    And workflows are triggered as per the configured rules for the corrected "<document_type>" request

    Examples:
      | document_type |
      | ZRK           |
      | ZRK1          |
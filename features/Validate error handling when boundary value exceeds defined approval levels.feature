Feature: Validate error handling when boundary value exceeds defined approval levels

  @TC-481
  Scenario Outline: User submits a Billing Correction Request with a value exceeding or within the defined approval levels
    Given the user is authorized to create Billing Correction Requests
    When the user navigates to the Credit Memo Request creation screen and selects document type "<document_type>"
    And the user enters request details with a value "<request_value>"
    And the user attempts to submit the request for workflow routing
    Then the system displays "<error_message>"
    And the request is "<submission_status>"
    And the error log "<error_log_details>"

    Examples:
      | document_type | request_value | error_message                                      | submission_status | error_log_details                                |
      | ZRK           | 10001         | Value exceeds the defined approval levels          | not submitted     | contains details about the value exceeding limit |
      | ZRK           | 10000         | Request submitted successfully                     | submitted         | does not contain validation failure details      |

  @TC-481
  Scenario: User modifies the value to a valid boundary and resubmits the request
    Given the user is authorized to create Billing Correction Requests
    And the user navigates to the Credit Memo Request creation screen and selects document type "ZRK"
    And the user enters request details with a value exceeding the boundary
    And the user attempts to submit the request for workflow routing
    And the system displays an error message indicating the value exceeds the defined approval levels
    When the user modifies the value to a valid boundary value
    And the user resubmits the request
    Then the system accepts the modified value
    And the request is successfully submitted
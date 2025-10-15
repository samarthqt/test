Feature: Validate error handling for missing approval level configuration for Billing Correction Requests

  @TC-482
  Scenario Outline: Validate request submission with different values for approval level configuration
    Given the user is logged into the SAP system with authorization to create Billing Correction Requests
    And the user navigates to the Credit Memo Request creation screen and selects document type "<document_type>"
    When the user enters request details with a value "<value>"
    And the user attempts to submit the request for workflow routing
    Then the system displays "<error_message>" if the value has no approval level configuration
    And the request submission is "<submission_status>"
    And the error log contains "<log_details>"
    When the user modifies the value to "<modified_value>" and resubmits
    Then the system accepts the modified value and the request is successfully submitted

    Examples:
      | document_type | value  | error_message                                         | submission_status | log_details                                     | modified_value |
      | ZRK           | 99999  | No approval level configuration exists for the value | Blocked           | Details about the missing approval level       | 10000          |
      | ZRK1          | 99999  | No approval level configuration exists for the value | Blocked           | Details about the missing approval level       | 50000          |
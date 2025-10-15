Feature: Validate rejection of ZRK1 request with invalid value bucket  
  Ensure that the system rejects a ZRK1 request when the value bucket is invalid or undefined.  

  @TC-241  
  Scenario Outline: User submits a ZRK1 request with various value bucket inputs  
    Given the user is logged into the SAP system with authorized credentials  
    And the user navigates to the Billing Correction Request creation module  
    And the user selects the document type as ZRK1  
    And the user assigns the value bucket "<value_bucket>" to the request  
    And the user enters mandatory fields such as customer ID, invoice number, and request details  
    When the user submits the ZRK1 request for workflow routing  
    Then the system "<validation_result>"  
    And "<workflow_status>"  
    And "<log_status>"  

    Examples:  
      | value_bucket      | validation_result                                      | workflow_status                   | log_status                               |  
      | Invalid           | rejects the ZRK1 request and displays an error message indicating the invalid value bucket | no workflow is initiated             | logs the error message details for audit purposes |  
      | Undefined         | rejects the ZRK1 request and displays an error message indicating the invalid value bucket | no workflow is initiated             | logs the error message details for audit purposes |  
      | Valid             | accepts the ZRK1 request                              | triggers the workflow as configured | no error message logged                 |  

  @TC-241  
  Scenario: User edits and resubmits a rejected ZRK1 request with a valid value bucket  
    Given the user is logged into the SAP system with authorized credentials  
    And the user navigates to the Billing Correction Request creation module  
    And the user selects the document type as ZRK1  
    And the user assigns an invalid value bucket to the request  
    And the user enters mandatory fields such as customer ID, invoice number, and request details  
    When the user submits the ZRK1 request for workflow routing  
    Then the system rejects the ZRK1 request and displays an error message indicating the invalid value bucket  
    And no workflow is initiated for the rejected request  
    And the error message details are logged in the system for audit purposes  
    When the user edits the rejected request and assigns a valid value bucket  
    And the user resubmits the corrected ZRK1 request for workflow routing  
    Then the system accepts the corrected ZRK1 request  
    And the workflow is triggered as per the configured rules
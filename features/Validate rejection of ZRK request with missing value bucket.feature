Feature: Validate rejection of ZRK request with missing value bucket  
  Ensure that the system rejects a ZRK request when the value bucket is missing.  

  @TC-240  
  Scenario Outline: Validate ZRK request submission with various value bucket inputs  
    Given the user is logged into the SAP system with authorized credentials  
    And the user navigates to the Billing Correction Request creation module  
    And the user selects the document type as ZRK  
    And the user enters other mandatory fields such as customer ID, invoice number, and request details  
    When the user submits the ZRK request for workflow routing with the value bucket "<value_bucket>"  
    Then the system should respond with "<validation_response>"  
    And "<workflow_status>" should occur  
    And "<log_status>" should be recorded in the system logs  

    Examples:  
      | value_bucket | validation_response                     | workflow_status         | log_status               |  
      |              | Error: Missing value bucket            | No workflow is triggered | Error message logged     |  
      | ValidBucket  | Request submitted successfully          | Workflow is triggered    | Request details logged   |  

  @TC-240  
  Scenario: Validate editing and resubmission of rejected ZRK request  
    Given the user is logged into the SAP system with authorized credentials  
    And the user navigates to the Billing Correction Request creation module  
    And the user selects the document type as ZRK  
    And the user enters other mandatory fields such as customer ID, invoice number, and request details  
    And the user submits the ZRK request for workflow routing with the value bucket left blank  
    And the system rejects the ZRK request and displays an error message indicating the missing value bucket  
    When the user edits the rejected ZRK request and enters a valid value bucket  
    And the user resubmits the corrected ZRK request for workflow routing  
    Then the corrected ZRK request is submitted successfully  
    And the workflow is triggered as per the configured rules
Feature: Validate system rejection of negative values in Credit Memo Requests  
  Ensure the system rejects Credit Memo Requests with negative values and displays appropriate error messages. Workflow configuration for Credit Memo Requests is set up as per the policy.

  @TC-471
  Scenario Outline: User creates a Credit Memo Request with different value inputs
    Given the user logs in to SAP Fiori with valid credentials  
    And the user navigates to the Credit Memo Request creation application  
    When the user selects Document Type "<DocumentType>"  
    And the user enters "<Value>" in the value field  
    And the user submits the Credit Memo Request  
    Then the system "<SystemResponse>"  

    Examples:  
      | DocumentType | Value    | SystemResponse                                |  
      | ZCR          | -10,000  | rejects the submission with an error message  |  
      | ZCR          | 10,000   | accepts the request and triggers the workflow |  

  @TC-471
  Scenario: User modifies a rejected Credit Memo Request and resubmits  
    Given the user logs in to SAP Fiori with valid credentials  
    And the user navigates to the Credit Memo Request creation application  
    And the user selects Document Type "ZCR"  
    And the user enters "-10,000" in the value field  
    When the user submits the Credit Memo Request  
    Then the system rejects the submission with an error message  
    When the user modifies the value to "10,000"  
    And the user resubmits the Credit Memo Request  
    Then the system accepts the request and triggers the workflow  

  @TC-471
  Scenario: Approver reviews and approves the submitted Credit Memo Request  
    Given the workflow is triggered and the Credit Memo Request is routed for approval  
    When the approver logs in and reviews the submitted request  
    Then the approver is able to view and review the request  
    When the approver approves the Credit Memo Request  
    Then the request is approved successfully, and the status is updated  
    And the approved request proceeds to the next stage in the workflow  
    And the request is visible in the system with updated status
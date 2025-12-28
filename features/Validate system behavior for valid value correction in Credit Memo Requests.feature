Feature: Validate system behavior for valid value correction in Credit Memo Requests  
  Ensure the system allows correction of invalid values to valid ones in Credit Memo Requests. Workflow configuration for Credit Memo Requests is set up as per the policy.  

  @TC-472  
  Scenario: User logs in to SAP Fiori and navigates to the Credit Memo Request creation application  
    Given the user has valid credentials  
    When the user logs in to SAP Fiori  
    Then the user is successfully logged in and navigates to the SAP Fiori homepage  
    And the user has appropriate authorization to create Credit Memo Requests  

  @TC-472  
  Scenario: User selects the Credit Memo Request creation application  
    Given the user is on the SAP Fiori homepage  
    When the user navigates to the Credit Memo Request creation application  
    Then the Credit Memo Request creation application is displayed  

  @TC-472  
  Scenario: User selects Document Type ZCR  
    Given the user is in the Credit Memo Request creation application  
    When the user selects Document Type ZCR  
    Then Document Type ZCR is selected successfully  

  @TC-472  
  Scenario Outline: User enters a value in the Credit Memo Request and submits it  
    Given the user is in the Credit Memo Request creation application and Document Type ZCR is selected  
    When the user enters "<value>" in the value field  
    And the user submits the Credit Memo Request  
    Then the system "<system_response>"  

    Examples:  
      | value    | system_response                                                                 |  
      | -10,000  | rejects the submission and displays an error message indicating negative values are not allowed |  
      | 10,000   | accepts the request and triggers the workflow                                   |  

  @TC-472  
  Scenario: User modifies an invalid value to a valid one and resubmits  
    Given the user has submitted a Credit Memo Request with an invalid value  
    When the user modifies the value to a valid positive number (e.g., 10,000)  
    And the user resubmits the Credit Memo Request  
    Then the system accepts the request and triggers the workflow  

  @TC-472  
  Scenario: Workflow is triggered and routed for approval  
    Given the Credit Memo Request has been successfully submitted  
    When the system triggers the workflow  
    Then the request is routed to the designated approver  

  @TC-472  
  Scenario: Approver reviews and approves the Credit Memo Request  
    Given the approver logs in to SAP Fiori  
    When the approver navigates to the submitted Credit Memo Request  
    Then the approver can view and review the submitted request  
    When the approver approves the Credit Memo Request  
    Then the request is approved successfully and the status is updated  

  @TC-472  
  Scenario: Approved Credit Memo Request proceeds to the next stage  
    Given the Credit Memo Request is approved  
    When the system processes the approved request  
    Then the request proceeds to the next stage in the workflow  

  @TC-472  
  Scenario: Approved Credit Memo Request is visible with updated status  
    Given the Credit Memo Request has been processed to the next stage  
    When the user checks the system for the request  
    Then the request is visible with the updated status and no errors
Feature: Validate workflow triggering for Credit Memo Requests with valid values  
  Ensure the workflow triggers correctly for Credit Memo Requests with valid values. Workflow configuration for Credit Memo Requests is set up as per the policy.

  @TC-473
  Scenario Outline: Validate Credit Memo Request creation and workflow triggering  
    Given the user logs in to SAP Fiori with valid credentials  
    And the user navigates to the Credit Memo Request creation application  
    When the user selects Document Type "<DocumentType>"  
    And the user enters a value of "<Value>" in the value field  
    And the user submits the Credit Memo Request  
    Then the system triggers the workflow and routes the request for approval  
    When the approver logs in and reviews the submitted request  
    And the approver approves the Credit Memo Request  
    Then the request status is updated and proceeds to the next stage in the workflow  
    And the request is visible in the system with updated status  
    And the request is processed further in the financial system without errors  
    And the audit log displays all actions taken on the request with timestamps  

    Examples:  
      | DocumentType | Value   |  
      | ZCR          | 10000   |
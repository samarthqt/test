Feature: Validate Routing of Credit Memo Requests at Maximum Threshold  
  Ensure that Credit Memo Requests at the maximum threshold value are routed correctly. Workflow configuration for Credit Memo Requests must be set up as per the policy.  

  @TC-239  
  Scenario: User logs in to the SAP Fiori app  
    Given the user has appropriate credentials  
    When the user logs in to the SAP Fiori app  
    Then the user is successfully logged in and navigates to the SAP Fiori dashboard  

  @TC-239  
  Scenario: User navigates to the Credit Memo Request creation app  
    Given the user is logged in to the SAP Fiori app  
    When the user navigates to the Credit Memo Request creation app  
    Then the Credit Memo Request creation screen is displayed  

  @TC-239  
  Scenario Outline: User selects document type and enters Credit Memo Request value  
    Given the user is on the Credit Memo Request creation screen  
    When the user selects Document Type as "<DocumentType>"  
    And the user enters a value of "<Value>"  
    Then the Document Type and value are entered successfully  

    Examples:  
      | DocumentType | Value     |  
      | ZCR          | 1,000,000 |  

  @TC-239  
  Scenario: User submits the Credit Memo Request  
    Given the user has entered the required details for the Credit Memo Request  
    When the user submits the Credit Memo Request  
    Then the system routes the request to Reviewer Laura T and Approver Kim B for three-level approval  

  @TC-239  
  Scenario: Reviewer Laura T reviews and approves the Credit Memo Request  
    Given the Credit Memo Request has been routed to Reviewer Laura T  
    When the user logs in as Reviewer Laura T and accesses the workflow inbox  
    Then the Credit Memo Request is visible in the workflow inbox  
    When the user reviews the Credit Memo Request details and approves it  
    Then the request is successfully approved by Reviewer Laura T  

  @TC-239  
  Scenario: Approver Kim B reviews and approves the Credit Memo Request  
    Given the Credit Memo Request has been routed to Approver Kim B  
    When the user logs in as Approver Kim B and accesses the workflow inbox  
    Then the Credit Memo Request is visible in the workflow inbox  
    When the user reviews the Credit Memo Request details and approves it  
    Then the request is successfully approved by Approver Kim B  

  @TC-239  
  Scenario: Verify the status of the Credit Memo Request  
    Given the Credit Memo Request has been approved by the required approvers  
    When the user verifies the status of the Credit Memo Request  
    Then the status of the Credit Memo Request is updated to 'Released for Billing'  

  @TC-239  
  Scenario: Validate the workflow log for routing sequence  
    Given the Credit Memo Request has been processed  
    When the user checks the workflow log  
    Then the workflow log shows that the request was routed to the correct Reviewer and Approver  

  @TC-239  
  Scenario: Verify the document flow for the Credit Memo Request  
    Given the Credit Memo Request has been processed  
    When the user verifies the document flow for the Credit Memo Request  
    Then the document flow shows the correct linkage and statuses  

  @TC-239  
  Scenario: Validate Credit Memo Request appears in the billing due list  
    Given the Credit Memo Request has been released for billing  
    When the user checks the billing due list  
    Then the Credit Memo Request is listed in the billing due list for further processing
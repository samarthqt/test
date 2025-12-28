Feature: Validate Routing of Credit Memo Requests at Minimum Threshold  
  Ensure that Credit Memo Requests at the minimum threshold value are routed correctly. Workflow configuration for Credit Memo Requests must be set up as per the policy.

  @TC-238
  Scenario: User logs in to SAP Fiori app and navigates to the dashboard  
    Given the user has appropriate credentials  
    When the user logs in to the SAP Fiori app  
    Then the user is successfully logged in and navigates to the SAP Fiori dashboard  

  @TC-238
  Scenario: User navigates to the Credit Memo Request creation app  
    Given the user is on the SAP Fiori dashboard  
    When the user navigates to the Credit Memo Request creation app  
    Then the Credit Memo Request creation screen is displayed  

  @TC-238
  Scenario Outline: User selects Document Type and enters value  
    Given the user has appropriate authorization to create Credit Memo Requests  
    When the user selects Document Type as "<Document_Type>" and enters a value of "<Value>"  
    Then the Document Type and value are entered successfully  

    Examples:  
      | Document_Type | Value |  
      | ZCR           | 1     |  

  @TC-238
  Scenario: User submits the Credit Memo Request  
    Given the user has entered the Document Type and value  
    When the user submits the Credit Memo Request  
    Then the system routes the request to Reviewer Laura T and Approver Kim B  

  @TC-238
  Scenario: Reviewer Laura T reviews and approves the Credit Memo Request  
    Given the user is logged in as Reviewer Laura T  
    And the Credit Memo Request is visible in the workflow inbox  
    When the user reviews the Credit Memo Request details and approves it  
    Then the request is successfully approved by Reviewer Laura T  

  @TC-238
  Scenario: Approver Kim B reviews and approves the Credit Memo Request  
    Given the user is logged in as Approver Kim B  
    And the Credit Memo Request is visible in the workflow inbox  
    When the user reviews the Credit Memo Request details and approves it  
    Then the request is successfully approved by Approver Kim B  

  @TC-238
  Scenario: Verify the status of the Credit Memo Request  
    Given the Credit Memo Request has been approved by the Reviewer and Approver  
    When the user verifies the status of the Credit Memo Request  
    Then the status of the Credit Memo Request is updated to 'Released for Billing'  

  @TC-238
  Scenario: Check the workflow log for routing sequence  
    Given the Credit Memo Request has been approved  
    When the user checks the workflow log  
    Then the workflow log shows that the request was routed to the correct Reviewer and Approver  

  @TC-238
  Scenario: Verify the document flow for the Credit Memo Request  
    Given the Credit Memo Request has been processed  
    When the user verifies the document flow for the Credit Memo Request  
    Then the document flow shows the correct linkage and statuses  

  @TC-238
  Scenario: Validate that the Credit Memo Request appears in the billing due list  
    Given the Credit Memo Request has been released for billing  
    When the user checks the billing due list  
    Then the Credit Memo Request is listed in the billing due list for further processing
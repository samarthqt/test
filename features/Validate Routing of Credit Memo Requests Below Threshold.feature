Feature: Validate Routing of Credit Memo Requests Below Threshold  
  Ensure that Credit Memo Requests below the threshold value are routed correctly to the designated approver. Workflow configuration for Credit Memo Requests must be set up as per the policy.

  @TC-235
  Scenario: User logs in to the SAP Fiori app  
    Given the user has appropriate credentials  
    When the user logs in to the SAP Fiori app  
    Then the user is navigated to the SAP Fiori dashboard  

  @TC-235
  Scenario: User navigates to the Credit Memo Request creation app  
    Given the user is logged in and has appropriate authorization  
    When the user navigates to the Credit Memo Request creation app  
    Then the Credit Memo Request creation screen is displayed  

  @TC-235
  Scenario Outline: User creates a Credit Memo Request with specific document type and value  
    Given the user is on the Credit Memo Request creation screen  
    When the user selects Document Type as "<DocumentType>" and enters a value of "<Value>"  
    Then the Document Type and value are entered successfully  
    And the Credit Memo Request is assigned to the designated Reviewer "<Reviewer>"  

    Examples:  
      | DocumentType | Value   | Reviewer  |  
      | ZCR          | 200000  | Laura T   |  

  @TC-235
  Scenario: User submits the Credit Memo Request  
    Given the user has entered the Credit Memo Request details  
    When the user submits the Credit Memo Request  
    Then the system routes the request to the designated approver for two-level approval  
    And the designated Approver is "Kim B"  

  @TC-235
  Scenario: Reviewer logs in and accesses the workflow inbox  
    Given the Credit Memo Request has been routed to the Reviewer  
    When the Reviewer logs in and accesses the workflow inbox  
    Then the Credit Memo Request is visible in the workflow inbox  

  @TC-235
  Scenario: Reviewer approves the Credit Memo Request  
    Given the Reviewer has accessed the Credit Memo Request details  
    When the Reviewer approves the Credit Memo Request  
    Then the request is successfully approved by the Reviewer  

  @TC-235
  Scenario: Approver logs in and accesses the workflow inbox  
    Given the Credit Memo Request has been approved by the Reviewer  
    When the Approver logs in and accesses the workflow inbox  
    Then the Credit Memo Request is visible in the workflow inbox  

  @TC-235
  Scenario: Approver approves the Credit Memo Request  
    Given the Approver has accessed the Credit Memo Request details  
    When the Approver approves the Credit Memo Request  
    Then the request is successfully approved by the Approver  

  @TC-235
  Scenario: Verify the status of the Credit Memo Request  
    Given the Credit Memo Request has been approved by the Approver  
    When the user verifies the status of the Credit Memo Request  
    Then the status of the Credit Memo Request is updated to "Released for Billing"  

  @TC-235
  Scenario: Check the workflow log for routing sequence  
    Given the Credit Memo Request has been processed through the workflow  
    When the user checks the workflow log  
    Then the workflow log shows the request was routed to the correct Reviewer and Approver  

  @TC-235
  Scenario: Verify the document flow for the Credit Memo Request  
    Given the Credit Memo Request has been processed  
    When the user verifies the document flow  
    Then the document flow shows the correct linkage and statuses  

  @TC-235
  Scenario: Validate the Credit Memo Request appears in the billing due list  
    Given the Credit Memo Request has been released for billing  
    When the user checks the billing due list  
    Then the Credit Memo Request is listed in the billing due list for further processing
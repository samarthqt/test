Feature: Verify edge-case behavior when attempting to edit a Credit Memo Request after rejection  
  Ensure the system allows editing of a Credit Memo Request after it is rejected, following the correct process.

  @TC-487  
  Scenario: User logs into the SAP system with permissions to create Credit Memo Requests  
    Given the user has a valid account with permissions to create Credit Memo Requests  
    When the user logs into the SAP system  
    Then the user is successfully logged into the SAP system  

  @TC-487  
  Scenario: User navigates to the transaction for creating a Credit Memo Request  
    Given the user is logged into the SAP system  
    When the user navigates to the transaction for creating a Credit Memo Request  
    Then the Credit Memo Request creation screen is displayed  

  @TC-487  
  Scenario: User completes required fields and saves the Credit Memo Request  
    Given the user is on the Credit Memo Request creation screen  
    When the user enters all required fields such as reference billing document and reason for request  
    And the user saves the Credit Memo Request  
    Then the Credit Memo Request is successfully created and saved  
    And a unique document number is generated  

  @TC-487  
  Scenario: User submits the Credit Memo Request for approval  
    Given the Credit Memo Request is successfully created  
    When the user submits the Credit Memo Request for approval  
    Then the Credit Memo Request is successfully submitted for approval  

  @TC-487  
  Scenario: User rejects the Credit Memo Request using the workflow process  
    Given the Credit Memo Request is submitted for approval  
    When the user rejects the Credit Memo Request using the workflow process  
    Then the Credit Memo Request is successfully rejected  

  @TC-487  
  Scenario Outline: User attempts to edit the rejected Credit Memo Request  
    Given the Credit Memo Request has been rejected  
    When the user attempts to edit the Credit Memo Request  
    Then the system allows editing of the Credit Memo Request based on the next process steps  

  @TC-487  
  Scenario Outline: System maintains a record of the rejection status  
    Given the Credit Memo Request has been rejected  
    When the user views the rejection status of the Credit Memo Request  
    Then the system maintains a complete record of the rejection status  

  @TC-487  
  Scenario Outline: System displays notification for editable Credit Memo Request  
    Given the Credit Memo Request has been rejected  
    When the user views the notification for the Credit Memo Request  
    Then the system displays a notification indicating that the Credit Memo Request is editable after rejection  

  @TC-487  
  Scenario Outline: System logs unauthorized attempts to edit rejected Credit Memo Requests  
    Given the Credit Memo Request has been rejected  
    When the system logs are checked  
    Then the system logs show no unauthorized edits were made during the workflow process  

  @TC-487  
  Scenario Outline: System allows modifications to the rejected Credit Memo Request  
    Given the Credit Memo Request has been rejected  
    When the user modifies the Credit Memo Request data  
    Then the system successfully allows modifications to the Credit Memo Request  

  @TC-487  
  Scenario Outline: System displays error message for unauthorized users  
    Given the Credit Memo Request has been rejected  
    When an unauthorized user attempts to edit the rejected Credit Memo Request  
    Then the system displays an error message indicating the user does not have permissions to edit the rejected Credit Memo Request  

  @TC-487  
  Scenario Outline: System maintains data integrity throughout the workflow process  
    Given the Credit Memo Request has been rejected  
    When the workflow process is completed  
    Then the system maintains the data integrity of the Credit Memo Request without any unauthorized changes
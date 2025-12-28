Feature: Creation of Debit Memo Request - Auto-Population Validation  
  To ensure that header and item details are correctly auto-populated from the referenced billing document during Debit Memo Request creation.  

  @TC-469  
  Scenario: User logs into SAP Fiori system with appropriate credentials  
    Given the user has appropriate authorization to create Debit Memo Requests  
    When the user logs into the SAP Fiori system  
    Then the user is successfully logged into the SAP Fiori system  

  @TC-469  
  Scenario: User navigates to the Debit Memo Request creation app  
    Given the user is logged into the SAP Fiori system  
    When the user navigates to the app for creating Debit Memo Requests  
    Then the Debit Memo Request creation screen is displayed  

  @TC-469  
  Scenario Outline: User enters a Billing Document number as a reference  
    Given the user is on the Debit Memo Request creation screen  
    When the user enters the Billing Document number "<Billing Document Number>" as a reference  
    Then the system accepts the Billing Document number and moves to the next step  

    Examples:  
      | Billing Document Number |  
      | BD-67890                |  

  @TC-469  
  Scenario: System auto-populates header details from the referenced Billing Document  
    Given the user has entered a valid Billing Document number  
    When the system retrieves the details from the referenced Billing Document  
    Then the system auto-populates the header details such as Customer Name, Address, and Billing Date  

  @TC-469  
  Scenario: System auto-populates item details from the referenced Billing Document  
    Given the user has entered a valid Billing Document number  
    When the system retrieves the details from the referenced Billing Document  
    Then the system auto-populates the item details such as Material Number, Quantity, and Amount  

  @TC-469  
  Scenario Outline: User edits an auto-populated field and saves the Debit Memo Request  
    Given the user is on the Debit Memo Request creation screen with auto-populated fields  
    When the user edits the field "<Field Name>" with value "<Updated Value>"  
    And the user saves the changes  
    Then the system accepts the changes and saves the Debit Memo Request  

    Examples:  
      | Field Name | Updated Value |  
      | Quantity   | 50            |  

  @TC-469  
  Scenario: User submits the Debit Memo Request  
    Given the user has saved the Debit Memo Request  
    When the user submits the Debit Memo Request  
    Then the Debit Memo Request is submitted successfully  

  @TC-469  
  Scenario: Changes made to auto-populated fields are reflected in the submitted Debit Memo Request  
    Given the Debit Memo Request has been submitted  
    When the user reviews the submitted Debit Memo Request  
    Then the submitted Debit Memo Request includes the updated field values  

  @TC-469  
  Scenario: Workflow logs confirm the Debit Memo Request has entered the workflow  
    Given the Debit Memo Request has been submitted  
    When the user checks the workflow logs  
    Then the workflow logs indicate that the Debit Memo Request has been successfully submitted  

  @TC-469  
  Scenario: Reviewer reviews the Debit Memo Request  
    Given the Reviewer logs into SAP Fiori  
    When the Reviewer navigates to the submitted Debit Memo Request  
    Then the Reviewer is able to view the updated Debit Memo Request  

  @TC-469  
  Scenario: Reviewer approves the Debit Memo Request  
    Given the Reviewer has reviewed the Debit Memo Request  
    When the Reviewer approves the Debit Memo Request  
    Then the Debit Memo Request is approved and moves to the Approver  

  @TC-469  
  Scenario: Debit Memo Request is released for Billing after approval  
    Given the Debit Memo Request has been approved  
    When the system processes the approval  
    Then the Debit Memo Request is released for Billing and visible in the billing queue
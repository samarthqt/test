Feature: Validate handling of maximum line items in consolidated billing - Boundary Condition at 999 Line Items  
  Ensure the system processes exactly 999 line items without triggering document splitting.  

  @TC-168  
  Scenario: User logs into the SAP S/4HANA Cloud system and navigates to the Billing Due Program  
    Given the user has valid credentials for the SAP S/4HANA Cloud system  
    When the user logs into the system  
    Then the user is successfully logged in and has access to the Finance module  
    And the Billing Due Program is active and accessible  

  @TC-168  
  Scenario Outline: Validate input of attributes and execution of Billing Due Program with 999 line items  
    Given the user is on the Billing Due Program screen  
    When the user inputs Attribute 1 as "<Attribute1>" and Attribute 2 as "<Attribute2>"  
    And the user loads test data with exactly "<LineItems>" line items  
    And the user executes the Billing Due Program  
    Then the program executes without errors  
    And the system creates a single billing document with all "<LineItems>" line items  
    And the document flow shows correct linkage to the source document  
    And all "<LineItems>" line items are accounted for in the billing document  
    And the system generates accounting postings for the billing document  
    And no errors or warnings are observed in the system logs  

    Examples:  
      | Attribute1 | Attribute2 | LineItems |  
      | ZC         | 30         | 999       |  

  @TC-168  
  Scenario: Generate and validate the accuracy of the billing document report  
    Given the user has successfully created a billing document with 999 line items  
    When the user generates a report summarizing the billing document  
    Then the report accurately reflects the billing document details and line item distribution
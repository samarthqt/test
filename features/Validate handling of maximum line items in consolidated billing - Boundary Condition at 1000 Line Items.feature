Feature: Validate handling of maximum line items in consolidated billing - Boundary Condition at 1000 Line Items  
  Ensure the system splits the billing document at the 1000th line item, maintaining data integrity.

  @TC-169
  Scenario: User logs into the SAP S/4HANA Cloud system and accesses the Billing Due Program  
    Given the user has valid credentials  
    When the user logs into the SAP S/4HANA Cloud system  
    Then the user is successfully logged in and has access to the Finance module  

    When the user navigates to the Billing Due Program  
    Then the Billing Due Program screen is displayed  

  @TC-169
  Scenario Outline: User inputs attributes and loads test data for billing  
    Given the user is on the Billing Due Program screen  
    When the user inputs Attribute 1 as "<Attribute1>" and Attribute 2 as "<Attribute2>"  
    Then the attributes are correctly entered and accepted by the system  

    When the user loads test data with exactly <LineItems> line items  
    Then the test data is successfully loaded into the system  

    Examples:  
      | Attribute1 | Attribute2 | LineItems |  
      | ZC         | 30         | 1000      |  

  @TC-169
  Scenario: User executes the Billing Due Program  
    Given the user has loaded test data with 1000 line items  
    When the user executes the Billing Due Program  
    Then the program executes without errors  

  @TC-169
  Scenario: Validate the system splits the billing document correctly  
    Given the Billing Due Program has executed successfully  
    When the user verifies the system splits the billing document into two documents with 999 and 1 line items respectively  
    Then the system successfully splits the billing documents as expected  

  @TC-169
  Scenario: Validate document flow linkage between split documents  
    Given the billing documents are split  
    When the user checks the document flow  
    Then the document flow shows correct linkage between the split documents  

  @TC-169
  Scenario: Validate all line items are included without data loss  
    Given the billing documents are split  
    When the user validates that all 1000 line items are included  
    Then all 1000 line items are accounted for in the split documents  

  @TC-169
  Scenario: Validate accounting postings for split documents  
    Given the billing documents are split  
    When the user verifies that the system generates accounting postings for each split document  
    Then accounting postings are correctly generated for both documents  

  @TC-169
  Scenario: Validate system logs for errors or warnings  
    Given the billing documents are split  
    When the user checks the system logs for any errors or warnings during the process  
    Then no errors or warnings are observed in the logs  

  @TC-169
  Scenario: Generate and validate report summarizing the billing document split  
    Given the billing documents are split  
    When the user generates a report summarizing the billing document split  
    Then the report accurately reflects the split details and line item distribution
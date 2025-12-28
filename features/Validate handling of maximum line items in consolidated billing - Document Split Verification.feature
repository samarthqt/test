Feature: Validate handling of maximum line items in consolidated billing - Document Split Verification  
  Ensure that the system accurately splits billing documents into multiple ones when the line items exceed 999, maintaining data integrity and compliance.

  @TC-163
  Scenario: User logs into the SAP S/4HANA Cloud system and accesses the Finance module  
    Given the user has appropriate credentials  
    When the user logs into the SAP S/4HANA Cloud system  
    Then the user is successfully logged in and has access to the Finance module  

  @TC-163
  Scenario: User navigates to the Billing Due Program  
    Given the user is logged into the SAP S/4HANA Cloud system  
    When the user navigates to the Billing Due Program  
    Then the Billing Due Program screen is displayed  

  @TC-163
  Scenario Outline: User inputs attributes and configures the program for document split  
    Given the user is on the Billing Due Program screen  
    When the user inputs Attribute 1 as "<Attribute1>" and Attribute 2 as "<Attribute2>"  
    Then the attributes are correctly entered and accepted by the system  
    When the user configures the program to handle maximum line items exceeding 999  
    Then the program configuration is successfully updated  

    Examples:  
      | Attribute1 | Attribute2 |  
      | ZC         | 30         |  

  @TC-163
  Scenario Outline: User loads test data and executes the Billing Due Program  
    Given the user has configured the program for document split  
    When the user loads test data with "<LineItems>" line items  
    Then the test data is successfully loaded into the system  
    When the user executes the Billing Due Program  
    Then the program executes without errors  

    Examples:  
      | LineItems |  
      | 1500      |  

  @TC-163
  Scenario Outline: System splits billing documents and validates the results  
    Given the Billing Due Program has executed successfully  
    When the user verifies that the system splits the billing document into "<Document1>" and "<Document2>" line items respectively  
    Then the system successfully splits the billing documents as expected  
    When the user checks the document flow to ensure proper linkage between split documents  
    Then the document flow shows correct linkage between the split documents  
    When the user validates that all "<TotalLineItems>" line items are included without any data loss  
    Then all line items are accounted for in the split documents  

    Examples:  
      | Document1 | Document2 | TotalLineItems |  
      | 999       | 501       | 1500           |  

  @TC-163
  Scenario: User verifies accounting postings for split documents  
    Given the billing documents are split successfully  
    When the user verifies that the system generates accounting postings for each split document  
    Then accounting postings are correctly generated for both documents  

  @TC-163
  Scenario: User checks system logs for errors or warnings  
    Given the Billing Due Program has executed successfully  
    When the user checks the system logs for any errors or warnings during the process  
    Then no errors or warnings are observed in the logs  

  @TC-163
  Scenario: User generates and validates the billing document split report  
    Given the billing documents are split successfully  
    When the user generates a report summarizing the billing document split  
    Then the report accurately reflects the split details and line item distribution
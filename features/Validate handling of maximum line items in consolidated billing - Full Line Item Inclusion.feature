Feature: Validate handling of maximum line items in consolidated billing - Full Line Item Inclusion  
  Ensure all line items are included in the split billing documents without any data loss or truncation.  

  @TC-164  
  Scenario: User logs in to the SAP S/4HANA Cloud system with appropriate credentials  
    Given the user has valid credentials  
    When the user logs in to the SAP S/4HANA Cloud system  
    Then the user is successfully logged in and has access to the Finance module  

  @TC-164  
  Scenario: User navigates to the Billing Due Program  
    Given the user is logged in to the SAP S/4HANA Cloud system  
    When the user navigates to the Billing Due Program  
    Then the Billing Due Program screen is displayed  

  @TC-164  
  Scenario Outline: User inputs attributes and configures the program for maximum line items  
    Given the user is on the Billing Due Program screen  
    When the user inputs Attribute 1 as "<Attribute1>" and Attribute 2 as "<Attribute2>"  
    Then the attributes are correctly entered and accepted by the system  
    When the user configures the program to handle maximum line items exceeding "<MaxLineItems>"  
    Then the program configuration is successfully updated  

    Examples:  
      | Attribute1 | Attribute2 | MaxLineItems |  
      | ZC         | 30         | 999          |  

  @TC-164  
  Scenario: User loads test data with 2,000 line items  
    Given the program is configured to handle maximum line items  
    When the user loads test data with 2,000 line items  
    Then the test data is successfully loaded into the system  

  @TC-164  
  Scenario: User executes the Billing Due Program  
    Given the test data with 2,000 line items is loaded  
    When the user executes the Billing Due Program  
    Then the program executes without errors  

  @TC-164  
  Scenario: System splits the billing documents into three documents  
    Given the Billing Due Program has executed successfully  
    When the user verifies the split billing documents  
    Then the system splits the billing document into three documents with 999, 999, and 2 line items respectively  

  @TC-164  
  Scenario: User checks document flow for proper linkage  
    Given the billing documents are split successfully  
    When the user checks the document flow  
    Then the document flow shows correct linkage between the split documents  

  @TC-164  
  Scenario: User validates all line items are included without data loss  
    Given the billing documents are split successfully  
    When the user validates the inclusion of all line items  
    Then all 2,000 line items are accounted for in the split documents  

  @TC-164  
  Scenario: User verifies accounting postings for split documents  
    Given the billing documents are split successfully  
    When the user verifies the accounting postings for each split document  
    Then accounting postings are correctly generated for all documents  

  @TC-164  
  Scenario: User checks system logs for errors or warnings  
    Given the billing documents are split successfully  
    When the user checks the system logs for any errors or warnings during the process  
    Then no errors or warnings are observed in the logs  

  @TC-164  
  Scenario: User generates a report summarizing the billing document split  
    Given the billing documents are split successfully  
    When the user generates a report summarizing the billing document split  
    Then the report accurately reflects the split details and line item distribution
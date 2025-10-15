Feature: Validate handling of maximum line items in consolidated billing - Document Flow Linkage

  @TC-165
  Scenario Outline: Validate the system's ability to handle and split documents with maximum line items in the billing process
    Given the user is logged into the SAP S/4HANA Cloud system with appropriate credentials and has access to the Finance module
    When the user navigates to the Billing Due Program
    And the user inputs Attribute 1 as "<Attribute1>" and Attribute 2 as "<Attribute2>"
    And the user configures the program to handle maximum line items exceeding 999
    And the user loads test data with "<LineItems>" line items
    And the user executes the Billing Due Program
    Then the system splits the billing document into two documents with "<Split1>" and "<Split2>" line items respectively
    And the user navigates to the document flow screen for the first split document
    And the document flow shows correct linkage to the second split document
    And the document flow shows correct linkage to the original source document
    And the system logs do not show any errors or warnings during the process
    And the user generates a report summarizing the document flow, which accurately reflects the document flow details and linkages

    Examples:
      | Attribute1 | Attribute2 | LineItems | Split1 | Split2 |
      | ZC         | 30         | 1200      | 999    | 201    |
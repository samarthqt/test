Feature: Validate system behavior for missing ZOTC_CROSSREFTAB entries for S1 invoices  
  Ensure the system logs errors and prevents processing when ZOTC_CROSSREFTAB entries for S1 invoices are missing.  

  @TC-37  
  Scenario: User navigates to the Direct Sales processing program  
    Given the user is on the application home page  
    When the user navigates to the Direct Sales processing program "ZOTC_SALES_ORDER"  
    Then the Direct Sales processing program is displayed successfully  

  @TC-37  
  Scenario Outline: User creates a sales order using billing document type S1  
    Given the user is on the Direct Sales processing program  
    When the user creates a sales order with billing document type "<BillingDocumentType>"  
    Then the sales order is created successfully with the specified billing document type  

    Examples:  
      | BillingDocumentType |  
      | S1                 |  

  @TC-37  
  Scenario: System logs an error when processing the sales order with missing ZOTC_CROSSREFTAB entries  
    Given the user has created a sales order with billing document type S1  
    When the user processes the sales order  
    Then the system logs an error indicating missing ZOTC_CROSSREFTAB entries for S1 invoices  
    And the system prevents further processing  

  @TC-37  
  Scenario: User navigates to the Indirect Sales processing program  
    Given the user is on the application home page  
    When the user navigates to the Indirect Sales processing program "ZOTC_INDSALES_MDLNE"  
    Then the Indirect Sales processing program is displayed successfully  

  @TC-37  
  Scenario Outline: System logs an error when processing an indirect sales transaction with missing ZOTC_CROSSREFTAB entries  
    Given the user is on the Indirect Sales processing program  
    When the user processes an indirect sales transaction with billing document type "<BillingDocumentType>"  
    Then the system logs an error indicating missing ZOTC_CROSSREFTAB entries for S1 invoices  
    And the system prevents further processing  

    Examples:  
      | BillingDocumentType |  
      | S1                 |  

  @TC-37  
  Scenario: User checks the error logs for missing ZOTC_CROSSREFTAB entries  
    Given the user has attempted to process a sales order or an indirect sales transaction with billing document type S1  
    When the user checks the error logs  
    Then the error logs contain detailed information about the missing ZOTC_CROSSREFTAB entries for S1 invoices  

  @TC-37  
  Scenario: System prevents data transmission to downstream systems due to missing ZOTC_CROSSREFTAB entries  
    Given the user has attempted to process a sales order or an indirect sales transaction with billing document type S1  
    When the user attempts to transmit the data to downstream systems  
    Then the system prevents data transmission due to the missing ZOTC_CROSSREFTAB entries
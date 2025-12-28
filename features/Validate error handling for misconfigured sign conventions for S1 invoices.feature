Feature: Validate error handling for misconfigured sign conventions for S1 invoices  
  Ensure the system logs errors and prevents processing when sign conventions for S1 invoices are misconfigured in ZOTC_SALES_ORDER and ZOTC_INDSALES_MDLNE programs.

  @TC-36
  Scenario: User navigates to the Direct Sales processing program  
    Given the user navigates to the Direct Sales processing program "ZOTC_SALES_ORDER"  
    Then the Direct Sales processing program "ZOTC_SALES_ORDER" is displayed successfully  

  @TC-36
  Scenario Outline: User attempts to create and process sales orders with misconfigured sign conventions  
    Given the user creates a sales order with billing document type "<billing_document_type>"  
    Then the sales order is created successfully with the specified billing document type  
    When the user processes the sales order  
    Then the system detects the misconfigured sign conventions and logs an error, preventing further processing  

    Examples:  
      | billing_document_type |  
      | S1                   |  

  @TC-36
  Scenario: User navigates to the Indirect Sales processing program  
    Given the user navigates to the Indirect Sales processing program "ZOTC_INDSALES_MDLNE"  
    Then the Indirect Sales processing program "ZOTC_INDSALES_MDLNE" is displayed successfully  

  @TC-36
  Scenario Outline: User processes indirect sales transactions with misconfigured sign conventions  
    Given the user processes an indirect sales transaction with billing document type "<billing_document_type>"  
    Then the system detects the misconfigured sign conventions and logs an error, preventing further processing  

    Examples:  
      | billing_document_type |  
      | S1                   |  

  @TC-36
  Scenario: User checks the error logs for misconfigured sign conventions  
    Given the user checks the error logs for details about the misconfiguration  
    Then the error logs contain detailed information about the misconfigured sign conventions for S1 invoices  

  @TC-36
  Scenario: User attempts to transmit data to downstream systems  
    Given the user attempts to transmit the data to downstream systems  
    Then the system prevents data transmission due to the detected misconfiguration
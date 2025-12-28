Feature: Validate edge case for minimum data in S1 invoices  
  Ensure the system handles S1 invoices with the minimum required data and detects misconfigured sign conventions.

  @TC-39  
  Scenario: User navigates to the Direct Sales processing program  
    Given the ZOTC_SALES_ORDER program is configured  
    When the user navigates to the Direct Sales processing program (ZOTC_SALES_ORDER)  
    Then the Direct Sales processing program is displayed successfully  

  @TC-39  
  Scenario Outline: User creates and processes a sales order with billing document type S1  
    Given the ZOTC_CROSSREFTAB table contains mappings for S1 billing document type with incorrect sign conventions  
    When the user creates a sales order using billing document type "<billingDocumentType>" with the minimum required data  
    Then the sales order is created successfully with the specified billing document type and minimum data  
    When the user processes the sales order  
    Then the system processes the sales order and generates a billing document  

    Examples:  
      | billingDocumentType |  
      | S1                 |  

  @TC-39  
  Scenario: User verifies the displayed amount and quantity in the generated billing document  
    Given the system has generated a billing document  
    When the user verifies the displayed amount and quantity in the generated billing document  
    Then the system detects the misconfigured sign conventions and logs an error or warning message  

  @TC-39  
  Scenario: User checks the error logs for details about the misconfiguration  
    Given the system has logged an error or warning message for misconfigured sign conventions  
    When the user checks the error logs for details about the misconfiguration  
    Then the error logs contain detailed information about the misconfigured sign conventions for S1 invoices  

  @TC-39  
  Scenario: User attempts to transmit the billing document data to downstream systems  
    Given the system has detected misconfigured sign conventions in the billing document  
    When the user attempts to transmit the billing document data to downstream systems  
    Then the system prevents data transmission due to the detected misconfiguration  

  @TC-39  
  Scenario: User validates that no incorrect data is transmitted to downstream systems  
    Given the system has prevented data transmission due to detected misconfiguration  
    When the user validates the transmitted data  
    Then no incorrect data is transmitted, ensuring data integrity
Feature: Validate edge case for maximum line items in S1 invoices  
  Ensure the system handles S1 invoices with the maximum number of line items and detects misconfigured sign conventions.

  @TC-38
  Scenario: User navigates to the Direct Sales processing program  
    Given the ZOTC_SALES_ORDER program is configured  
    When the user navigates to the Direct Sales processing program  
    Then the Direct Sales processing program is displayed successfully  

  @TC-38
  Scenario Outline: User creates a sales order with billing document type S1 and maximum line items  
    Given the ZOTC_SALES_ORDER program is configured  
    And the ZOTC_CROSSREFTAB table contains mappings for S1 billing document type with incorrect sign conventions  
    When the user creates a sales order using billing document type "<billingDocumentType>" with "<lineItems>" line items  
    Then the sales order is created successfully with the specified billing document type and line items  

    Examples:  
      | billingDocumentType | lineItems |  
      | S1                 | Maximum   |  

  @TC-38
  Scenario: User processes the sales order  
    Given the sales order with billing document type S1 and maximum line items is created  
    When the user processes the sales order  
    Then the system processes the sales order and generates a billing document  

  @TC-38
  Scenario: User verifies the displayed amount and quantity in the generated billing document  
    Given the billing document is generated for the sales order  
    When the user verifies the displayed amount and quantity in the billing document  
    Then the system detects the misconfigured sign conventions  
    And the system logs an error or warning message  

  @TC-38
  Scenario: User checks the error logs for details about the misconfiguration  
    Given the system has logged an error or warning message  
    When the user checks the error logs  
    Then the error logs contain detailed information about the misconfigured sign conventions for S1 invoices  

  @TC-38
  Scenario: User attempts to transmit the billing document data to downstream systems  
    Given the system has detected misconfigured sign conventions in the billing document  
    When the user attempts to transmit the billing document data to downstream systems  
    Then the system prevents data transmission due to the detected misconfiguration  

  @TC-38
  Scenario: User validates that no incorrect data is transmitted to downstream systems  
    Given the system has prevented data transmission due to the detected misconfiguration  
    When the user validates the transmitted data  
    Then no incorrect data is transmitted, ensuring data integrity
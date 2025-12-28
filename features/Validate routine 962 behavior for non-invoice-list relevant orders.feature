Feature: Validate routine 962 behavior for non-invoice-list relevant orders  
  Ensure routine 962 triggers outputs correctly for non-invoice-list relevant orders. Routine 962 must be created and assigned to the output determination strategy for ZPDT.  

  @TC-315  
  Scenario: User logs in to the SAP system  
    Given the user has valid credentials  
    When the user logs in to the SAP system  
    Then the user is successfully logged in and has access to the relevant modules  

  @TC-315  
  Scenario: User navigates to the sales order creation module  
    Given the user is logged in to the SAP system  
    When the user navigates to the sales order creation module  
    Then the sales order creation screen is displayed  

  @TC-315  
  Scenario Outline: User creates a non-invoice-list relevant order  
    Given the user is on the sales order creation screen  
    When the user creates a non-invoice-list relevant order using "<order ID>"  
    Then the non-invoice-list relevant order is created successfully  

    Examples:  
      | order ID      |  
      | NONINV56789   |  

  @TC-315  
  Scenario: User navigates to the billing workflow module  
    Given the user has created a non-invoice-list relevant order  
    When the user navigates to the billing workflow module  
    Then the billing workflow screen is displayed  

  @TC-315  
  Scenario Outline: User processes the non-invoice-list relevant order through the billing workflow  
    Given the user is on the billing workflow screen  
    When the user processes the created non-invoice-list relevant order with "<order ID>"  
    Then the order is processed successfully without any issues  

    Examples:  
      | order ID      |  
      | NONINV56789   |  

  @TC-315  
  Scenario Outline: Verify routine 962 triggers outputs correctly  
    Given the user has processed a non-invoice-list relevant order with "<order ID>"  
    When the user verifies the output triggered by routine 962  
    Then routine 962 triggers outputs correctly for the non-invoice-list relevant order  

    Examples:  
      | order ID      |  
      | NONINV56789   |  

  @TC-315  
  Scenario Outline: Check the output determination logs  
    Given the user has processed a non-invoice-list relevant order with "<order ID>"  
    When the user checks the output determination logs for the processed order  
    Then the logs confirm that outputs were triggered for the non-invoice-list relevant order  

    Examples:  
      | order ID      |  
      | NONINV56789   |  

  @TC-315  
  Scenario Outline: Validate the document flow for the processed order  
    Given the user has processed a non-invoice-list relevant order with "<order ID>"  
    When the user validates the document flow for the processed order  
    Then the document flow shows output-related entries for routine 962  

    Examples:  
      | order ID      |  
      | NONINV56789   |  

  @TC-315  
  Scenario: Verify output determination strategy for ZPDT configuration  
    Given the user is in the billing workflow module  
    When the user verifies the output determination strategy for ZPDT  
    Then the output determination strategy for ZPDT is correctly configured and routine 962 is assigned  

  @TC-315  
  Scenario Outline: Validate master data for the created order  
    Given the user has created a non-invoice-list relevant order with "<order ID>"  
    When the user validates the master data for the created order  
    Then the master data reflects the non-invoice-list relevancy attribute correctly  

    Examples:  
      | order ID      |  
      | NONINV56789   |  

  @TC-315  
  Scenario: Document the results of the test case execution  
    Given the user has completed the test case execution  
    When the user documents the results  
    Then the test case results are documented successfully  

  @TC-315  
  Scenario: User logs out of the SAP system  
    Given the user has completed all tasks  
    When the user logs out of the SAP system  
    Then the user is logged out successfully
Feature: Validate routine 962 behavior with incorrect invoice relevancy check  
  Ensure routine 962 does not trigger outputs for invoice-list relevant orders when the invoice relevancy check is not removed. Routine 962 must be created but with the invoice relevancy check still included.  

  @TC-317  
  Scenario: User logs in to the SAP system with appropriate credentials  
    Given the user has valid credentials  
    When the user logs in to the SAP system  
    Then the user is successfully logged in and has access to the relevant modules  

  @TC-317  
  Scenario: User navigates to the sales order creation module  
    Given the user is logged in to the SAP system  
    When the user navigates to the sales order creation module  
    Then the sales order creation screen is displayed  

  @TC-317  
  Scenario: User creates an invoice-list relevant order  
    Given the user is on the sales order creation screen  
    When the user creates an invoice-list relevant order using the provided test data  
    Then the invoice-list relevant order is created successfully  

  @TC-317  
  Scenario: User navigates to the billing workflow module  
    Given the user has created an invoice-list relevant order  
    When the user navigates to the billing workflow module  
    Then the billing workflow screen is displayed  

  @TC-317  
  Scenario: User processes the created invoice-list relevant order through the billing workflow  
    Given the user is on the billing workflow screen  
    When the user processes the created invoice-list relevant order through the billing workflow  
    Then the order is processed successfully without any issues  

  @TC-317  
  Scenario: User verifies if routine 962 incorrectly triggers outputs  
    Given the user has processed the invoice-list relevant order  
    When the user verifies routine 962 behavior  
    Then routine 962 incorrectly triggers outputs for the invoice-list relevant order, indicating a failure in removing the invoice relevancy check  

  @TC-317  
  Scenario: User checks the output determination logs  
    Given the user has verified routine 962 behavior  
    When the user checks the output determination logs for the processed order  
    Then the logs confirm that outputs were incorrectly triggered for the invoice-list relevant order  

  @TC-317  
  Scenario: User validates the document flow for the processed order  
    Given the user has checked the output determination logs  
    When the user validates the document flow for the processed order  
    Then the document flow shows incorrect output-related entries for routine 962  

  @TC-317  
  Scenario: User verifies the configuration of routine 962  
    Given the user has validated the document flow  
    When the user verifies the configuration of routine 962 in the output determination strategy  
    Then routine 962 is found to have the invoice relevancy check still included  

  @TC-317  
  Scenario: User documents the results of the test case execution  
    Given the user has verified the configuration of routine 962  
    When the user documents the results of the test case execution  
    Then the test case results are documented successfully  

  @TC-317  
  Scenario: User logs out of the SAP system  
    Given the user has completed all test case validations  
    When the user logs out of the SAP system  
    Then the user is logged out successfully
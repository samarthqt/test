Feature: Validate routine 962 behavior with null invoice relevancy attribute  
  Ensure routine 962 handles orders with null invoice relevancy attributes gracefully. Routine 962 must be created and assigned to the output determination strategy for ZPDT.  

  @TC-320  
  Scenario: User logs in to the SAP system with appropriate credentials  
    Given the user has valid credentials  
    When the user logs in to the SAP system  
    Then the user is successfully logged in and has access to the relevant modules  

  @TC-320  
  Scenario: User navigates to the sales order creation module  
    Given the user is logged in to the SAP system  
    When the user navigates to the sales order creation module  
    Then the sales order creation screen is displayed  

  @TC-320  
  Scenario Outline: User creates an order with null invoice relevancy attribute  
    Given the user is on the sales order creation screen  
    When the user creates an order with "<Order ID>" and null invoice relevancy attribute  
    Then the order with null invoice relevancy attribute is created successfully  

    Examples:  
      | Order ID          |  
      | NULLATTR12345     |  

  @TC-320  
  Scenario: User navigates to the billing workflow module  
    Given the user has created an order with null invoice relevancy attribute  
    When the user navigates to the billing workflow module  
    Then the billing workflow screen is displayed  

  @TC-320  
  Scenario: User processes the created order through the billing workflow  
    Given the user is on the billing workflow screen  
    When the user processes the created order through the billing workflow  
    Then the order is processed successfully without any issues  

  @TC-320  
  Scenario: Verify how routine 962 handles the null invoice relevancy attribute during output determination  
    Given the user has processed the order with null invoice relevancy attribute  
    When the user verifies how routine 962 handles the null invoice relevancy attribute during output determination  
    Then routine 962 handles the null invoice relevancy attribute gracefully without causing errors  

  @TC-320  
  Scenario: Check the output determination logs for the processed order  
    Given the user has processed the order with null invoice relevancy attribute  
    When the user checks the output determination logs for the processed order  
    Then the logs confirm that routine 962 handled the null invoice relevancy attribute without issues  

  @TC-320  
  Scenario: Validate the document flow for the processed order  
    Given the user has processed the order with null invoice relevancy attribute  
    When the user validates the document flow for the processed order  
    Then the document flow reflects the correct output determination behavior for the order  

  @TC-320  
  Scenario: Verify the output determination strategy configuration for ZPDT  
    Given the user has access to the output determination strategy configuration  
    When the user verifies the output determination strategy configuration for ZPDT  
    Then the output determination strategy for ZPDT is correctly configured and routine 962 is assigned  

  @TC-320  
  Scenario: Document the results of the test case execution  
    Given the user has completed the test case execution  
    When the user documents the results of the test case execution  
    Then the test case results are documented successfully  

  @TC-320  
  Scenario: User logs out of the SAP system  
    Given the user has completed all required actions  
    When the user logs out of the SAP system  
    Then the user is logged out successfully
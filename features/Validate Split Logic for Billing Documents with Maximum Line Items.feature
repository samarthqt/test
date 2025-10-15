Feature: Validate Split Logic for Billing Documents with Maximum Line Items  
  Test system behavior when billing documents involve maximum line items. Copy control routine for split logic implemented and assigned to relevant billing document types.

  @TC-209
  Scenario: User logs into the SAP S/4HANA system with appropriate authorization for billing document creation  
    Given the user has valid credentials and authorization  
    When the user logs into the SAP S/4HANA system  
    Then the user should successfully access the billing module  

  @TC-209
  Scenario Outline: Create a sales order with specified attributes and maximum line items  
    Given the user is in the billing module  
    When the user creates a sales order with PMF site "<PMF_Site>", price type "<Price_Type>", and includes "<Line_Items>" line items  
    Then the sales order should be created successfully with the specified attributes and line items  

    Examples:  
      | PMF_Site | Price_Type | Line_Items |  
      | PMF001   | Standard   | 999        |  

  @TC-209
  Scenario: Execute the billing process to generate billing documents  
    Given the user has created a sales order with maximum line items  
    When the user executes the billing process  
    Then the billing documents should be generated successfully without errors  

  @TC-209
  Scenario Outline: Validate billing document split logic based on PMF site and price type  
    Given the billing documents are generated  
    When the user validates the split logic for PMF site "<PMF_Site>" and price type "<Price_Type>"  
    Then the billing documents should be split correctly based on the specified PMF site and price type  

    Examples:  
      | PMF_Site | Price_Type |  
      | PMF001   | Standard   |  

  @TC-209
  Scenario: Check that all line items are processed accurately  
    Given the billing documents are generated  
    When the user checks the processing of all line items  
    Then all 999 line items should be processed without errors or omissions  

  @TC-209
  Scenario: Verify the document flow for the billing documents  
    Given the billing documents are generated  
    When the user verifies the document flow  
    Then the document flow should display accurate linkage between the sales order and billing documents  

  @TC-209
  Scenario: Check the accounting postings for each billing document  
    Given the billing documents are generated  
    When the user checks the accounting postings  
    Then the accounting postings should be accurate and comply with the defined logic  

  @TC-209
  Scenario: Verify the tax calculations for the billing documents  
    Given the billing documents are generated  
    When the user verifies the tax calculations  
    Then the tax calculations should be accurate and comply with business rules  

  @TC-209
  Scenario: Validate the invoice output format for the billing documents  
    Given the billing documents are generated  
    When the user validates the invoice output format  
    Then the invoice output format should meet the defined standards  

  @TC-209
  Scenario: Check the system performance during the billing process  
    Given the billing documents are generated  
    When the user monitors the system performance during the billing process  
    Then the system performance should be stable and efficient  

  @TC-209
  Scenario: Verify the customer communication records for the billing documents  
    Given the billing documents are generated  
    When the user verifies the customer communication records  
    Then the customer communication records should be updated accurately for each document  

  @TC-209
  Scenario: Ensure the split logic configuration matches business requirements  
    Given the billing documents are generated  
    When the user verifies the split logic configuration in the system  
    Then the split logic configuration should match the business requirements
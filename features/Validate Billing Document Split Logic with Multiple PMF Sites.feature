Feature: Validate Billing Document Split Logic with Multiple PMF Sites  
  Ensure billing documents are split correctly when multiple PMF sites are involved in the sales orders. Copy control routine for split logic implemented and assigned to relevant billing document types.

  @TC-205
  Scenario: User logs in with appropriate authorization for billing document creation  
    Given the user has authorization to access the billing module  
    When the user logs into the SAP S/4HANA system  
    Then the user successfully accesses the billing module  

  @TC-205
  Scenario Outline: Validate sales order creation with PMF sites and price type  
    Given the user navigates to the sales order creation module  
    When the user creates a sales order with PMF site "<PMF_Site>" and price type "<Price_Type>"  
    Then the sales order is created successfully with the specified attributes  

    Examples:  
      | PMF_Site | Price_Type   |  
      | PMF001   | Discounted   |  
      | PMF002   | Discounted   |  

  @TC-205
  Scenario: Execute billing process to generate billing documents  
    Given the user has created sales orders with PMF sites and price type  
    When the user executes the billing process  
    Then the billing documents are generated successfully  

  @TC-205
  Scenario Outline: Validate billing document split logic based on PMF sites and price type  
    Given the user has generated billing documents  
    When the user validates the billing documents for PMF site "<PMF_Site>" and price type "<Price_Type>"  
    Then the billing documents are split correctly based on the PMF sites and price type  

    Examples:  
      | PMF_Site | Price_Type   |  
      | PMF001   | Discounted   |  
      | PMF002   | Discounted   |  

  @TC-205
  Scenario: Check Ship-to/Bill-to/Payer relationships in billing documents  
    Given the user has billing documents generated from sales orders  
    When the user checks the Ship-to/Bill-to/Payer relationships  
    Then the relationships are maintained accurately without any discrepancies  

  @TC-205
  Scenario: Verify pricing constraints for split billing documents  
    Given the user has split billing documents  
    When the user verifies the pricing constraints  
    Then the pricing constraints are validated and applied correctly  

  @TC-205
  Scenario: Validate document flow for split billing documents  
    Given the user has generated split billing documents  
    When the user validates the document flow  
    Then the document flow displays accurate linkage between the sales order and billing documents  

  @TC-205
  Scenario: Check accounting postings for split billing documents  
    Given the user has split billing documents  
    When the user checks the accounting postings for each document  
    Then the accounting postings are accurate and comply with the defined logic  

  @TC-205
  Scenario: Verify tax calculations for split billing documents  
    Given the user has split billing documents  
    When the user verifies the tax calculations  
    Then the tax calculations are accurate and comply with business rules  

  @TC-205
  Scenario: Validate invoice output format for split billing documents  
    Given the user has split billing documents  
    When the user validates the invoice output format  
    Then the invoice output format meets the defined standards  

  @TC-205
  Scenario: Check customer communication records for split billing documents  
    Given the user has split billing documents  
    When the user checks the customer communication records  
    Then the customer communication records are updated accurately for each document  

  @TC-205
  Scenario: Ensure split logic configuration matches business requirements  
    Given the user has access to the split logic configuration  
    When the user verifies the configuration  
    Then the split logic configuration matches the business requirements
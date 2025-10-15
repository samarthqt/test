Feature: Validate Split Logic for Billing Documents with Edge Case PMF Site Values  
  Ensure billing documents are split correctly when edge case PMF site values are used.  

  @TC-210  
  Scenario: User logs into the SAP S/4HANA system with appropriate authorization  
    Given the user has appropriate authorization for billing document creation  
    When the user logs into the SAP S/4HANA system  
    Then the user should successfully access the billing module  

  @TC-210  
  Scenario Outline: Validate sales order creation with PMF site and price type  
    Given the user is in the billing module  
    When the user creates a sales order with PMF site "<PMF_Site>" and price type "<Price_Type>"  
    Then the sales order should be created successfully with the specified attributes  

    Examples:  
      | PMF_Site | Price_Type |  
      | PMF999   | Special    |  

  @TC-210  
  Scenario Outline: Validate billing document generation based on PMF site and attributes  
    Given the user has created a sales order with PMF site "<PMF_Site>" and attributes KATR1 = "<KATR1>", KATR2 = "<KATR2>"  
    When the user executes the billing process  
    Then the billing documents should be generated successfully  

    Examples:  
      | PMF_Site | KATR1 | KATR2 |  
      | PMF999   | X     | Y     |  

  @TC-210  
  Scenario Outline: Validate billing document split logic  
    Given the billing documents are generated  
    When the user validates the split logic based on PMF site "<PMF_Site>" and price type "<Price_Type>"  
    Then the billing documents should be split correctly as per the defined logic with billing document type "<Billing_Document_Type>"  

    Examples:  
      | PMF_Site | Price_Type | Billing_Document_Type |  
      | PMF999   | Special    | ZF2                  |  

  @TC-210  
  Scenario: Validate Ship-to/Bill-to/Payer relationships  
    Given the split billing documents are generated  
    When the user checks the Ship-to/Bill-to/Payer relationships  
    Then the relationships should be maintained accurately without any discrepancies  

  @TC-210  
  Scenario: Validate pricing constraints for split documents  
    Given the split billing documents are generated  
    When the user verifies the pricing constraints  
    Then the pricing constraints should be validated and applied correctly  

  @TC-210  
  Scenario: Validate document flow for split billing documents  
    Given the split billing documents are generated  
    When the user validates the document flow  
    Then the document flow should display accurate linkage between the sales order and billing documents  

  @TC-210  
  Scenario: Validate accounting postings for split billing documents  
    Given the split billing documents are generated  
    When the user checks the accounting postings  
    Then the accounting postings should be accurate and comply with the defined logic  

  @TC-210  
  Scenario: Validate tax calculations for split billing documents  
    Given the split billing documents are generated  
    When the user verifies the tax calculations  
    Then the tax calculations should be accurate and comply with business rules  

  @TC-210  
  Scenario: Validate invoice output format for split billing documents  
    Given the split billing documents are generated  
    When the user validates the invoice output format  
    Then the invoice output format should meet the defined standards  

  @TC-210  
  Scenario: Validate customer communication records for split billing documents  
    Given the split billing documents are generated  
    When the user checks the customer communication records  
    Then the customer communication records should be updated accurately for each document  

  @TC-210  
  Scenario: Validate split logic configuration in the system  
    Given the split billing documents are generated  
    When the user ensures the split logic configuration in the system  
    Then the split logic configuration should match the business requirements
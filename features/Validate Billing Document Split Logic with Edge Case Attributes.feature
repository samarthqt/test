Feature: Validate Billing Document Split Logic with Edge Case Attributes  
  Ensure billing documents are split correctly when edge case values for PMF site and price type are used. Copy control routine for split logic implemented and assigned to relevant billing document types.

  @TC-206
  Scenario: User logs into the SAP S/4HANA system with appropriate authorization for billing document creation  
    Given the user has appropriate authorization for billing document creation  
    When the user logs into the SAP S/4HANA system  
    Then the user successfully accesses the billing module  

  @TC-206
  Scenario Outline: Create and process billing documents with split logic for edge case attributes  
    Given the user has accessed the billing module  
    When the user creates a sales order with PMF site "<PMF site>" and price type "<price type>"  
    Then the sales order is created successfully with the specified attributes  
    When the user executes the billing process to generate billing documents  
    Then billing documents are generated successfully  
    And the billing documents are split correctly based on PMF site and price type "<PMF site>" and "<price type>"  
    And the Ship-to/Bill-to/Payer relationships are preserved without discrepancies  
    And pricing constraints are applied correctly for the split documents  
    And the document flow displays accurate linkage between the sales order and billing documents  
    And accounting postings for each split billing document comply with the defined logic  
    And tax calculations for the split billing documents comply with business rules  
    And the invoice output format for each split billing document meets the defined standards  
    And customer communication records are updated accurately for each document  
    And the split logic configuration in the system matches the business requirements  

    Examples:  
      | PMF site | price type |  
      | PMF999   | Special    |  

  @TC-206
  Scenario: Validate Ship-to Business Partner attributes for billing documents  
    Given the user has created billing documents  
    When the Ship-to Business Partner attributes KATR1 = "X" and KATR2 = "Y" are maintained in KNA1  
    Then the billing documents reflect the correct Ship-to Business Partner attributes  

  @TC-206
  Scenario: Ensure split logic configuration matches business requirements  
    Given the user has verified the split logic configuration  
    When the user compares the system configuration to the business requirements  
    Then the split logic configuration matches the business requirements
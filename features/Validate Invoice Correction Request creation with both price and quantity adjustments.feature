Feature: Validate Invoice Correction Request creation with both price and quantity adjustments  
  Ensure the system handles Invoice Correction Requests with both price and quantity adjustments accurately.  

  @TC-75  
  Scenario: User logs in to the SAP S/4HANA system  
    Given the user has valid credentials  
    When the user logs in to the SAP S/4HANA system  
    Then the user is successfully logged in and has access to the Invoice Correction Request module  

  @TC-75  
  Scenario: User navigates to the Invoice Correction Request creation screen  
    Given the user is logged in to the SAP S/4HANA system  
    When the user navigates to the Invoice Correction Request creation screen  
    Then the Invoice Correction Request creation screen is displayed  

  @TC-75  
  Scenario Outline: User creates an Invoice Correction Request with price and quantity adjustments  
    Given the user is on the Invoice Correction Request creation screen  
    When the user selects an existing sales invoice "<Invoice Number>" for correction  
    And the user enters the correction type as "<Correction Type>"  
    And the user enters the price adjustment as "<Price Adjustment>"  
    And the user enters the quantity adjustment as "<Quantity Adjustment>"  
    And the user saves the Invoice Correction Request  
    Then the Invoice Correction Request is saved successfully with a unique request number  

    Examples:  
      | Invoice Number | Correction Type | Price Adjustment | Quantity Adjustment |  
      | INV-003        | ZRK1            | +$75             | +5 units            |  

  @TC-75  
  Scenario: Validate debit memo generation for the Invoice Correction Request  
    Given the user has created an Invoice Correction Request  
    When the user validates that a debit memo "<Debit Memo Type>" is generated for the correction request  
    Then the debit memo "<Debit Memo Type>" is generated successfully and linked to the correction request  

    Examples:  
      | Debit Memo Type |  
      | ZL2C           |  

  @TC-75  
  Scenario: Verify linkage between correction request and original billing document  
    Given the user has created an Invoice Correction Request  
    When the user verifies the linkage between the correction request and the original billing document  
    Then the linkage is correctly displayed in the document flow  

  @TC-75  
  Scenario: Check financial postings for the debit memo  
    Given the user has created an Invoice Correction Request  
    When the user checks the financial postings for the debit memo  
    Then the financial postings reflect the price and quantity adjustments accurately  

  @TC-75  
  Scenario: Verify debit memo visibility in the customer account statement  
    Given the user has created an Invoice Correction Request  
    When the user verifies that the debit memo is visible in the customer account statement  
    Then the debit memo is listed in the customer account statement  

  @TC-75  
  Scenario: User logs out of the SAP S/4HANA system  
    Given the user is logged in to the SAP S/4HANA system  
    When the user logs out of the SAP S/4HANA system  
    Then the user is logged out successfully
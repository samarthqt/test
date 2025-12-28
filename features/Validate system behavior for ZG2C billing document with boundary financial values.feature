Feature: Validate system behavior for ZG2C billing document with boundary financial values  
  Ensure that the system correctly processes ZG2C billing documents with boundary financial values for item categories.  

  @TC-522  
  Scenario: User logs into the SAP S/4HANA system with billing document creation permissions  
    Given the user has valid credentials with billing document creation permissions  
    When the user logs into the SAP S/4HANA system  
    Then the user is successfully logged into the system  

  @TC-522  
  Scenario: User navigates to the billing document creation screen  
    Given the user is logged into the SAP S/4HANA system  
    When the user navigates to the billing document creation screen using transaction code VF01  
    Then the billing document creation screen is displayed  

  @TC-522  
  Scenario Outline: User selects billing document type ZG2C and enters the original billing document number  
    Given the user is on the billing document creation screen  
    When the user selects billing document type "<billing_document_type>"  
    And the user enters the original billing document number "<original_billing_document_number>"  
    Then the billing document type and original document number are accepted  

    Examples:  
      | billing_document_type | original_billing_document_number |  
      | ZG2C                  | 4455667788                       |  

  @TC-522  
  Scenario Outline: User adds item categories with boundary financial values  
    Given the user has selected billing document type ZG2C and entered the original billing document number 4455667788  
    When the user adds item category "<item_category>" with the "<financial_value>" financial value allowed  
    Then the item category "<item_category>" is added successfully with the specified value  

    Examples:  
      | item_category | financial_value      |  
      | L2N           | maximum positive     |  
      | G2N           | maximum negative     |  

  @TC-522  
  Scenario: User saves the billing document  
    Given the user has added item categories with boundary financial values  
    When the user saves the billing document  
    Then the billing document is saved successfully  
    And a unique document number is generated  

  @TC-522  
  Scenario: User verifies financial values in the VBRP table  
    Given the billing document is saved successfully  
    When the user verifies the financial values in the VBRP table for the billing document  
    Then the financial values are correctly reflected in the VBRP table  

  @TC-522  
  Scenario: User checks the linkage in the VBFA table  
    Given the billing document is saved successfully  
    When the user checks the linkage between the billing document and the original document in the VBFA table  
    Then the linkage is accurate and consistent  

  @TC-522  
  Scenario: User generates a report to validate financial impact  
    Given the billing document is saved successfully  
    When the user generates a report to validate the financial impact of the billing document  
    Then the report shows accurate financial entries corresponding to the billing document  

  @TC-522  
  Scenario: User exports billing document details for audit purposes  
    Given the billing document is saved successfully  
    When the user exports the billing document details to a file for audit purposes  
    Then the billing document details are successfully exported  

  @TC-522  
  Scenario: User logs out of the SAP S/4HANA system  
    Given the user has completed all required actions  
    When the user logs out of the SAP S/4HANA system  
    Then the user is logged out successfully
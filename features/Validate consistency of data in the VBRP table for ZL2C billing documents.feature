Feature: Validate consistency of data in the VBRP table for ZL2C billing documents  
  Ensure that the VBRP table reflects correct sign conventions and linkage to the original billing document for ZL2C billing documents.

  @TC-42
  Scenario: User logs into the SAP S/4HANA system  
    Given the user has appropriate credentials  
    When the user logs into the SAP S/4HANA system  
    Then the user is successfully logged into the system  

  @TC-42
  Scenario: User navigates to the billing correction request creation screen  
    Given the user is logged into the SAP S/4HANA system  
    When the user navigates to the billing correction request creation screen  
    Then the billing correction request creation screen is displayed  

  @TC-42
  Scenario Outline: User creates a billing correction request  
    Given the user is on the billing correction request creation screen  
    When the user enters the original billing document number "<original_billing_document_number>"  
    And the user selects the billing correction request type "<billing_correction_request_type>"  
    And the user saves the billing correction request  
    Then the billing correction request is successfully created  

    Examples:  
      | original_billing_document_number | billing_correction_request_type |  
      | 12345678                        | ZRK1                            |  

  @TC-42
  Scenario: User generates a ZL2C billing document linked to the billing correction request  
    Given the billing correction request is successfully created  
    When the user generates a ZL2C billing document linked to the billing correction request  
    Then the ZL2C billing document is successfully generated  

  @TC-42
  Scenario: User accesses the VBRP table to locate entries for the ZL2C billing document  
    Given the ZL2C billing document is successfully generated  
    When the user accesses the VBRP table  
    Then the VBRP table entries for the ZL2C billing document are displayed  

  @TC-42
  Scenario Outline: User verifies sign conventions in the VBRP table for item categories  
    Given the VBRP table entries for the ZL2C billing document are displayed  
    When the user verifies that item category "<item_category>" has a "<sign_convention>" sign convention in the VBRP table  
    Then the VBRP table reflects "<sign_convention>" values for "<item_category>" items  

    Examples:  
      | item_category | sign_convention |  
      | L2N           | negative        |  
      | G2N           | positive        |  

  @TC-42
  Scenario: User validates linkage between the ZL2C billing document and the original billing document in the VBRP table  
    Given the VBRP table entries for the ZL2C billing document are displayed  
    When the user validates the linkage between the ZL2C billing document and the original billing document  
    Then the VBRP table accurately links the ZL2C billing document to the original billing document  

  @TC-42
  Scenario: User generates a report to review VBRP table entries for consistency  
    Given the VBRP table entries for the ZL2C billing document are displayed  
    When the user generates a report to review the VBRP table entries  
    Then the report confirms accurate data consistency in the VBRP table  

  @TC-42
  Scenario: User validates financial data in the ZL2C billing document  
    Given the ZL2C billing document is successfully generated  
    When the user validates the financial data in the ZL2C billing document  
    Then the financial data is consistent and accurately reflects the VBRP table entries  

  @TC-42
  Scenario: User logs out of the SAP S/4HANA system  
    Given the user is logged into the SAP S/4HANA system  
    When the user logs out of the SAP S/4HANA system  
    Then the user is successfully logged out
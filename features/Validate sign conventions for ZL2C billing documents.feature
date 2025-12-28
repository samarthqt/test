Feature: Validate sign conventions for ZL2C billing documents  
  Ensure that ZL2C billing documents accurately apply sign conventions for item categories L2N (negative) and G2N (positive).  

  @TC-40  
  Scenario: User logs into the SAP S/4HANA system  
    Given the user has the appropriate credentials  
    When the user logs into the SAP S/4HANA system  
    Then the user is successfully logged into the system  

  @TC-40  
  Scenario: User navigates to the billing correction request creation screen  
    Given the user is logged into the SAP S/4HANA system  
    When the user navigates to the billing correction request creation screen  
    Then the billing correction request creation screen is displayed  

  @TC-40  
  Scenario Outline: User creates a billing correction request  
    Given the user is on the billing correction request creation screen  
    When the user enters the original billing document number "<originalBillingDocument>"  
    And the user selects billing correction request type "<correctionRequestType>"  
    Then the billing correction request is linked to the original document  
    And the item categories "<itemCategories>" are correctly referenced  

    Examples:  
      | originalBillingDocument | correctionRequestType | itemCategories |  
      | 12345678                | ZRK1                 | L2N, G2N       |  

  @TC-40  
  Scenario: User saves the billing correction request  
    Given the user has entered the billing correction request details  
    When the user saves the billing correction request  
    Then the billing correction request is successfully created  

  @TC-40  
  Scenario: User generates a ZL2C billing document  
    Given the user has a billing correction request  
    When the user generates a ZL2C billing document linked to the billing correction request  
    Then the ZL2C billing document is successfully generated  

  @TC-40  
  Scenario Outline: Verify sign conventions for ZL2C billing document item categories  
    Given the ZL2C billing document is generated  
    When the user verifies the item category "<itemCategory>"  
    Then the item category "<itemCategory>" has a "<signConvention>" sign convention  

    Examples:  
      | itemCategory | signConvention |  
      | L2N          | negative       |  
      | G2N          | positive       |  

  @TC-40  
  Scenario: Verify original billing document references in VBFA table  
    Given the ZL2C billing document is generated  
    When the user checks the VGBEL and VGPOS fields in the VBFA table  
    Then the original billing document numbers and positions are correctly propagated  

  @TC-40  
  Scenario: Verify sign conventions in the VBRP table  
    Given the ZL2C billing document is generated  
    When the user verifies the VBRP table  
    Then the VBRP table reflects correct sign conventions for item categories L2N and G2N  

  @TC-40  
  Scenario: Validate linkage in the document flow  
    Given the ZL2C billing document is generated  
    When the user validates the linkage between the ZL2C billing document and the original billing document in the document flow  
    Then the document flow shows accurate linkage  

  @TC-40  
  Scenario: Generate financial data consistency report for ZL2C billing document  
    Given the ZL2C billing document is generated  
    When the user generates a report to review financial data consistency  
    Then the financial data is consistent and reflects accurate sign conventions  

  @TC-40  
  Scenario: User logs out of the SAP S/4HANA system  
    Given the user has completed their tasks  
    When the user logs out of the SAP S/4HANA system  
    Then the user is successfully logged out
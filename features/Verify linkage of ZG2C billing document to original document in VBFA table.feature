Feature: Verify linkage of ZG2C billing document to original document in VBFA table  
  Ensure that the original billing document numbers and positions are correctly propagated to the VGBEL and VGPOS fields in the VBFA table.

  @TC-517  
  Scenario: User logs into the SAP S/4HANA system  
    Given user has access to billing document creation  
    When user logs into the SAP S/4HANA system  
    Then user is successfully logged into the system  

  @TC-517  
  Scenario: User navigates to the billing document creation screen  
    Given user is logged into the SAP S/4HANA system  
    When user navigates to the billing document creation screen using transaction code VF01  
    Then billing document creation screen is displayed  

  @TC-517  
  Scenario Outline: User creates a billing document of type ZG2C linked to the original billing document  
    Given user is on the billing document creation screen  
    When user creates a billing document of type ZG2C linked to the original billing document "<originalDocumentNumber>"  
    Then billing document is created successfully and linked to the original document  
    And item categories "<itemCategories>" are displayed  

    Examples:  
      | originalDocumentNumber | itemCategories |  
      | 987654321              | L2N, G2N       |  

  @TC-517  
  Scenario: User saves the billing document and notes the generated document number  
    Given user has created a billing document  
    When user saves the billing document  
    Then billing document is saved successfully  
    And a unique document number is generated  

  @TC-517  
  Scenario: User navigates to the VBFA table  
    Given user is logged into the SAP S/4HANA system  
    When user navigates to the VBFA table  
    Then VBFA table is displayed  

  @TC-517  
  Scenario: User searches for the newly created billing document in the VBFA table  
    Given user is on the VBFA table screen  
    When user searches for the newly created billing document  
    Then billing document is found in the VBFA table  

  @TC-517  
  Scenario Outline: User verifies VGBEL and VGPOS fields in the VBFA table for the billing document  
    Given user has found the billing document in the VBFA table  
    When user verifies the VGBEL field in the VBFA table  
    Then VGBEL field contains the original billing document number "<originalDocumentNumber>"  
    When user verifies the VGPOS field in the VBFA table  
    Then VGPOS field contains the correct position numbers from the original billing document  

    Examples:  
      | originalDocumentNumber |  
      | 987654321              |  

  @TC-517  
  Scenario: User checks linkage consistency between the original and newly created billing documents  
    Given user has verified VGBEL and VGPOS fields in the VBFA table  
    When user checks the linkage consistency between the original and newly created billing documents  
    Then linkage is consistent, and no discrepancies are found  

  @TC-517  
  Scenario: User generates a report to validate the document linkage  
    Given user has checked the linkage consistency  
    When user generates a report to validate the document linkage  
    Then report shows accurate linkage between the original and newly created billing documents  

  @TC-517  
  Scenario: User exports the linkage details to a file for audit purposes  
    Given user has generated a report to validate the document linkage  
    When user exports the linkage details to a file  
    Then linkage details are successfully exported  

  @TC-517  
  Scenario: User logs out of the SAP S/4HANA system  
    Given user has completed all actions  
    When user logs out of the SAP S/4HANA system  
    Then user is logged out successfully
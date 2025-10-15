Feature: Validate data transmission to Model N with correct Ext Link ID  
  Ensure that the data transmitted to Model N contains the correct Ext Link ID and no errors occur during transmission. The system is configured to handle billing documents with VBTYP_V set to 'M'.

  @TC-392
  Scenario Outline: Validate S1 invoice creation and Ext Link ID formation  
    Given the user creates an S1 invoice linked to a direct program  
    And the system generates VBELV and POSNV values for the invoice  
    When the user retrieves VBELV "<VBELV>" and POSNV "<POSNV>" values from the VBFA table  
    And the user concatenates VBELV and POSNV values to form the Ext Link ID  
    Then the Ext Link ID "<ExtLinkID>" is formed correctly  

    Examples:  
      | VBELV       | POSNV  | ExtLinkID         |  
      | 100000125   | 00030  | 10000012500030    |  
      | 100000126   | 00040  | 10000012600040    |  

  @TC-392
  Scenario Outline: Validate Ext Link ID inclusion in outbound data  
    Given the user includes Ext Link ID "<ExtLinkID>" in the outbound data to Model N  
    Then the outbound data contains the correct Ext Link ID  

    Examples:  
      | ExtLinkID         |  
      | 10000012500030    |  
      | 10000012600040    |  

  @TC-392
  Scenario Outline: Validate successful data transmission to Model N  
    Given the user transmits data containing Ext Link ID "<ExtLinkID>" to Model N  
    Then the transmission is successful without errors  

    Examples:  
      | ExtLinkID         |  
      | 10000012500030    |  
      | 10000012600040    |  

  @TC-392
  Scenario Outline: Validate Ext Link ID in Model N system  
    Given the user verifies the Ext Link ID "<ExtLinkID>" in Model N  
    Then the Ext Link ID matches the original VBELV "<VBELV>" and POSNV "<POSNV>" values  

    Examples:  
      | ExtLinkID         | VBELV       | POSNV  |  
      | 10000012500030    | 100000125   | 00030  |  
      | 10000012600040    | 100000126   | 00040  |  

  @TC-392
  Scenario: Validate reconciliation report for Ext Link ID consistency  
    Given the user runs a reconciliation report  
    Then the report confirms consistency of Ext Link ID across systems  

  @TC-392
  Scenario: Validate Ext Link ID usage in rebate and administrative fee calculations  
    Given the rebate and administrative fee calculations use Ext Link ID "<ExtLinkID>"  
    Then the calculations are performed correctly  

    Examples:  
      | ExtLinkID         |  
      | 10000012500030    |  
      | 10000012600040    |  

  @TC-392
  Scenario: Validate consistency of Ext Link ID formation and transmission for a new invoice  
    Given the user creates another S1 invoice linked to a direct program  
    And the system generates VBELV "<VBELV>" and POSNV "<POSNV>" values for the new invoice  
    When the user concatenates VBELV and POSNV values to form the Ext Link ID "<ExtLinkID>"  
    Then the Ext Link ID is formed and transmitted correctly  

    Examples:  
      | VBELV       | POSNV  | ExtLinkID         |  
      | 100000127   | 00050  | 10000012700050    |  
      | 100000128   | 00060  | 10000012800060    |  

  @TC-392
  Scenario: Validate system performance during data transmission  
    Given the user transmits data to Model N  
    Then the system performance remains stable during the transmission process  

  @TC-392
  Scenario: Validate no duplicate Ext Link IDs in Model N  
    Given the user checks for duplicate Ext Link IDs in Model N  
    Then no duplicate Ext Link IDs are found in the system
Feature: Edge case test for maximum number of linked invoices in Invoice List output  
  Verify system behavior when the Invoice List output includes the maximum number of linked invoices.

  @TC-446  
  Scenario: User logs into the SAP S/4HANA system with valid credentials  
    Given the user has valid SAP credentials with VF23 execution authorization  
    And the High Output Type ZPIL is assigned  
    When the user logs into the SAP S/4HANA system  
    Then the user is successfully logged into the SAP system  

  @TC-446  
  Scenario: User navigates to the VF23 transaction  
    Given the user is logged into the SAP system  
    And the SD_INVOICE_PRINT01 program and ZOTC_CON_INV_DT_FORM are configured and accessible  
    When the user navigates to the VF23 transaction  
    Then the VF23 transaction screen is displayed  

  @TC-446  
  Scenario Outline: User selects invoice list document with maximum number of linked invoices  
    Given the user is on the VF23 transaction screen  
    When the user enters the required parameters to select the invoice list document "<documentNumber>"  
    Then the invoice list document is selected successfully  

    Examples:  
      | documentNumber |  
      | MAX_DOC_001    |  

  @TC-446  
  Scenario: User triggers the Invoice List output  
    Given the user has selected an invoice list document with the maximum number of linked invoices  
    When the user executes the transaction to trigger the Invoice List output  
    Then the Invoice List output is triggered successfully  

  @TC-446  
  Scenario: Validate Output Type ZPIL is triggered  
    Given the Invoice List output is triggered successfully  
    When the user validates the output type  
    Then Output Type ZPIL is confirmed as triggered  

  @TC-446  
  Scenario: Verify all linked invoices are included in the output  
    Given Output Type ZPIL is triggered  
    When the user reviews the output  
    Then all linked invoices are included in the output  

  @TC-446  
  Scenario: Check for performance issues during output generation  
    Given the Invoice List output is generated  
    When the user checks for performance issues or delays  
    Then the output is generated without performance issues or delays  

  @TC-446  
  Scenario: Ensure output format consistency  
    Given the Invoice List output is generated  
    When the user reviews the output format  
    Then the output format remains consistent and as expected  

  @TC-446  
  Scenario: Validate accuracy of data for linked invoices  
    Given the Invoice List output is generated  
    When the user validates the data for all linked invoices  
    Then the data for all invoices in the output is accurate and complete  

  @TC-446  
  Scenario: Save the output for further analysis  
    Given the Invoice List output is generated  
    When the user saves the output  
    Then the output is saved successfully  

  @TC-446  
  Scenario: Export the output for external review  
    Given the Invoice List output is saved  
    When the user exports the output  
    Then the output is exported successfully  

  @TC-446  
  Scenario: Document observations or anomalies during the test  
    Given the Invoice List output is generated  
    When the user documents observations or anomalies  
    Then all observations and anomalies are documented successfully
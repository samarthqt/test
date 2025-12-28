Feature: Edge case test for missing invoices in Invoice List output  
  Verify system behavior when some invoices linked to the invoice list document are missing in the output.  

  @TC-447  
  Scenario: User logs into the SAP system successfully  
    Given the user has valid SAP credentials with VF23 execution authorization  
    When the user logs into the SAP S/4HANA system  
    Then the user is successfully logged into the SAP system  

  @TC-447  
  Scenario: User navigates to the VF23 transaction  
    Given the user is logged into the SAP system  
    When the user navigates to the VF23 transaction  
    Then the VF23 transaction screen is displayed  

  @TC-447  
  Scenario: User selects an invoice list document with missing invoices  
    Given the user is on the VF23 transaction screen  
    And an invoice list document exists in the system with some invoices intentionally removed or unlinked  
    When the user inputs the required parameters to select the invoice list document with missing invoices  
    Then the invoice list document is selected successfully  

  @TC-447  
  Scenario: User triggers the Invoice List output  
    Given the user has selected an invoice list document  
    When the user executes the transaction to trigger the Invoice List output  
    Then the Invoice List output is triggered successfully  

  @TC-447  
  Scenario: Validate that Output Type ZPIL is triggered  
    Given the Invoice List output is triggered  
    When the user validates the output type  
    Then Output Type ZPIL is confirmed as triggered  

  @TC-447  
  Scenario: Verify missing invoices in the output  
    Given the Invoice List output is generated  
    When the user verifies the output  
    Then some invoices are missing from the output as expected  

  @TC-447  
  Scenario: Check system logs for warnings or errors related to missing invoices  
    Given the Invoice List output is generated  
    When the user checks the system logs  
    Then system logs display warnings or errors related to the missing invoices  

  @TC-447  
  Scenario: Document missing invoices and their details  
    Given the system logs display warnings or errors related to missing invoices  
    When the user documents the missing invoices and their details  
    Then the missing invoices and their details are documented successfully  

  @TC-447  
  Scenario: Validate output for remaining invoices  
    Given the Invoice List output is generated  
    When the user validates the output for the remaining invoices  
    Then the output for the remaining invoices is generated correctly  

  @TC-447  
  Scenario: Save the output for further review  
    Given the Invoice List output is generated  
    When the user saves the output  
    Then the output is saved successfully  

  @TC-447  
  Scenario: Export the output for external validation  
    Given the Invoice List output is saved  
    When the user exports the output  
    Then the output is exported successfully  

  @TC-447  
  Scenario: Document observations and anomalies during the test  
    Given the test has been executed  
    When the user documents any observations or anomalies  
    Then all observations and anomalies are documented successfully
Feature: Validate successful handling of maximum-length VBELV and POSNV values during Ext Link ID formation  
  Ensure the system correctly forms the Ext Link ID with maximum-length VBELV and POSNV values without exceeding limits.  

  @TC-65  
  Scenario: User logs in to the SAP S/4 HANA system  
    Given the user has appropriate credentials  
    When the user logs into the SAP S/4 HANA system  
    Then the user is successfully logged into the system  

  @TC-65  
  Scenario: User navigates to the invoice creation screen  
    Given the user is logged into the SAP S/4 HANA system  
    When the user navigates to the transaction code for creating invoices (e.g., VF01)  
    Then the invoice creation screen is displayed  

  @TC-65  
  Scenario Outline: User creates an S1 invoice with maximum-length VBELV and POSNV values  
    Given the user is on the invoice creation screen  
    When the user creates an S1 invoice with VBELV value "<VBELV>" and POSNV value "<POSNV>" and saves it  
    Then the S1 invoice is successfully created with maximum-length values  

    Examples:  
      | VBELV        | POSNV        |  
      | 9999999999   | 9999999999   |  

  @TC-65  
  Scenario: User retrieves VBELV and POSNV values from the VBFA table  
    Given the user has created an S1 invoice  
    When the user retrieves the VBELV and POSNV values from the VBFA table for the created invoice  
    Then the maximum-length VBELV and POSNV values are retrieved successfully  

  @TC-65  
  Scenario: User forms the Ext Link ID by concatenating VBELV and POSNV values  
    Given the user has retrieved the VBELV and POSNV values  
    When the user concatenates VBELV and POSNV values to form the Ext Link ID  
    Then the Ext Link ID is formed correctly with concatenated values  

  @TC-65  
  Scenario: User validates the length of the Ext Link ID  
    Given the Ext Link ID is formed  
    When the user validates the length of the Ext Link ID  
    Then the Ext Link ID length is within the acceptable limits  

  @TC-65  
  Scenario: User verifies the correctness of the Ext Link ID format  
    Given the Ext Link ID is formed  
    When the user verifies the correctness of the Ext Link ID format  
    Then the Ext Link ID format is correct as per system requirements  

  @TC-65  
  Scenario: User includes the Ext Link ID in the outbound data for Model N  
    Given the Ext Link ID is formed  
    When the user includes the Ext Link ID in the outbound data for Model N  
    Then the Ext Link ID is included in the outbound data without errors  

  @TC-65  
  Scenario: User transmits the outbound data to Model N  
    Given the outbound data includes the Ext Link ID  
    When the user transmits the outbound data to Model N  
    Then the data is transmitted successfully to Model N  

  @TC-65  
  Scenario: User verifies that Model N processes the Ext Link ID without errors  
    Given the data is transmitted to Model N  
    When the user verifies that Model N processes the Ext Link ID  
    Then Model N processes the Ext Link ID successfully  

  @TC-65  
  Scenario: User checks the system logs for warnings or errors during the process  
    Given the Ext Link ID is processed by Model N  
    When the user checks the system logs for any warnings or errors during the process  
    Then no warnings or errors are logged during the process  

  @TC-65  
  Scenario: User documents the test results and observations  
    Given the process is completed successfully  
    When the user documents the test results and any observations  
    Then the test results and observations are documented for future reference
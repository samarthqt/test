Feature: Negative test for missing Output Type ZPIL configuration during VF23 execution  
  Verify system behavior when Output Type ZPIL is not configured during VF23 execution. Invoice List Form configuration is incomplete.

  @TC-444  
  Scenario: User logs into the SAP S/4HANA system using valid credentials  
    Given user has valid SAP S/4HANA credentials with VF23 execution authorization  
    When user logs into the SAP S/4HANA system  
    Then user is successfully logged into the SAP system  

  @TC-444  
  Scenario: User navigates to the VF23 transaction  
    Given user is logged into the SAP S/4HANA system  
    When user navigates to the VF23 transaction  
    Then VF23 transaction screen is displayed  

  @TC-444  
  Scenario Outline: User inputs parameters to select an invoice list document  
    Given user is on the VF23 transaction screen  
    When user inputs the required parameters "<parameters>" to select an invoice list document  
    Then the invoice list document is selected successfully  
    And at least one invoice list document exists in the system linked to multiple invoices  

    Examples:  
      | parameters       |  
      | valid parameters |  

  @TC-444  
  Scenario: User executes the transaction to trigger the Invoice List output  
    Given user has selected an invoice list document in VF23  
    When user executes the transaction to trigger the Invoice List output  
    Then the system attempts to trigger the output  

  @TC-444  
  Scenario: User checks for error messages indicating missing Output Type ZPIL configuration  
    Given user has executed the transaction in VF23  
    When user checks for error messages  
    Then an error message is displayed indicating that Output Type ZPIL is not configured  

  @TC-444  
  Scenario: User verifies that no output is generated due to the missing configuration  
    Given user has encountered an error message indicating missing Output Type ZPIL configuration  
    When user verifies the output generation  
    Then no output is generated  

  @TC-444  
  Scenario: User documents the error message for further analysis  
    Given user has encountered an error message indicating missing Output Type ZPIL configuration  
    When user documents the error message  
    Then the error message is documented successfully  

  @TC-444  
  Scenario: User validates that the system prevents further processing of the invoice list  
    Given user has encountered an error message indicating missing Output Type ZPIL configuration  
    When user validates the system behavior  
    Then the system halts further processing due to the missing configuration
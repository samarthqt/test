Feature: Validate system behavior with corrupted ZPDT template  
  Ensure the system handles corrupted ZPDT templates gracefully without generating invalid outputs.

  @TC-90
  Scenario: User logs into the SAP system successfully  
    Given the user has valid credentials  
    When the user logs into the SAP system  
    Then the user is successfully logged in  

  @TC-90
  Scenario: User navigates to the Invoice Correction Request creation screen  
    Given the user is logged into the SAP system  
    When the user navigates to the Invoice Correction Request creation screen  
    Then the Invoice Correction Request creation screen is displayed  

  @TC-90
  Scenario: User creates an Invoice Correction Request for a debit adjustment  
    Given the user is on the Invoice Correction Request creation screen  
    When the user creates an Invoice Correction Request with ID "ZRK1" for a debit adjustment using a corrupted ZPDT template  
    Then the Invoice Correction Request is created successfully  

  @TC-90
  Scenario: System displays an error for corrupted ZPDT template during ZGL1 output generation  
    Given the user has created an Invoice Correction Request using a corrupted ZPDT template  
    When the user attempts to generate the ZGL1 output  
    Then the system displays an error indicating the corrupted ZPDT template  

  @TC-90
  Scenario: System logs indicate corruption in the ZPDT template  
    Given the user attempted to generate the ZGL1 output using a corrupted ZPDT template  
    When the user checks the system logs for error details  
    Then the logs indicate the corruption in the ZPDT template  

  @TC-90
  Scenario: System prevents printing of ZGL1 output with corrupted template  
    Given the user attempted to generate the ZGL1 output using a corrupted ZPDT template  
    When the user tries to print the ZGL1 output  
    Then the system does not allow printing of outputs with a corrupted template  

  @TC-90
  Scenario: System provides clear error messages for corrupted templates  
    Given the user attempted to generate the ZGL1 output using a corrupted ZPDT template  
    When the system displays an error message  
    Then the error message is clear and actionable  

  @TC-90
  Scenario: System ensures compliance with operational and billing standards  
    Given the user attempted to generate the ZGL1 output using a corrupted ZPDT template  
    When the system handles the corrupted template  
    Then the system complies with operational and billing standards
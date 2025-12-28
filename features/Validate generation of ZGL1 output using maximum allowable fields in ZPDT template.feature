Feature: Validate generation of ZGL1 output using maximum allowable fields in ZPDT template  
  Ensure the system generates the ZGL1 output for debit adjustments using the ZPDT template with maximum allowable fields.

  @TC-87
  Scenario: User logs into the SAP system with valid credentials  
    Given the user has valid credentials  
    When the user logs into the SAP system  
    Then the user is successfully logged in  

  @TC-87
  Scenario: User navigates to the Invoice Correction Request creation screen  
    Given the user is logged into the SAP system  
    When the user navigates to the Invoice Correction Request creation screen  
    Then the Invoice Correction Request creation screen is displayed  

  @TC-87
  Scenario: User creates an Invoice Correction Request for a debit adjustment  
    Given the user is on the Invoice Correction Request creation screen  
    When the user creates an Invoice Correction Request (ZRK1) for a debit adjustment with Customer ID "CUST002"  
    Then the Invoice Correction Request (ZRK1) is created successfully  

  @TC-87
  Scenario: User selects the ZPDT template with maximum allowable fields  
    Given the user is creating an Invoice Correction Request  
    When the user selects the ZPDT template with maximum allowable fields  
    Then the ZPDT template with maximum fields is selected  

  @TC-87
  Scenario: User triggers the generation of the ZGL1 form  
    Given the user has selected the ZPDT template  
    When the user triggers the generation of the ZGL1 form using the Print Program "SD_INVOICE_PRINT01"  
    Then the ZGL1 form generation process is initiated  

  @TC-87
  Scenario: System generates the ZGL1 output  
    Given the user has initiated the ZGL1 form generation process  
    When the system generates the ZGL1 output  
    Then the ZGL1 output is generated successfully  

  @TC-87
  Scenario: User validates the generated ZGL1 output for accuracy and completeness  
    Given the ZGL1 output is generated successfully  
    When the user validates the generated ZGL1 output  
    Then the ZGL1 output matches the expected format and data  

  @TC-87
  Scenario: User attempts to print the ZGL1 output for customer delivery  
    Given the ZGL1 output is validated for accuracy and completeness  
    When the user attempts to print the ZGL1 output  
    Then the ZGL1 output is printed successfully  

  @TC-87
  Scenario: User verifies the printed ZGL1 output for formatting and data accuracy  
    Given the ZGL1 output is printed successfully  
    When the user verifies the printed output  
    Then the printed ZGL1 output is accurate and well-formatted  

  @TC-87
  Scenario: User checks the system logs for any errors or warnings during the process  
    Given the ZGL1 output generation and printing process is completed  
    When the user checks the system logs  
    Then no errors or warnings are logged  

  @TC-87
  Scenario: User confirms the linkage of the ZGL1 output to the Invoice Correction Request  
    Given the ZGL1 output is generated  
    When the user verifies the linkage of the ZGL1 output to the Invoice Correction Request  
    Then the ZGL1 output is correctly linked to the Invoice Correction Request  

  @TC-87
  Scenario: User ensures compliance with operational and billing standards  
    Given the ZGL1 output is generated and linked to the Invoice Correction Request  
    When the user ensures compliance with operational and billing standards  
    Then the system complies with operational and billing standards
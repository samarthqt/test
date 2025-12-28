Feature: Validate generation of ZGC1 output using maximum allowable fields in ZPDT template  
  Ensure the system generates the ZGC1 output for credit adjustments using the ZPDT template with maximum allowable fields.  

  @TC-86  
  Scenario: User logs into the SAP system with valid credentials  
    Given the user has valid credentials  
    When the user logs into the SAP system  
    Then the user is successfully logged in  

  @TC-86  
  Scenario: User navigates to the Invoice Correction Request creation screen  
    Given the user is logged into the SAP system  
    When the user navigates to the Invoice Correction Request creation screen  
    Then the Invoice Correction Request creation screen is displayed  

  @TC-86  
  Scenario Outline: User creates an Invoice Correction Request (ZRK) for a credit adjustment  
    Given the user is on the Invoice Correction Request creation screen  
    When the user creates an Invoice Correction Request with the following details:  
      | Invoice Correction Request ID | Customer ID | Template |  
      | <InvoiceCorrectionRequestID> | <CustomerID> | <Template> |  
    Then the Invoice Correction Request is created successfully  

    Examples:  
      | InvoiceCorrectionRequestID | CustomerID | Template |  
      | ZRK12345                   | CUST001    | ZPDT     |  

  @TC-86  
  Scenario: User ensures the ZPDT template with maximum allowable fields is selected  
    Given the Invoice Correction Request has been created  
    When the user selects the ZPDT template with maximum allowable fields  
    Then the ZPDT template with maximum fields is selected  

  @TC-86  
  Scenario Outline: User triggers the generation of the ZGC1 form  
    Given the ZPDT template with maximum fields is selected  
    When the user triggers the generation of the ZGC1 form using the Print Program <PrintProgram>  
    Then the ZGC1 form generation process is initiated  

    Examples:  
      | PrintProgram         |  
      | SD_INVOICE_PRINT01   |  

  @TC-86  
  Scenario: User monitors the system for the generation of the ZGC1 output  
    Given the ZGC1 form generation process is initiated  
    When the user monitors the system for the generation of the ZGC1 output  
    Then the ZGC1 output is generated successfully  

  @TC-86  
  Scenario: User validates the generated ZGC1 output for accuracy and completeness  
    Given the ZGC1 output is generated successfully  
    When the user validates the generated ZGC1 output  
    Then the ZGC1 output matches the expected format and data  

  @TC-86  
  Scenario: User attempts to print the ZGC1 output for customer delivery  
    Given the ZGC1 output matches the expected format and data  
    When the user attempts to print the ZGC1 output for customer delivery  
    Then the ZGC1 output is printed successfully  

  @TC-86  
  Scenario: User verifies the printed output for formatting and data accuracy  
    Given the ZGC1 output is printed successfully  
    When the user verifies the printed output for formatting and data accuracy  
    Then the printed ZGC1 output is accurate and well-formatted  

  @TC-86  
  Scenario: User checks the system logs for errors or warnings during the process  
    Given the ZGC1 output is generated and printed successfully  
    When the user checks the system logs for any errors or warnings during the process  
    Then no errors or warnings are logged  

  @TC-86  
  Scenario: User confirms the linkage of the ZGC1 output to the Invoice Correction Request  
    Given the ZGC1 output is generated successfully  
    When the user confirms the linkage of the ZGC1 output to the Invoice Correction Request  
    Then the ZGC1 output is correctly linked to the Invoice Correction Request  

  @TC-86  
  Scenario: User ensures compliance with operational and billing standards  
    Given the ZGC1 output is linked to the Invoice Correction Request  
    When the user ensures compliance with operational and billing standards  
    Then the system complies with operational and billing standards
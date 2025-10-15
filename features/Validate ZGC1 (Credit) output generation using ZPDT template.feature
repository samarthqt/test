Feature: Validate ZGC1 (Credit) output generation using ZPDT template  
  Ensure ZGC1 output is generated correctly for credit adjustments using the ZPDT template and Print Program SD_INVOICE_PRINT01.  

  @TC-83  
  Scenario: User logs into the SAP S/4HANA system  
    Given the user has valid credentials  
    When the user logs into the SAP S/4HANA system  
    Then the user is successfully logged in and navigates to the SAP main menu  

  @TC-83  
  Scenario: User navigates to the Invoice Correction Request creation screen  
    Given the user is logged into the SAP S/4HANA system  
    When the user navigates to the Invoice Correction Request creation screen  
    Then the Invoice Correction Request creation screen is displayed  

  @TC-83  
  Scenario: User selects the Invoice Correction Request type as ZRK  
    Given the user is on the Invoice Correction Request creation screen  
    When the user selects the Invoice Correction Request type as ZRK  
    Then the Invoice Correction Request type ZRK is selected  

  @TC-83  
  Scenario Outline: User enters customer and billing details for a credit adjustment  
    Given the user has selected the Invoice Correction Request type as ZRK  
    When the user enters customer details "<customer_details>" and billing details for a credit adjustment of "<credit_adjustment>"  
    Then the customer and billing details are entered successfully  

    Examples:  
      | customer_details | credit_adjustment |  
      | Customer A       | $500              |  

  @TC-83  
  Scenario: User saves the Invoice Correction Request  
    Given the user has entered customer and billing details  
    When the user saves the Invoice Correction Request  
    Then the Invoice Correction Request is saved successfully, and a unique document number is generated  

  @TC-83  
  Scenario: User triggers the output generation process  
    Given the Invoice Correction Request is saved successfully  
    When the user triggers the output generation process for the saved Invoice Correction Request  
    Then the system initiates the output generation process  

  @TC-83  
  Scenario: Verify ZPDT template is used for ZGC1 form generation  
    Given the output generation process is initiated  
    When the user verifies the template used for generating the ZGC1 form  
    Then the ZGC1 form is generated using the ZPDT template  

  @TC-83  
  Scenario: Ensure Print Program SD_INVOICE_PRINT01 is invoked  
    Given the ZGC1 form is generated  
    When the user ensures the Print Program SD_INVOICE_PRINT01 is invoked during the generation process  
    Then the Print Program SD_INVOICE_PRINT01 is invoked successfully  

  @TC-83  
  Scenario: User prints the ZGC1 output  
    Given the Print Program SD_INVOICE_PRINT01 is invoked successfully  
    When the user attempts to print the ZGC1 output  
    Then the ZGC1 output is printed successfully  

  @TC-83  
  Scenario: Verify printed ZGC1 output for accuracy and completeness  
    Given the ZGC1 output is printed successfully  
    When the user verifies the printed output for accuracy and completeness  
    Then the printed ZGC1 output matches the expected format and contains all necessary details  

  @TC-83  
  Scenario: Validate the output is ready for customer delivery  
    Given the printed ZGC1 output matches the expected format  
    When the user validates the output for customer delivery  
    Then the output is confirmed to be ready for customer delivery  

  @TC-83  
  Scenario: User logs out of the SAP S/4HANA system  
    Given the user has completed all tasks  
    When the user logs out of the SAP S/4HANA system  
    Then the user is logged out successfully
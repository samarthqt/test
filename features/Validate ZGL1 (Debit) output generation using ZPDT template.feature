Feature: Validate ZGL1 (Debit) output generation using ZPDT template  
  Ensure ZGL1 output is generated correctly for debit adjustments using the ZPDT template and Print Program SD_INVOICE_PRINT01.  

  @TC-84  
  Scenario: User logs into the SAP S/4HANA system  
    Given the user has valid credentials  
    When the user logs into the SAP S/4HANA system  
    Then the user is successfully logged in and navigates to the SAP main menu  

  @TC-84  
  Scenario: User navigates to the Invoice Correction Request creation screen  
    Given the user is on the SAP main menu  
    When the user navigates to the Invoice Correction Request creation screen  
    Then the Invoice Correction Request creation screen is displayed  

  @TC-84  
  Scenario Outline: User selects Invoice Correction Request type and enters billing details  
    Given the user is on the Invoice Correction Request creation screen  
    When the user selects the Invoice Correction Request type as "<RequestType>"  
    And the user enters customer details as "<CustomerDetails>" and billing details for a debit adjustment of "<BillingAmount>"  
    Then the Invoice Correction Request type "<RequestType>" is selected  
    And customer and billing details are entered successfully  

    Examples:  
      | RequestType | CustomerDetails | BillingAmount |  
      | ZRK1        | Customer B      | $300          |  

  @TC-84  
  Scenario: User saves the Invoice Correction Request  
    Given the user has entered the required details for the Invoice Correction Request  
    When the user saves the Invoice Correction Request  
    Then the Invoice Correction Request is saved successfully  
    And a unique document number is generated  

  @TC-84  
  Scenario: User triggers the output generation process  
    Given the Invoice Correction Request is saved successfully  
    When the user triggers the output generation process for the saved Invoice Correction Request  
    Then the system initiates the output generation process  

  @TC-84  
  Scenario: Verify ZPDT template is used to generate ZGL1 form  
    Given the output generation process is initiated  
    When the user verifies the template used for generating the ZGL1 form  
    Then the ZGL1 form is generated using the ZPDT template  

  @TC-84  
  Scenario: Ensure Print Program SD_INVOICE_PRINT01 is invoked  
    Given the output generation process is initiated  
    When the user ensures the Print Program SD_INVOICE_PRINT01 is invoked  
    Then the Print Program SD_INVOICE_PRINT01 is invoked successfully  

  @TC-84  
  Scenario: User prints the ZGL1 output  
    Given the ZGL1 form is generated successfully  
    When the user attempts to print the ZGL1 output  
    Then the ZGL1 output is printed successfully  

  @TC-84  
  Scenario: Verify printed ZGL1 output for accuracy and completeness  
    Given the ZGL1 output is printed successfully  
    When the user verifies the printed ZGL1 output for accuracy and completeness  
    Then the printed ZGL1 output matches the expected format  
    And the printed ZGL1 output contains all necessary details  

  @TC-84  
  Scenario: Validate output readiness for customer delivery  
    Given the printed ZGL1 output is verified successfully  
    When the user validates the readiness of the output for customer delivery  
    Then the output is confirmed to be ready for customer delivery  

  @TC-84  
  Scenario: User logs out of the SAP S/4HANA system  
    Given the user has completed all actions in the SAP S/4HANA system  
    When the user logs out of the SAP S/4HANA system  
    Then the user is logged out successfully
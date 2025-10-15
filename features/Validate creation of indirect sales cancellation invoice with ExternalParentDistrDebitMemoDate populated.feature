Feature: Validate creation of indirect sales cancellation invoice with ExternalParentDistrDebitMemoDate populated  
  Ensure that an indirect sales cancellation invoice can be created successfully when ExternalParentDistrDebitMemoDate is populated. Billing document type S1 is configured for indirect sales cancellations.

  @TC-388
  Scenario: User successfully logs into the SAP S/4HANA Cloud system  
    Given the user has valid credentials  
    When the user logs into the SAP S/4HANA Cloud system  
    Then the user is successfully logged into the system  

  @TC-388
  Scenario: User navigates to the billing document creation screen  
    Given the user is logged into the SAP S/4HANA Cloud system  
    When the user navigates to the billing document creation screen  
    Then the billing document creation screen is displayed  

  @TC-388
  Scenario: User selects billing type S1 for indirect sales cancellations  
    Given the user is on the billing document creation screen  
    When the user selects billing type "S1" for indirect sales cancellations  
    Then billing type "S1" is selected  

  @TC-388
  Scenario: User enters the necessary invoice details  
    Given the user is on the billing document creation screen  
    When the user enters the necessary invoice details, including "ExternalParentDistrDebitMemoDate"  
    Then the invoice details are entered successfully  

  @TC-388
  Scenario: User saves the invoice  
    Given the user has entered the necessary invoice details  
    When the user saves the invoice  
    Then the invoice is created successfully  

  @TC-388
  Scenario: User validates the invoice data in relevant tables  
    Given the invoice is created successfully  
    When the user navigates to the relevant tables in the system  
    Then the relevant tables show the correct invoice data  

  @TC-388
  Scenario: User ensures invoice data is transmitted correctly across interfaces  
    Given the invoice is created successfully  
    When the user checks the interfaces in the system  
    Then the invoice data is transmitted correctly across interfaces  

  @TC-388
  Scenario: User generates a report for the created invoice  
    Given the invoice is created successfully  
    When the user generates a report for the created invoice  
    Then the report shows the correct field data, including "ExternalParentDistrDebitMemoDate"  

  @TC-388
  Scenario: User validates data consistency across all related tables  
    Given the invoice is created successfully  
    When the user validates data consistency across all related tables  
    Then data consistency is maintained across all related tables  

  @TC-388
  Scenario: User reviews audit logs for error-free processing  
    Given the invoice is created successfully  
    When the user reviews the audit logs in the system  
    Then the audit logs confirm error-free processing  

  @TC-388
  Scenario: User confirms correctness of the invoice data  
    Given the invoice is created successfully  
    When the user reviews the invoice data  
    Then the user confirms the correctness of the invoice data  

  @TC-388
  Scenario: User validates invoice readiness for further processing  
    Given the invoice is created successfully  
    When the user validates the readiness of the invoice  
    Then the invoice is ready for further processing
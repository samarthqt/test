Feature: Validate billing correction for ZL2C document type  
  To ensure that the system correctly creates and processes billing corrections for ZL2C document types and generates the appropriate output (ZGL1).

  @TC-101
  Scenario: User logs into the SAP system with valid credentials  
    Given the user has valid credentials  
    When the user logs into the SAP system  
    Then the user successfully logs into the SAP system  

  @TC-101
  Scenario: User navigates to the billing correction form  
    Given the user is logged into the SAP system  
    When the user navigates to the billing correction form using the appropriate transaction code  
    Then the billing correction form is displayed with mandatory fields Customer ID, Billing Date, and Amount  

  @TC-101
  Scenario: User selects the option to create a new correction request  
    Given the user is on the billing correction form  
    When the user selects the option to create a new correction request  
    Then the system displays the form for creating a new correction request with output type ZGL1  

  @TC-101
  Scenario Outline: User enters the ZL2C document number  
    Given the user is on the form for creating a new correction request  
    When the user enters the ZL2C document number "<Document Number>" in the provided field  
    Then the system validates the document number and retrieves the associated details  

    Examples:  
      | Document Number |  
      | 654321          |  

  @TC-101
  Scenario Outline: User fills in all mandatory fields for the correction request  
    Given the user has entered the ZL2C document number  
    When the user fills in all mandatory fields with the following details:  
      | Field        | Value          |  
      | Customer ID  | <Customer ID>  |  
      | Billing Date | <Billing Date> |  
      | Amount       | <Amount>       |  
    Then all mandatory fields are populated without errors  

    Examples:  
      | Customer ID | Billing Date | Amount |  
      | CUST123     | 2023-10-01  | 1000   |  

  @TC-101
  Scenario: User reviews and submits the correction request  
    Given the user has filled in all mandatory fields  
    When the user reviews the entered details and submits the correction request  
    Then the system accepts the submission and processes the correction request  

  @TC-101
  Scenario: System generates the ZGL1 output for the correction request  
    Given the correction request has been submitted  
    When the system processes the correction request  
    Then the system generates the ZGL1 output and links it to the correction request  

  @TC-101
  Scenario: User verifies the document flow for the ZL2C document  
    Given the ZGL1 output is generated for the correction request  
    When the user navigates to the document flow for the ZL2C document  
    Then the document flow shows the correction request linked to the original ZL2C document  

  @TC-101
  Scenario: User checks the status of the correction request  
    Given the correction request is linked to the ZL2C document  
    When the user checks the status of the correction request in the system  
    Then the status is updated to 'Processed' or equivalent  

  @TC-101
  Scenario: User validates the financial postings associated with the correction request  
    Given the correction request has been processed  
    When the user validates the financial postings associated with the correction request  
    Then the financial postings are accurate and reflect the correction request  

  @TC-101
  Scenario: User generates a report to confirm the ZGL1 output  
    Given the correction request has been processed  
    When the user generates a report for the correction request  
    Then the report shows the ZGL1 output with accurate details  

  @TC-101
  Scenario: User logs out of the SAP system  
    Given the user has completed all necessary actions  
    When the user logs out of the SAP system  
    Then the user successfully logs out of the system
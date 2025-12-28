Feature: Validate ZRK1 Correction Request Creation and Output Generation  
  Ensure the system correctly creates a ZRK1 correction request, generates a ZL2C debit document, and links output ZGL1. The system must be configured with document type mappings for ZRK1 corrections.

  @TC-531
  Scenario: User logs into the SAP S/4HANA Cloud system  
    Given the user has valid credentials  
    When the user logs into the SAP S/4HANA Cloud system  
    Then the user is successfully logged into the system  

  @TC-531
  Scenario: User navigates to the billing correction form  
    Given the user is logged into the SAP S/4HANA Cloud system  
    When the user navigates to the billing correction form  
    Then the billing correction form is displayed  

  @TC-531
  Scenario Outline: User creates a new ZRK1 correction request  
    Given the user is on the billing correction form  
    When the user selects to create a new correction request of type "<CorrectionRequestType>"  
    Then the correction request form for "<CorrectionRequestType>" is displayed  

    Examples:  
      | CorrectionRequestType |  
      | ZRK1                  |  

  @TC-531
  Scenario Outline: User fills in mandatory fields for ZRK1 correction request  
    Given the user is on the correction request form for ZRK1  
    When the user enters the mandatory fields:  
      | Field           | Value            |  
      | Customer ID     | <CustomerID>     |  
      | Billing Document| <BillingDocument>|  
      | Amount          | <Amount>         |  
      | Reason Code     | <ReasonCode>     |  
    Then all mandatory fields are populated with valid data  
    And the expected output type is "<OutputType>"  

    Examples:  
      | CustomerID | BillingDocument | Amount | ReasonCode | OutputType |  
      | 12345      | BD001           | 100.00 | RC01       | ZGL1       |  

  @TC-531
  Scenario: User submits the ZRK1 correction request  
    Given the user has filled in all mandatory fields for ZRK1 correction request  
    When the user submits the ZRK1 correction request  
    Then the ZRK1 correction request is successfully submitted  

  @TC-531
  Scenario Outline: System generates a debit document of type ZL2C  
    Given the ZRK1 correction request has been successfully submitted  
    When the system generates a debit document  
    Then the debit document of type "<DebitDocumentType>" is created  
    And the debit document is linked to the correction request  

    Examples:  
      | DebitDocumentType |  
      | ZL2C              |  

  @TC-531
  Scenario Outline: System generates output linked to the debit document  
    Given the debit document of type ZL2C is created  
    When the system generates output for the debit document  
    Then the output "<OutputType>" is generated  
    And the output is linked to the debit document  

    Examples:  
      | OutputType |  
      | ZGL1       |  

  @TC-531
  Scenario: Verify traceability of the debit document and output  
    Given the debit document and output are generated  
    When the user verifies the traceability  
    Then all documents and outputs are traceable to the original correction request  

  @TC-531
  Scenario: Check financial postings for the debit document  
    Given the debit document is generated  
    When the user checks the financial postings in the system  
    Then the financial postings are accurate and align with the correction request  

  @TC-531
  Scenario: Validate audit trail for correction request and associated documents  
    Given the correction request, debit document, and output are generated  
    When the user validates the audit trail  
    Then the audit trail shows a clear linkage between the correction request, debit document, and output  

  @TC-531
  Scenario: Ensure compliance with business rules and financial integrity  
    Given the correction request process is completed  
    When the user validates compliance  
    Then all processes comply with business rules and maintain financial integrity  

  @TC-531
  Scenario: User logs out of the SAP system  
    Given the user has completed their tasks  
    When the user logs out of the SAP system  
    Then the user is logged out successfully
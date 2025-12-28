Feature: Validate ZRK Correction Request Creation and Output Generation  
  Ensure the system correctly creates a ZRK correction request, generates a ZG2C credit document, and links output ZGC1. The system must be configured with document type mappings for ZRK corrections.

  @TC-530
  Scenario: User successfully logs into the SAP S/4HANA Cloud system
    Given the user opens the SAP S/4HANA Cloud system
    When the user enters valid login credentials
    Then the user is successfully logged into the system

  @TC-530
  Scenario: User navigates to the billing correction form
    Given the user is logged into the SAP S/4HANA Cloud system
    When the user navigates to the billing correction form
    Then the billing correction form is displayed

  @TC-530
  Scenario Outline: User creates a ZRK correction request with mandatory fields
    Given the user is on the billing correction form
    When the user selects correction request type "<CorrectionRequestType>"
    And the user fills in mandatory fields: Customer ID "<CustomerID>", Billing Document "<BillingDocument>", Amount "<Amount>", and Reason Code "<ReasonCode>"
    And the user submits the correction request
    Then the ZRK correction request is successfully submitted
    And a credit document of type "<ExpectedCreditDocumentType>" is created and linked to the correction request
    And the output "<ExpectedOutputType>" is generated and linked to the credit document

    Examples:
      | CorrectionRequestType | CustomerID | BillingDocument | Amount | ReasonCode | ExpectedCreditDocumentType | ExpectedOutputType |
      | ZRK                  | CUST001    | BILL123         | 100.00 | RC01       | ZG2C                      | ZGC1               |
      | ZRK                  | CUST002    | BILL456         | 200.00 | RC02       | ZG2C                      | ZGC1               |

  @TC-530
  Scenario: Verify traceability of the credit document and output
    Given the user has successfully created a ZRK correction request
    When the user verifies the traceability of the credit document and output
    Then all documents and outputs are traceable to the original correction request

  @TC-530
  Scenario: Validate financial postings for the generated credit document
    Given the user has successfully created a ZRK correction request
    When the user checks the financial postings for the generated credit document
    Then the financial postings are accurate and align with the correction request

  @TC-530
  Scenario: Validate the audit trail for the correction request and associated documents
    Given the user has successfully created a ZRK correction request
    When the user checks the audit trail for the correction request and associated documents
    Then the audit trail shows a clear linkage between the correction request, credit document, and output

  @TC-530
  Scenario: Ensure compliance with business rules and financial integrity
    Given the user has successfully created a ZRK correction request
    When the user validates compliance with business rules and financial integrity
    Then all processes comply with business rules and maintain financial integrity

  @TC-530
  Scenario: User logs out of the SAP system
    Given the user is logged into the SAP S/4HANA Cloud system
    When the user logs out of the system
    Then the user is logged out successfully
Feature: Validate data consistency after replacing ExternalInvoiceDate with ExternalParentDistrDebitMemoDate

  @TC-389
  Scenario: User logs into the SAP S/4HANA Cloud system and navigates to the billing document creation screen
    Given the user has appropriate credentials
    When the user logs into the SAP S/4HANA Cloud system
    Then the user is successfully logged into the system

  @TC-389
  Scenario: User navigates to the billing document creation screen
    When the user navigates to the billing document creation screen
    Then the billing document creation screen is displayed

  @TC-389
  Scenario Outline: User selects billing type S1 and enters invoice details for indirect sales cancellations
    Given the user is on the billing document creation screen
    When the user selects billing type "<BillingType>"
    And the user enters the necessary invoice details, including "<ExternalParentDistrDebitMemoDate>"
    Then the invoice details are entered successfully

    Examples:
      | BillingType | ExternalParentDistrDebitMemoDate |
      | S1          | 2023-10-01                      |

  @TC-389
  Scenario: User saves the invoice
    Given the user has entered the necessary invoice details
    When the user saves the invoice
    Then the invoice is created successfully

  @TC-389
  Scenario: System replaces ExternalInvoiceDate with ExternalParentDistrDebitMemoDate
    Given the invoice is created successfully
    When the user verifies in the system
    Then the ExternalInvoiceDate is replaced with ExternalParentDistrDebitMemoDate

  @TC-389
  Scenario: User validates data in relevant tables after replacement
    Given the ExternalInvoiceDate is replaced with ExternalParentDistrDebitMemoDate
    When the user navigates to the relevant tables in the system
    Then the data in the relevant tables reflects the replacement of ExternalInvoiceDate with ExternalParentDistrDebitMemoDate

  @TC-389
  Scenario: User ensures updated data is transmitted correctly across interfaces
    Given the data in the relevant tables reflects the replacement
    When the user checks the interfaces
    Then the updated data is transmitted correctly across interfaces

  @TC-389
  Scenario: User validates data consistency across all related tables
    Given the updated data is transmitted correctly across interfaces
    When the user validates data consistency across all related tables
    Then data consistency is maintained across all related tables

  @TC-389
  Scenario: User generates a report for the created invoice and validates field data
    Given the data consistency is maintained across all related tables
    When the user generates a report for the created invoice
    Then the report shows the correct field data with ExternalParentDistrDebitMemoDate

  @TC-389
  Scenario: User reviews audit logs for error-free processing
    Given the report shows the correct field data
    When the user reviews the audit logs
    Then the audit logs confirm error-free processing

  @TC-389
  Scenario: User confirms the correctness of the invoice data
    Given the audit logs confirm error-free processing
    When the user reviews the invoice data
    Then the user confirms the correctness of the invoice data
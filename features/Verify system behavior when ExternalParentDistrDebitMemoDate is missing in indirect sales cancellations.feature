Feature: Verify system behavior when ExternalParentDistrDebitMemoDate is missing in indirect sales cancellations

  @TC-563
  Scenario Outline: Validate invoice processing with ExternalParentDistrDebitMemoDate field
    Given the user logs into the SAP S/4 HANA Cloud system with valid credentials
    And the user navigates to the billing document creation module
    When the user selects billing document type "<BillingDocumentType>" for indirect sales cancellations
    And the user enters invoice details with ExternalParentDistrDebitMemoDate field as "<ExternalParentDistrDebitMemoDate>"
    And the user attempts to process the invoice
    Then the system prevents the processing of the invoice
    And the system displays an error message "<ErrorMessage>"
    And the error message accurately describes the issue and provides guidance for resolution
    When the user attempts to save the invoice without processing
    Then the system prevents saving the invoice due to the missing field
    And the system logs include entries describing the error and action taken
    And no invalid invoices are created in the system
    When the user populates the ExternalParentDistrDebitMemoDate field and reprocesses the invoice
    Then the invoice is processed successfully

    Examples:
      | BillingDocumentType | ExternalParentDistrDebitMemoDate | ErrorMessage                                      |
      | S1                  | NULL                             | ExternalParentDistrDebitMemoDate field is missing |

  @TC-563
  Scenario: Document error message and system behavior for reporting
    Given the user logs into the SAP S/4 HANA Cloud system with valid credentials
    And the user navigates to the billing document creation module
    When the user encounters an error due to missing ExternalParentDistrDebitMemoDate field
    Then the user documents the error message and system behavior for reporting purposes
Feature: Validate replacement of ExternalInvoiceDate with ExternalParentDistrDebitMemoDate for indirect sales cancellations

  @TC-387
  Scenario: User logs into the SAP S/4HANA Cloud system
    Given user has appropriate credentials
    When user logs into the SAP S/4HANA Cloud system
    Then user is successfully logged into the system

  @TC-387
  Scenario: User navigates to the billing document creation screen
    Given user is logged into the SAP S/4HANA Cloud system
    When user navigates to the billing document creation screen
    Then billing document creation screen is displayed

  @TC-387
  Scenario Outline: User selects billing type S1 for indirect sales cancellations
    Given user is on the billing document creation screen
    When user selects billing type "<billingType>" for indirect sales cancellations
    Then billing type "<billingType>" is selected

    Examples:
      | billingType |
      | S1          |

  @TC-387
  Scenario Outline: User enters invoice details including ExternalParentDistrDebitMemoDate
    Given user has selected billing type "<billingType>"
    When user enters the necessary invoice details, including ExternalParentDistrDebitMemoDate "<externalParentDistrDebitMemoDate>"
    Then invoice details are entered successfully

    Examples:
      | billingType | externalParentDistrDebitMemoDate |
      | S1          | 2023-10-01                      |

  @TC-387
  Scenario: User saves the invoice
    Given user has entered the necessary invoice details
    When user saves the invoice
    Then invoice is created successfully

  @TC-387
  Scenario: User verifies replacement of ExternalInvoiceDate with ExternalParentDistrDebitMemoDate
    Given user has saved the invoice
    When user verifies the system data
    Then ExternalInvoiceDate is replaced with ExternalParentDistrDebitMemoDate

  @TC-387
  Scenario: User validates updated data in relevant tables
    Given ExternalInvoiceDate is replaced with ExternalParentDistrDebitMemoDate
    When user navigates to the relevant tables in the system
    Then data in the relevant tables reflects the replacement of ExternalInvoiceDate with ExternalParentDistrDebitMemoDate

  @TC-387
  Scenario: User checks interfaces for correct data transmission
    Given data in the relevant tables reflects the replacement of ExternalInvoiceDate with ExternalParentDistrDebitMemoDate
    When user checks the interfaces
    Then updated data is transmitted correctly across interfaces

  @TC-387
  Scenario: User validates data consistency across related tables
    Given updated data is transmitted correctly across interfaces
    When user validates data consistency across all related tables
    Then data consistency is maintained across all related tables

  @TC-387
  Scenario: User generates a report for the created invoice
    Given data consistency is maintained across all related tables
    When user generates a report for the created invoice
    Then report shows the correct field data with ExternalParentDistrDebitMemoDate

  @TC-387
  Scenario: User reviews audit logs for error-free processing
    Given report shows the correct field data with ExternalParentDistrDebitMemoDate
    When user reviews the audit logs
    Then audit logs confirm error-free processing

  @TC-387
  Scenario: User confirms the correctness of the invoice data
    Given audit logs confirm error-free processing
    When user validates the invoice data
    Then user confirms the correctness of the invoice data
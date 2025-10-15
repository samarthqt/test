Feature: Validate negative sign conventions for ExternalInvoiceQuantityAmount in Indirect Sales

  @TC-381
  Scenario: User logs into the SAP system successfully
    Given user has valid credentials
    When user logs into the SAP system
    Then user is logged into the SAP system successfully

  @TC-381
  Scenario: User navigates to the Indirect Sales processing program
    Given user is logged into the SAP system
    When user navigates to the Indirect Sales processing program (ZOTC_INDSALES_MDLNE)
    Then the Indirect Sales processing program interface is displayed

  @TC-381
  Scenario Outline: User processes an indirect sales transaction
    Given user is on the Indirect Sales processing program interface
    When user processes an indirect sales transaction with billing document type "<BillingDocumentType>" using the provided test data: Transaction ID "<TransactionID>", Customer ID "<CustomerID>", Product ID "<ProductID>", Quantity "<Quantity>", Price "<Price>"
    Then the indirect sales transaction is processed successfully with billing document type "<BillingDocumentType>"

    Examples:
      | BillingDocumentType | TransactionID | CustomerID | ProductID | Quantity | Price |
      | S1                  | T10002        | C002       | P002      | 5        | 200   |

  @TC-381
  Scenario: User navigates to the generated data for the indirect sales transaction
    Given user has processed an indirect sales transaction
    When user navigates to the data generated for the indirect sales transaction
    Then the generated data for the indirect sales transaction is displayed

  @TC-381
  Scenario: User verifies the ExternalInvoiceQuantityAmount is displayed as negative
    Given user has navigated to the generated data for the indirect sales transaction
    When user verifies the ExternalInvoiceQuantityAmount in the generated data
    Then the ExternalInvoiceQuantityAmount is displayed as negative

  @TC-381
  Scenario: User validates the consistency of sign conventions with ZOTC_CROSSREFTAB table mappings
    Given user has verified the ExternalInvoiceQuantityAmount
    When user validates the consistency of the sign conventions with the ZOTC_CROSSREFTAB table mappings
    Then the sign conventions are consistent with the ZOTC_CROSSREFTAB table mappings

  @TC-381
  Scenario: User generates a report of the indirect sales transaction details
    Given user has validated the consistency of the sign conventions
    When user generates a report of the indirect sales transaction details
    Then the report is generated successfully showing the correct sign conventions

  @TC-381
  Scenario Outline: User exports the report for further validation
    Given user has generated the report of the indirect sales transaction details
    When user exports the report in "<Format>"
    Then the report is exported successfully in the desired format

    Examples:
      | Format    |
      | PDF       |
      | Excel     |

  @TC-381
  Scenario: User logs out of the SAP system
    Given user has completed all validations and actions
    When user logs out of the SAP system
    Then user is logged out of the SAP system successfully

  @TC-381
  Scenario: User documents the test results and observations
    Given user has logged out of the SAP system
    When user documents the test results and observations
    Then the test results and observations are documented accurately
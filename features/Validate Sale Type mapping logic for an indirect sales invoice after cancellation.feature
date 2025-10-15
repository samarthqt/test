Feature: Validate Sale Type mapping logic for an indirect sales invoice after cancellation

  @TC-56
  Scenario: User logs into the SAP S/4HANA system successfully
    Given the user has valid credentials
    When the user logs into the SAP S/4HANA system
    Then the user is logged in successfully

  @TC-56
  Scenario Outline: User creates an indirect sales invoice after cancellation and verifies Sale Type mapping
    Given the user is on the transaction screen for creating an indirect sales invoice after cancellation
      And an indirect sales cancellation invoice exists for Sales Order ID "<SalesOrderID>"
    When the user enters the billing document type as "<BillingDocumentType>"
      And the user provides the Sales Order ID as "<SalesOrderID>"
      And the user saves the invoice
    Then the invoice is saved successfully
      And the user navigates to the created invoice and opens the details
      And the Sale Type field in the invoice should be set to "<ExpectedSaleType>"
      And the relevant tables maintain data consistency
      And no errors or warnings are logged in the system logs
      And the invoice is correctly linked in the document flow
      And the output for the created invoice is rendered correctly as per the configuration
      And the linkage between the cancellation invoice and the new invoice is correctly established in the document flow

    Examples:
      | BillingDocumentType | SalesOrderID | ExpectedSaleType |
      | S1                 | 100003       | ADJ_BOTH         |
Feature: Validate Sale Type mapping logic for indirect sales invoices with VBTYP='M'

  @TC-55
  Scenario Outline: Validate the creation and mapping of Sale Type for indirect sales invoices
    Given the user is logged into the SAP S/4HANA system with valid credentials
    When the user navigates to the transaction code for creating an indirect sales invoice
    And the user enters the billing document type as "<BillingDocumentType>"
    And the user sets the VBTYP value to "<VBTYP>"
    And the user provides the Sales Order ID as "<SalesOrderID>"
    And the user saves the invoice
    Then the invoice is saved successfully
    And the user navigates to the created invoice and opens the details
    And the Sale Type field in the invoice is "<ExpectedSaleType>"
    And the relevant tables maintain data consistency
    And the system logs contain no errors or warnings during the process
    And the invoice is correctly linked in the document flow
    And the output for the created invoice is rendered correctly as per the configuration

    Examples:
      | BillingDocumentType | VBTYP | SalesOrderID | ExpectedSaleType |
      | S1                 | M     | 100002       | SALE             |
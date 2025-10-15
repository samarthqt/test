Feature: Validate inclusion of new billing document type ZF2 in Direct Sales processing

  @TC-28
  Scenario Outline: Validate the creation and processing of sales orders with billing document type ZF2
    Given the user is logged into the SAP system and navigates to the ZOTC_SALES_ORDER program
    When the user creates a new sales order with billing document type "<BillingDocumentType>" using valid customer and product data
    Then the sales order is successfully created with the billing document type "<BillingDocumentType>"
    When the user processes the sales order to generate a billing document
    Then the billing document is successfully generated without errors
    And the generated billing document reflects the correct document type "<BillingDocumentType>"
    And the ZOTC_CROSSREFTAB table contains the correct mapping for the document type "<BillingDocumentType>"
    And the document flow shows the correct linkage between the sales order and the billing document
    And the financial postings created for the billing document are accurate and align with the sales order details
    And the billing document type "<BillingDocumentType>" is included in the Direct Sales reporting
    And the tax calculations for the billing document are accurate and comply with the configured rules

    Examples:
      | BillingDocumentType |
      | ZF2                |

  @TC-28
  Scenario: Validate repeated processing of sales orders with billing document type ZF2
    Given the user is logged into the SAP system and navigates to the ZOTC_SALES_ORDER program
    When the user creates and processes a second sales order with billing document type ZF2 using valid customer and product data
    Then the second sales order and billing document are processed successfully with the correct document type ZF2

  @TC-28
  Scenario: Validate system logs for ZF2 processing
    Given the user has processed sales orders with billing document type ZF2
    When the user checks the system logs
    Then the system logs confirm successful processing without errors

  @TC-28
  Scenario: Log out of the SAP system
    Given the user has completed validation of ZF2 billing document processing
    When the user logs out of the SAP system
    Then the user is successfully logged out
Feature: Validate inclusion of new billing document type S1 in Direct Sales processing

  @TC-29
  Scenario Outline: Validate the creation and processing of a sales order with billing document type S1
    Given the user logs into the SAP system and navigates to the ZOTC_SALES_ORDER program
    When the user creates a new sales order with billing document type "<billingDocumentType>" using valid customer and product data
    Then the sales order is successfully created with the billing document type "<billingDocumentType>"
    And the ZOTC_CROSSREFTAB table contains the correct mapping for the billing document type "<billingDocumentType>"
    When the user processes the sales order to generate a billing document
    Then the billing document is successfully generated without errors
    And the generated billing document reflects the document type "<billingDocumentType>"
    And the document flow shows the correct linkage between the sales order and the billing document
    And the financial postings created for the billing document type "<billingDocumentType>" are accurate and align with the sales order details
    And the system logs confirm successful processing without errors
    And the Direct Sales reporting includes the billing document type "<billingDocumentType>"
    And the tax calculations for the billing document type "<billingDocumentType>" are accurate and comply with the configured rules

    Examples:
      | billingDocumentType |
      | S1                  |

  @TC-29
  Scenario: Validate the processing of a second sales order with billing document type S1
    Given the user logs into the SAP system and navigates to the ZOTC_SALES_ORDER program
    When the user creates and processes another sales order with billing document type S1 using valid customer and product data
    Then the second sales order and billing document are processed successfully with the correct document type S1

  @TC-29
  Scenario: Verify the user can log out of the SAP system
    Given the user is logged into the SAP system
    When the user logs out of the SAP system
    Then the user is successfully logged out
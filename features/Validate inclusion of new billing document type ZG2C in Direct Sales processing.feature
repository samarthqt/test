Feature: Validate inclusion of new billing document type ZG2C in Direct Sales processing

  @TC-30
  Scenario Outline: User processes and validates sales orders with billing document type ZG2C
    Given the user logs into the SAP system and navigates to the ZOTC_SALES_ORDER program
    When the user creates a new sales order with the billing document type "<billingDocumentType>" using "<customerData>" and "<productData>"
    Then the sales order is successfully created with the billing document type "<billingDocumentType>"
    When the user processes the sales order to generate a billing document
    Then the billing document is successfully generated without errors
    And the generated billing document reflects the correct document type "<billingDocumentType>"
    And the ZOTC_CROSSREFTAB table contains the correct mapping for the document type "<billingDocumentType>"
    And the document flow shows the correct linkage between the sales order and the billing document
    And the financial postings created for the billing document are accurate and align with the sales order details
    And the billing document type "<billingDocumentType>" is included in the Direct Sales reporting
    And the tax calculations for the billing document are accurate and comply with the configured rules
    And the system logs do not show any errors related to "<billingDocumentType>" processing

    Examples:
      | billingDocumentType | customerData | productData |
      | ZG2C                | Valid        | Valid       |

  @TC-30
  Scenario: User repeats the process for another sales order with billing document type ZG2C
    Given the user logs into the SAP system and navigates to the ZOTC_SALES_ORDER program
    When the user creates and processes another sales order with the billing document type "ZG2C" using valid customer and product data
    Then the second sales order and billing document are processed successfully with the correct document type "ZG2C"

  @TC-30
  Scenario: User logs out of the SAP system
    Given the user is logged into the SAP system
    When the user logs out of the system
    Then the user is successfully logged out
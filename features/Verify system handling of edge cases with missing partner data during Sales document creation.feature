Feature: Verify system handling of edge cases with missing partner data during Sales document creation

  @TC-197
  Scenario Outline: Validate system behavior when header partner data is missing and reference items contain only partial partner data
    Given user logs in to the SAP system with valid credentials
    When user navigates to the transaction code for creating Sales documents "<TransactionCode>"
    And user inputs the Billing document ID "<BillingDocumentID>" in the reference field
    And user selects the Sales document type "<SalesDocumentType>" for creation
    And user executes the FV45C003 routine for copying partner data
    Then the system processes the Billing document and identifies missing partner data "<MissingPartnerData>"
    And the system attempts to complete the header data with partial partner data
    When user saves the Sales document and finalizes creation
    Then the Sales document is saved successfully with partial partner data
    When user navigates to the document flow
    Then the document flow shows correct linkage between the Billing document and the newly created Sales document
    When user checks the header-level partner data for completeness
    Then the header-level partner data is "<HeaderPartnerData>"
    When user generates a report of the created Sales document
    Then the generated report accurately reflects the Sales document details, including partial partner data
    And user logs out of the SAP system successfully

    Examples:
      | TransactionCode | BillingDocumentID | SalesDocumentType | MissingPartnerData       | HeaderPartnerData     |
      | VA01            | ZL2               | ZCR               | Bill-to and Ship-to      | Partially complete    |
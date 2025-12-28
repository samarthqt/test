Feature: Validate system handling of exactly 999 line items without splitting

  @TC-543
  Scenario Outline: Ensure the system creates a single billing document for exactly 999 line items and posts it to accounting without splitting
    Given the user navigates to the billing due program in the SAP system
    When the user selects the source document with "<number_of_line_items>" line items
    And the user executes the program to create billing documents
    Then the system creates "<expected_billing_documents>" billing document(s) containing all "<line_items_created>" line items
    And the resulting billing document is posted to accounting successfully
    And the user navigates to the accounting module and locates the posted billing document
    And all "<line_items_verified>" line items are present and accurately recorded
    And the document header contains correct and complete information
    And the document type "<document_type>" and numbering sequence are correct as per the configuration
    And the processing logs show "<log_status>" related to document splitting or posting
    And the system performs optimally without delays or crashes
    And the billing document is available for further processing without any issues

    Examples:
      | number_of_line_items | expected_billing_documents | line_items_created | line_items_verified | document_type          | log_status          |
      | 999                  | 1                          | 999                | 999                 | Standard Billing Document | no errors or warnings |
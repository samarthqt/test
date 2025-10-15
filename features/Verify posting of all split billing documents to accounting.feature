Feature: Verify posting of all split billing documents to accounting

  @TC-175
  Scenario Outline: Validate the posting of split billing documents
    Given the user navigates to the billing due program in SAP S/4HANA
    When the user selects the source document with "<line_items>" line items
    And the user executes the program to create billing documents
    Then the system splits the billing document into multiple documents, each containing a maximum of 999 line items
    And the total number of line items across all split documents equals the source document's total line items
    And all resulting billing documents are posted to accounting successfully
    And accounting documents are generated for each split billing document
    And accounting entries match the details in the split billing documents
    And the status of all split billing documents is updated to 'Posted'
    And the document flow shows proper linkage between the source document, split billing documents, and accounting documents
    And no errors are logged during the posting process
    And the system generates a summary report showing successful posting of all split billing documents

    Examples:
      | line_items |
      | 2500       |
      | 1500       |
      | 1000       |
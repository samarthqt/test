Feature: Verify total line item count matches across split billing documents

  @TC-174
  Scenario Outline: Validate the billing document splitting process and line item consistency
    Given the user navigates to the billing due program in SAP S/4HANA
    When the user selects the source document with <line_item_count> line items
    And the user executes the program to create billing documents
    Then the system splits the billing document into multiple documents, each containing a maximum of 999 line items
    And the total number of line items across all split documents equals the source document's total of <line_item_count>
    And all resulting billing documents are posted to accounting successfully
    And the document flow shows proper linkage between the source document and split billing documents
    And there are no discrepancies in the line item count across split billing documents
    And the line items are sequentially distributed across split billing documents
    And the details of each line item match the source document
    And all split billing documents are saved and accessible in the system
    And the system performs efficiently without any performance degradation

    Examples:
      | line_item_count |
      | 2000            |
      | 1500            |
      | 1001            |
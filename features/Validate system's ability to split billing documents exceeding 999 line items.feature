Feature: Validate system's ability to split billing documents exceeding 999 line items

  @TC-173
  Scenario: User navigates to the billing due program interface
    Given the user is in SAP S/4HANA
    When the user navigates to the billing due program
    Then the billing due program interface is displayed

  @TC-173
  Scenario Outline: User selects a source document with more than 999 line items
    Given the source document contains "<line_items>" line items
    And the source document is ready for processing
    When the user selects the source document
    Then the source document is successfully selected for processing

    Examples:
      | line_items |
      | 1500       |
      | 2000       |

  @TC-173
  Scenario: User executes the program to create billing documents
    Given the user has selected a source document with more than 999 line items
    When the user executes the program to create billing documents
    Then the system begins processing the source document

  @TC-173
  Scenario: Verify the system splits the billing document into multiple documents
    Given the source document contains more than 999 line items
    When the system processes the source document
    Then the system splits the billing document into multiple documents
    And each document contains no more than 999 line items

  @TC-173
  Scenario: Verify the total number of line items across all split documents
    Given the source document contains 1500 line items
    And the system has split the billing document into multiple documents
    When the user checks the total number of line items across all split documents
    Then the total number of line items equals the source document's total line items

  @TC-173
  Scenario: Verify all resulting billing documents are posted to accounting
    Given the system has split the billing document into multiple documents
    When the user verifies the posting of all billing documents
    Then all billing documents are posted to accounting without errors

  @TC-173
  Scenario: Verify the document flow for each split billing document
    Given the system has split the billing document into multiple documents
    When the user reviews the document flow
    Then the document flow shows proper linkage between the source document and split billing documents

  @TC-173
  Scenario: Check the log for warnings or errors during processing
    Given the system has processed the source document
    When the user checks the log
    Then no warnings or errors are logged during the process

  @TC-173
  Scenario: Verify customer and material details in split billing documents
    Given the system has split the billing document into multiple documents
    When the user verifies the customer and material details in each document
    Then customer and material details are accurately copied to all split billing documents

  @TC-173
  Scenario: Validate pricing conditions in split billing documents
    Given the system has split the billing document into multiple documents
    When the user validates pricing conditions in each document
    Then pricing conditions are correctly calculated and applied in all split billing documents

  @TC-173
  Scenario: Ensure unique document numbers for split billing documents
    Given the system has split the billing document into multiple documents
    When the user verifies the document numbers
    Then each billing document has a unique document number

  @TC-173
  Scenario: Verify scalability of the system during document splitting
    Given the source document contains more than 999 line items
    When the system processes the document splitting
    Then the system performs efficiently without any performance degradation
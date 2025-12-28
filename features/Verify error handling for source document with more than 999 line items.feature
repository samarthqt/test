Feature: Verify error handling for source document with more than 999 line items

  @TC-544
  Scenario: User navigates to the billing due program
    Given the user navigates to the billing due program in the SAP system
    Then the billing due program interface is displayed successfully

  @TC-544
  Scenario Outline: Validate system response for documents with more than 999 line items
    Given a billing document with "<number_of_line_items>" line items is ready for processing
    When the user selects the source document
    Then the system selects the source document without errors
    When the user executes the program to create billing documents
    Then the system displays an error message indicating that the document exceeds the maximum allowed line items
    And the processing logs contain detailed information about the error and the reason for failure
    When the user attempts to post the document to accounting
    Then the system prevents the document from being posted to accounting
    And no partial or incomplete billing documents are created in the system
    And the system handles the error gracefully without crashing or slowing down
    And the system provides clear instructions or suggestions to correct the issue
    When the user modifies the document to "<modified_number_of_line_items>" and reprocesses
    Then the system allows the modified document to be reprocessed successfully
    And no unintended side effects or data inconsistencies are observed
    And the error scenario is logged with all relevant details for future reference

    Examples:
      | number_of_line_items | modified_number_of_line_items |
      | 1000                 | 999                           |
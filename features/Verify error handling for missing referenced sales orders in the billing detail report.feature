Feature: Verify error handling for missing referenced sales orders in the billing detail report

  @TC-199
  Scenario Outline: Validate system behavior for missing referenced sales orders
    Given the user is logged into the SAP S/4HANA system with valid credentials
    When the user navigates to the transaction for creating a Credit Memo Request of type "<Credit Memo Request Type>"
    And the user enters the Billing document number "<Billing Document Number>" as a reference
    And the user saves the Credit Memo Request
    And the user navigates to the 'display billing detail' report
    And the user searches for the Credit Memo Request created using the Billing document reference
    Then the system displays the Credit Memo Request in the search results
    And the referenced sales orders are "<Referenced Sales Orders>" in the report
    And the system logs contain "<System Log Message>"
    And the error messages displayed in the report are "<Error Message>"
    And the system "<Processing Behavior>"
    And the user documents the results of the test case execution
    And the user reports the error to the development team for analysis and resolution

    Examples:
      | Credit Memo Request Type | Billing Document Number | Referenced Sales Orders | System Log Message                          | Error Message                                | Processing Behavior                                              |
      | ZCR                     | 2345678901             | not displayed           | contains error messages indicating absence | indicate the absence of referenced sales orders | prevents further processing and prompts the user to correct data |
Feature: Validate system behavior for missing or incorrectly displayed referenced sales orders in the 'display billing detail' report

  @TC-198
  Scenario Outline: Validate the creation of Credit Memo Request with reference to a Billing document
    Given the user has logged into the SAP S/4HANA system with valid credentials
    When the user navigates to the transaction for creating a Credit Memo Request of type "<credit_memo_type>"
    And the user enters the Billing document number "<billing_document_number>" as a reference
    Then the system accepts the Billing document number and auto-populates the data
    And the user saves the Credit Memo Request
    Then the system generates the Credit Memo Request with a unique document number

    Examples:
      | credit_memo_type | billing_document_number |
      | ZCR             | 1234567890              |
      | ZDR             | 1234567890              |

  @TC-198
  Scenario Outline: Validate the display of referenced sales orders in the 'display billing detail' report
    Given the user navigates to the 'display billing detail' report
    When the user searches for the Credit Memo Request using the Billing document reference "<billing_document_reference>"
    Then the search results display the Credit Memo Request
    And the referenced sales orders "<referenced_sales_orders>" are displayed in the report

    Examples:
      | billing_document_reference | referenced_sales_orders |
      | 1234567890                 | 9876543210              |
      | 1234567890                 |                         |

  @TC-198
  Scenario Outline: Validate discrepancies or missing referenced sales orders in the report
    Given the user reviews the referenced sales orders displayed in the report
    When discrepancies or missing referenced sales orders are identified
    Then the system highlights the discrepancies or missing referenced sales orders
    And the user analyzes the system logs for errors related to missing or incorrect reference data
    Then the system logs contain detailed error messages indicating the discrepancies
    And the error messages displayed in the report are clear and indicate the nature of the discrepancies
    And the system flags the missing or incorrect data for correction

    Examples:
      | referenced_sales_orders |
      | 9876543210              |
      |                         |

  @TC-198
  Scenario: Document the results of the test case execution
    Given the user has completed the test case execution
    When the user documents the results of the test case execution
    Then the test case results are documented successfully
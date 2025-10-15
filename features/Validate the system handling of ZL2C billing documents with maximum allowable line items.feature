Feature: Validate the system handling of ZL2C billing documents with maximum allowable line items

  @TC-45
  Scenario: User logs into the SAP S/4HANA system
    Given the user has appropriate credentials
    When the user logs into the SAP S/4HANA system
    Then the user is successfully logged into the system

  @TC-45
  Scenario: Original billing document with maximum line items exists
    Given the original billing document number is "98765432"
    When the user checks the billing document
    Then the original billing document with maximum line items exists

  @TC-45
  Scenario: User navigates to the billing correction request creation screen
    When the user navigates to the billing correction request creation screen
    Then the billing correction request creation screen is displayed

  @TC-45
  Scenario Outline: User creates a billing correction request for the original document
    Given the user is on the billing correction request creation screen
    When the user enters the original billing document number "<original_document_number>" and selects billing correction request type "<request_type>"
    Then the billing correction request is linked to the original document
    And the maximum line items allowed are "<max_line_items>"

    Examples:
      | original_document_number | request_type | max_line_items |
      | 98765432                 | ZRK1         | 999            |

  @TC-45
  Scenario: User saves the billing correction request
    Given the billing correction request is linked to the original document
    When the user saves the billing correction request
    Then the billing correction request is successfully created

  @TC-45
  Scenario: User generates a ZL2C billing document linked to the correction request
    Given the billing correction request is successfully created
    When the user generates a ZL2C billing document linked to the billing correction request
    Then the ZL2C billing document is successfully generated

  @TC-45
  Scenario Outline: Verify ZL2C billing document contains the maximum allowable line items
    Given the ZL2C billing document is successfully generated
    When the user verifies the number of line items in the ZL2C billing document
    Then the ZL2C billing document includes "<line_items>" line items

    Examples:
      | line_items |
      | 999        |

  @TC-45
  Scenario: Check system performance during ZL2C billing document generation
    Given the ZL2C billing document is being generated
    When the user monitors the system performance metrics
    Then the system performance is within acceptable limits with no errors or delays

  @TC-45
  Scenario: Validate linkage between ZL2C billing document and the original billing document
    Given the ZL2C billing document is successfully generated
    When the user checks the document flow
    Then the document flow shows accurate linkage between the ZL2C billing document and the original billing document

  @TC-45
  Scenario: Generate report to review financial data consistency for ZL2C billing document
    Given the ZL2C billing document is successfully generated
    When the user generates a report for financial data consistency
    Then the financial data is consistent and reflects accurate sign conventions

  @TC-45
  Scenario: User logs out of the SAP S/4HANA system
    Given the user has completed their tasks
    When the user logs out of the SAP S/4HANA system
    Then the user is successfully logged out
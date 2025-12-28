Feature: Validate Billing Document Split Logic Based on PMF Site and Price Type

  @TC-204
  Scenario: User logs into the SAP S/4HANA system and accesses the billing module
    Given the user has appropriate authorization for billing document creation
    When the user logs into the SAP S/4HANA system
    Then the user successfully accesses the billing module

  @TC-204
  Scenario Outline: Create a sales order with PMF site and price type
    Given the user is in the billing module
    When the user creates a sales order with PMF site "<PMF Site>" and price type "<Price Type>"
    Then the sales order is created successfully with the specified attributes

    Examples:
      | PMF Site | Price Type  |
      | PMF001   | Standard    |

  @TC-204
  Scenario: Execute the billing process to generate billing documents
    Given the user has created a sales order with the required attributes
    When the user executes the billing process
    Then billing documents are generated successfully

  @TC-204
  Scenario Outline: Validate billing document split based on PMF site and price type
    Given the user has generated billing documents
    When the user validates the billing documents
    Then the billing documents are split correctly based on PMF site "<PMF Site>" and price type "<Price Type>"
    And the billing document type is "<Billing Document Type>"

    Examples:
      | PMF Site | Price Type  | Billing Document Type |
      | PMF001   | Standard    | ZF2                  |

  @TC-204
  Scenario: Check that Ship-to/Bill-to/Payer relationships are preserved
    Given the user has split billing documents
    When the user checks the relationships between Ship-to, Bill-to, and Payer
    Then the relationships are maintained accurately without any discrepancies

  @TC-204
  Scenario: Verify pricing constraints for split billing documents
    Given the user has split billing documents
    When the user verifies pricing constraints
    Then pricing constraints are validated and applied correctly

  @TC-204
  Scenario: Validate the document flow for split billing documents
    Given the user has split billing documents
    When the user validates the document flow
    Then the document flow displays accurate linkage between the sales order and billing documents

  @TC-204
  Scenario: Check accounting postings for split billing documents
    Given the user has split billing documents
    When the user checks the accounting postings
    Then accounting postings are accurate and comply with the defined logic

  @TC-204
  Scenario: Verify tax calculations for split billing documents
    Given the user has split billing documents
    When the user verifies tax calculations
    Then tax calculations are accurate and comply with business rules

  @TC-204
  Scenario: Validate invoice output format for split billing documents
    Given the user has split billing documents
    When the user validates the invoice output format
    Then the invoice output format meets the defined standards

  @TC-204
  Scenario: Check customer communication records for split billing documents
    Given the user has split billing documents
    When the user checks the customer communication records
    Then customer communication records are updated accurately for each document

  @TC-204
  Scenario: Ensure split logic configuration matches business requirements
    Given the user has access to the system configuration
    When the user verifies the split logic configuration
    Then the split logic configuration matches the business requirements
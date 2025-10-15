Feature: Validate system behavior for billing documents with one less than the maximum allowable line items

  @TC-53
  Scenario: User logs into the SAP S/4HANA system and accesses the Finance module
    Given the user has appropriate credentials
    When the user logs into the SAP S/4HANA system
    Then the user is successfully logged in and has access to the Finance module

  @TC-53
  Scenario: User navigates to the transaction for creating billing correction requests
    Given the user is logged into the SAP S/4HANA system
    When the user navigates to the transaction for creating billing correction requests
    Then the billing correction request creation screen is displayed

  @TC-53
  Scenario Outline: User enters billing correction request type and links to an existing billing document
    Given the user is on the billing correction request creation screen
    When the user enters the billing correction request type as "<request_type>"
    And the user links the correction request to an existing billing document with "<line_items>" line items
    Then the system accepts the billing correction request type
    And the system successfully links the correction request to the original billing document

    Examples:
      | request_type | line_items |
      | ZRK          | 998        |

  @TC-53
  Scenario: User saves the billing correction request
    Given the user has created a billing correction request
    When the user saves the billing correction request
    Then the billing correction request is saved successfully

  @TC-53
  Scenario: User generates the corresponding ZG2C billing document
    Given the user has saved the billing correction request
    When the user generates the corresponding ZG2C billing document
    Then the ZG2C billing document is generated successfully

  @TC-53
  Scenario: User verifies line item processing in the ZG2C document
    Given the ZG2C billing document is generated
    When the user verifies all line items in the ZG2C document
    Then all line items are correctly processed and linked to the original document

  @TC-53
  Scenario: User validates the document flow for proper linkage
    Given the ZG2C billing document is generated
    When the user validates the document flow
    Then the document flow shows correct linkage between all related documents

  @TC-53
  Scenario: User checks for errors or warnings in the system log
    Given the ZG2C billing document is generated
    When the user checks the system log for errors or warnings
    Then no errors or warnings are logged during the process

  @TC-53
  Scenario: User verifies financial postings for the ZG2C document
    Given the ZG2C billing document is generated
    When the user verifies the financial postings for the ZG2C document
    Then the financial postings are accurate and reflect the corrections made

  @TC-53
  Scenario: User inspects the billing document for discrepancies
    Given the ZG2C billing document is generated
    When the user inspects the billing document for discrepancies in line item processing
    Then no discrepancies are found in the line item processing

  @TC-53
  Scenario: User ensures the system generates a success message
    Given the ZG2C billing document is generated
    When the user completes the document creation process
    Then the system displays a success message indicating the billing document was created successfully
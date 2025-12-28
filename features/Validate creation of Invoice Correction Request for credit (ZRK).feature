Feature: Validate creation of Invoice Correction Request for credit (ZRK)

  Ensure the system successfully creates an Invoice Correction Request for credit (ZRK) and generates the subsequent credit memo in the SAP S/4HANA system configured with Invoice Correction Request type ZRK.

  @TC-73
  Scenario: User logs into the SAP S/4HANA system
    Given the user has valid credentials
    When the user logs into the SAP S/4HANA system
    Then the user is successfully logged in and has access to the Invoice Correction Request module

  @TC-73
  Scenario: User navigates to the Invoice Correction Request creation screen
    Given the user is logged into the SAP S/4HANA system
    When the user navigates to the Invoice Correction Request creation screen
    Then the Invoice Correction Request creation screen is displayed

  @TC-73
  Scenario Outline: User creates an Invoice Correction Request for credit
    Given the user is on the Invoice Correction Request creation screen
    When the user selects an existing sales invoice "<Invoice Number>" for correction
    And the user enters the correction type as "<Correction Type>"
    And the user enters the price adjustment as "<Price Adjustment>"
    And the user leaves the quantity adjustment field as "<Quantity Adjustment>"
    And the user saves the Invoice Correction Request
    Then the Invoice Correction Request is saved successfully with a unique request number

    Examples:
      | Invoice Number | Correction Type | Price Adjustment | Quantity Adjustment |
      | INV-001        | ZRK             | -$50             | None                |

  @TC-73
  Scenario: Validate credit memo generation for the correction request
    Given an Invoice Correction Request has been created
    When the user validates that a credit memo is generated for the correction request
    Then the credit memo is generated successfully and linked to the correction request

  @TC-73
  Scenario: Verify linkage between correction request and original billing document
    Given an Invoice Correction Request has been created
    When the user verifies the linkage between the correction request and the original billing document
    Then the linkage is correctly displayed in the document flow

  @TC-73
  Scenario: Check financial postings for the credit memo
    Given a credit memo has been generated
    When the user checks the financial postings for the credit memo
    Then the financial postings reflect the price adjustment accurately

  @TC-73
  Scenario: Verify credit memo visibility in the customer account statement
    Given a credit memo has been generated
    When the user verifies that the credit memo is visible in the customer account statement
    Then the credit memo is listed in the customer account statement

  @TC-73
  Scenario: User logs out of the SAP S/4HANA system
    Given the user has completed their tasks
    When the user logs out of the SAP S/4HANA system
    Then the user is logged out successfully
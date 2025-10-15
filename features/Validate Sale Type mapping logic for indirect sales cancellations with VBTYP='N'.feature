Feature: Validate Sale Type mapping logic for indirect sales cancellations with VBTYP='N'

  @TC-54
  Scenario: User logs into the SAP S/4HANA system successfully
    Given the user has valid credentials
    When the user logs into the SAP S/4HANA system
    Then the user is logged in successfully

  @TC-54
  Scenario: User navigates to the transaction code for creating an indirect sales cancellation invoice
    Given the user is logged into the SAP S/4HANA system
    When the user navigates to the transaction code for creating an indirect sales cancellation invoice
    Then the invoice creation screen is displayed

  @TC-54
  Scenario Outline: Validate invoice creation with billing document type, VBTYP value, and Sales Order ID
    Given the user is on the invoice creation screen
    When the user enters the billing document type as "<billingDocumentType>"
    And the user sets the VBTYP value to "<vbtypValue>"
    And the user provides the Sales Order ID as "<salesOrderID>"
    And the user saves the invoice
    Then the invoice is saved successfully

    Examples:
      | billingDocumentType | vbtypValue | salesOrderID |
      | S1                  | N          | 100001       |

  @TC-54
  Scenario: User verifies the details of the created invoice
    Given the invoice is created successfully
    When the user navigates to the created invoice and opens the details
    Then the invoice details are displayed

  @TC-54
  Scenario: Verify Sale Type field mapping in the created invoice
    Given the user has opened the details of the created invoice
    When the user verifies the Sale Type field in the invoice
    Then the Sale Type field is set to "ADJ_BOTH"

  @TC-54
  Scenario: Validate data consistency in relevant tables
    Given the invoice is created successfully
    When the user checks the relevant tables (e.g., VBRK, VBRP) for data consistency
    Then data consistency is maintained across all relevant tables

  @TC-54
  Scenario: Verify system logs for errors or warnings
    Given the invoice creation process is completed
    When the user verifies the system logs for any errors or warnings
    Then no errors or warnings are logged

  @TC-54
  Scenario: Validate linkage of the invoice in the document flow
    Given the invoice is created successfully
    When the user validates the linkage of the invoice in the document flow
    Then the invoice is correctly linked in the document flow

  @TC-54
  Scenario: Confirm output rendering for the created invoice
    Given the invoice is created successfully
    When the user confirms the output rendering for the created invoice
    Then the output is rendered correctly as per the configuration
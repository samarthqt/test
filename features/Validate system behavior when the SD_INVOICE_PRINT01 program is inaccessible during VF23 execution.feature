Feature: Validate system behavior when the SD_INVOICE_PRINT01 program is inaccessible during VF23 execution

  @TC-445
  Scenario: Verify user login to the SAP S/4HANA system
    Given the user has valid SAP credentials with VF23 execution authorization
    When the user logs into the SAP S/4HANA system
    Then the user is successfully logged into the SAP system

  @TC-445
  Scenario: Verify navigation to the VF23 transaction
    Given the user is logged into the SAP S/4HANA system
    When the user navigates to the VF23 transaction
    Then the VF23 transaction screen is displayed

  @TC-445
  Scenario Outline: Validate input of parameters to select an invoice list document
    Given the user is on the VF23 transaction screen
    When the user inputs the required parameters "<parameters>" to select an invoice list document
    Then the invoice list document is selected successfully
    And at least one invoice list document exists in the system linked to multiple invoices

    Examples:
      | parameters  |
      | ValidParams |
      | InvalidParams |

  @TC-445
  Scenario: Verify execution of the transaction to trigger Invoice List output
    Given the user has selected an invoice list document
    When the user executes the transaction to trigger the Invoice List output
    Then the system attempts to trigger the output

  @TC-445
  Scenario: Validate error message when SD_INVOICE_PRINT01 program is inaccessible
    Given the SD_INVOICE_PRINT01 program is inaccessible or incorrectly configured
    When the user attempts to trigger the Invoice List output
    Then an error message is displayed indicating that the SD_INVOICE_PRINT01 program is inaccessible

  @TC-445
  Scenario: Verify no output is generated due to inaccessible program
    Given the SD_INVOICE_PRINT01 program is inaccessible
    When the user attempts to trigger the Invoice List output
    Then no output is generated

  @TC-445
  Scenario: Document error message for further analysis
    Given an error message is displayed indicating that the SD_INVOICE_PRINT01 program is inaccessible
    When the user documents the error message
    Then the error message is documented successfully

  @TC-445
  Scenario: Validate system prevents further processing of the invoice list
    Given the SD_INVOICE_PRINT01 program is inaccessible
    When the user attempts further processing of the invoice list
    Then the system halts further processing due to the inaccessible program
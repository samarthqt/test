Feature: Validate alignment of Invoice List output with functional specifications

  @TC-443
  Scenario: User logs into the SAP S/4HANA system
    Given the user has valid SAP credentials with VF23 execution authorization
    When the user logs into the SAP S/4HANA system
    Then the user is successfully logged into the SAP system

  @TC-443
  Scenario: User navigates to the VF23 transaction
    Given the user is logged into the SAP system
    When the user navigates to the VF23 transaction
    Then the VF23 transaction screen is displayed

  @TC-443
  Scenario Outline: User inputs parameters to select an invoice list document
    Given the user is on the VF23 transaction screen
    When the user enters "<parameters>" to select an invoice list document
    Then the invoice list document is selected successfully

    Examples:
      | parameters             |
      | valid parameters       |
      | invalid parameters     |
      | blank parameters       |

  @TC-443
  Scenario: User executes the transaction to trigger the Invoice List output
    Given the user has selected an invoice list document
    When the user executes the transaction
    Then the Invoice List output is triggered successfully

  @TC-443
  Scenario: Validate that Output Type ZPIL is triggered
    Given the Invoice List output is triggered successfully
    When the user checks the output type
    Then Output Type ZPIL is confirmed as triggered

  @TC-443
  Scenario: Compare the generated output with the functional specification document
    Given the Invoice List output is triggered successfully
    When the user compares the generated output with the functional specification document
    Then the generated output matches the functional specification document

  @TC-443
  Scenario: Validate that the output format aligns with the documented scope
    Given the Invoice List output is triggered successfully
    When the user validates the output format
    Then the output format aligns with the documented scope

  @TC-443
  Scenario Outline: Validate that the output includes all required data fields
    Given the Invoice List output is triggered successfully
    When the user checks the output for "<data fields>"
    Then the output includes all required data fields as specified

    Examples:
      | data fields             |
      | all required fields     |
      | missing required fields |

  @TC-443
  Scenario: Check the accuracy of the data in the output against the functional specification
    Given the Invoice List output is triggered successfully
    When the user checks the accuracy of the data in the output
    Then the data in the output is accurate and matches the functional specification

  @TC-443
  Scenario: Validate the use of SD_INVOICE_PRINT01 program and ZOTC_CON_INV_DT_FORM in the output
    Given the Invoice List output is triggered successfully
    When the user validates the use of SD_INVOICE_PRINT01 program and ZOTC_CON_INV_DT_FORM
    Then the SD_INVOICE_PRINT01 program and ZOTC_CON_INV_DT_FORM are used as required

  @TC-443
  Scenario: Save the output for further review and documentation
    Given the Invoice List output is triggered successfully
    When the user saves the output
    Then the output is saved successfully

  @TC-443
  Scenario: Export the output for external validation if needed
    Given the Invoice List output is triggered successfully
    When the user exports the output
    Then the output is exported successfully
Feature: Verify inclusion of all invoices in Invoice List output during VF23 execution

  @TC-442
  Scenario: User logs in to the SAP S/4HANA system using valid credentials
    Given user has valid SAP credentials with VF23 execution authorization
    When user logs into the SAP S/4HANA system
    Then user is successfully logged into the SAP system

  @TC-442
  Scenario: User navigates to the VF23 transaction
    Given user is logged into the SAP S/4HANA system
    When user navigates to the VF23 transaction
    Then VF23 transaction screen is displayed

  @TC-442
  Scenario Outline: User selects an invoice list document
    Given user is on the VF23 transaction screen
    When user inputs the required parameters "<invoice_list_document>"
    Then the invoice list document "<invoice_list_document>" is selected successfully

    Examples:
      | invoice_list_document |
      | Document001           |
      | Document002           |

  @TC-442
  Scenario: User executes the transaction to trigger the Invoice List output
    Given user has selected an invoice list document
    When user executes the transaction
    Then the Invoice List output is triggered successfully

  @TC-442
  Scenario: Validate that Output Type ZPIL is triggered
    Given the Invoice List output is triggered successfully
    When user checks the output type
    Then Output Type ZPIL is confirmed as triggered

  @TC-442
  Scenario: Verify all invoices linked to the selected invoice list document are included in the output
    Given Output Type ZPIL is triggered
    When user reviews the output for linked invoices
    Then all linked invoices are included in the output

  @TC-442
  Scenario Outline: Cross-check the number of invoices in the output with the original invoice list document
    Given all linked invoices are included in the output
    When user cross-checks the number of invoices "<output_invoice_count>" with the original invoice list "<original_invoice_count>"
    Then the number of invoices in the output "<output_invoice_count>" matches "<original_invoice_count>"

    Examples:
      | output_invoice_count | original_invoice_count |
      | 5                    | 5                      |
      | 10                   | 10                     |

  @TC-442
  Scenario: Ensure no invoices are missing from the output
    Given the number of invoices in the output matches the original invoice list document
    When user validates the completeness of the output
    Then no invoices are missing from the output

  @TC-442
  Scenario Outline: Check the details of each invoice in the output
    Given no invoices are missing from the output
    When user reviews the details of each invoice "<invoice_number>" "<amount>" "<date>"
    Then the details "<invoice_number>" "<amount>" "<date>" are accurate and complete

    Examples:
      | invoice_number | amount | date       |
      | INV001         | 100.00 | 2023-10-01 |
      | INV002         | 200.00 | 2023-10-02 |

  @TC-442
  Scenario: Validate the format of the output for consistency
    Given the details of each invoice in the output are accurate
    When user reviews the format of the output
    Then the output format is consistent and as expected

  @TC-442
  Scenario: Save the output for further analysis if required
    Given the output format is consistent and as expected
    When user saves the output
    Then the output is saved successfully

  @TC-442
  Scenario: Export the output for external review if necessary
    Given the output is saved successfully
    When user exports the output
    Then the output is exported successfully
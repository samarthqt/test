Feature: Validate rendering of cancellation billing documents with maximum page numbers using Output Type ZPBL

  @TC-514
  Scenario: User navigates to SAP VF03 transaction to open a cancellation billing document
    Given the user has access to the SAP VF03 transaction
    When the user opens the cancellation billing document with ID "123456"
    Then the cancellation billing document is displayed successfully

  @TC-514
  Scenario: User initiates the output rendering process using Output Type ZPBL
    Given the Output Type "ZPBL" is configured
    When the user executes the output rendering process using Output Type "ZPBL"
    Then the output rendering process is initiated successfully

  @TC-514
  Scenario: Verify the updated form ZOTC_CON_INV_DT_FORM is used for rendering
    Given the print program "SD_INVOICE_PRINT01" is updated
    When the user verifies the form used for rendering
    Then the form "ZOTC_CON_INV_DT_FORM" is applied correctly

  @TC-514
  Scenario: Verify that the header text is updated to 'INVOICE CANCELLATION'
    Given the form template "ZOTC_CON_INV_DT_FORM" is updated
    When the user checks the header text in the rendered output
    Then the header text displays "INVOICE CANCELLATION"

  @TC-514
  Scenario: Validate that the page number is replaced with the Original Invoice Number
    When the user verifies the page number in the rendered output
    Then the page number displays the Original Invoice Number

  @TC-514
  Scenario: Confirm that the Reference Invoice Number is displayed correctly
    When the user verifies the Reference Invoice Number in the rendered output
    Then the Reference Invoice Number is displayed accurately

  @TC-514
  Scenario: Ensure that the footer shows page numbering at the bottom-right
    When the user verifies the footer in the rendered output
    Then the footer displays correct page numbering format (e.g., '1 of 3', '2 of 3')

  @TC-514
  Scenario: Verify that the Period Covered and Incoterms sections are omitted
    When the user checks the rendered output
    Then the Period Covered and Incoterms sections are omitted successfully

  @TC-514
  Scenario: Validate that all pages in the printed output are aligned correctly
    When the user prints the rendered output
    Then the printed output is aligned correctly across all pages

  @TC-514
  Scenario: Validate the scalability for maximum page numbers
    When the user processes cancellation billing documents with maximum page numbers
    Then the system handles maximum page numbers efficiently without errors

  @TC-514
  Scenario: Check for errors or warnings in the log during the rendering process
    When the user checks the log entries for the rendering process
    Then no errors or warnings are logged during the rendering process

  @TC-514
  Scenario: Confirm that the output rendering is completed successfully
    When the user reviews the final rendered output
    Then the output rendering is completed successfully and meets all specified formatting requirements
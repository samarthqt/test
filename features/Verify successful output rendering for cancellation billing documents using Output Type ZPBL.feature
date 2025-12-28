Feature: Verify successful output rendering for cancellation billing documents using Output Type ZPBL

  @TC-366
  Scenario: User logs into SAP S/4HANA system with valid credentials
    Given the user has valid credentials
    When the user logs into the SAP S/4HANA system
    Then the user is successfully logged in and navigates to the SAP home screen

  @TC-366
  Scenario: User navigates to transaction VF03 to view the cancellation billing document
    Given a cancellation billing document number "3000001234" exists in the system
    And Output Type ZPBL is configured
    When the user navigates to transaction VF03
    Then the cancellation billing document details are displayed
    And the Output Type is "ZPBL"

  @TC-366
  Scenario: User executes the output rendering process using Output Type ZPBL
    Given the print program "SD_INVOICE_PRINT01" is set up
    And the form "ZOTC_CON_INV_DT_FORM" is updated as per requirements
    When the user executes the output rendering process using Output Type ZPBL
    Then the output rendering process is executed successfully

  @TC-366
  Scenario: Verify that the updated form is used
    Given the form "ZOTC_CON_INV_DT_FORM" is updated
    When the user views the rendered output
    Then the form "ZOTC_CON_INV_DT_FORM" is displayed with updated formatting

  @TC-366
  Scenario: Verify that the header text is updated to 'INVOICE CANCELLATION'
    When the user views the rendered output
    Then the header text is displayed as "INVOICE CANCELLATION"

  @TC-366
  Scenario: Validate that the page number is replaced with the Original Invoice Number
    When the user views the rendered output
    Then the page number is replaced with the Original Invoice Number

  @TC-366
  Scenario: Confirm that the Reference Invoice Number is displayed
    When the user views the rendered output
    Then the Reference Invoice Number is correctly displayed

  @TC-366
  Scenario: Ensure that the footer shows page numbering at the bottom-right
    When the user views the rendered output
    Then the footer displays page numbering correctly at the bottom-right (e.g., "1 of 3")

  @TC-366
  Scenario: Verify that the Period Covered and Incoterms sections are omitted
    When the user views the rendered output
    Then the Period Covered and Incoterms sections are not displayed

  @TC-366
  Scenario: Validate the printed output for accuracy and formatting
    When the user validates the printed output
    Then the printed output matches all specified formatting requirements

  @TC-366
  Scenario: Check system logs for any errors during the rendering process
    When the user checks the system logs after rendering
    Then no errors are logged during the rendering process

  @TC-366
  Scenario: Save the rendered output for future reference
    When the user saves the rendered output
    Then the rendered output is saved successfully
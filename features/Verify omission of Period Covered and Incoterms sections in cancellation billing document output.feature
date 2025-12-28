Feature: Verify omission of Period Covered and Incoterms sections in cancellation billing document output

  @TC-368
  Scenario: User logs into the SAP S/4HANA system and navigates to the home screen
    Given the user has valid credentials
    When the user logs into the SAP S/4HANA system
    Then the user is successfully logged in and navigates to the SAP home screen

  @TC-368
  Scenario: User navigates to transaction VF03 to view the cancellation billing document
    Given a cancellation billing document number "3000001236" exists
    And Output Type "ZPBL" is configured
    And the Print Program "SD_INVOICE_PRINT01" is set up
    When the user navigates to transaction VF03
    Then the cancellation billing document details are displayed

  @TC-368
  Scenario: User executes the output rendering process using Output Type ZPBL
    Given the Print Program "SD_INVOICE_PRINT01" and Form "ZOTC_CON_INV_DT_FORM" are set up
    When the user executes the output rendering process using Output Type "ZPBL"
    Then the output rendering process is executed successfully

  @TC-368
  Scenario: Verify that the updated form is used in the output rendering process
    Given the Form "ZOTC_CON_INV_DT_FORM" is updated as per requirements
    When the user views the rendered output
    Then the updated form "ZOTC_CON_INV_DT_FORM" is displayed with updated formatting

  @TC-368
  Scenario: Validate omission of Period Covered section in the output
    When the user views the rendered output
    Then the Period Covered section is not displayed in the output

  @TC-368
  Scenario: Validate omission of Incoterms section in the output
    When the user views the rendered output
    Then the Incoterms section is not displayed in the output

  @TC-368
  Scenario: Validate the printed output for accuracy and formatting
    When the user reviews the printed output
    Then the printed output matches all specified formatting requirements

  @TC-368
  Scenario: Check system logs for errors during the rendering process
    When the user checks the system logs after the rendering process
    Then no errors are logged during the rendering process

  @TC-368
  Scenario: Save the rendered output for future reference
    When the user saves the rendered output
    Then the rendered output is saved successfully

  @TC-368
  Scenario: Ensure omission of sections is consistent across all pages
    When the user reviews the rendered output across all pages
    Then the Period Covered and Incoterms sections are consistently omitted across all pages

  @TC-368
  Scenario: Verify omission of sections does not affect other formatting elements
    When the user reviews the rendered output
    Then omission of sections does not affect other formatting elements

  @TC-368
  Scenario: Validate final rendered output for compliance with business requirements
    When the user reviews the final rendered output
    Then the final rendered output complies with all business requirements
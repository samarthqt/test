Feature: Validate header text and footer page numbering in cancellation billing document output

  @TC-367
  Scenario: User logs into SAP S/4HANA system with valid credentials
    Given user has valid credentials
    When user logs into the SAP S/4HANA system
    Then user is successfully logged in and navigates to the SAP home screen

  @TC-367
  Scenario: User navigates to transaction VF03 to view cancellation billing document
    Given cancellation billing document number "3000001235" is available
    And Output Type "ZPBL" is configured
    When user navigates to transaction VF03
    Then cancellation billing document details are displayed

  @TC-367
  Scenario: User executes the output rendering process using Output Type ZPBL
    Given Print program "SD_INVOICE_PRINT01" is set up
    And Form "ZOTC_CON_INV_DT_FORM" is updated as per requirements
    When user executes the output rendering process using Output Type "ZPBL"
    Then output rendering process is executed successfully

  @TC-367
  Scenario Outline: Validate header text and footer page numbering in the rendered output
    Given user has executed the output rendering process successfully
    When user verifies the "<validationType>"
    Then "<expectedOutcome>"

    Examples:
      | validationType                                   | expectedOutcome                                            |
      | header text is updated to 'INVOICE CANCELLATION' | header text is displayed as 'INVOICE CANCELLATION'         |
      | footer shows page numbering at the bottom-right  | footer displays page numbering correctly at the bottom-right |
      | printed output for accuracy and formatting       | printed output matches all specified formatting requirements |
      | Reference Invoice Number is displayed            | Reference Invoice Number is correctly displayed            |
      | system logs for any errors during rendering      | no errors are logged during the rendering process          |
      | header text is consistent across all pages       | header text is consistent across all pages                 |
      | footer page numbering is accurate for multi-page | footer page numbering is accurate for multi-page documents |
      | footer does not overlap other sections           | footer does not overlap other sections                     |

  @TC-367
  Scenario: User saves the rendered output for future reference
    Given user has verified the printed output for accuracy and formatting
    When user saves the rendered output
    Then rendered output is saved successfully
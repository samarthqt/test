Feature: Validate error handling when SD_INVOICE_PRINT01 fails to print ZPB1 output

  @TC-135
  Scenario: User logs into the SAP S/4HANA system
    Given the user has authorized credentials
    When the user logs into the SAP S/4HANA system
    Then the user is successfully logged in and navigates to the SAP home screen

  @TC-135
  Scenario: User navigates to the periodic billing document creation screen
    Given the user is logged into the SAP S/4HANA system
    When the user navigates to the transaction for creating periodic billing documents
    Then the periodic billing document creation screen is displayed

  @TC-135
  Scenario Outline: User enters billing document details and creates a periodic billing document
    Given the user is on the periodic billing document creation screen
    When the user enters the billing document type as "<Billing Document Type>" and provides the necessary details like "<Customer>", "<Items>", and "<Amounts>"
    And the user saves the periodic billing document
    Then the billing document is successfully created and a document number is generated

    Examples:
      | Billing Document Type | Customer          | Items    | Amounts |
      | ZPB                   | customer@example.com | Item001 | 1000.00 |

  @TC-135
  Scenario: User navigates to the output processing screen
    Given the user has created a billing document
    When the user navigates to the transaction for triggering output processing
    Then the output processing screen is displayed

  @TC-135
  Scenario: User triggers the output process for the created billing document
    Given the user is on the output processing screen
    When the user selects the created billing document and triggers the output process
    Then the output process is triggered successfully

  @TC-135
  Scenario: Simulate an error by disabling the SD_INVOICE_PRINT01 program
    Given the user has triggered the output process
    When the user simulates an error by disabling the SD_INVOICE_PRINT01 program
    Then the SD_INVOICE_PRINT01 program is unavailable or fails to execute

  @TC-135
  Scenario: Verify system response when the SD_INVOICE_PRINT01 program fails
    Given the SD_INVOICE_PRINT01 program has failed to execute
    When the user checks the system response
    Then the system logs appropriate error messages indicating the print program failure

  @TC-135
  Scenario: Verify fallback mechanisms for generating output
    Given the SD_INVOICE_PRINT01 program has failed
    When the user checks for fallback mechanisms
    Then the system provides fallback mechanisms or halts the output process gracefully

  @TC-135
  Scenario: Verify error logs for detailed information on the failure
    Given the SD_INVOICE_PRINT01 program has failed
    When the user verifies the error logs in the SAP system
    Then the error logs provide detailed insights into the failure for troubleshooting

  @TC-135
  Scenario: Manually re-trigger the output process after resolving the issue
    Given the issue with the SD_INVOICE_PRINT01 program has been resolved
    When the user attempts to manually re-trigger the output process
    Then the output process is re-triggered successfully

  @TC-135
  Scenario: Verify the final output matches the ZPB1 form template
    Given the output process has been successfully re-triggered
    When the user verifies the final output
    Then the final output matches the ZPB1 form template with accurate data
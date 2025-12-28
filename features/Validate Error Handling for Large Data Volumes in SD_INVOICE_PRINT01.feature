Feature: Validate Error Handling for Large Data Volumes in SD_INVOICE_PRINT01

  @TC-139
  Scenario: User logs into the SAP S/4HANA Cloud system
    Given the SD_INVOICE_PRINT01 program is configured in the system
    When the user logs into the SAP S/4HANA Cloud system with appropriate credentials
    Then the user is successfully logged into the system

  @TC-139
  Scenario: User navigates to the periodic billing section
    Given the user is logged into the SAP S/4HANA Cloud system
    And the ZPB1 form template is configured in the system
    When the user navigates to the periodic billing section
    Then the periodic billing section is displayed

  @TC-139
  Scenario Outline: User creates periodic billing documents with corrupted data
    Given the ZPB1 form template is assigned to the periodic billing process
    And test data with large data volumes is prepared
    When the user creates multiple periodic billing documents of type "<billingType>" with "<dataCondition>"
    Then periodic billing documents are created
    And errors are logged due to corrupted data

    Examples:
      | billingType | dataCondition         |
      | ZPB         | intentionally corrupted data |

  @TC-139
  Scenario: User triggers the output process for billing documents
    Given periodic billing documents with corrupted data are created
    When the user triggers the output process for the billing documents
    Then the output process fails with error messages

  @TC-139
  Scenario: User inspects system logs for error messages
    Given the output process has failed due to corrupted data
    When the user inspects the system logs for error messages
    Then the system logs contain detailed error messages about the corrupted data

  @TC-139
  Scenario: Verify no incorrect outputs are generated
    Given periodic billing documents with corrupted data are processed
    When the user verifies the outputs
    Then no outputs are generated for the corrupted data

  @TC-139
  Scenario: Ensure system remains operational despite errors
    Given periodic billing documents with corrupted data are processed
    When the user monitors the system's operational state
    Then the system remains operational without crashes or freezes

  @TC-139
  Scenario: Validate clear error messages for troubleshooting
    Given the system logs contain error messages about corrupted data
    When the user reviews the error messages
    Then error messages are clear and provide actionable information

  @TC-139
  Scenario: User reprocesses billing documents after correcting the data
    Given periodic billing documents with corrupted data are corrected
    When the user reprocesses the billing documents
    Then the corrected billing documents are processed successfully

  @TC-139
  Scenario: Confirm program handles resubmitted data without issues
    Given the corrected billing documents are processed
    When the user submits the data again
    Then resubmitted data is processed without errors

  @TC-139
  Scenario: Verify no residual errors remain in the system after reprocessing
    Given the corrected billing documents are processed
    When the user inspects the system logs
    Then system logs do not contain any residual errors

  @TC-139
  Scenario: Validate system prevents corrupted data from affecting other processes
    Given periodic billing documents with corrupted data exist in the system
    When the user verifies the impact on other processes
    Then corrupted data is isolated and does not impact other processes
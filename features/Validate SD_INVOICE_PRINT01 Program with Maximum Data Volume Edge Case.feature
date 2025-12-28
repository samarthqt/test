Feature: Validate SD_INVOICE_PRINT01 Program with Maximum Data Volume Edge Case  
  Ensure the SD_INVOICE_PRINT01 program handles maximum data volume without performance issues.

  @TC-141
  Scenario: User logs into the SAP S/4HANA Cloud system
    Given the user has appropriate credentials
    When the user logs into the SAP S/4HANA Cloud system
    Then the user is successfully logged into the system

  @TC-141
  Scenario: User navigates to the periodic billing section
    Given the user is logged into the SAP S/4HANA Cloud system
    When the user navigates to the periodic billing section
    Then the periodic billing section is displayed

  @TC-141
  Scenario: ZPB1 form template is configured in the system
    Given the ZPB1 form template is created and assigned to the periodic billing process
    And test data with maximum data volume is prepared
    Then the system is ready for the periodic billing process

  @TC-141
  Scenario: User creates periodic billing documents with maximum data volume
    Given the periodic billing section is displayed
    When the user creates multiple periodic billing documents of type "ZPB" with maximum data volume
    Then the periodic billing documents are created successfully

  @TC-141
  Scenario: User triggers the output process for the billing documents
    Given the periodic billing documents are created successfully
    When the user triggers the output process for the billing documents
    Then the output process is triggered without errors

  @TC-141
  Scenario: Monitor program performance during the output process
    Given the output process is triggered
    When the user monitors the performance of the SD_INVOICE_PRINT01 program during the output process
    Then the program performs efficiently without any degradation

  @TC-141
  Scenario: Verify program stability during the output process
    Given the output process is triggered
    When the user verifies the stability of the SD_INVOICE_PRINT01 program during the output process
    Then the program remains stable throughout the process

  @TC-141
  Scenario Outline: Check printed outputs for formatting and accuracy
    Given the output process is triggered
    When the user checks the printed outputs for "<issue>"
    Then the printed outputs are "<result>"

    Examples:
      | issue               | result                          |
      | formatting issues   | correctly formatted without errors |
      | accuracy            | accurate and match the data in the billing documents |

  @TC-141
  Scenario: Inspect system logs during the output process
    Given the output process is triggered
    When the user inspects the system logs for any errors or warnings
    Then the system logs do not contain any critical errors or warnings

  @TC-141
  Scenario: Verify linkage between billing documents and printed outputs
    Given the output process is triggered
    When the user verifies the linkage between the billing documents and the printed outputs
    Then the linkage is accurate and consistent

  @TC-141
  Scenario: Ensure program handles maximum data volume within acceptable time limits
    Given the output process is triggered
    When the user ensures the program handles the maximum data volume within acceptable time limits
    Then the processing time is within acceptable limits

  @TC-141
  Scenario: Confirm no system crashes or freezes occurred during the process
    Given the output process is triggered
    When the user confirms that no system crashes or freezes occurred during the process
    Then the system remains operational without crashes or freezes
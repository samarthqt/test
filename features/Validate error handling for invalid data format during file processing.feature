Feature: Validate error handling for invalid data format during file processing

  @TC-506
  Scenario: User logs into the SAP S/4HANA system
    Given the user has SAP user credentials with appropriate access
    When the user logs into the SAP S/4HANA system using valid credentials
    Then the user is successfully logged into the system

  @TC-506
  Scenario: User navigates to the background job scheduling module
    Given the user is logged into the SAP S/4HANA system
    When the user navigates to the background job scheduling module
    Then the background job scheduling module is displayed

  @TC-506
  Scenario Outline: Schedule and verify background job for file polling and processing
    Given a pipe-delimited file with "<data_format>" is prepared and placed in the EC2 path
    When the user schedules a background job to poll the EC2 path for sales order data
    Then the background job is successfully scheduled
    And the system retrieves the file from the EC2 path
    And the background job attempts to process the file
    Then the system encounters "<processing_outcome>"
    And logs indicate "<log_message>"
    And "<sales_order_status>" in the system

    Examples:
      | data_format           | processing_outcome                     | log_message                                | sales_order_status              |
      | invalid data format   | errors due to invalid data format      | exact issues with the data format         | no new sales orders are created |
      | corrected data format | successful processing and file parsing | no errors                                 | sales orders are created        |

  @TC-506
  Scenario: User checks system logs for error messages
    Given the background job has processed a file with invalid data format
    When the user checks the system logs
    Then logs indicate errors specifying the exact issues with the data format

  @TC-506
  Scenario: User manually attempts to process an invalid file
    Given a file with invalid data format has been processed
    When the user attempts to manually process the file using the same interface
    Then the system prevents manual processing
    And the system displays error messages related to the invalid data format

  @TC-506
  Scenario: System sends notification for file processing failure
    Given the background job has encountered errors during file processing
    When the system identifies the file processing failure
    Then the system sends a notification or alert to relevant stakeholders
    And the notification details the failure reason

  @TC-506
  Scenario: Invalid file is moved to error folder or flagged for review
    Given a file with invalid data format has failed processing
    When the system completes the error handling process
    Then the file is moved to an error folder or flagged for further analysis

  @TC-506
  Scenario: User resubmits corrected file for processing
    Given the user has corrected the data format of the file
    When the user resubmits the same file
    Then the system processes the corrected file successfully
    And the system creates sales orders

  @TC-506
  Scenario: User generates a report of failed file processing attempts
    Given there are failed file processing attempts in the system
    When the user generates a report for audit purposes
    Then the report is successfully generated
    And the report details all failed attempts and their reasons
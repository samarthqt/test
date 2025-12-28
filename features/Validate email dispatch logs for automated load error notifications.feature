Feature: Validate email dispatch logs for automated load error notifications

  @TC-365
  Scenario: User logs into the SAP S/4HANA system
    Given the user has appropriate credentials
    When the user logs into the SAP S/4HANA system
    Then the user successfully logs into the system

  @TC-365
  Scenario: User navigates to the automated load process module
    Given the user is logged into the SAP S/4HANA system
    When the user navigates to the automated load process module
    Then the automated load process module is displayed with options to trigger the process

  @TC-365
  Scenario Outline: User uploads the pipe-delimited input file containing errors
    Given the user is in the automated load process module
    When the user uploads the prepared input file "<file_name>" with errors
    Then the file is successfully uploaded and visible in the system

    Examples:
      | file_name            |
      | error_file_03.txt    |

  @TC-365
  Scenario: User triggers the automated load process
    Given the user has uploaded the input file with errors
    When the user triggers the automated load process
    Then the system begins processing the uploaded file

  @TC-365
  Scenario: User monitors system for error detection during file processing
    Given the user has triggered the automated load process
    When the system processes the uploaded file
    Then errors in the file are detected and logged by the system

  @TC-365
  Scenario: User verifies email notifications are generated for detected errors
    Given errors are detected during file processing
    When the system generates email notifications for the detected errors
    Then email notifications are queued for dispatch

  @TC-365
  Scenario: User navigates to the email dispatch logs
    Given email notifications are queued for dispatch
    When the user navigates to the email dispatch logs in the system
    Then the email dispatch logs are accessible and display relevant information

  @TC-365
  Scenario Outline: User checks the dispatch logs for successful sending of notifications
    Given the user is in the email dispatch logs
    When the user verifies the dispatch logs for notifications sent to "<recipient_emails>"
    Then the dispatch logs confirm notifications are sent to the intended recipients

    Examples:
      | recipient_emails                 |
      | admin@example.com, support@example.com |

  @TC-365
  Scenario: User verifies the accuracy of recipient email addresses in the dispatch logs
    Given the user is in the email dispatch logs
    When the user checks the recipient email addresses in the logs
    Then the recipient email addresses in the logs match the configured users

  @TC-365
  Scenario: User confirms timestamps are included in the dispatch logs
    Given the user is in the email dispatch logs
    When the user checks for timestamps for each notification sent
    Then timestamps for notification dispatch are present in the logs

  @TC-365
  Scenario: User checks for errors or warnings in the dispatch logs
    Given the user is in the email dispatch logs
    When the user verifies the logs for errors or warnings
    Then no errors or warnings are present in the dispatch logs

  @TC-365
  Scenario: User validates system performance metrics during email dispatch process
    Given the email dispatch process is in progress
    When the user monitors system performance metrics
    Then the system performance remains within acceptable limits during email dispatch
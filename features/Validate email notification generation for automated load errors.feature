Feature: Validate email notification generation for automated load errors

  @TC-363
  Scenario: User logs into the SAP S/4HANA system
    Given the user has valid credentials for the SAP S/4HANA system
    When the user logs into the system
    Then the user successfully gains access to the system

  @TC-363
  Scenario: User navigates to the automated load process module
    Given the user is logged into the SAP S/4HANA system
    When the user navigates to the automated load process module
    Then the automated load process module is displayed with options to trigger the process

  @TC-363
  Scenario: User uploads a prepared input file containing errors
    Given the user is in the automated load process module
    And the user has a prepared pipe-delimited input file with errors named "error_file_01.txt"
    When the user uploads the file to the system
    Then the file is successfully uploaded and visible in the system

  @TC-363
  Scenario: User triggers the automated load process
    Given the user has uploaded a pipe-delimited input file with errors
    When the user triggers the automated load process
    Then the system begins processing the uploaded file

  @TC-363
  Scenario: System detects errors during file processing
    Given the system is processing the uploaded file
    When the system detects errors in the file
    Then the errors are logged by the system

  @TC-363
  Scenario: Email notifications are generated for detected errors
    Given the system has logged errors from the uploaded file
    When the system generates email notifications for the detected errors
    Then the notifications are queued for dispatch

  @TC-363
  Scenario Outline: Verify email dispatch logs confirm successful notification sending
    Given the system has queued email notifications for dispatch
    When the user checks the email dispatch logs
    Then the logs confirm that notifications are sent to the intended recipients "<recipients>"

    Examples:
      | recipients                |
      | user1@example.com         |
      | user2@example.com         |

  @TC-363
  Scenario: Verify email notification content
    Given the system has sent notifications for detected errors
    When the user reviews the content of the email notification
    Then the content includes details about the errors and troubleshooting steps
    And the content is clear and actionable

  @TC-363
  Scenario Outline: Validate email recipient list matches configured users
    Given the system has sent email notifications
    When the user validates the recipient list in the email
    Then the recipient list matches the configured users "<configured_users>"

    Examples:
      | configured_users          |
      | user1@example.com         |
      | user2@example.com         |

  @TC-363
  Scenario: Confirm notification generation event is logged
    Given the system has generated email notifications
    When the user checks the system logs
    Then the notification generation event is logged with a timestamp and error details

  @TC-363
  Scenario: Check for duplicate or missing notifications in dispatch logs
    Given the system has dispatched email notifications
    When the user reviews the dispatch logs
    Then no duplicate or missing notifications are found

  @TC-363
  Scenario: Verify system performance during notification generation
    Given the system is generating and dispatching email notifications
    When the user monitors system performance metrics
    Then the system performance remains within acceptable limits during the notification generation process
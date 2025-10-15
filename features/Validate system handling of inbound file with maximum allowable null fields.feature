Feature: Validate system handling of inbound file with maximum allowable null fields

  @TC-350
  Scenario: User logs into the SAP S/4HANA system using valid credentials
    Given the user has valid SAP S/4HANA credentials
    When the user logs into the SAP S/4HANA system
    Then the user is successfully logged into the SAP S/4HANA system

  @TC-350
  Scenario: User navigates to the Sales Order processing screen
    Given the user is logged into the SAP S/4HANA system
    When the user navigates to the Sales Order processing screen
    Then the Sales Order processing screen is displayed

  @TC-350
  Scenario Outline: User uploads a pipe-delimited file with null fields using the inbound interface
    Given the user is on the Sales Order processing screen
      And a pipe-delimited file with "<file_condition>" is prepared
    When the user uploads the file using the inbound interface
    Then the system "<system_action>"

    Examples:
      | file_condition                     | system_action                                     |
      | maximum allowable null fields      | processes the file and identifies the null fields |
      | null fields exceeding the limit    | rejects the file and logs an error               |

  @TC-350
  Scenario: User attempts to display or process sales orders from a file with null fields
    Given the user has uploaded a pipe-delimited file with maximum allowable null fields
    When the user attempts to display or process sales orders from the uploaded file
    Then the system rejects the file and logs an error indicating the null fields

  @TC-350
  Scenario: User checks the system log for errors related to the uploaded file
    Given the user has uploaded a pipe-delimited file with null fields
    When the user checks the system log
    Then the error logs clearly indicate the null fields

  @TC-350
  Scenario: User verifies no sales orders are displayed or processed from the uploaded file
    Given the user has uploaded a pipe-delimited file with null fields
    When the user attempts to view or process sales orders
    Then no sales orders are displayed or processed

  @TC-350
  Scenario: User validates the error message for null fields
    Given the user has uploaded a pipe-delimited file with null fields
    When the system logs an error
    Then the error message provides clear details about the null fields and corrective actions

  @TC-350
  Scenario: User retries the upload with corrected data
    Given the user has corrected the data in the pipe-delimited file
    When the user uploads the corrected file using the inbound interface
    Then the system accepts and processes the corrected file successfully

  @TC-350
  Scenario: User verifies valid sales orders are created from the corrected file
    Given the user has uploaded a corrected pipe-delimited file
    When the system processes the file
    Then valid sales orders are created and displayed in the system

  @TC-350
  Scenario: System prevents processing of files with null fields in future uploads
    Given the user uploads a pipe-delimited file with null fields
    When the system processes the file
    Then the system consistently rejects files with null fields

  @TC-350
  Scenario: System stores error log entries for audit purposes
    Given the user has uploaded a pipe-delimited file with null fields
    When the system logs an error
    Then the error log entries are stored and accessible for audit

  @TC-350
  Scenario: System generates notifications for errors in the uploaded file
    Given the user has uploaded a pipe-delimited file with null fields
    When the system logs an error
    Then notifications are sent to the relevant stakeholders with error details
Feature: Validate system handling of inbound file with partial data for Document Types

  @TC-346
  Scenario: User logs in to the SAP S/4HANA system
    Given the user has valid SAP S/4HANA credentials
    When the user logs in to the SAP S/4HANA system
    Then the user is successfully logged in to the SAP S/4HANA system

  @TC-346
  Scenario: User navigates to the Sales Order processing screen
    Given the user is logged in to the SAP S/4HANA system
    When the user navigates to the Sales Order processing screen
    Then the Sales Order processing screen is displayed

  @TC-346
  Scenario Outline: System processes uploaded pipe-delimited file with partial Document Types
    Given the user has access to the Sales Order processing screen
    When the user uploads a pipe-delimited file with <file_status> Document Types using the inbound interface
    Then the system <system_response> the file
    And <additional_action>

    Examples:
      | file_status       | system_response       | additional_action                               |
      | partial           | identifies incomplete | logs an error indicating incomplete Document Types |
      | corrected         | accepts and processes | the corrected file successfully                  |

  @TC-346
  Scenario: System rejects file with incomplete Document Types and logs errors
    Given the user has uploaded a pipe-delimited file with partial Document Types
    When the user attempts to display or process sales orders from the uploaded file
    Then the system rejects the file
    And the system logs an error indicating incomplete Document Types

  @TC-346
  Scenario Outline: Verify system log for errors related to uploaded file
    Given the user has uploaded a file with <file_status> Document Types
    When the user checks the system log for errors
    Then the error logs <log_details>

    Examples:
      | file_status       | log_details                                 |
      | partial           | clearly indicate incomplete Document Types |
      | corrected         | do not contain errors                      |

  @TC-346
  Scenario: Ensure no sales orders are displayed or processed from an invalid file
    Given the user has uploaded a pipe-delimited file with partial Document Types
    When the user attempts to display or process sales orders
    Then no sales orders are displayed or processed

  @TC-346
  Scenario: Validate user-friendly and actionable error messages
    Given the user has uploaded a pipe-delimited file with partial Document Types
    When the system rejects the file
    Then the error message provides clear details about the incomplete fields and corrective actions

  @TC-346
  Scenario: Retry upload with corrected data
    Given the user has corrected the pipe-delimited file
    When the user retries the upload using the inbound interface
    Then the system accepts and processes the corrected file successfully

  @TC-346
  Scenario: Verify valid sales orders creation from corrected file
    Given the user has uploaded a corrected pipe-delimited file
    When the system processes the file
    Then valid sales orders are created and displayed in the system

  @TC-346
  Scenario: Ensure system prevents future uploads with incomplete data
    Given the user uploads a pipe-delimited file with incomplete Document Types
    When the system processes the file
    Then the system consistently rejects files with incomplete data

  @TC-346
  Scenario: Validate error log entries are stored for audit purposes
    Given the user has uploaded a file with incomplete Document Types
    When the system logs errors
    Then the error log entries are stored and accessible for audit purposes

  @TC-346
  Scenario: Validate system notifications for errors in uploaded file
    Given the user has uploaded a file with incomplete Document Types
    When the system logs errors
    Then notifications are sent to the relevant stakeholders with error details
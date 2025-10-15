Feature: Validate system rejection of inbound file with null Sales Organization

  @TC-347
  Scenario Outline: User uploads a file with null Sales Organization and validates system behavior
    Given the user is logged into the SAP S/4HANA system with valid credentials
    And the user has prepared a pipe-delimited file with "<Sales Organization>" for Sales Organization
    When the user navigates to the Sales Order processing screen
    And the user uploads the prepared file using the inbound interface
    Then the system processes the file and "<System Behavior>"
    And the user checks the system log for errors related to the uploaded file
    Then the error logs "<Error Log Behavior>"
    And the user verifies that "<Sales Order Display Behavior>"
    And the user validates that the error message "<Error Message Behavior>"
    And the user retries the upload with corrected data
    Then the system "<Retry Behavior>"
    And the user verifies that the corrected file creates "<Correct File Behavior>"
    And the user checks if the system prevents processing of data with null values in future uploads
    Then the system "<Future Upload Behavior>"
    And the user ensures that error log entries are stored for audit purposes
    Then the error logs "<Audit Log Behavior>"
    And the user validates that the system generates notifications for errors in the uploaded file
    Then the notifications "<Notification Behavior>"

    Examples:
      | Sales Organization | System Behavior                                         | Error Log Behavior                       | Sales Order Display Behavior               | Error Message Behavior                     | Retry Behavior                              | Correct File Behavior                     | Future Upload Behavior                          | Audit Log Behavior                       | Notification Behavior                          |
      | null               | identifies missing Sales Organization                   | clearly indicate missing Sales Organization | no sales orders are displayed or processed | provides clear details about missing fields | accepts and processes the corrected file    | valid sales orders are created and displayed | consistently rejects files with null data     | are stored and accessible for audit purposes | are sent to relevant stakeholders with details |
      | empty              | identifies missing Sales Organization                   | clearly indicate missing Sales Organization | no sales orders are displayed or processed | provides clear details about missing fields | accepts and processes the corrected file    | valid sales orders are created and displayed | consistently rejects files with incomplete data | are stored and accessible for audit purposes | are sent to relevant stakeholders with details |
      | valid              | processes the file successfully                         | no errors are logged                      | sales orders are displayed and processed    | no error message displayed                  | not applicable                              | not applicable                             | not applicable                                 | not applicable                            | not applicable                                 |
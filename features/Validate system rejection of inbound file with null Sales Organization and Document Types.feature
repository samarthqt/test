Feature: Validate system rejection of inbound file with null Sales Organization and Document Types

  @TC-345
  Scenario Outline: Validate system behavior for inbound files with null or incomplete Sales Organization and Document Types
    Given the user is logged into the SAP S/4HANA system with valid credentials
    And the user navigates to the Sales Order processing screen
    When the user uploads a pipe-delimited file with "<Sales Organization>" and "<Document Types>" using the inbound interface
    Then the system processes the file and identifies missing or incomplete data
    And the system logs an error indicating "<Error Message>"
    And no sales orders are displayed or processed from the file
    And the error message is user-friendly and provides "<Corrective Action>"

    Examples:
      | Sales Organization | Document Types | Error Message                              | Corrective Action                       |
      | null               | null           | Missing Sales Organization and Document Types | Provide valid Sales Organization and Document Types |
      | null               | ValidType      | Missing Sales Organization                | Provide a valid Sales Organization     |
      | ValidOrg           | null           | Missing Document Types                    | Provide valid Document Types           |

  @TC-345
  Scenario Outline: Validate system acceptance of corrected inbound file
    Given the user is logged into the SAP S/4HANA system with valid credentials
    And the user navigates to the Sales Order processing screen
    When the user uploads a corrected pipe-delimited file with "<Sales Organization>" and "<Document Types>" using the inbound interface
    Then the system accepts and processes the file successfully
    And valid sales orders are created and displayed in the system

    Examples:
      | Sales Organization | Document Types |
      | ValidOrg           | ValidType      |

  @TC-345
  Scenario Outline: Validate system prevention of future uploads with null or incomplete data
    Given the user is logged into the SAP S/4HANA system with valid credentials
    And the user navigates to the Sales Order processing screen
    When the user uploads a pipe-delimited file with "<Sales Organization>" and "<Document Types>" using the inbound interface
    Then the system rejects the file consistently
    And the system logs an error indicating "<Error Message>"

    Examples:
      | Sales Organization | Document Types | Error Message                              |
      | null               | null           | Missing Sales Organization and Document Types |
      | null               | ValidType      | Missing Sales Organization                |
      | ValidOrg           | null           | Missing Document Types                    |

  @TC-345
  Scenario: Validate error log storage for audit purposes
    Given the user has uploaded a file with null or incomplete data
    When the user checks the system logs
    Then the error log entries are stored and accessible for audit purposes

  @TC-345
  Scenario: Validate system notifications for errors in uploaded file
    Given the user has uploaded a file with null or incomplete data
    When the system identifies errors in the file
    Then notifications are sent to the relevant stakeholders with error details
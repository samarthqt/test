Feature: Validate system behavior during background job execution when the input file is missing

  @TC-360
  Scenario Outline: Validate system behavior when the input file is missing during background job execution
    Given the user logs into SAP S/4HANA with valid credentials
    And the user navigates to the AL11/EC2/Inbound directory and confirms the absence of the input file
    And the user navigates to the selection screen for the background job execution
    And the user enters mandatory parameters into the selection screen
    When the user manually executes the background job using the selection screen
    Then the system logs an error message "<error_message>" indicating "<file_status>"
    And the system halts execution

    Examples:
      | error_message            | file_status             |
      | File not found           | Missing input file      |

  @TC-360
  Scenario Outline: Validate system behavior when attempting to re-execute the job with missing file
    Given the user verifies the absence of the input file in the AL11/EC2/Inbound directory
    When the user attempts to re-execute the background job
    Then the system logs an error message "<error_message>" indicating "<file_status>"
    And the system halts execution

    Examples:
      | error_message            | file_status             |
      | File not found           | Missing input file      |

  @TC-360
  Scenario Outline: Validate system behavior after uploading the missing input file
    Given the user uploads the missing input file to the AL11/EC2/Inbound directory
    And the user re-executes the background job after uploading the file
    Then the background job executes successfully
    And the system processes the uploaded file
    And the processed data is accurate and complete in Customer and Site Master Data

    Examples:
      | file_status             |
      | File successfully uploaded |

  @TC-360
  Scenario: Validate system logs after successful execution
    Given the user rechecks the system logs after successful background job execution
    Then the system logs confirm clean execution with no residual errors

  @TC-360
  Scenario: Validate no data processing occurred during failed attempts
    Given the user verifies the system state after failed job executions
    Then no changes were made during failed job executions
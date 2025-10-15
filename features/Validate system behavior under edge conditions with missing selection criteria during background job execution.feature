Feature: Validate system behavior under edge conditions with missing selection criteria during background job execution

  @TC-182
  Scenario Outline: Ensure the system handles missing selection criteria during background job execution
    Given the user logs in to the SAP S/4HANA system with appropriate credentials
    And the user navigates to the billing due program configuration screen
    When the user selects the "<execution_mode>" execution mode for the billing program
    And the user leaves the selection criteria "<selection_criteria>"
    And the user schedules the program as a background job
    Then the background job is scheduled successfully
    When the user executes the background job and monitors its status
    Then the background job execution starts successfully
    And the user accesses the job log to review error messages
    Then error messages indicating "<error_message>" are displayed in the job log
    And no billing documents are created as a result of the execution
    When the user checks the system logs for detailed error descriptions
    Then the system logs provide detailed error descriptions related to "<error_details>"
    And the error messages are clear and actionable, indicating "<error_clarity>"
    And the system maintains data integrity with no unintended changes
    And the user documents the observed behavior and error handling for further analysis

    Examples:
      | execution_mode | selection_criteria | error_message                        | error_details                     | error_clarity              |
      | Background job | Blank              | Missing selection criteria detected | Missing selection criteria error | Clear and actionable       |
      | Background job | Missing            | Missing selection criteria detected | Missing selection criteria error | Clear and actionable       |
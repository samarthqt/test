Feature: Validate system behavior for invalid selection criteria during background execution

  The system should correctly handle invalid selection criteria during background job execution in the CustomBillingDueProgram, ensuring data integrity and actionable error messages.

  @TC-180
  Scenario Outline: Validate background job execution with invalid selection criteria
    Given the user logs in to the SAP S/4HANA system with valid credentials
    And the user navigates to the billing due program configuration screen
    When the user selects the option for background execution of the billing program
    And the user enters "<selection_criteria>" as the selection criteria for processing billing due documents
    And the user schedules the program as a background job with the entered criteria
    And the user executes the background job
    Then the background job execution should start successfully
    And the user accesses the job log to review error messages
    And error messages indicating issues with "<selection_criteria>" should be displayed in the job log
    And no billing documents should be created as a result of the execution
    And the system logs should provide detailed error descriptions related to "<selection_criteria>"
    And the error messages should be clear and actionable, indicating the exact issue with "<selection_criteria>"
    And the system should maintain data integrity despite the error

    Examples:
      | selection_criteria           |
      | Non-existent billing IDs     |
      | Invalid date range           |
      | Blank selection criteria     |
      | Special characters in input  |

  @TC-180
  Scenario: Validate documentation of observed behavior and error handling
    Given the user has executed a background job with invalid selection criteria
    When the user documents the observed behavior and error handling
    Then the documentation should be completed successfully
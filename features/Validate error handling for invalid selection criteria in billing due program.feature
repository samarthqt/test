Feature: Validate error handling for invalid selection criteria in billing due program

  Ensure the system displays appropriate error messages when invalid selection criteria are provided for the billing due program. The custom billing due program is configured for background execution.

  @TC-439
  Scenario Outline: Validate the system behavior with various selection criteria for the billing due program
    Given the user navigates to the billing due program in the SAP system
    And the billing due program screen is displayed
    When the user selects the option to execute the program in background mode
    And the user enters "<selection_criteria>" for the program
    And the user schedules the program as a background job
    And the user executes the background job
    Then the system processes the job and displays "<job_log_message>" in the job log
    And "<billing_document_status>" billing documents are generated
    And the error messages in the job log indicate "<error_message>"
    When the user corrects the invalid criteria to "<corrected_criteria>" and reschedules the job
    And the user executes the corrected background job
    Then the corrected job executes successfully
    And the logs for the corrected job execution show "<corrected_job_log_message>"
    And the system ensures data integrity by halting processing with invalid input

    Examples:
      | selection_criteria  | job_log_message                              | billing_document_status | error_message                       | corrected_criteria | corrected_job_log_message             |
      | Non-existent customer numbers | Errors due to invalid selection criteria | No                      | Invalid customer numbers provided  | Valid customer numbers | Job executed successfully without errors |
      | Blank input          | Errors due to missing selection criteria    | No                      | Selection criteria cannot be blank | Valid customer numbers | Job executed successfully without errors |
      | Invalid date range   | Errors due to invalid date range            | No                      | Date range is invalid              | Valid date range     | Job executed successfully without errors |
      | Non-numeric input    | Errors due to non-numeric input             | No                      | Input must be numeric              | Valid numeric input  | Job executed successfully without errors |
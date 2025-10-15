Feature: Validate error handling when mandatory parameters are missing in the selection screen

  @TC-359
  Scenario Outline: Validate system behavior with missing or incomplete mandatory parameters
    Given the user logs into SAP S/4HANA with valid credentials
    And the user navigates to the selection screen for the background job execution
    When the user provides the following mandatory parameters:
      | Sales Document Type | Sales Organization | Distribution Channel | Division | Run Date | File Path |
      | <Sales Document Type> | <Sales Organization> | <Distribution Channel> | <Division> | <Run Date> | <File Path> |
    Then the system displays the appropriate message "<Expected Message>"
    And the system logs record the corresponding details with timestamps

    Examples:
      | Sales Document Type | Sales Organization | Distribution Channel | Division | Run Date | File Path | Expected Message                                   |
      | NULL                | NULL               | NULL                 | NULL     | NULL     | NULL      | Error: Missing mandatory parameters               |
      | Valid               | NULL               | NULL                 | NULL     | NULL     | NULL      | Error: Incomplete parameter set                   |
      | Valid               | Valid              | Valid                | NULL     | NULL     | NULL      | Error: Incomplete parameter set                   |
      | Valid               | Valid              | Valid                | Valid    | Valid    | Valid      | Success: Job executes successfully                |

  @TC-359
  Scenario: Verify background job execution with all mandatory parameters provided
    Given the user logs into SAP S/4HANA with valid credentials
    And the user navigates to the selection screen for the background job execution
    When the user provides all mandatory parameters
    Then the background job executes successfully
    And the system logs indicate clean execution with no errors
    And the processed data is accurate and complete in S/4HANA

  @TC-359
  Scenario: Confirm no data processing occurred during failed attempts
    Given the user attempts to execute the background job with missing mandatory parameters
    Then no changes are made to Customer or Site Master Data
    And the system logs confirm no processing occurred during failed attempts

  @TC-359
  Scenario: Verify system behavior after correcting missing parameters
    Given the user provides all mandatory parameters after initial failed attempts
    When the user executes the background job
    Then the background job proceeds without errors
    And the system logs indicate clean execution post-parameter correction
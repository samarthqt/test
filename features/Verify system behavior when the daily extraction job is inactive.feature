Feature: Verify system behavior when the daily extraction job is inactive

  @TC-377
  Scenario: User logs in to the SAP S/4 HANA Cloud system
    Given the user has appropriate credentials
    When the user logs in to the SAP S/4 HANA Cloud system
    Then the user is successfully logged in
    And the user has access to the relevant modules

  @TC-377
  Scenario: Verify the daily extraction job status
    Given the user is logged in to the SAP S/4 HANA Cloud system
    When the user navigates to the daily extraction job schedule
    Then the daily extraction job is found to be inactive

  @TC-377
  Scenario: Generate simulated direct sales data near maximum capacity
    Given the system supports data simulation
    When the user generates simulated direct sales data near the system's maximum capacity
    Then simulated data is generated successfully

  @TC-377
  Scenario: Monitor system logs for triggered extraction jobs
    Given the daily extraction job is inactive
    When the user monitors the system logs
    Then the system logs confirm that no extraction job was triggered

  @TC-377
  Scenario Outline: Attempt to trigger the daily extraction job when inactive
    Given the daily extraction job is inactive
    When the user attempts to trigger the daily extraction job
    Then the system does not allow the extraction job to be triggered
    And the system displays the error message "<error_message>"

    Examples:
      | error_message                              |
      | Extraction job is inactive. Please activate it first. |

  @TC-377
  Scenario: Verify error message for inactive extraction job
    Given the user attempts to trigger the inactive daily extraction job
    When the error message is displayed
    Then the error message clearly indicates that the extraction job is inactive

  @TC-377
  Scenario: Check option to activate the extraction job from the error message screen
    Given the daily extraction job is inactive
    When the error message is displayed
    Then the system provides an option to activate the extraction job directly from the error message screen

  @TC-377
  Scenario: Activate the extraction job and re-trigger the process
    Given the daily extraction job is inactive
    When the user activates the extraction job from the error message screen
    And the user re-triggers the extraction process
    Then the extraction job is activated successfully
    And the process can be re-triggered

  @TC-377
  Scenario: Validate system error handling mechanism for inactive job
    Given the daily extraction job is inactive
    When the user interacts with the system
    Then the system handles the error gracefully without crashing or freezing

  @TC-377
  Scenario: Ensure no data is transmitted to Model N during inactive job status
    Given the daily extraction job is inactive
    When the user checks the data transmission to Model N
    Then no data is transmitted to Model N during the inactive job status

  @TC-377
  Scenario: Log in to Model N and confirm no data processing occurred
    Given the daily extraction job is inactive
    When the user logs in to Model N
    Then Model N does not display any data processing activity

  @TC-377
  Scenario: Document the results of the test
    Given the test for the inactive daily extraction job is completed
    When the user documents the results
    Then the test results highlight the system's behavior when the job is inactive
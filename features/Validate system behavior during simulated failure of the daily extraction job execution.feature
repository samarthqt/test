Feature: Validate system behavior during simulated failure of the daily extraction job execution

  @TC-22
  Scenario: User successfully logs in to the SAP S/4HANA system
    Given the user has valid credentials
    When the user logs in to the SAP S/4HANA system
    Then the user is successfully logged in and accesses the dashboard

  @TC-22
  Scenario: User navigates to the Job Monitoring module
    Given the user is logged in to the SAP S/4HANA system
    When the user navigates to the Job Monitoring module
    Then the Job Monitoring module is displayed with all scheduled jobs

  @TC-22
  Scenario: User searches for the daily extraction job
    Given the Job Monitoring module is displayed
    When the user searches for the job using the job name "Daily_Extraction_Job"
    Then the job details are displayed, including its schedule and status

  @TC-22
  Scenario: User manually triggers the job execution
    Given the daily extraction job details are displayed
    When the user manually triggers the job execution
    Then the job execution starts successfully

  @TC-22
  Scenario: Simulated failure is introduced during job execution
    Given the job execution has started
    When the user introduces a simulated failure by disconnecting the network
    Then the network disconnection occurs, simulating a failure scenario

  @TC-22
  Scenario: User monitors logs for error messages during failure
    Given a simulated failure has been introduced
    When the user monitors the job execution logs
    Then error messages related to the network failure are logged

  @TC-22
  Scenario: System sends notifications or alerts during failure
    Given error messages are logged for the simulated failure
    When the system detects the failure
    Then notifications or alerts are sent to the responsible team

  @TC-22
  Scenario: Job status is updated after failure
    Given the job execution has failed due to the simulated failure
    When the user checks the job status
    Then the job status is updated to "Failed"

  @TC-22
  Scenario: User resolves the simulated failure
    Given the job status is "Failed"
    When the user resolves the simulated failure by reconnecting the network
    Then the network connectivity is restored

  @TC-22
  Scenario: User reruns the job after resolving the failure
    Given the network connectivity is restored
    When the user attempts to re-run the job manually
    Then the job execution starts successfully

  @TC-22
  Scenario: User monitors logs for successful execution after failure resolution
    Given the job execution has been re-run
    When the user monitors the logs
    Then the logs show successful execution of the job

  @TC-22
  Scenario: User logs out of the SAP S/4HANA system
    Given the job execution is successful
    When the user logs out of the SAP S/4HANA system
    Then the user successfully logs out
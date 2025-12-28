Feature: Validate system notifications for job failure

  Ensure the system sends appropriate notifications or alerts when the daily extraction job fails.

  @TC-23
  Scenario: User logs in to the SAP S/4HANA system successfully
    Given the user has valid credentials
    When the user logs in to the SAP S/4HANA system
    Then the user successfully accesses the dashboard

  @TC-23
  Scenario: User navigates to the Job Monitoring module
    Given the user is logged in to the SAP S/4HANA system
    When the user navigates to the Job Monitoring module
    Then the Job Monitoring module is displayed with all scheduled jobs

  @TC-23
  Scenario: User searches for the daily extraction job
    Given the user is in the Job Monitoring module
    When the user searches for the job using the job name "Daily_Extraction_Job"
    Then the job details are displayed, including its schedule and status

  @TC-23
  Scenario: User manually triggers the job execution
    Given the user has accessed the job details for "Daily_Extraction_Job"
    When the user manually triggers the job execution
    Then the job execution starts successfully

  @TC-23
  Scenario: User simulates a database failure
    Given the job "Daily_Extraction_Job" is executing
    When the user introduces a simulated failure by making the database unavailable
    Then the database unavailability occurs, simulating a failure scenario

  @TC-23
  Scenario: User monitors the job execution logs for error messages
    Given the database is unavailable during the job execution
    When the user monitors the job execution logs
    Then error messages related to database unavailability are logged

  @TC-23
  Scenario Outline: System sends notifications or alerts for job failure
    Given the job "Daily_Extraction_Job" has failed
    When the system sends notifications to the responsible team
    Then the notifications are sent successfully to "<recipient>"
    And the notification contains clear and actionable details about the failure

    Examples:
      | recipient                     |
      | extraction_team@company.com  |

  @TC-23
  Scenario: User restores the database availability
    Given the database is unavailable
    When the user resolves the simulated failure by restoring database availability
    Then the database availability is restored

  @TC-23
  Scenario: User re-runs the job manually
    Given the database availability is restored
    When the user attempts to re-run the job "Daily_Extraction_Job" manually
    Then the job execution starts successfully

  @TC-23
  Scenario: User monitors logs for successful execution after resolving the issue
    Given the job "Daily_Extraction_Job" has been re-executed
    When the user monitors the logs
    Then the logs show successful execution of the job

  @TC-23
  Scenario: User logs out of the SAP S/4HANA system
    Given the user has completed the job monitoring activities
    When the user logs out of the SAP S/4HANA system
    Then the user successfully logs out
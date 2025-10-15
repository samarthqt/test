Feature: Validate system behavior with data just below maximum capacity

  @TC-379
  Scenario: User logs in to the SAP S/4 HANA Cloud system
    Given the user has appropriate credentials
    When the user logs in to the SAP S/4 HANA Cloud system
    Then the user is successfully logged in and has access to the relevant modules

  @TC-379
  Scenario: Verify the schedule and activation status of the daily extraction job
    Given the daily extraction job is scheduled and active
    When the user verifies the schedule and activation status of the daily extraction job
    Then the daily extraction job schedule details are displayed

  @TC-379
  Scenario: Generate simulated direct sales data just below the maximum allowable transaction limit
    Given test data simulating daily transactions just below the maximum allowable limit is available
    When the user generates simulated direct sales data just below the maximum allowable transaction limit
    Then the simulated data is generated successfully just below the limit

  @TC-379
  Scenario: Trigger the daily extraction job to process the generated data
    Given the daily extraction job is scheduled and active
    When the user triggers the daily extraction job to process the generated data
    Then the daily extraction job is triggered successfully

  @TC-379
  Scenario: Monitor system logs during the data extraction process
    Given the daily extraction job is processing the generated data
    When the user monitors the system logs for any errors or warnings
    Then the system logs show no errors or warnings during the extraction process

  @TC-379
  Scenario: Validate successful data transmission to Model N
    Given the system has processed data just below the maximum allowable limit
    When the user verifies that all data is transmitted to Model N
    Then all data just below the maximum limit is transmitted successfully without errors

  @TC-379
  Scenario: Validate accuracy and completeness of data in Model N
    Given all data has been transmitted to Model N
    When the user logs in to Model N and validates the received data
    Then Model N displays all received data accurately and completely

  @TC-379
  Scenario: Check system performance metrics during the extraction process
    Given the daily extraction job is processing data
    When the user checks the system's performance metrics
    Then the system performance remains stable without any degradation

  @TC-379
  Scenario: Validate timestamps of transmitted data
    Given the data has been transmitted to Model N
    When the user validates the timestamps of the transmitted data
    Then the timestamps match the extraction job schedule, ensuring data consistency

  @TC-379
  Scenario: Verify the completion time of the daily extraction job
    Given the daily extraction job is processing data
    When the user verifies the completion time of the daily extraction job
    Then the extraction job completes within the defined time frame without delays

  @TC-379
  Scenario: Validate the system generates a detailed report of processed data
    Given the daily extraction job has processed data just below the maximum limit
    When the user verifies the generated report
    Then the system generates a report listing all processed data just below the maximum limit

  @TC-379
  Scenario: Document test results and observations
    Given the daily extraction job has completed successfully
    When the user documents the test results and observations
    Then the test results confirm successful processing just below the maximum allowable data volume
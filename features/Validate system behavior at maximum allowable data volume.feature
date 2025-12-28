Feature: Validate system behavior at maximum allowable data volume  
  Ensure the system successfully processes data at the exact maximum allowable daily transaction limit.

  @TC-378
  Scenario: User logs in to the SAP S/4 HANA Cloud system with appropriate credentials
    Given the user has valid credentials
    When the user logs in to the SAP S/4 HANA Cloud system
    Then the user is successfully logged in and has access to the relevant modules

  @TC-378
  Scenario: Verify the schedule and activation status of the daily extraction job
    Given the daily extraction job is scheduled and active
    When the user verifies the schedule and activation status of the daily extraction job
    Then the daily extraction job schedule details are displayed

  @TC-378
  Scenario: Generate simulated direct sales data at the maximum allowable transaction limit
    Given the test data simulating the exact maximum allowable daily transactions is available
    When the user generates simulated direct sales data at the exact maximum allowable transaction limit
    Then the simulated data is generated successfully at the exact limit

  @TC-378
  Scenario: Trigger the daily extraction job to process the generated data
    Given the simulated data at the maximum allowable transaction limit is ready
    When the user triggers the daily extraction job to process the generated data
    Then the daily extraction job is triggered successfully

  @TC-378
  Scenario: Monitor system logs for errors or warnings during the extraction process
    Given the daily extraction job is in progress
    When the user monitors the system logs during the extraction process
    Then the system logs show no errors or warnings during the extraction process

  @TC-378
  Scenario: Verify successful data transmission to Model N
    Given the daily extraction job has completed
    When the user verifies the data transmission to Model N
    Then all data at the maximum limit is transmitted successfully without errors

  @TC-378
  Scenario: Validate accuracy and completeness of received data in Model N
    Given all data has been transmitted to Model N
    When the user logs in to Model N and validates the received data
    Then Model N displays all received data accurately and completely

  @TC-378
  Scenario: Check the system's performance metrics during the extraction process
    Given the daily extraction job is in progress
    When the user checks the system's performance metrics
    Then the system performance remains stable without any degradation

  @TC-378
  Scenario: Validate timestamps of transmitted data align with the extraction job schedule
    Given the data has been transmitted to Model N
    When the user validates the timestamps of the transmitted data
    Then the timestamps match the extraction job schedule, ensuring data consistency

  @TC-378
  Scenario: Verify daily extraction job completes within the expected time frame
    Given the daily extraction job is running
    When the user verifies the completion time of the daily extraction job
    Then the extraction job completes within the defined time frame without delays

  @TC-378
  Scenario: Ensure the system generates a detailed report of the processed data
    Given the daily extraction job has completed
    When the user checks for the generated report
    Then the system generates a report listing all processed data at the maximum limit

  @TC-378
  Scenario: Document the results of the test and system behavior observations
    Given the test on maximum allowable data volume has been completed
    When the user documents the results and observations
    Then the test results confirm successful processing at the maximum allowable data volume
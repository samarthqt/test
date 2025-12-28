Feature: Verify system performance under maximum data load during extraction

  @TC-374
  Scenario: User logs into the SAP S/4 HANA Cloud system
    Given the user has appropriate credentials
    When the user logs into the SAP S/4 HANA Cloud system
    Then the user is successfully logged in and has access to the relevant modules
    And system performance monitoring tools are configured

  @TC-374
  Scenario: User verifies the schedule of the daily extraction job
    Given the user is logged into the SAP S/4 HANA Cloud system
    When the user verifies the schedule of the daily extraction job in the job scheduling module
    Then the daily extraction job is scheduled and active
    And test data simulating maximum transaction volume is available

  @TC-374
  Scenario: User generates simulated direct sales data near maximum capacity
    Given the user has access to system logs and performance metrics
    When the user generates simulated direct sales data with a volume close to the system's maximum capacity
    Then the simulated data is generated successfully

  @TC-374
  Scenario: User triggers the daily extraction job
    Given the user has generated simulated data near maximum capacity
    When the user triggers the daily extraction job to process and transmit the generated data
    Then the daily extraction job is triggered successfully

  @TC-374
  Scenario: User monitors system resource usage during the extraction job
    Given the daily extraction job is in progress
    When the user monitors the system CPU, memory, and disk usage
    Then the system resource usage remains within acceptable thresholds without spikes

  @TC-374
  Scenario: User checks the system logs for warnings or errors
    Given the daily extraction job is in progress
    When the user checks the system logs for warnings or errors during the data extraction process
    Then the system logs show no warnings or errors related to the extraction process

  @TC-374
  Scenario: User verifies data transmission to Model N
    Given the daily extraction job has processed the generated data
    When the user verifies that the data transmission to Model N is completed
    Then the data transmission is completed successfully without interruptions

  @TC-374
  Scenario: User validates performance monitoring metrics
    Given the daily extraction job has completed
    When the user validates the performance monitoring tool's metrics
    Then the performance metrics indicate stable system performance throughout the process

  @TC-374
  Scenario: User validates data in Model N
    Given the data transmission to Model N is completed
    When the user logs into Model N and validates the transmitted data
    Then Model N displays all transmitted data accurately and completely

  @TC-374
  Scenario: User verifies the completion time of the extraction job
    Given the daily extraction job has completed
    When the user verifies the completion time of the extraction job against the expected time frame
    Then the extraction job completes within the expected time frame

  @TC-374
  Scenario: User ensures the system handles maximum data volume
    Given the system is processing maximum allowable data
    When the user observes the system's handling of the data volume
    Then the system successfully handles maximum data volume without manual intervention

  @TC-374
  Scenario: User documents the results of the performance validation
    Given the performance validation has been completed
    When the user documents the results of the performance validation
    Then the performance validation results are documented with no significant issues observed
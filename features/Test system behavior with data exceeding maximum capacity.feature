Feature: Test system behavior with data exceeding maximum capacity

  Verify that the system handles scenarios where the daily data feed volume exceeds the maximum allowable capacity. The daily extraction job is scheduled and active.

  @TC-376
  Scenario: User logs into the system with appropriate credentials
    Given the user has valid credentials
    When the user logs into the SAP S/4 HANA Cloud system
    Then the user is successfully logged in and has access to the relevant modules

  @TC-376
  Scenario: User verifies the daily extraction job schedule and activation status
    Given the daily extraction job is configured in the system
    When the user checks the schedule and activation status of the daily extraction job
    Then the daily extraction job is scheduled and active

  @TC-376
  Scenario Outline: User generates simulated direct sales data exceeding maximum capacity
    Given the system's maximum allowable daily transactions are "<maximum capacity>"
    When the user generates simulated direct sales data exceeding "<test data volume>"
    Then simulated data exceeding maximum capacity is generated successfully

    Examples:
      | maximum capacity | test data volume |
      | 1000             | 1200             |
      | 5000             | 6000             |

  @TC-376
  Scenario: User triggers the daily extraction job to process the generated data
    Given simulated data exceeding maximum capacity is available
    When the user triggers the daily extraction job to process the generated data
    Then the daily extraction job is triggered successfully

  @TC-376
  Scenario: User monitors system logs for errors or warnings during extraction
    Given the daily extraction job is processing data
    When the user monitors the system logs
    Then the system logs display errors or warnings indicating data volume exceeds capacity

  @TC-376
  Scenario: User verifies that the system prevents processing of data exceeding maximum capacity
    Given the data volume exceeds the maximum allowable capacity
    When the user checks the processing status of the data
    Then the system does not process data that exceeds the maximum allowable capacity

  @TC-376
  Scenario Outline: User validates error messages displayed for exceeded capacity
    Given the data volume exceeds "<exceeded data volume>"
    When the user views the error messages displayed
    Then the error messages are clear and indicate that the data volume exceeds the system's capacity

    Examples:
      | exceeded data volume |
      | 1200                 |
      | 6000                 |

  @TC-376
  Scenario: User checks if the system allows partial processing of data within allowable capacity
    Given the data volume exceeds the maximum allowable capacity
    When the user verifies the processed data
    Then the system processes only the data within the allowable capacity and skips the rest

  @TC-376
  Scenario: User logs into Model N and verifies no excess data is transmitted
    Given the system has processed the allowable data
    When the user logs into Model N
    Then Model N does not receive data exceeding the defined capacity

  @TC-376
  Scenario: User reviews the system's response time when handling excess data volume
    Given the system is processing data exceeding maximum capacity
    When the user monitors the system's response time
    Then the system response time remains stable despite the excess data volume

  @TC-376
  Scenario: User ensures the system generates a detailed report of non-processed data
    Given the system has skipped processing data exceeding maximum capacity
    When the user reviews the generated report
    Then the system generates a report listing the data that exceeded the capacity and was not processed

  @TC-376
  Scenario: User documents the results of the test and observations
    Given the system has completed processing the data
    When the user documents the test results and observations
    Then the test results highlight the system's ability to handle excess data volume scenarios
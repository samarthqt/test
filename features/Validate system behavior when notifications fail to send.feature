Feature: Validate system behavior when notifications fail to send  
  Ensure the system handles notification failures gracefully and logs errors.

  @TC-24
  Scenario: User logs into the SAP S/4HANA system  
    Given the user has valid credentials  
    When the user logs into the SAP S/4HANA system  
    Then the user successfully accesses the dashboard  

  @TC-24
  Scenario: User navigates to the Job Monitoring module  
    Given the notification settings are configured in the system  
    When the user navigates to the Job Monitoring module  
    Then the Job Monitoring module is displayed with all scheduled jobs  

  @TC-24
  Scenario Outline: User searches for a specific job by job name  
    Given the Job Monitoring module is displayed  
    When the user searches for the job using the job name "<JobName>"  
    Then the job details are displayed, including its schedule and status  

    Examples:  
      | JobName              |  
      | Daily_Extraction_Job |  

  @TC-24
  Scenario: User manually triggers the job execution  
    Given the job details are displayed  
    When the user manually triggers the job execution  
    Then the job execution starts successfully  

  @TC-24
  Scenario: Simulating an email server failure  
    Given the email server is available  
    When the user introduces a simulated failure by making the email server unavailable  
    Then email server unavailability occurs, simulating a notification failure scenario  

  @TC-24
  Scenario: Monitoring job execution logs for error messages  
    Given the email server is unavailable during job execution  
    When the user monitors the job execution logs  
    Then error messages related to notification failure are logged  

  @TC-24
  Scenario: Verifying system attempts to send notifications despite failure  
    Given the email server is unavailable during job execution  
    When the user verifies the system's notification attempts  
    Then the system attempts to send notifications but encounters errors  

  @TC-24
  Scenario: Checking detailed error messages in the logs  
    Given the system encounters notification errors  
    When the user checks the system logs  
    Then detailed error messages about the notification failure are logged, indicating the cause of the failure  

  @TC-24
  Scenario: Resolving the simulated email server failure  
    Given the email server is unavailable  
    When the user resolves the simulated email server failure  
    Then the email server availability is restored  

  @TC-24
  Scenario: Re-sending notifications manually after resolving the issue  
    Given the email server availability is restored  
    When the user attempts to re-send the notifications manually  
    Then the notifications are sent successfully  

  @TC-24
  Scenario: Monitoring logs for successful notification delivery  
    Given the notifications are sent successfully  
    When the user monitors the logs  
    Then the logs show successful delivery of notifications  

  @TC-24
  Scenario: User logs out of the SAP S/4HANA system  
    Given the user has completed their tasks  
    When the user logs out of the SAP S/4HANA system  
    Then the user successfully logs out
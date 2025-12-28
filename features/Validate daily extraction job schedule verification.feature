Feature: Validate daily extraction job schedule verification  
  Ensure the daily extraction job is scheduled and active.  

  @TC-21  
  Scenario: User logs in to the SAP S/4HANA system  
    Given the user has valid credentials  
    When the user logs in to the SAP S/4HANA system  
    Then the user successfully logs in and accesses the dashboard  

  @TC-21  
  Scenario: User navigates to the Job Monitoring module  
    Given the user is on the dashboard  
    When the user navigates to the Job Monitoring module  
    Then the Job Monitoring module is displayed with all scheduled jobs  

  @TC-21  
  Scenario Outline: User verifies the daily extraction job details  
    Given the user is in the Job Monitoring module  
    When the user searches for the daily extraction job using the job name "<Job Name>"  
    Then the job details are displayed, including its schedule and status  
    And the job schedule is displayed correctly as "<Schedule>"  
    And the job status is displayed as "<Status>"  

    Examples:  
      | Job Name              | Schedule       | Status   |  
      | Daily_Extraction_Job  | 12:00 AM daily | Active   |  

  @TC-21  
  Scenario: User verifies the job configuration details  
    Given the user has accessed the daily extraction job details  
    When the user verifies the job configuration details such as target database and extraction parameters  
    Then the job configuration details are displayed accurately  

  @TC-21  
  Scenario: User validates notification settings for the job  
    Given the user has accessed the daily extraction job details  
    When the user validates the notification settings for the job in case of failure  
    Then the notification settings are configured for alerts in case of job failure  

  @TC-21  
  Scenario: User checks the last execution logs of the job  
    Given the user has accessed the daily extraction job details  
    When the user checks the last execution logs to confirm the job ran successfully  
    Then the logs show successful execution of the job  

  @TC-21  
  Scenario: User confirms the job owner and responsible team  
    Given the user has accessed the daily extraction job details  
    When the user confirms the job owner and responsible team are correctly assigned  
    Then the job owner and team details are displayed correctly  

  @TC-21  
  Scenario: User validates job dependencies  
    Given the user has accessed the daily extraction job details  
    When the user validates the job dependencies to ensure no conflicting schedules exist  
    Then no conflicting schedules are found  

  @TC-21  
  Scenario: User documents findings and confirms job readiness  
    Given the user has completed all validations for the daily extraction job  
    When the user documents the findings and confirms the job is ready for execution  
    Then the documentation is completed, and the job is confirmed ready  

  @TC-21  
  Scenario: User logs out of the SAP S/4HANA system  
    Given the user has completed all tasks  
    When the user logs out of the SAP S/4HANA system  
    Then the user successfully logs out
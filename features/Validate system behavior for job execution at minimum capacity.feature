Feature: Validate system behavior for job execution at minimum capacity  
  Ensure the system handles job execution at minimum capacity efficiently.  

  @TC-27  
  Scenario: User logs in to the SAP S/4HANA system  
    Given the user has valid credentials  
    When the user logs in to the SAP S/4HANA system  
    Then the user successfully accesses the dashboard  

  @TC-27  
  Scenario: User navigates to the Job Monitoring module  
    Given the user is logged in to the SAP S/4HANA system  
    When the user navigates to the Job Monitoring module  
    Then the Job Monitoring module is displayed with all scheduled jobs  

  @TC-27  
  Scenario Outline: Search for the daily extraction job by job name  
    Given the user is in the Job Monitoring module  
    When the user searches for the job using the job name "<job_name>"  
    Then the job details are displayed, including its schedule and status  

    Examples:  
      | job_name              |  
      | Daily_Extraction_Job  |  

  @TC-27  
  Scenario: User manually triggers the job execution  
    Given the daily extraction job is displayed in the Job Monitoring module  
    When the user triggers the job execution  
    Then the job execution starts successfully  

  @TC-27  
  Scenario: Monitor job execution logs for performance metrics  
    Given the daily extraction job execution has started  
    When the user monitors the job execution logs  
    Then the performance metrics are logged, showing processing time and resource utilization  

  @TC-27  
  Scenario Outline: Validate job processing and resource utilization  
    Given the daily extraction job execution logs are available  
    When the user verifies the system processes "<capacity>" without errors  
    Then the record is processed successfully  
    And the resource utilization remains minimal  

    Examples:  
      | capacity   |  
      | 1 record   |  

  @TC-27  
  Scenario: Validate system response time and throughput  
    Given the daily extraction job execution is completed  
    When the user validates the system's response time and throughput  
    Then the response time and throughput meet expected thresholds  

  @TC-27  
  Scenario: Document performance metrics and resource utilization findings  
    Given the performance metrics and resource utilization findings are available  
    When the user documents the findings  
    Then the documentation is completed, highlighting system performance at minimum capacity  

  @TC-27  
  Scenario: Compare performance metrics against baseline values  
    Given the performance metrics for the daily extraction job are documented  
    When the user compares the metrics against baseline values  
    Then the performance metrics align with baseline values, indicating efficient handling  

  @TC-27  
  Scenario: Validate concurrent job execution during minimum capacity  
    Given the daily extraction job is executing at minimum capacity  
    When the user validates the system's ability to handle concurrent jobs  
    Then the concurrent jobs execute successfully without impacting the daily extraction job  

  @TC-27  
  Scenario: User logs out of the SAP S/4HANA system  
    Given the user has completed all tasks in the SAP S/4HANA system  
    When the user logs out  
    Then the user successfully logs out
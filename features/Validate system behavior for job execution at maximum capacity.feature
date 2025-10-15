Feature: Validate system behavior for job execution at maximum capacity  
  Ensure the system handles job execution at maximum capacity without performance degradation.  

  @TC-26  
  Scenario Outline: Validate job execution with various system parameters and behaviors  
    Given the user logs into the SAP S/4HANA system with valid credentials  
    And the user navigates to the Job Monitoring module  
    When the user searches for the daily extraction job using the job name "<Job Name>"  
    And the user manually triggers the job execution  
    Then the system starts the job execution successfully  
    And the system processes "<Number of Records>" records without errors  
    And the system's resource utilization remains "<Resource Utilization>"  
    And the system's response time and throughput are "<Performance Thresholds>"  
    And the user documents the performance metrics and resource utilization findings  
    And the user compares the performance metrics against baseline values, which "<Baseline Comparison>"  
    And the system successfully handles concurrent jobs during execution  

    Examples:  
      | Job Name              | Number of Records | Resource Utilization    | Performance Thresholds      | Baseline Comparison                |  
      | Daily_Extraction_Job  | 1,000,000         | within acceptable limits| meet expected thresholds     | aligns with baseline values       |  

  @TC-26  
  Scenario: Validate user login functionality  
    Given the user logs into the SAP S/4HANA system with valid credentials  
    Then the user successfully accesses the dashboard  

  @TC-26  
  Scenario: Validate navigation to Job Monitoring module  
    Given the user logs into the SAP S/4HANA system with valid credentials  
    When the user navigates to the Job Monitoring module  
    Then the Job Monitoring module is displayed with all scheduled jobs  

  @TC-26  
  Scenario: Validate job search functionality  
    Given the user is in the Job Monitoring module  
    When the user searches for the daily extraction job using the job name "Daily_Extraction_Job"  
    Then the job details are displayed, including its schedule and status  

  @TC-26  
  Scenario: Validate system's ability to handle concurrent jobs during maximum capacity execution  
    Given the user triggers the daily extraction job execution  
    When concurrent jobs are executed during the job run  
    Then the concurrent jobs execute successfully without impacting the daily extraction job  

  @TC-26  
  Scenario: Validate user logout functionality  
    Given the user is logged into the SAP S/4HANA system  
    When the user logs out of the system  
    Then the user successfully logs out
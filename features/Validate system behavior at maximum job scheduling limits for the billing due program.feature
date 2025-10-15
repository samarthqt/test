Feature: Validate system behavior at maximum job scheduling limits for the billing due program  
  Ensure the system can handle maximum allowable job schedules for the billing due program without performance issues.  

  @TC-440  
  Scenario: User navigates to the billing due program  
    Given the user is logged into the SAP system  
    When the user navigates to the billing due program  
    Then the billing due program screen is displayed  

  @TC-440  
  Scenario: User selects the option to execute the program in background mode  
    Given the billing due program screen is displayed  
    When the user selects the option to execute the program in background mode  
    Then the option for background execution is selected successfully  

  @TC-440  
  Scenario Outline: User defines selection criteria for jobs and schedules them up to the maximum limit  
    Given the user is on the billing due program screen  
    When the user defines the selection criteria for the "<job_number>" job  
    And the user schedules the "<job_number>" job  
    Then the "<job_number>" job is scheduled successfully  

    Examples:  
      | job_number |  
      | 1          |  
      | 2          |  
      | 3          |  
      | 4          |  
      | 5          |  
      | ...        |  
      | Maximum    |  

  @TC-440  
  Scenario: User executes all scheduled jobs sequentially  
    Given all jobs are scheduled successfully  
    When the user executes all scheduled jobs sequentially  
    Then all jobs execute successfully without performance degradation  

  @TC-440  
  Scenario Outline: User monitors the status of each job in the job log  
    Given all scheduled jobs have been executed  
    When the user monitors the status of the "<job_number>" job in the job log  
    Then the job log displays successful completion for the "<job_number>" job  

    Examples:  
      | job_number |  
      | 1          |  
      | 2          |  
      | 3          |  
      | 4          |  
      | 5          |  
      | ...        |  
      | Maximum    |  

  @TC-440  
  Scenario Outline: User verifies the creation of billing documents for each job  
    Given all jobs have been executed successfully  
    When the user verifies the creation of billing documents for the "<job_number>" job  
    Then billing documents are created successfully for the "<job_number>" job  

    Examples:  
      | job_number |  
      | 1          |  
      | 2          |  
      | 3          |  
      | 4          |  
      | 5          |  
      | ...        |  
      | Maximum    |  

  @TC-440  
  Scenario: User validates system performance metrics during job execution  
    Given all jobs are being executed sequentially  
    When the user monitors system performance metrics  
    Then the system performance remains stable with acceptable resource utilization  

  @TC-440  
  Scenario: User checks for warnings or errors in the logs  
    Given all jobs are executed successfully  
    When the user checks the logs for warnings or errors  
    Then no warnings or errors are found in the logs  

  @TC-440  
  Scenario: User ensures system stability after job execution  
    Given all jobs are executed successfully  
    When the user monitors the system after job execution  
    Then the system remains stable and operational  

  @TC-440  
  Scenario: User notifies stakeholders about the successful execution of all jobs  
    Given all jobs are executed successfully and no issues are found  
    When the user notifies stakeholders about the execution results  
    Then stakeholders are informed, and no further actions are required
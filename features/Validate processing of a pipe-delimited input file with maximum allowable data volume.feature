Feature: Validate processing of a pipe-delimited input file with maximum allowable data volume  
  Ensure the system successfully processes a pipe-delimited input file with maximum allowable data volume without errors or performance degradation.  

  @TC-361  
  Scenario: User logs into SAP S/4HANA with valid credentials  
    Given the user has valid SAP S/4HANA login credentials  
    When the user logs into the system  
    Then the user successfully logs into the system  

  @TC-361  
  Scenario: User navigates to the AL11/EC2/Inbound directory  
    Given the pipe-delimited file named "max_volume_input.txt" containing maximum allowable records is available in the directory  
    And the daily background job is scheduled and active  
    When the user navigates to the AL11/EC2/Inbound directory  
    Then the directory is displayed, and the input file "max_volume_input.txt" is visible  

  @TC-361  
  Scenario: User verifies the size and format of the file  
    Given the file "max_volume_input.txt" is in the AL11/EC2/Inbound directory  
    When the user verifies the size and format of the file  
    Then the file matches the maximum allowable size and is in pipe-delimited format  

  @TC-361  
  Scenario: User manually triggers the background job for file processing  
    Given the configured background job ID is "JOB_MAX_VOLUME"  
    When the user triggers the background job "JOB_MAX_VOLUME" for file processing  
    Then the background job is triggered successfully  

  @TC-361  
  Scenario: User monitors the job execution in SM37 transaction  
    Given the background job "JOB_MAX_VOLUME" has been triggered  
    When the user monitors the job execution in SM37 transaction  
    Then the job status changes to "Finished" without any errors  

  @TC-361  
  Scenario: User navigates to the processed data section in S/4HANA  
    Given the job "JOB_MAX_VOLUME" has completed successfully  
    When the user navigates to the processed data section in S/4HANA  
    Then all data from "max_volume_input.txt" is processed and visible in the system  

  @TC-361  
  Scenario: User verifies the accuracy of Customer Master Data updates  
    Given the data from "max_volume_input.txt" has been processed  
    When the user verifies the Customer Master Data updates  
    Then the Customer Master Data is updated accurately as per the input file  

  @TC-361  
  Scenario: User verifies the accuracy of Site Master Data updates  
    Given the data from "max_volume_input.txt" has been processed  
    When the user verifies the Site Master Data updates  
    Then the Site Master Data is updated accurately as per the input file  

  @TC-361  
  Scenario: User checks system logs in SM21 for warnings or errors  
    Given the job "JOB_MAX_VOLUME" has completed successfully  
    When the user checks system logs in SM21  
    Then no warnings or errors related to file size or processing are logged  

  @TC-361  
  Scenario: User validates system performance metrics during job execution  
    Given the background job "JOB_MAX_VOLUME" is executed  
    When the user validates system performance metrics during the execution  
    Then system performance metrics remain within acceptable thresholds  

  @TC-361  
  Scenario: User ensures no duplicate records are created in the database  
    Given the data from "max_volume_input.txt" is processed  
    When the user checks for duplicate records in the database  
    Then no duplicate records are found in the processed data  

  @TC-361  
  Scenario: User generates a report summarizing the processed data and job execution details  
    Given the job "JOB_MAX_VOLUME" has completed successfully  
    When the user generates a report summarizing the processed data and job execution details  
    Then the report is generated successfully, showing accurate and complete data processing
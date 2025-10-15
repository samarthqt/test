Feature: Validate manual execution of the background job with correct selection screen defaults  
  Ensure the background job executes successfully using pre-populated mandatory defaults from the selection screen.  

  @TC-358  
  Scenario: User logs into SAP S/4HANA with valid credentials  
    Given the user has valid SAP S/4HANA credentials  
    When the user logs into the system  
    Then the user should successfully access the main dashboard  

  @TC-358  
  Scenario: User navigates to the selection screen for the background job execution  
    Given the user is logged into SAP S/4HANA  
    When the user navigates to the selection screen for the background job execution  
    Then the selection screen for the background job should be displayed  

  @TC-358  
  Scenario: Verify mandatory parameters are pre-populated with default values  
    Given the user is on the selection screen for the background job execution  
    When the user views the mandatory parameters  
    Then the mandatory parameters such as Sales Document Type, Sales Organization, Distribution Channel, and Division should be pre-populated with default values  

  @TC-358  
  Scenario Outline: User inputs Run Date and File Path into the selection screen  
    Given the user is on the selection screen for the background job execution  
    When the user inputs the Run Date as "<Run Date>" and the File Path as "<File Path>"  
    Then the system should accept the Run Date and File Path without errors  

    Examples:  
      | Run Date     | File Path                        |  
      | 2023-10-01   | /AL11/EC2/Inbound/input_file.txt |  

  @TC-358  
  Scenario: User executes the background job manually  
    Given the user has entered valid Run Date and File Path on the selection screen  
    When the user executes the background job manually  
    Then the background job execution should be triggered successfully  

  @TC-358  
  Scenario: User monitors the job execution in the job log  
    Given the background job execution has been triggered  
    When the user monitors the job execution in the job log  
    Then the job log should update with execution details and progress  

  @TC-358  
  Scenario: Verify the job picks up the input file from the specified path  
    Given the background job execution is in progress  
    When the job attempts to pick up the input file  
    Then the input file should be successfully picked up from the specified path  

  @TC-358  
  Scenario: Validate the job processes the file data and updates Customer Master Data  
    Given the background job has picked up the input file  
    When the job processes the file data  
    Then the Customer Master Data should be updated accurately  

  @TC-358  
  Scenario: Validate the job processes the file data and updates Site Master Data  
    Given the background job has picked up the input file  
    When the job processes the file data  
    Then the Site Master Data should be updated accurately  

  @TC-358  
  Scenario: Check system logs for errors or warnings during job execution  
    Given the background job execution is in progress or completed  
    When the user checks the system logs  
    Then the system logs should indicate successful job execution without errors or warnings  

  @TC-358  
  Scenario: Confirm the background job completes successfully  
    Given the background job execution is in progress  
    When the job completes its execution  
    Then the background job status should be marked as 'Completed' in the job monitor  

  @TC-358  
  Scenario: Verify that the processed data is visible and accurate in S/4HANA  
    Given the background job execution is completed successfully  
    When the user views the processed data in S/4HANA  
    Then the processed data should be displayed correctly and accurately in the system
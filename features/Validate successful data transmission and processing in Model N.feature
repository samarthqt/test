Feature: Validate successful data transmission and processing in Model N  
  Ensure that all data transmitted during the daily extraction job is processed correctly in Model N.  

  @TC-375  
  Scenario: User logs in to SAP S/4 HANA Cloud system  
    Given the user has valid credentials for SAP S/4 HANA Cloud  
    When the user logs in to the system  
    Then the user should be successfully logged in and have access to relevant modules  

  @TC-375  
  Scenario: User verifies the daily extraction job schedule and activation status  
    Given the daily extraction job is scheduled and active  
    When the user verifies the schedule and activation status of the job  
    Then the job should be confirmed as scheduled and active  

  @TC-375  
  Scenario: User generates simulated direct sales data near maximum capacity  
    Given simulated direct sales data near maximum capacity is required  
    When the user generates simulated data near the system's maximum capacity  
    Then the simulated data should be generated successfully  

  @TC-375  
  Scenario: User triggers the daily extraction job  
    Given the daily extraction job is scheduled and simulated data is available  
    When the user triggers the daily extraction job to process the generated data  
    Then the daily extraction job should be triggered successfully  

  @TC-375  
  Scenario: User monitors system logs for data extraction and transmission  
    Given the daily extraction job has been triggered  
    When the user monitors the system logs  
    Then the logs should indicate successful data extraction and transmission without errors  

  @TC-375  
  Scenario: User logs in to Model N  
    Given the user has valid credentials for Model N  
    When the user logs in to Model N  
    Then the user should be successfully logged in to Model N  

  @TC-375  
  Scenario: User verifies the data received in Model N  
    Given the daily extraction job has transmitted data  
    When the user navigates to the data import section in Model N  
    Then all transmitted data should be visible in Model N and match the expected values  

  @TC-375  
  Scenario: User validates the accuracy and completeness of transmitted data in Model N  
    Given the transmitted data is visible in Model N  
    When the user validates the accuracy and completeness of the received data  
    Then the data should be accurate and complete with no discrepancies  

  @TC-375  
  Scenario: User checks processing logs in Model N for errors or warnings  
    Given the data processing is underway in Model N  
    When the user checks the processing logs  
    Then the logs should show no errors or warnings during data processing  

  @TC-375  
  Scenario: User verifies data processing is completed within the expected time frame  
    Given the data processing is ongoing in Model N  
    When the user verifies the processing time  
    Then the data processing should be completed within the defined time frame  

  @TC-375  
  Scenario: User ensures processed data is ready for downstream workflows  
    Given the data processing is completed in Model N  
    When the user verifies the readiness of processed data  
    Then the processed data should be ready and available for downstream workflows  

  @TC-375  
  Scenario: User documents the results of the data transmission and processing validation  
    Given the data transmission and processing validation is completed  
    When the user documents the validation results  
    Then the results should confirm successful data transmission and processing
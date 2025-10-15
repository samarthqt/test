Feature: Validate system behavior with a large file containing invalid data  
  Ensure the system properly handles and logs errors when processing a large file with invalid data.  

  @TC-357  
  Scenario: User logs in to the SAP S/4HANA system  
    Given the user has valid SAP S/4HANA credentials  
    When the user enters the credentials and logs in  
    Then the user successfully logs in to the system  

  @TC-357  
  Scenario: User prepares and places a pipe-delimited file with invalid data  
    Given a pipe-delimited file with invalid data is prepared  
    When the user places the file in the EC2 path  
    Then the file is successfully placed in the EC2 path  

  @TC-357  
  Scenario: User schedules a background job to poll the EC2 path  
    Given the user is logged in to the SAP S/4HANA system  
    When the user navigates to the job scheduling interface and schedules a background job to poll the EC2 path for sales order data  
    Then the background job is successfully scheduled  

  @TC-357  
  Scenario: System retrieves the file from the EC2 path  
    Given the background job is scheduled  
    When the background job runs and retrieves the file from the EC2 path  
    Then the system successfully retrieves the file  

  @TC-357  
  Scenario: System processes the data from the retrieved file  
    Given the system has retrieved the file  
    When the system begins processing the data  
    Then the system starts processing the file  

  @TC-357  
  Scenario: System logs errors for invalid data in the file  
    Given the system is processing the file  
    When the system encounters invalid data  
    Then the system logs display detailed error messages for the invalid data  

  @TC-357  
  Scenario: System skips invalid records and processes valid records  
    Given the system is processing the file  
    When the system identifies records with invalid data  
    Then the system skips invalid records and continues processing valid records without interruption  

  @TC-357  
  Scenario: System ensures no invalid data is processed or saved  
    Given the system skips invalid records  
    When the processing is completed  
    Then no invalid data is processed or saved in the system  

  @TC-357  
  Scenario Outline: Validate total number of successfully processed records  
    Given the file contains <total records> with <valid records> and <invalid records>  
    When the system completes processing  
    Then the total number of successfully processed records matches the <valid records>  

    Examples:  
      | total records | valid records | invalid records |  
      | 100           | 80            | 20              |  
      | 50            | 45            | 5               |  

  @TC-357  
  Scenario: System remains stable during the process  
    Given the system is processing the file  
    When the process is ongoing  
    Then the system remains stable and operational throughout  

  @TC-357  
  Scenario: Logs provide actionable error details for remediation  
    Given the system logs errors for invalid data  
    When the user reviews the logs  
    Then the logs contain actionable error details for resolving issues with invalid data  

  @TC-357  
  Scenario: System generates alerts or notifications for errors  
    Given the system encounters errors during processing  
    When the errors are logged  
    Then the system generates alerts or notifications for the errors encountered  

  @TC-357  
  Scenario: No dependent workflows or processes are triggered by invalid data  
    Given the system skips invalid records  
    When the processing is completed  
    Then no dependent workflows or processes are triggered by invalid data
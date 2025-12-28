Feature: Validate system behavior with a large file containing maximum allowable records  
  Ensure the system retrieves and processes a large file with maximum allowable records without errors or performance degradation.  

  @TC-355  
  Scenario: User logs in to the SAP S/4HANA system using valid credentials  
    Given user has valid SAP S/4HANA credentials  
    When user logs in to the SAP S/4HANA system  
    Then user successfully logs in to the system  

  @TC-355  
  Scenario: User schedules a background job to poll the EC2 path for sales order data  
    Given a pipe-delimited file with the maximum allowable number of records is prepared and placed in the EC2 path  
    When user navigates to the job scheduling interface and schedules a background job to poll the EC2 path for sales order data  
    Then the background job is successfully scheduled  

  @TC-355  
  Scenario: System retrieves the file from the EC2 path  
    Given the EC2 path is configured for file retrieval  
    When the background job runs and retrieves the file from the EC2 path  
    Then the system successfully retrieves the file from the specified EC2 path  

  @TC-355  
  Scenario: System processes the file without errors or performance issues  
    Given the system has retrieved the file from the EC2 path  
    When the system processes the data from the retrieved file  
    Then the system processes the file without any errors or performance issues  

  @TC-355  
  Scenario: Verify creation or update of sales orders for all records in the file  
    Given the file contains sales order records  
    When the system processes all records in the file  
    Then all records are processed successfully, and corresponding sales orders are created or updated  

  @TC-355  
  Scenario: Validate system logs for warnings or performance-related messages  
    Given the system has completed processing the file  
    When user navigates to the system logs and reviews them  
    Then logs indicate successful processing of the file without any warnings or performance issues  

  @TC-355  
  Scenario: Validate total number of records processed matches the file's record count  
    Given the file contains a specific number of records  
    When the system completes processing the file  
    Then the total number of processed records matches the file's record count  

  @TC-355  
  Scenario: Validate no data discrepancies exist between the file and system records  
    Given the file contains accurate sales order data  
    When the system processes the file  
    Then data in the system matches the data in the file exactly  

  @TC-355  
  Scenario: Verify successful creation of dependent objects or workflows  
    Given the file contains records that trigger dependent objects or workflows  
    When the system processes the file  
    Then all dependent objects or workflows are successfully created or triggered  

  @TC-355  
  Scenario: Validate system performance metrics during file processing  
    Given the system processes a large file  
    When user monitors the system's performance metrics during the file processing  
    Then performance metrics remain within acceptable thresholds  

  @TC-355  
  Scenario: Verify system stability during file processing  
    Given the system processes the file  
    When user monitors for system errors or crashes during the process  
    Then the system remains stable and operational throughout the process  

  @TC-355  
  Scenario: Validate processed data accuracy in the reporting interface  
    Given the system has completed processing the file  
    When user accesses the system's reporting interface  
    Then processed data is accurate and accessible in the reporting interface
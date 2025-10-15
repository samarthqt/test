Feature: Validate successful execution of billing due program in background mode  
  Ensure the billing due program executes successfully in background mode and creates billing documents as per the selection criteria.

  @TC-438  
  Scenario: User navigates to the billing due program in the SAP system  
    Given the user has access to the SAP system  
    When the user navigates to the billing due program  
    Then the billing due program screen is displayed  

  @TC-438  
  Scenario: User selects the option to execute the program in background mode  
    Given the user is on the billing due program screen  
    When the user selects the option to execute the program in background mode  
    Then the option for background execution is selected successfully  

  @TC-438  
  Scenario Outline: User defines the selection criteria for the billing due program  
    Given the user is on the billing due program screen  
    When the user enters "<selection criteria>"  
    Then the selection criteria are entered correctly  

    Examples:  
      | selection criteria              |  
      | Valid billing due documents     |  
      | Invalid billing due documents   |  
      | Blank selection criteria        |  

  @TC-438  
  Scenario: User schedules the program as a background job  
    Given the user has defined the selection criteria for the billing due program  
    When the user schedules the program as a background job  
    Then the background job is scheduled successfully with the provided criteria  

  @TC-438  
  Scenario: User executes the background job  
    Given the background job is scheduled successfully  
    When the user executes the background job  
    Then the background job is executed without errors  

  @TC-438  
  Scenario: User monitors the status of the background job in the job log  
    Given the background job is executed successfully  
    When the user monitors the status of the background job in the job log  
    Then the job status is displayed as completed successfully  

  @TC-438  
  Scenario: User verifies the creation of billing documents in the system  
    Given the background job status is completed successfully  
    When the user verifies the creation of billing documents in the system  
    Then billing documents are created successfully as per the selection criteria  

  @TC-438  
  Scenario: User validates that no user intervention was required during the process  
    Given the background job is executed successfully  
    When the user reviews the execution process  
    Then the process is completed without manual intervention  

  @TC-438  
  Scenario: User checks the generated billing documents for accuracy  
    Given the billing documents are created successfully  
    When the user checks the generated billing documents for accuracy  
    Then the billing documents meet the expected criteria and contain correct data  

  @TC-438  
  Scenario: User verifies the logs for any warnings or errors during execution  
    Given the background job is executed successfully  
    When the user verifies the logs for warnings or errors during execution  
    Then no warnings or errors are found in the logs  

  @TC-438  
  Scenario: User confirms that the job is marked as completed in the job overview  
    Given the background job is executed successfully  
    When the user checks the job overview  
    Then the job status is marked as completed  

  @TC-438  
  Scenario: User notifies stakeholders about the successful execution of the job  
    Given the job status is marked as completed  
    When the user notifies stakeholders about the job execution  
    Then stakeholders are informed, and no further actions are required
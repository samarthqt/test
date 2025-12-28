Feature: Validate system error handling for missing input file in background job execution  
  Ensure the system correctly handles scenarios where the input file is missing during background job execution. The custom billing due program is configured to support background execution.

  @TC-179
  Scenario: Validate user login to SAP S/4HANA system  
    Given the user has valid credentials  
    When the user logs in to the SAP S/4HANA system  
    Then the user is successfully logged in  

  @TC-179
  Scenario: Navigate to the billing due program configuration screen  
    Given the user is logged in to the SAP S/4HANA system  
    When the user navigates to the billing due program configuration screen  
    Then the billing due program configuration screen is displayed  

  @TC-179
  Scenario: Select background execution mode for the billing program  
    Given the user is on the billing due program configuration screen  
    When the user selects the option for background execution of the billing program  
    Then the background execution mode is selected  

  @TC-179
  Scenario Outline: Schedule and execute the billing program as a background job with missing input file  
    Given the user has selected background execution mode  
    And the user enters valid selection criteria for processing billing due documents  
    When the user schedules the program as a background job without providing the input file  
    And the user executes the background job and monitors its status  
    Then the background job execution starts successfully  
    And the user accesses the job log to review error messages  
    And error messages indicating the missing input file are displayed in the job log  
    And no billing documents are created as a result of the execution  
    And the system logs provide detailed error descriptions related to the missing input file  
    And the error messages are clear and actionable, indicating the absence of the input file  
    And the system maintains data integrity despite the error  
    And the user documents the observed behavior and error handling for further analysis  

    Examples:  
      | SelectionCriteria         | InputFile |  
      | Valid billing document IDs | Missing   |
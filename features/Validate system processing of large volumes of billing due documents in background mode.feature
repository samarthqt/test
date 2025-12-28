Feature: Validate system processing of large volumes of billing due documents in background mode  
  Ensure the system efficiently processes large volumes of billing due documents in background mode without errors or performance issues.

  @TC-178
  Scenario: User logs in to the SAP S/4HANA system with appropriate credentials  
    Given the user has valid credentials  
    When the user logs in to the SAP S/4HANA system  
    Then the user is successfully logged in  

  @TC-178
  Scenario: User navigates to the billing due program configuration screen  
    Given the user is logged in to the SAP S/4HANA system  
    When the user navigates to the billing due program configuration screen  
    Then the billing due program configuration screen is displayed  

  @TC-178
  Scenario: User selects the option for background execution of the billing program  
    Given the user is on the billing due program configuration screen  
    When the user selects the option for background execution of the billing program  
    Then the background execution mode is selected  

  @TC-178
  Scenario Outline: User enters selection criteria for processing billing documents  
    Given the user is on the billing due program configuration screen  
    When the user enters selection criteria for processing billing documents "<criteria>"  
    Then the selection criteria "<criteria>" are successfully entered  

    Examples:  
      | criteria          |  
      | Valid billing document IDs (10,000 records) |  

  @TC-178
  Scenario: User schedules the program as a background job  
    Given the user has entered valid selection criteria  
    When the user schedules the program as a background job  
    Then the background job is scheduled successfully  

  @TC-178
  Scenario: User executes the background job and monitors its status  
    Given the background job is scheduled  
    When the user executes the background job  
    Then the background job execution starts successfully  

  @TC-178
  Scenario: User reviews the job log for progress and messages  
    Given the background job is executing  
    When the user accesses the job log  
    Then the job log displays progress and indicates successful processing of billing documents  

  @TC-178
  Scenario: User verifies all billing due documents are processed successfully  
    Given the background job execution is complete  
    When the user verifies the processed documents  
    Then all billing due documents are processed successfully  

  @TC-178
  Scenario: User checks system performance metrics during job execution  
    Given the background job is executing  
    When the user checks system performance metrics  
    Then the system performance metrics indicate efficient processing without degradation  

  @TC-178
  Scenario: User ensures the system creates corresponding billing documents  
    Given all billing due documents are processed successfully  
    When the user verifies the creation of corresponding billing documents  
    Then corresponding billing documents are created successfully  

  @TC-178
  Scenario: User validates that no errors occurred during processing  
    Given the background job execution is complete  
    When the user reviews the processing logs  
    Then no errors occurred during processing  

  @TC-178
  Scenario: User documents observed behavior and system performance  
    Given the background job execution is complete  
    When the user documents the observed behavior and system performance metrics  
    Then the behavior and performance metrics are documented successfully
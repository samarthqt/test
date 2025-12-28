Feature: Validate maximum entries in condition table 911  
  Ensure the condition table 911 can handle the maximum number of entries without errors or performance degradation.

  @TC-557  
  Scenario: User logs into the SAP system  
    Given the user has appropriate credentials  
    When the user logs into the SAP system  
    Then the user is successfully logged into the SAP system  

  @TC-557  
  Scenario: User navigates to condition table maintenance  
    Given the user is logged into the SAP system  
    When the user navigates to the condition table maintenance transaction  
    Then the condition table maintenance screen is displayed  

  @TC-557  
  Scenario: User selects condition table 911  
    Given the user is on the condition table maintenance screen  
    When the user selects condition table 911 from the list  
    Then condition table 911 is selected and displayed for maintenance  

  @TC-557  
  Scenario Outline: User prepares and uploads bulk entries to condition table  
    Given the user has prepared a bulk upload file with <entries>  
    When the user uploads the prepared file to the condition table using the bulk upload program  
    Then the bulk upload is initiated, and entries are added to the condition table  
    And no errors or warnings are displayed during the upload process  

    Examples:  
      | entries                  |  
      | maximum allowed entries |  

  @TC-557  
  Scenario: User verifies saved entries in condition table  
    Given the user has uploaded entries to the condition table  
    When the user verifies that all entries are saved in the condition table  
    Then all entries up to the maximum capacity are successfully saved in the condition table  

  @TC-557  
  Scenario: User validates accessibility of specific entries  
    Given the condition table contains maximum entries  
    When the user accesses the condition table and searches for specific entries  
    Then all entries are accessible without errors or delays  

  @TC-557  
  Scenario: User performs data retrieval operations  
    Given the condition table contains maximum entries  
    When the user performs data retrieval operations on the condition table  
    Then data retrieval operations are performed successfully without performance degradation  

  @TC-557  
  Scenario: User generates a report for the number of entries  
    Given the condition table contains maximum entries  
    When the user generates a report to verify the number of entries in the table  
    Then the report accurately reflects the number of entries in the condition table  

  @TC-557  
  Scenario: User validates system performance metrics  
    Given the condition table contains maximum entries  
    When the user validates the system's performance metrics during the data retrieval process  
    Then system performance metrics remain within acceptable thresholds  

  @TC-557  
  Scenario: User documents results and confirms compliance  
    Given the condition table meets system capacity requirements  
    When the user documents the results  
    Then the compliance with system capacity requirements is confirmed
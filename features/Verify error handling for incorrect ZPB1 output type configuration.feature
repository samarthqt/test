Feature: Verify error handling for incorrect ZPB1 output type configuration  
  Ensure the system identifies and prevents workflow execution with incorrect ZPB1 output configuration.

  @TC-144
  Scenario: User logs into the SAP S/4HANA Cloud system successfully  
    Given the user has valid credentials  
    When the user logs into the SAP S/4HANA Cloud system  
    Then the user is successfully logged into the system  

  @TC-144
  Scenario: User navigates to the periodic billing section  
    Given the user is logged into the SAP S/4HANA Cloud system  
    When the user navigates to the periodic billing section  
    Then the periodic billing section is displayed  

  @TC-144
  Scenario: User creates a billing document of type ZFR  
    Given the user is in the periodic billing section  
    When the user creates a billing document of type "ZFR"  
    Then the billing document of type "ZFR" is successfully created  

  @TC-144
  Scenario: User triggers the periodic billing workflow  
    Given the user has created a billing document of type "ZFR"  
    When the user triggers the periodic billing workflow for the created document  
    Then the workflow is triggered successfully  

  @TC-144
  Scenario Outline: System handles ZPB1 output generation with incorrect configuration  
    Given the user has triggered the periodic billing workflow  
    When the user attempts to generate ZPB1 output for the billing document  
    Then the system displays an error message indicating "<error_message>"  
    And the periodic billing workflow halts at the output generation step  

    Examples:  
      | error_message                                   |  
      | Incorrect ZPB1 output configuration specified |  

  @TC-144
  Scenario: User checks system logs for detailed error messages  
    Given the system has halted the workflow due to an incorrect ZPB1 configuration  
    When the user checks the system logs  
    Then the logs contain detailed error messages about the incorrect ZPB1 output configuration  

  @TC-144
  Scenario: User captures screenshots of error messages  
    Given the system has displayed error messages regarding the incorrect ZPB1 configuration  
    When the user captures screenshots of the error messages  
    Then the screenshots are captured successfully  

  @TC-144
  Scenario: User reconfigures ZPB1 output type and re-triggers the workflow  
    Given the user has identified the incorrect ZPB1 configuration  
    When the user reconfigures the ZPB1 output type manually  
    And the user re-triggers the periodic billing workflow  
    Then the system allows reconfiguration and workflow re-triggering  

  @TC-144
  Scenario: User validates the resolution of the issue  
    Given the user has reconfigured the ZPB1 output type correctly  
    When the user triggers the periodic billing workflow again  
    Then the workflow completes successfully with ZPB1 output generation  

  @TC-144
  Scenario: User documents the resolution steps  
    Given the user has resolved the issue with the ZPB1 configuration  
    When the user documents the resolution steps  
    Then the resolution steps are documented successfully
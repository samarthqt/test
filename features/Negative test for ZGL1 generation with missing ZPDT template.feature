Feature: Negative test for ZGL1 generation with missing ZPDT template  
  Ensure the system does not generate ZGL1 output when the ZPDT template is missing and provides an appropriate error message.  

  @TC-407  
  Scenario: User logs into the SAP system successfully  
    Given the user has billing administrator credentials  
    When the user logs into the SAP system  
    Then the user is successfully logged into the system  

  @TC-407  
  Scenario: User navigates to the billing output generation module  
    Given the user is logged into the SAP system  
    When the user navigates to the billing output generation module  
    Then the billing output generation module is displayed  

  @TC-407  
  Scenario: System prevents ZGL1 generation when ZPDT template is missing  
    Given the ZPDT template configuration is missing in the system  
    When the user attempts to generate a ZGL1 form  
    Then the system displays an error message indicating the missing ZPDT template  
    And no ZGL1 outputs are generated  

  @TC-407  
  Scenario: System logs contain error entries for missing ZPDT template  
    Given the user attempted to generate a ZGL1 form with a missing ZPDT template  
    When the user checks the system logs  
    Then the system logs contain entries indicating the missing ZPDT template  

  @TC-407  
  Scenario: System consistently prevents ZGL1 generation after retry  
    Given the user has received an error message for the missing ZPDT template  
    When the user retries the generation process  
    Then the system consistently prevents the generation of the ZGL1 form  

  @TC-407  
  Scenario: No incorrect or partial outputs are generated  
    Given the ZPDT template is missing  
    When the user attempts to generate a ZGL1 form  
    Then no incorrect or partial ZGL1 outputs are generated  

  @TC-407  
  Scenario: System remains stable after error  
    Given the user attempted to generate a ZGL1 form with a missing ZPDT template  
    When the user observes the system's behavior  
    Then the system remains stable  

  @TC-407  
  Scenario: User logs out of the SAP system  
    Given the user has completed all actions in the SAP system  
    When the user logs out of the SAP system  
    Then the user is successfully logged out  

  @TC-407  
  Scenario: User documents findings and submits test results  
    Given the user has completed the test execution  
    When the user documents all findings and screenshots in the test report  
    And the user submits the test results for review  
    Then the findings and screenshots are documented successfully  
    And the test results are successfully submitted for review
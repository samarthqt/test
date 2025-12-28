Feature: Validate ZGC1 output generation with missing ZPDT template  
  Ensure the system prevents the generation of ZGC1 output when the ZPDT template is missing.  

  @TC-403  
  Scenario: Validate system login with billing administrator credentials  
    Given the user logs into the SAP system with billing administrator credentials  
    Then the user is successfully logged into the system  

  @TC-403  
  Scenario: Validate navigation to billing output generation module  
    Given the user navigates to the billing output generation module  
    Then the billing output generation module is displayed  

  @TC-403  
  Scenario Outline: Attempt to generate ZGC1 form with missing ZPDT template  
    Given the user attempts to generate a ZGC1 form  
    When the ZPDT template configuration is missing in the system  
    Then the system prevents the generation of the ZGC1 form  
    And the system displays an error message "<error_message>"  
    And the user verifies that no incorrect or partial outputs are generated  
    And the system remains stable after the error  

    Examples:  
      | error_message                     |  
      | ZPDT template is missing          |  

  @TC-403  
  Scenario: Validate capturing screenshot of the error message  
    Given the user observes the system behavior when the ZPDT template is missing  
    Then the user captures a screenshot of the error message for documentation  

  @TC-403  
  Scenario: Validate system logs for related error entries  
    Given the user checks the system logs for any related error entries  
    Then the system logs contain entries indicating the missing ZPDT template  

  @TC-403  
  Scenario: Validate retrying the generation process after error message  
    Given the user attempts to retry the generation process after the error message  
    Then the system consistently prevents the generation of the ZGC1 form  

  @TC-403  
  Scenario: Validate system logout  
    Given the user logs out of the SAP system  
    Then the user is successfully logged out  

  @TC-403  
  Scenario: Validate documentation of findings and screenshots  
    Given the user documents all findings and screenshots in the test report  
    Then the findings and screenshots are documented successfully
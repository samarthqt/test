Feature: Negative test for ZGC1 generation with corrupted ZPDT template  
  Ensure the system does not generate ZGC1 output when the ZPDT template is corrupted and handles the error gracefully.  

  @TC-406  
  Scenario Outline: Validate ZGC1 generation with corrupted ZPDT template  
    Given the user is logged into the SAP system with billing administrator credentials  
    And the user navigates to the billing output generation module  
    And the ZPDT template configuration is <template_configuration>  
    When the user attempts to generate a ZGC1 form  
    Then the system displays an error message indicating the corrupted ZPDT template  
    And no ZGC1 outputs are generated  
    And the system logs contain entries indicating the corrupted ZPDT template  
    When the user retries the generation process after the error message  
    Then the system consistently prevents the generation of the ZGC1 form  
    And no incorrect or partial outputs are generated  
    And the system remains stable  

    Examples:  
      | template_configuration |  
      | Corrupted              |  

  @TC-406  
  Scenario: Log out of the SAP system  
    Given the user is logged into the SAP system with billing administrator credentials  
    When the user logs out of the SAP system  
    Then the user is successfully logged out  

  @TC-406  
  Scenario: Document findings and submit test results  
    Given the user has completed the test execution  
    When the user documents all findings and screenshots in the test report  
    Then findings and screenshots are documented successfully  
    When the user submits the test results for review  
    Then the test results are successfully submitted for review
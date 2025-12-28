Feature: Validate ZGL1 output generation with corrupted ZPDT template  
  Ensure the system prevents the generation of ZGL1 output when the ZPDT template is corrupted.  

  @TC-404  
  Scenario Outline: Validate ZPDT template corruption handling during ZGL1 output generation  
    Given the user logs into the SAP system with billing administrator credentials  
    And the user navigates to the billing output generation module  
    When the user attempts to generate a ZGL1 form with a "<template_configuration>" template  
    Then the system prevents the generation of the ZGL1 form  
    And the system displays an error message indicating that the ZPDT template is corrupted  
    And the user captures a screenshot of the error message for documentation  
    And the system logs contain entries indicating the corrupted ZPDT template  
    When the user retries the generation process after the error message  
    Then the system consistently prevents the generation of the ZGL1 form  
    And no ZGL1 outputs are generated  
    And the system remains stable after the error  

    Examples:  
      | template_configuration |  
      | Corrupted              |  

  @TC-404  
  Scenario: Verify successful login and logout process  
    Given the user logs into the SAP system with billing administrator credentials  
    Then the user is successfully logged into the system  
    When the user logs out of the SAP system  
    Then the user is successfully logged out  

  @TC-404  
  Scenario: Document findings and screenshots in the test report  
    Given the user has completed the validation process  
    When the user documents all findings and screenshots in the test report  
    Then the findings and screenshots are documented successfully
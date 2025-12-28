Feature: Validate error message for missing ZPDT template during ZGC1 generation  
  Ensure the system provides a clear and actionable error message when ZGC1 output generation fails due to a missing ZPDT template.  

  @TC-405  
  Scenario: Validate user login and access to billing output generation module  
    Given user logs into the SAP system with billing administrator credentials  
    Then user is successfully logged into the system  
    And user navigates to the billing output generation module  
    Then billing output generation module is displayed  

  @TC-405  
  Scenario Outline: Validate error handling for ZGC1 generation with missing ZPDT template  
    Given user attempts to generate a ZGC1 form  
    Then system displays an error message indicating the missing ZPDT template  
    And error message clearly states the issue and suggests corrective actions  
    And user captures a screenshot of the error message for documentation  
    And user checks the system logs for related error entries  
    Then system logs contain entries indicating the missing ZPDT template  
    And user attempts to retry the generation process after the error message  
    Then system consistently prevents the generation of the ZGC1 form  
    And no ZGC1 outputs are generated  
    And system stability is maintained  

    Examples:  
      | Template Configuration | User Role           | Document Type |  
      | Missing               | Billing Administrator | ZGC1          |  

  @TC-405  
  Scenario: Validate user logout and documentation of findings  
    Given user logs out of the SAP system  
    Then user is successfully logged out  
    And user documents all findings and screenshots in the test report  
    Then findings and screenshots are documented successfully
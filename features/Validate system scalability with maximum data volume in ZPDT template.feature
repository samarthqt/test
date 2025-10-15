Feature: Validate system scalability with maximum data volume in ZPDT template  
  Ensure the system can handle large data volumes and complex configurations in the ZPDT template without performance degradation.

  @TC-92
  Scenario: User logs into the SAP system with valid credentials  
    Given the user navigates to the SAP system login page  
    When the user enters valid credentials  
    Then the user is successfully logged in  
    And the ZPDT template is configured with maximum data volume and fields  
    And the outputs ZGC1 and ZGL1 are generated successfully  

  @TC-92
  Scenario: User navigates to the output management screen  
    Given the user is logged into the SAP system  
    When the user navigates to the output management screen  
    Then the output management screen is displayed  
    And the maximum fields allowed are 100  

  @TC-92
  Scenario Outline: User processes output and monitors system performance  
    Given the user is on the output management screen  
    When the user selects the "<output>" for processing  
    And the user initiates the processing of "<output>"  
    Then the system handles the large data volume without performance degradation  

    Examples:  
      | output |  
      | ZGC1   |  
      | ZGL1   |  

  @TC-92
  Scenario: User checks system logs for performance-related warnings or errors  
    Given the user has processed outputs ZGC1 and ZGL1  
    When the user checks the system logs  
    Then no performance-related warnings or errors are logged  

  @TC-92
  Scenario: User validates the outputs for accuracy and completeness  
    Given the user has processed outputs ZGC1 and ZGL1  
    When the user reviews the outputs  
    Then the outputs are accurate and complete  

  @TC-92
  Scenario: User ensures compliance with operational and billing standards  
    Given the user has processed outputs ZGC1 and ZGL1  
    When the user validates compliance with operational and billing standards  
    Then the system complies with operational and billing standards
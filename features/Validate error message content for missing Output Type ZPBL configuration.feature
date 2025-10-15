Feature: Validate error message content for missing Output Type ZPBL configuration  
  Ensure the error message displayed for missing Output Type ZPBL configuration is clear and actionable.  

  @TC-8  
  Scenario: User logs into the SAP system  
    Given the user has authorized credentials  
    When the user logs into the SAP system  
    Then the user successfully logs into the SAP system  

  @TC-8  
  Scenario: User navigates to transaction VF03  
    Given the user is logged into the SAP system  
    When the user navigates to transaction VF03  
    Then the VF03 transaction screen is displayed  

  @TC-8  
  Scenario Outline: User enters cancellation billing document number and executes  
    Given the user is on the VF03 transaction screen  
    When the user enters the cancellation billing document number "<cancellationBillingDocument>" and executes  
    Then the cancellation billing document details are displayed  

    Examples:  
      | cancellationBillingDocument |  
      | 9000001234                  |  

  @TC-8  
  Scenario: User selects the output rendering option  
    Given the user has entered a valid cancellation billing document number  
    When the user selects the output rendering option from the menu  
    Then the output rendering options are displayed  

  @TC-8  
  Scenario: User chooses Output Type ZPBL for rendering  
    Given the output rendering options are displayed  
    When the user chooses Output Type ZPBL for rendering  
    Then the system attempts to process the output rendering  

  @TC-8  
  Scenario: System displays error message for missing Output Type ZPBL configuration  
    Given the Output Type ZPBL is not configured  
    When the user attempts to render output using Output Type ZPBL  
    Then the system displays an error message indicating Output Type ZPBL is not configured  

  @TC-8  
  Scenario Outline: Verify content of the error message displayed  
    Given the system displays an error message for missing Output Type ZPBL configuration  
    When the user checks the content of the error message  
    Then the error message clearly states "<errorMessage>"  
    And the error message provides "<actionableSteps>"  

    Examples:  
      | errorMessage                                   | actionableSteps                          |  
      | Output Type ZPBL is not configured            | Steps to configure Output Type ZPBL      |  
      | Missing configuration for Output Type ZPBL    | Reference to configuration documentation |  

  @TC-8  
  Scenario: User reconfigures Output Type ZPBL based on error message instructions  
    Given the error message contains instructions for configuring Output Type ZPBL  
    When the user attempts to reconfigure Output Type ZPBL  
    Then the configuration is successfully updated  

  @TC-8  
  Scenario: User repeats output rendering process after configuration  
    Given the Output Type ZPBL configuration is updated  
    When the user repeats the output rendering process  
    Then the output rendering process completes successfully  

  @TC-8  
  Scenario: User documents error message content and resolution  
    Given the error message content and resolution steps are identified  
    When the user documents the error message content and resolution for audit purposes  
    Then the error message content and resolution steps are documented successfully  

  @TC-8  
  Scenario: User logs out from the SAP system  
    Given the user has completed all required actions  
    When the user logs out from the SAP system  
    Then the user logs out successfully
Feature: Validate error handling for missing configuration of Output Type ZPBL in cancellation billing documents  
  Ensure the system displays an error message and prevents the output rendering process when Output Type ZPBL is not configured.  

  @TC-7  
  Scenario Outline: Validate system response for Output Type ZPBL configuration during output rendering  
    Given the user logs into the SAP system with authorized credentials  
    And the user navigates to transaction VF03  
    When the user enters the cancellation billing document number "<cancellationBillingDocument>" and executes  
    And the user selects the output rendering option from the menu  
    And the user chooses Output Type "<outputType>" for rendering  
    Then the system displays an error message "<errorMessage>" if Output Type "<outputType>" is not configured  
    And the output rendering process does not proceed  
    And the system logs contain error messages related to Output Type "<outputType>"  
    And no output documents are created in the system  

    Examples:  
      | cancellationBillingDocument | outputType | errorMessage                          |  
      | 9000001234                  | ZPBL       | Output Type ZPBL is not configured    |  

  @TC-7  
  Scenario: Validate reconfiguration of Output Type ZPBL and successful rendering  
    Given the user logs into the SAP system with authorized credentials  
    And the user navigates to transaction VF03  
    When the user reconfigures Output Type ZPBL  
    And the user enters the cancellation billing document number "9000001234" and executes  
    And the user selects the output rendering option from the menu  
    And the user chooses Output Type ZPBL for rendering  
    Then the system accepts the configuration and allows rendering  

  @TC-7  
  Scenario: Document error message and resolution steps for audit purposes  
    Given the user logs into the SAP system with authorized credentials  
    When the user documents the error message and resolution steps for Output Type ZPBL configuration  
    Then the error message and resolution steps are documented successfully  

  @TC-7  
  Scenario: User logs out of the SAP system  
    Given the user logs into the SAP system with authorized credentials  
    When the user logs out from the SAP system  
    Then the user logs out successfully
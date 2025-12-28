Feature: Validate system behavior with missing Output Type ZPBL configuration and subsequent reconfiguration  
  Ensure the system identifies missing configuration for Output Type ZPBL and adapts correctly after reconfiguration.  

  @TC-13  
  Scenario: User logs into the SAP system  
    Given the user has authorized credentials  
    When the user logs into the SAP system  
    Then the user successfully logs into the SAP system  

  @TC-13  
  Scenario: User navigates to transaction VF03  
    Given the user is logged into the SAP system  
    When the user navigates to transaction VF03  
    Then the VF03 transaction screen is displayed  

  @TC-13  
  Scenario Outline: Validate cancellation billing document details  
    Given the user is on the VF03 transaction screen  
    When the user enters the cancellation billing document number "<document_number>" and executes  
    Then the cancellation billing document details for "<document_number>" are displayed  

    Examples:  
      | document_number |  
      | 9000001234      |  
      | 9000005678      |  

  @TC-13  
  Scenario: User selects output rendering options  
    Given the user is viewing the cancellation billing document details  
    When the user selects the output rendering option from the menu  
    Then the output rendering options are displayed  

  @TC-13  
  Scenario Outline: Validate rendering with Output Type ZPBL  
    Given the user is viewing the output rendering options  
    When the user chooses Output Type ZPBL for rendering  
    Then the system attempts to process the output rendering  

    Examples:  
      | Output_Type |  
      | ZPBL        |  

  @TC-13  
  Scenario: Validate system response when Output Type ZPBL configuration is missing  
    Given the Output Type ZPBL configuration is missing  
    When the user attempts to render Output Type ZPBL  
    Then the system displays an error message indicating Output Type ZPBL is not configured  

  @TC-13  
  Scenario: Reconfigure Output Type ZPBL and validate rendering  
    Given the Output Type ZPBL configuration is missing  
    When the user configures Output Type ZPBL and repeats the rendering process  
    Then the system accepts the configuration and allows rendering  

  @TC-13  
  Scenario: Validate output document generation  
    Given the Output Type ZPBL is configured  
    When the user renders the output document  
    Then the output document is generated successfully with expected details  

  @TC-13  
  Scenario: Validate system logs for successful rendering  
    Given the output document is generated successfully  
    When the user checks the system logs  
    Then the system logs confirm successful rendering of Output Type ZPBL  

  @TC-13  
  Scenario Outline: Validate consistency of rendering for another document  
    Given the Output Type ZPBL is configured  
    When the user renders the output for another cancellation billing document "<new_document_number>"  
    Then the output rendering process completes successfully for the new document  

    Examples:  
      | new_document_number |  
      | 9000005678          |  
      | 9000009876          |  

  @TC-13  
  Scenario: Document error message and resolution steps  
    Given the system displayed an error message for Output Type ZPBL  
    When the user documents the error message and resolution steps for audit purposes  
    Then the error message and resolution steps are documented successfully  

  @TC-13  
  Scenario: User logs out from the SAP system  
    Given the user has completed the required tasks  
    When the user logs out from the SAP system  
    Then the user logs out successfully
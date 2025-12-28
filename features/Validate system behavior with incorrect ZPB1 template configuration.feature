Feature: Validate system behavior with incorrect ZPB1 template configuration  
  Ensure the system blocks periodic billing document generation when the ZPB1 template is incorrectly configured.

  @TC-130
  Scenario: User logs into the SAP system and navigates to the periodic billing document creation module  
    Given the user has appropriate credentials  
    When the user logs into the SAP system  
    Then the user is successfully logged in and redirected to the main dashboard  
    And the periodic billing document creation module is displayed  

  @TC-130
  Scenario Outline: Validate system behavior for periodic billing document generation with incorrect ZPB1 template configuration  
    Given the user is on the periodic billing document creation module  
    And the form template status is "<form_template_status>"  
    When the user selects document type "<document_type>" for creation  
    And the user attempts to generate the periodic billing document  
    Then the system displays "<system_response>"  
    And the system logs contain "<log_details>"  
    And no incomplete billing document is saved in the system  

    Examples:  
      | form_template_status    | document_type | system_response                                      | log_details                                    |  
      | Incorrectly configured  | ZPB           | Error indicating incorrect ZPB1 template configuration | Detailed error messages about the incorrect template configuration |  

  @TC-130
  Scenario: Verify error messages include actionable suggestions for resolution  
    Given the user observes system error messages  
    Then the error messages include actionable suggestions for resolution  

  @TC-130
  Scenario: Correct the ZPB1 template configuration and reprocess the billing document  
    Given the user has received error message details  
    When the user attempts to correct the ZPB1 template configuration  
    Then the ZPB1 template configuration is corrected successfully  
    When the user reprocesses the billing document after correcting the template  
    Then the billing document is processed successfully using the corrected template  

  @TC-130
  Scenario: Validate the system's compliance with periodic billing standards  
    Given the user has generated a billing document with the corrected template  
    Then the system complies with periodic billing standards ensuring no disruptions  

  @TC-130
  Scenario: Verify the corrected ZPB1 form template is used in the billing document  
    Given the user has successfully processed the billing document  
    Then the corrected ZPB1 form template is used without issues
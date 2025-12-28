Feature: Validate ZPB1 output generation with maximum field length data  
  Test system behavior when generating ZPB1 output for periodic billing with maximum field length data. The ZPB1 output type must be defined and configured in the system.  

  @TC-425  
  Scenario: User logs into the SAP S/4HANA Cloud system with appropriate credentials  
    Given the user has appropriate credentials to access the SAP S/4HANA Cloud system  
    When the user logs into the system  
    Then the user successfully accesses the system dashboard  

  @TC-425  
  Scenario: User navigates to the periodic billing section  
    Given the user is logged into the SAP S/4HANA Cloud system  
    When the user navigates to the periodic billing section  
    Then the periodic billing section is displayed successfully  

  @TC-425  
  Scenario: User creates a billing document of type ZFR with maximum field length data  
    Given the user is in the periodic billing section  
    And test data for periodic billing with maximum field length values exists in the system  
    When the user creates a billing document of type ZFR with maximum field length data  
    Then the billing document ZFR is created successfully and saved  

  @TC-425  
  Scenario Outline: User triggers the periodic billing workflow ensuring ZPB1 output type is selected  
    Given the user has created a billing document of type ZFR  
    And the ZPB1 output type is configured in the system  
    When the user triggers the periodic billing workflow and selects the ZPB1 output type  
    Then the workflow is triggered successfully without errors  

    Examples:  
      | ZPB1 Output Type |  
      | Configured       |  

  @TC-425  
  Scenario: Verify ZPB1 output is generated successfully as an email attachment  
    Given the periodic billing workflow is triggered  
    When the user verifies the ZPB1 output generation  
    Then the ZPB1 output is generated without errors and attached to the email  

  @TC-425  
  Scenario: Check email system to ensure ZPB1 output is routed to the correct recipient  
    Given the ZPB1 output is generated successfully  
    When the user checks the email system for routing  
    Then the email containing the ZPB1 output is routed successfully to the configured recipient  

  @TC-425  
  Scenario: Validate the content and format of the ZPB1 output against the ZPDT template  
    Given the ZPB1 output is generated successfully  
    When the user validates the content and format of the ZPB1 output  
    Then the ZPB1 output content and format align with the ZPDT template, including all required details  

  @TC-425  
  Scenario: Check system logs for any errors during workflow execution  
    Given the ZPB1 output generation workflow is completed  
    When the user checks the system logs  
    Then the system logs show no errors, confirming successful execution of the workflow  

  @TC-425  
  Scenario: Verify the audit trail for the ZPB1 output generation process  
    Given the ZPB1 output generation workflow is completed  
    When the user verifies the audit trail  
    Then the audit trail confirms that the ZPB1 output was generated and routed as per the configuration  

  @TC-425  
  Scenario: Validate recipient's email address in email configuration settings  
    Given the ZPB1 output is routed successfully  
    When the user validates the recipient's email address in the email configuration settings  
    Then the recipient's email address matches the configured details  

  @TC-425  
  Scenario: Ensure ZPB1 output is stored in the system for future reference  
    Given the ZPB1 output is generated successfully  
    When the user ensures the ZPB1 output is stored in the system  
    Then the ZPB1 output is stored successfully for future reference  

  @TC-425  
  Scenario: Verify periodic billing workflow status is updated to 'Completed'  
    Given the ZPB1 output generation workflow is completed  
    When the user verifies the workflow status  
    Then the periodic billing workflow status is updated to 'Completed' without issues
Feature: Validate successful generation and routing of ZPB1 output during periodic billing workflow

  @TC-423
  Scenario: User logs into the SAP S/4HANA Cloud system with appropriate credentials
    Given the user has valid credentials with appropriate access to the SAP S/4HANA Cloud system
    When the user logs into the system
    Then the user successfully accesses the system dashboard

  @TC-423
  Scenario: User navigates to the periodic billing section
    Given the user has access to the SAP S/4HANA Cloud system
    When the user navigates to the periodic billing section
    Then the periodic billing section is displayed successfully

  @TC-423
  Scenario Outline: User creates a billing document of type ZFR
    Given the user has access to the periodic billing section
    When the user creates a billing document of type ZFR
    Then the billing document <documentType> is created successfully and saved

    Examples:
      | documentType |
      | ZFR          |

  @TC-423
  Scenario: User triggers the periodic billing workflow with ZPB1 output type selected
    Given the user has a billing document of type ZFR
    When the user triggers the periodic billing workflow ensuring the ZPB1 output type is selected
    Then the workflow is triggered successfully, and ZPB1 output type is selected without errors

  @TC-423
  Scenario: Verify ZPB1 output is generated successfully as an email attachment
    Given the periodic billing workflow is triggered with ZPB1 output type
    When the workflow is executed
    Then the ZPB1 output is generated successfully and attached to the email

  @TC-423
  Scenario: Verify ZPB1 output is routed to the correct recipient
    Given the ZPB1 output is generated as an email attachment
    When the email is sent
    Then the email is routed successfully to the configured recipient

  @TC-423
  Scenario: Validate ZPB1 output content and format against the ZPDT template
    Given the ZPB1 output is generated
    When the user validates the content and format of the output
    Then the ZPB1 output content and format align with the ZPDT template, including all required details

  @TC-423
  Scenario: Check system logs for errors during workflow execution
    Given the periodic billing workflow is executed
    When the user checks the system logs
    Then the system logs show no errors, confirming successful execution of the workflow

  @TC-423
  Scenario: Verify audit trail for ZPB1 output generation
    Given the ZPB1 output is generated and routed
    When the user verifies the audit trail
    Then the audit trail confirms that the ZPB1 output was generated and routed as per the configuration

  @TC-423
  Scenario: Validate recipient's email address in email configuration settings
    Given the email routing is configured
    When the user validates the recipient's email address
    Then the recipient's email address matches the configured details

  @TC-423
  Scenario: Ensure ZPB1 output is stored in the system for future reference
    Given the ZPB1 output is generated
    When the user checks the system storage
    Then the ZPB1 output is stored successfully in the system

  @TC-423
  Scenario: Verify periodic billing workflow status is updated to 'Completed'
    Given the periodic billing workflow is executed
    When the user checks the workflow status
    Then the workflow status is updated to 'Completed' without issues
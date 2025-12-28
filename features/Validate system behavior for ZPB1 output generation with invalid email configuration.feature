Feature: Validate system behavior for ZPB1 output generation with invalid email configuration

  @TC-424
  Scenario: User logs into the SAP S/4HANA Cloud system
    Given user has appropriate credentials to access the SAP S/4HANA Cloud system
    When user logs into the system
    Then user successfully accesses the system dashboard

  @TC-424
  Scenario: User navigates to the periodic billing section
    Given user is logged into the SAP S/4HANA Cloud system
    When user navigates to the periodic billing section
    Then periodic billing section is displayed successfully

  @TC-424
  Scenario: User creates a billing document of type ZFR
    Given test data for periodic billing exists in the system
    When user creates a billing document of type ZFR
    Then billing document ZFR is created successfully and saved

  @TC-424
  Scenario Outline: Trigger periodic billing workflow with ZPB1 output type
    Given a billing document of type ZFR is created
    And ZPB1 output type is configured
    When user triggers the periodic billing workflow ensuring the ZPB1 output type is selected
    Then workflow is triggered successfully
    And ZPB1 output type is selected without errors

  @TC-424
  Scenario Outline: Validate email routing for ZPB1 output
    Given ZPB1 output type is selected in the periodic billing workflow
    When user checks the email system for the routed ZPB1 output
    Then email routing fails due to "<email configuration issue>"
    And an error message is displayed

    Examples:
      | email configuration issue |
      | invalid recipient details |
      | missing recipient details |

  @TC-424
  Scenario: Verify system logs for email routing error details
    Given email routing failed for ZPB1 output
    When user verifies the system logs
    Then system logs capture the error related to email routing configuration

  @TC-424
  Scenario: Resend ZPB1 output after correcting email configuration
    Given email routing configuration is corrected
    When user attempts to resend the ZPB1 output
    Then ZPB1 output is successfully routed

  @TC-424
  Scenario: Validate ZPB1 output storage despite email routing failure
    Given email routing failed for ZPB1 output
    When user checks the system for the stored ZPB1 output
    Then ZPB1 output is stored successfully in the system for future reference

  @TC-424
  Scenario: Verify audit trail for ZPB1 output generation
    Given ZPB1 output was generated
    When user verifies the audit trail for the ZPB1 output generation process
    Then audit trail confirms that ZPB1 output was generated but failed to route due to configuration issues

  @TC-424
  Scenario: Ensure user notification for email routing failure
    Given email routing failed for ZPB1 output
    When user checks for notifications
    Then user receives a notification about the email routing failure

  @TC-424
  Scenario: Verify workflow status for periodic billing process
    Given email routing failed for ZPB1 output
    When user verifies the workflow status for the periodic billing process
    Then workflow status is updated to indicate partial completion due to email routing failure

  @TC-424
  Scenario: Correct email configuration and re-trigger workflow
    Given email configuration is corrected
    When user re-triggers the periodic billing workflow
    Then workflow completes successfully after correcting the email configuration
Feature: Validate system behavior when SMTP configuration is missing

  @TC-540
  Scenario: User logs into the SAP S/4HANA Cloud system
    Given the user has valid credentials with appropriate access rights
    When the user logs into the SAP S/4HANA Cloud system
    Then the user is successfully logged into the system

  @TC-540
  Scenario: User navigates to the periodic billing section
    Given a large batch of periodic billing documents (e.g., 1000+ ZFR documents) exists in the system
    When the user navigates to the periodic billing section
    Then the periodic billing section is displayed

  @TC-540
  Scenario: User selects a batch of ZFR documents for processing
    Given a batch of 1000+ ZFR documents is available in the system
    When the user selects a batch of ZFR documents for processing
    Then the batch of ZFR documents is successfully selected

  @TC-540
  Scenario: User triggers the periodic billing workflow with ZPB1 output type
    Given the ZPB1 output type is defined and configured in the system
    When the user triggers the periodic billing workflow ensuring ZPB1 output type is selected
    Then the workflow is triggered and ZPB1 output type is selected

  @TC-540
  Scenario Outline: Monitor system behavior when SMTP configuration is missing
    Given the user triggers the periodic billing workflow with ZPB1 output type
    When the user monitors the email routing process
    Then the system displays an error message indicating "<error_message>"
    And the ZPB1 outputs are not sent via email
    And the system logs contain detailed error messages about the missing SMTP configuration
    And no ZPB1 outputs are generated during the failed attempt
    And the system remains stable and does not crash
    And the error message provides "<instructions>"
    And the email routing process is not triggered during the failed attempt

    Examples:
      | error_message                       | instructions                              |
      | SMTP configuration is missing      | clear instructions to configure SMTP     |

  @TC-540
  Scenario: User reconfigures SMTP settings and retries the workflow
    Given the user reconfigures the SMTP settings
    When the user retries the periodic billing workflow
    Then the workflow proceeds successfully after SMTP settings are configured
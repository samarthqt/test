Feature: Validate error handling for missing ZPB1 output configuration

  @TC-539
  Scenario: User logs into the SAP S/4HANA Cloud system
    Given the user has valid credentials with appropriate access rights
    When the user logs into the SAP S/4HANA Cloud system
    Then the user is successfully logged into the system

  @TC-539
  Scenario: User navigates to the periodic billing section
    Given the user is logged into the SAP S/4HANA Cloud system
    When the user navigates to the periodic billing section
    Then the periodic billing section is displayed
    And a batch of 1000+ ZFR documents is available in the system

  @TC-539
  Scenario: User selects a batch of 1000+ ZFR documents for processing
    Given the user is in the periodic billing section
    When the user selects a batch of 1000+ ZFR documents for processing
    Then the batch of ZFR documents is successfully selected

  @TC-539
  Scenario: User attempts to trigger periodic billing workflow without configuring ZPB1 output type
    Given the user has selected a batch of 1000+ ZFR documents for processing
    When the user attempts to trigger the periodic billing workflow without configuring the ZPB1 output type
    Then the system displays an error message indicating that the ZPB1 output type is not configured
    And the workflow does not proceed
    And no ZPB1 outputs are generated

  @TC-539
  Scenario: User checks system logs for missing ZPB1 configuration error details
    Given the user attempted to trigger the workflow without configuring the ZPB1 output type
    When the user checks the system logs
    Then the system logs contain detailed error messages about the missing ZPB1 configuration

  @TC-539
  Scenario: User reconfigures the ZPB1 output type and retries the workflow
    Given the user has identified the missing ZPB1 output type configuration
    When the user reconfigures the ZPB1 output type and retries the workflow
    Then the workflow proceeds successfully
    And ZPB1 outputs are generated

  @TC-539
  Scenario: Validate no ZPB1 outputs are generated during the initial failed attempt
    Given the user attempted to trigger the workflow without configuring the ZPB1 output type
    When the user reviews the system output
    Then no ZPB1 outputs are generated during the initial failed attempt

  @TC-539
  Scenario: Verify system stability during failed workflow attempt
    Given the user attempted to trigger the workflow without configuring the ZPB1 output type
    When the user monitors the system behavior
    Then the system remains stable and does not crash

  @TC-539
  Scenario: Validate error message clarity and actionability
    Given the user attempted to trigger the workflow without configuring the ZPB1 output type
    When the user reviews the error message displayed by the system
    Then the error message provides clear instructions to configure the ZPB1 output type

  @TC-539
  Scenario: Verify audit logs for unauthorized changes
    Given the user attempted to trigger the workflow without configuring the ZPB1 output type
    When the user checks the system's audit logs
    Then the audit logs show no unauthorized changes

  @TC-539
  Scenario: Validate email routing process is not triggered during failed attempt
    Given the user attempted to trigger the workflow without configuring the ZPB1 output type
    When the user reviews the email routing process
    Then the email routing process is not triggered during the failed attempt
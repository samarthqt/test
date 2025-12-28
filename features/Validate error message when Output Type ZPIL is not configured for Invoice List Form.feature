Feature: Validate error message when Output Type ZPIL is not configured for Invoice List Form

  To ensure the system displays an error message when Output Type ZPIL is missing for the Invoice List Form, and to verify that the process is halted until the configuration is completed.

  @TC-201
  Scenario: User logs into the SAP S/4HANA system and navigates to VF23 transaction
    Given the user has valid credentials with VF23 execution authorization
    When the user logs into the SAP S/4HANA system
    Then the user is successfully logged in with access to the VF23 transaction

  @TC-201
  Scenario: User inputs invoice list document number in VF23 transaction
    Given the user is on the VF23 transaction screen
    When the user inputs the invoice list document number "INVLIST001"
    Then the invoice list document details are retrieved and displayed

  @TC-201
  Scenario Outline: Validate system response when Output Type ZPIL is not configured
    Given the user has retrieved the invoice list document details
    When the user executes the transaction to trigger the Invoice List output
    Then the system displays an error message "<error_message>"
    And the system prevents further processing of the Invoice List output
    And no output is generated

    Examples:
      | error_message                                  |
      | Output Type ZPIL is not configured            |

  @TC-201
  Scenario: Verify error message details in the system log
    Given the user has attempted to generate the Invoice List output
    When the user checks the system log for error message details
    Then the error log contains detailed information about the missing configuration for Output Type ZPIL

  @TC-201
  Scenario: Re-trigger output without modifying the configuration
    Given the user has received the error message for missing Output Type ZPIL
    When the user attempts to re-trigger the output without modifying the configuration
    Then the system displays the same error message
    And the behavior is confirmed to be consistent

  @TC-201
  Scenario: Navigate to the configuration screen for Output Type ZPIL
    Given the user needs to verify the configuration of Output Type ZPIL
    When the user navigates to the configuration screen for Output Type ZPIL
    Then the configuration screen for Output Type ZPIL is accessible

  @TC-201
  Scenario: Verify Output Type ZPIL is not assigned to the Invoice List Form
    Given the user is on the configuration screen for Output Type ZPIL
    When the user verifies the configuration
    Then Output Type ZPIL is confirmed to be missing from the configuration

  @TC-201
  Scenario: Document test results and error message details
    Given the user has completed the test for missing Output Type ZPIL
    When the user documents the test results and error message details
    Then the test results and error message details are documented for further analysis

  @TC-201
  Scenario: User logs out of the SAP S/4HANA system
    Given the user has completed all necessary actions in the system
    When the user logs out of the SAP S/4HANA system
    Then the user is successfully logged out of the system
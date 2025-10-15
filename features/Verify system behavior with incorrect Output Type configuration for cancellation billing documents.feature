Feature: Verify system behavior with incorrect Output Type configuration for cancellation billing documents

  @TC-369
  Scenario: User logs in to the SAP S/4HANA system
    Given user has valid credentials
    When user logs in to the SAP S/4HANA system
    Then user is successfully logged in and navigates to the SAP home screen

  @TC-369
  Scenario: User navigates to transaction VF03 to view cancellation billing document
    Given cancellation billing document number "3000001237" exists
    When user navigates to transaction VF03
    Then cancellation billing document details are displayed with Output Type "ZPBL"

  @TC-369
  Scenario: User executes output rendering process with incorrect Output Type configuration
    Given Output Type "ZPBL" is configured incorrectly in the system
    When user executes the output rendering process using Output Type "ZPBL"
    Then system attempts to execute the rendering process using print program "SD_INVOICE_PRINT01"

  @TC-369
  Scenario Outline: System displays error messages due to incorrect Output Type configuration
    Given user attempts rendering process with Output Type "<Output Type>"
    When system detects incorrect configuration
    Then system displays error messages indicating "<Error Message>"
    And system logs contain detailed information about "<Log Details>"
    And rendering process is halted and no output is generated
    And user is notified about the error via system prompts
    And system provides guidance for correcting the Output Type configuration

    Examples:
      | Output Type | Error Message                      | Log Details                |
      | ZPBL        | Incorrect Output Type configuration | Detailed configuration error |

  @TC-369
  Scenario: User saves error logs for future reference
    Given system logs contain detailed error information
    When user saves error logs
    Then error logs are saved successfully

  @TC-369
  Scenario: User verifies that no invalid outputs are generated
    Given rendering process is halted due to the error
    When user checks for invalid outputs
    Then no invalid outputs are generated

  @TC-369
  Scenario: User reconfigures Output Type to correct the configuration
    Given system provides guidance for correcting the Output Type configuration
    When user attempts to reconfigure Output Type
    Then system allows reconfiguration of Output Type

  @TC-369
  Scenario: User reattempts rendering process after correcting Output Type configuration
    Given Output Type configuration is corrected
    When user reattempts the rendering process
    Then rendering process is successfully executed
Feature: Verify correct formation and usage of Ext Link ID for S1 invoices

  @TC-390
  Scenario Outline: Validate the formation of Ext Link ID for S1 invoices
    Given the user has created an S1 invoice linked to a direct program
    When the user retrieves VBELV value "<VBELV>" and POSNV value "<POSNV>" from the VBFA table
    And the user concatenates VBELV and POSNV to form the Ext Link ID
    Then the Ext Link ID is formed correctly as "<ExtLinkID>"

    Examples:
      | VBELV      | POSNV  | ExtLinkID       |
      | 100000123  | 00010  | 10000012300010  |
      | 200000456  | 00020  | 20000045600020  |

  @TC-390
  Scenario: Include Ext Link ID in outbound data to Model N
    Given the user has formed the correct Ext Link ID
    When the user includes the Ext Link ID in the outbound data to Model N
    Then the outbound data contains the correct Ext Link ID

  @TC-390
  Scenario: Validate data transmission to Model N
    Given the outbound data contains the correct Ext Link ID
    When the user transmits the data to Model N
    Then Model N receives the correct Ext Link ID without errors

  @TC-390
  Scenario: Verify successful data transmission in system logs
    Given the user has transmitted data to Model N
    When the user checks the system logs
    Then the logs indicate successful data transmission with no errors

  @TC-390
  Scenario: Verify Ext Link ID in Model N matches VBELV and POSNV
    Given the user has transmitted the Ext Link ID to Model N
    When the user verifies the Ext Link ID in Model N against the original VBELV and POSNV values
    Then the Ext Link ID in Model N matches the concatenated VBELV and POSNV values

  @TC-390
  Scenario: Validate consistency of Ext Link ID across systems
    Given the user has verified the Ext Link ID in Model N
    When the user runs a reconciliation report
    Then the reconciliation report confirms consistency of Ext Link ID across systems

  @TC-390
  Scenario: Validate Ext Link ID usage in rebate and administrative fee calculations
    Given the user has verified the consistency of Ext Link ID
    When the user validates rebate and administrative fee calculations
    Then the calculations are performed correctly using the Ext Link ID

  @TC-390
  Scenario: Repeat process for new S1 invoice to ensure consistency
    Given the user creates a new S1 invoice linked to a direct program
    When the user repeats the process of forming and transmitting the Ext Link ID
    Then the Ext Link ID is formed and transmitted correctly for the new invoice

  @TC-390
  Scenario: Verify system performance during transmission
    Given the user is transmitting data containing the Ext Link ID
    When the user monitors the system performance
    Then the system performance remains stable during the transmission process

  @TC-390
  Scenario: Ensure no duplicate Ext Link IDs in Model N
    Given the user has transmitted multiple Ext Link IDs to Model N
    When the user checks for duplicate Ext Link IDs in Model N
    Then no duplicate Ext Link IDs are found in Model N
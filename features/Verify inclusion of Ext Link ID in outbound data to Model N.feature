Feature: Verify inclusion of Ext Link ID in outbound data to Model N

  @TC-391
  Scenario: User creates an S1 invoice linked to a direct program
    Given the system is configured to handle billing documents with VBTYP_V set to 'M'
    When the user creates an S1 invoice linked to a direct program
    Then the S1 invoice is created successfully and linked to the direct program

  @TC-391
  Scenario Outline: User retrieves VBELV and POSNV values and forms Ext Link ID
    Given an S1 invoice exists with VBELV and POSNV values in the VBFA table
    When the user retrieves VBELV and POSNV values from the VBFA table
    And the user concatenates VBELV and POSNV values to form the Ext Link ID
    Then the Ext Link ID is formed correctly as "<expectedExtLinkID>"

    Examples:
      | VBELV       | POSNV   | expectedExtLinkID    |
      | 100000124   | 00020   | 10000012400020       |
      | 200000567   | 00030   | 20000056700030       |

  @TC-391
  Scenario: User includes Ext Link ID in outbound data to Model N
    Given the Ext Link ID is formed correctly
    When the user includes the Ext Link ID in the outbound data to Model N
    Then the outbound data contains the correct Ext Link ID

  @TC-391
  Scenario: User validates data transmitted to Model N
    Given the outbound data contains the correct Ext Link ID
    When the user validates the data transmitted to Model N
    Then Model N receives the correct Ext Link ID without errors

  @TC-391
  Scenario: User checks system logs for successful transmission
    Given the data is transmitted to Model N
    When the user checks the system logs
    Then the logs indicate successful data transmission with no errors

  @TC-391
  Scenario Outline: User verifies Ext Link ID in Model N against VBELV and POSNV
    Given the Ext Link ID is included in Model N
    When the user verifies the Ext Link ID in Model N against VBELV and POSNV values
    Then the Ext Link ID in Model N matches the concatenated VBELV and POSNV values

    Examples:
      | VBELV       | POSNV   | expectedExtLinkID    |
      | 100000124   | 00020   | 10000012400020       |
      | 200000567   | 00030   | 20000056700030       |

  @TC-391
  Scenario: User runs reconciliation report to validate consistency of Ext Link ID
    Given the Ext Link ID is included in Model N
    When the user runs a reconciliation report
    Then the reconciliation report confirms consistency of Ext Link ID across systems

  @TC-391
  Scenario: User validates Ext Link ID usage in rebate and administrative fee calculations
    Given the Ext Link ID is included in Model N
    When the user validates rebate and administrative fee calculations
    Then calculations are performed correctly using the Ext Link ID

  @TC-391
  Scenario: User creates another S1 invoice and repeats the process
    Given the user creates another S1 invoice linked to a direct program
    When the user repeats the process to form and transmit the Ext Link ID
    Then the Ext Link ID is formed and transmitted correctly for the new invoice

  @TC-391
  Scenario: User verifies system performance during transmission
    Given the user transmits data to Model N
    When the user monitors system performance during the process
    Then system performance remains stable during the transmission process

  @TC-391
  Scenario: User ensures no duplicate Ext Link IDs in Model N
    Given the Ext Link ID is included in Model N
    When the user checks for duplicate Ext Link IDs in Model N
    Then no duplicate Ext Link IDs are found in Model N
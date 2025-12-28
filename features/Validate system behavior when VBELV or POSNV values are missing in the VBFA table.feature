Feature: Validate system behavior when VBELV or POSNV values are missing in the VBFA table

  @TC-393
  Scenario Outline: Validate behavior for missing VBELV or POSNV values
    Given the user creates an S1 invoice in the system linked to a direct program
    When the user attempts to retrieve VBELV and POSNV values from the VBFA table for the created invoice
    And the user attempts to concatenate VBELV and POSNV values to form the Ext Link ID
    Then the system logs an error for the missing "<missing_value>" value
    And the system prevents Ext Link ID formation due to the missing "<missing_value>" value
    And the outbound data to Model N does not include an incomplete Ext Link ID
    When the user attempts to transmit the data to Model N
    Then the system prevents transmission due to incomplete Ext Link ID
    And no erroneous data is transmitted to Model N
    And the error messages are clear and actionable for the user

    Examples:
      | missing_value |
      | VBELV         |
      | POSNV         |

  @TC-393
  Scenario: Validate system notification for missing VBELV during invoice creation
    Given the user creates an S1 invoice in the system with VBELV value missing
    Then the system notifies the user about the missing VBELV value

  @TC-393
  Scenario: Verify system behavior when attempting to save an invoice with missing VBELV value
    Given the user attempts to save an invoice with VBELV value missing
    Then the system prevents saving the invoice with the missing VBELV value
    And the error messages are clear and actionable for the user

  @TC-393
  Scenario: Validate correct behavior for complete VBELV and POSNV values
    Given the user creates a new S1 invoice with complete VBELV and POSNV values
    When the user repeats the process of forming and transmitting the Ext Link ID
    Then the Ext Link ID is formed and transmitted correctly for the new invoice
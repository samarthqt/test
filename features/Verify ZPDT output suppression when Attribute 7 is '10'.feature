Feature: Verify ZPDT output suppression when Attribute 7 is '10'

  @TC-257
  Scenario Outline: Validate that the ZPDT billing output is suppressed when Attribute 7 is set to '10' in the Payer Business Partner master data
    Given the user is logged into the SAP system with appropriate permissions
    And the user has access to the Payer Business Partner master data for "<Payer Business Partner ID>"
    When the user navigates to the Payer Business Partner master data screen
    And the user locates Attribute 7 in the master data fields
    And the user sets Attribute 7 to "<Attribute 7 value>" and saves the changes
    And the user creates a new billing document for the Payer Business Partner
    And the user triggers the output determination process for the billing document
    Then the output log for the billing document indicates that the ZPDT output is "<Output Suppression Status>"
    And the document flow for the billing document does not show any invoice sent to the customer
    And the system logs confirm that the process executed without errors

    Examples:
      | Payer Business Partner ID | Attribute 7 value | Output Suppression Status |
      | PBP12345                  | 10                | suppressed                |
      | PBP67890                  | 10                | suppressed                |
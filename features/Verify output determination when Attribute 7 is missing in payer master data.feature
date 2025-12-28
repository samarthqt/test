Feature: Verify output determination when Attribute 7 is missing in payer master data

  @TC-266
  Scenario: Ensure the system processes billing documents without errors when Attribute 7 is missing in payer master data
    Given the user logs into the SAP S/4HANA system with valid credentials
    And the payer master data does not include Attribute 7 for the test payer
    When the user navigates to the billing document creation screen using transaction code VF01
    And the user enters the required details for the billing document
    And the user saves the billing document
    And the user triggers the output determination process for the created billing document
    Then the KOMKBV3 structure should show a null or default value for Attribute 7
    And the KOMB structure should show a null or default value for Attribute 7
    And the output determination logic should proceed without relying on the missing Attribute 7
    And no critical errors should be logged; warnings, if any, should be informational
    And the output should be generated correctly as per the configured rules
    And the output should be correctly linked to the billing document in the document flow
    And the test results and observations should be documented successfully
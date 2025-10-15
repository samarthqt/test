Feature: Validate ZPDT determination for billing document with intermediate value for Attribute 7  
  Ensure that ZPDT output determination works correctly when Attribute 7 is set to an intermediate value within its allowable range. Output condition record for ZPDT determination must be maintained.

  @TC-309
  Scenario Outline: Validate ZPDT determination process for Attribute 7 with intermediate value
    Given the user is logged into the SAP system with valid credentials
    When the user navigates to the transaction code for maintaining output condition records
    And the user maintains the output condition record for ZPDT determination using Attribute 7 with value <Attribute7Value>
    And the user creates a new billing document and populates Attribute 7 with the value <Attribute7Value>
    And the user saves the billing document and triggers the output determination process
    Then the ZPDT output should be determined and applied correctly for Attribute 7 with value <Attribute7Value>
    And no errors or warnings should be logged in the output determination process
    And the user navigates to the output preview screen for the billing document
    Then the output preview screen should display the ZPDT output correctly
    And the output data should match the expected format and comply with business rules
    When the user generates a report of the billing document and associated outputs
    Then the report should be generated successfully, showing ZPDT output determination details
    And the Attribute 7 value <Attribute7Value> should be correctly logged in the output determination process

    Examples:
      | Attribute7Value |
      | 500000          |
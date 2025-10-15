Feature: Validate ZPDT determination for billing document with maximum boundary value for Attribute 7  
  Ensure that ZPDT output determination works correctly when Attribute 7 is set to its maximum allowable value. Output condition record for ZPDT determination must be maintained.

  @TC-308
  Scenario Outline: Validate ZPDT output determination for Attribute 7 with maximum boundary value
    Given user is logged into the SAP system with proper credentials
    When user navigates to the transaction code for maintaining output condition records
    And user maintains the output condition record for ZPDT determination using Attribute 7 with value <Attribute7Value>
    And user creates a new billing document and populates Attribute 7 with the value <Attribute7Value>
    And user saves the billing document and triggers the output determination process
    Then the ZPDT output should be determined and applied correctly for Attribute 7 with value <Attribute7Value>
    And no errors or warnings should be logged during the output determination process
    When user navigates to the output preview screen for the billing document
    Then the output preview screen should display the ZPDT output correctly
    And the output data should match the expected format and comply with business rules
    When user generates a report of the billing document and associated outputs
    Then the report should be generated successfully, showing ZPDT output determination details
    And the Attribute 7 value <Attribute7Value> should be correctly reflected in the output determination logs

    Examples:
      | Attribute7Value |
      | 999999          |
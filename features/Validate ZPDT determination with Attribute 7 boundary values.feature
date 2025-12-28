Feature: Validate ZPDT determination with Attribute 7 boundary values

  Ensure the system handles Attribute 7 boundary values correctly during ZPDT determination and maintains output condition records effectively.

  @TC-306
  Scenario Outline: Validate ZPDT determination with boundary values for Attribute 7
    Given the user is logged into the SAP S/4HANA system with appropriate credentials
    And the user navigates to the transaction for maintaining output condition records
    When the user creates or verifies an output condition record for ZPDT determination with Attribute 7 set to "<attribute_7>"
    Then the output condition record is saved successfully
    And the user navigates to the billing creation transaction
    When the user enters the required details to create a billing document that meets the ZPDT determination criteria
    And the user saves the billing document to trigger the output determination process
    Then ZPDT is automatically determined and applied to the billing document for Attribute 7 = "<attribute_7>"
    And the output logs confirm ZPDT determination and application for Attribute 7 = "<attribute_7>"
    And no errors are logged during the ZPDT determination process
    And the results are documented, verifying the system's robustness in handling boundary values

    Examples:
      | attribute_7 |
      | 0           |
      | 999999      |
Feature: Validate propagation of Attribute 7 with maximum allowable length and special characters

  @TC-302
  Scenario Outline: Ensure Attribute 7 with maximum length and special characters is correctly propagated to KOMKBV3
    Given user logs into the SAP system with valid credentials
    And user navigates to the billing document creation screen
    When user creates a billing document and populates Attribute 7 with "<attribute_7_value>"
    And user saves the billing document
    And user triggers the user exit RVCOMFZZ:USEREXIT_KOMKBV3_FILL during the output determination process
    Then Attribute 7 is successfully propagated to KOMKBV3 without truncation or corruption
    And special characters in Attribute 7 are intact in KOMKBV3
    And no warnings or errors are logged during the propagation process
    And the output determination process proceeds without any issues
    When user retrieves the billing document
    Then Attribute 7 values are displayed correctly
    And the original Attribute 7 value matches the propagated value in KOMKBV3 exactly

    Examples:
      | attribute_7_value                                                                 |
      | @#$%^&*()_+1234567890ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz         |
      | 1234567890                                                                      |
      |                                                                                 |
      | !@#$%^&*()_+{}[]:"<>?                                                          |
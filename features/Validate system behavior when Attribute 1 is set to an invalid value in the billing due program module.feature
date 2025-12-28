Feature: Validate system behavior when Attribute 1 is set to an invalid value in the billing due program module

  @TC-431
  Scenario Outline: Validate system behavior for Attribute 1 with various input values
    Given user is logged into the SAP S/4HANA Cloud system with authorized credentials
    And user navigates to the billing due program module
    When user enters Attribute 1 as "<Attribute1>"
    And user enters Attribute 2 as "<Attribute2>"
    And user executes the billing due program
    Then the system displays "<ErrorMessage>" for Attribute 1
    And no billing documents are generated
    When user corrects Attribute 1 to "<CorrectedAttribute1>" and re-executes the program
    Then the system processes the program successfully with Attribute 1 as "<CorrectedAttribute1>" and Attribute 2 as "<Attribute2>"
    And error and resolution details are logged for future reference

    Examples:
      | Attribute1        | Attribute2        | ErrorMessage                            | CorrectedAttribute1 |
      | INVALID_CODE_1    | VALID_CODE_2      | Error message for invalid Attribute 1   | VALID_CODE_1        |
      | INVALID_CODE_2    | VALID_CODE_2      | Error message for invalid Attribute 1   | VALID_CODE_1        |
      | INVALID_CODE_3    | VALID_CODE_2      | Error message for invalid Attribute 1   | VALID_CODE_1        |

  @TC-431
  Scenario: User logs out of the SAP S/4HANA Cloud system
    Given user is logged into the SAP S/4HANA Cloud system with authorized credentials
    When user logs out of the SAP S/4HANA Cloud system
    Then user is logged out successfully
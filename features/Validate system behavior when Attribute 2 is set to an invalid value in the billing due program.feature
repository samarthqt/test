Feature: Validate system behavior when Attribute 2 is set to an invalid value in the billing due program

  @TC-432
  Scenario Outline: User validates the system behavior with different Attribute 2 values
    Given the user is logged into the SAP S/4HANA Cloud system with authorized credentials
    And the user navigates to the billing due program module
    When the user enters Attribute 1 as "<Attribute1>"
    And the user enters Attribute 2 as "<Attribute2>"
    And the user executes the billing due program
    Then the system displays "<ErrorMessage>" for Attribute 2
    And no billing documents are generated
    When the user corrects Attribute 2 to "<CorrectedAttribute2>" and re-executes the program
    Then the system processes the program successfully with valid Attribute 1 and Attribute 2
    And the user logs the details of the error and resolution process
    And the user logs out of the SAP S/4HANA Cloud system

    Examples:
      | Attribute1     | Attribute2     | ErrorMessage                      | CorrectedAttribute2 |
      | VALID_CODE_1   | INVALID_CODE_2 | Error for invalid Attribute 2     | VALID_CODE_2        |
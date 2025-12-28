Feature: Validate the behavior of the billing due program with various input combinations for Attribute 1 and Attribute 2

  @TC-433
  Scenario Outline: Ensure the system handles different input values for Attribute 1 and Attribute 2
    Given the user is logged into the SAP S/4HANA Cloud system
    When the user navigates to the billing due program screen
    And the user enters "<Attribute 1>" in the Attribute 1 field
    And the user enters "<Attribute 2>" in the Attribute 2 field
    And the user executes the billing due program
    Then the system should display "<System Message>"
    And no billing documents should be generated if "<Attribute 1>" or "<Attribute 2>" is invalid
    And the system logs should contain "<Log Details>" for the execution
    And if valid inputs are provided, the program should process successfully

    Examples:
      | Attribute 1 | Attribute 2 | System Message                              | Log Details                        |
      |             |             | Error: Missing values for Attribute 1 and Attribute 2 | Log entry: Missing input values   |
      | ValidValue1 |             | Error: Missing value for Attribute 2       | Log entry: Missing input value for Attribute 2 |
      |             | ValidValue2 | Error: Missing value for Attribute 1       | Log entry: Missing input value for Attribute 1 |
      | ValidValue1 | ValidValue2 | Program processed successfully              | Log entry: Program executed successfully |

  @TC-433
  Scenario: Document the test results and log out of the system
    Given the user has observed the results of the billing due program execution
    When the user documents the test results and screenshots of error messages
    Then the test results and screenshots should be saved for reference
    And the user logs out of the SAP S/4HANA Cloud system
    And the user should be logged out successfully
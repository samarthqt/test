Feature: Validate system behavior with incorrect and correct Attribute1 and Attribute2 values in the billing due program

  @TC-151
  Scenario Outline: Validate system behavior for Sales Order creation and billing due program execution with various Attribute1 and Attribute2 values
    Given the user logs into the SAP S/4HANA Cloud system with valid credentials
    When the user navigates to the Sales Order creation screen
    And the user creates a Sales Order of type ZOR with Attribute1 as "<Attribute1>" and Attribute2 as "<Attribute2>"
    And the user saves the Sales Order and notes the Order ID
    And the user navigates to the billing due program screen
    And the user triggers the billing due program for the created Sales Order
    Then the billing due program "<ProgramOutcome>" with the message "<ErrorMessage>"
    And the user navigates to the error log screen
    And the user verifies the error log for the message "<ErrorMessage>"
    When the user edits the Sales Order and updates Attribute1 to "<CorrectAttribute1>" and Attribute2 to "<CorrectAttribute2>"
    And the user re-triggers the billing due program
    Then the billing due program completes successfully without errors

    Examples:
      | Attribute1      | Attribute2      | ProgramOutcome         | ErrorMessage                              | CorrectAttribute1 | CorrectAttribute2 |
      | InvalidValue    | InvalidValue    | halts                  | Error: Incorrect Attribute1 and Attribute2 values | ValidValue       | ValidValue       |
      | Blank           | InvalidValue    | halts                  | Error: Attribute1 is required             | ValidValue       | ValidValue       |
      | InvalidValue    | Blank           | halts                  | Error: Attribute2 is required             | ValidValue       | ValidValue       |
      | ValidValue      | InvalidValue    | halts                  | Error: Incorrect Attribute2 value         | ValidValue       | ValidValue       |
      | InvalidValue    | ValidValue      | halts                  | Error: Incorrect Attribute1 value         | ValidValue       | ValidValue       |
      | ValidValue      | ValidValue      | completes successfully |                                          | ValidValue       | ValidValue       |
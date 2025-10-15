Feature: Validate periodic billing creation for monthly frequency with incorrect Attribute 3 configuration

  @TC-572
  Scenario Outline: Validate error handling when Attribute 3 is not set to 'ZM' for the Ship-to BP during periodic billing creation
    Given the user logs in to the SAP S/4HANA Cloud system with valid credentials
    And the user navigates to the billing due program
    And the user ensures that Attribute 3 is set to "<Attribute3Value>" for the Ship-to BP
    When the user executes the billing due program in foreground mode
    Then the user verifies that the program displays an error message indicating "<ExpectedErrorMessage>"
    And the user checks the error logs for details
    And the user documents the test results and observations

    Examples:
      | Attribute3Value | ExpectedErrorMessage                              |
      | null            | Attribute 3 must not be blank                    |
      | ""              | Attribute 3 must not be blank                    |
      | "InvalidValue"  | Incorrect Attribute 3 configuration for Ship-to BP |
      | "ZM"            | No error message; configuration is correct       |
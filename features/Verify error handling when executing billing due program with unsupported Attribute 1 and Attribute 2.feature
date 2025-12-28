Feature: Verify error handling when executing billing due program with unsupported Attribute 1 and Attribute 2

  @TC-429
  Scenario Outline: Validate system behavior for unsupported and valid Attribute 1 and Attribute 2 values
    Given the user is logged into the SAP S/4HANA Cloud system
    When the user navigates to the billing due program screen
    And the user enters Attribute 1 as "<Attribute1>" and Attribute 2 as "<Attribute2>"
    And the user executes the billing due program
    Then the system should display "<ErrorMessage>" if the values are unsupported
    And no billing documents should be generated if the values are unsupported
    And the error log should contain details about "<ErrorDetails>" if the values are unsupported
    And the system should process the program successfully if the values are valid
    And the system log should reflect "<LogDetails>" for the corresponding input values

    Examples:
      | Attribute1        | Attribute2        | ErrorMessage                                   | ErrorDetails                                    | LogDetails                                    |
      | UNSUPPORTED_1     | UNSUPPORTED_2     | Unsupported values for Attribute 1 and 2      | Details about unsupported Attribute 1 and 2    | Error handling for unsupported values         |
      | VALID_ATTRIBUTE_1 | VALID_ATTRIBUTE_2 |                                                |                                                | Successfully processed valid input values      |

  @TC-429
  Scenario: Log in and log out of the SAP S/4HANA Cloud system
    Given the user is logged into the SAP S/4HANA Cloud system
    When the user logs out of the SAP S/4HANA Cloud system
    Then the user should be successfully logged out
Feature: Validate error handling for invalid Attribute 1 and Attribute 2 values in the billing due program

  @TC-428
  Scenario Outline: Verify system behavior for invalid and valid Attribute 1 and Attribute 2 values
    Given the user is logged into the SAP S/4HANA Cloud system with valid credentials
    When the user navigates to the billing due program module
    And the user enters Attribute 1 value as "<Attribute1>"
    And the user enters Attribute 2 value as "<Attribute2>"
    And the user executes the billing due program
    Then the system displays the message "<ErrorMessage>"
    And no billing documents are created in the system if the input values are invalid
    And the system logs contain detailed entries for invalid input values if the input values are invalid
    And the system processes the billing due program successfully if the input values are valid

    Examples:
      | Attribute1        | Attribute2        | ErrorMessage                                            |
      | INVALID_CODE_1    | INVALID_CODE_2    | Invalid values for Attribute 1 and Attribute 2         |
      | VALID_CODE_1      | VALID_CODE_2      | Billing due program processed successfully             |

  @TC-428
  Scenario: Validate clarity and relevance of error messages for invalid inputs
    Given the user is logged into the SAP S/4HANA Cloud system with valid credentials
    When the user navigates to the billing due program module
    And the user enters Attribute 1 value as "INVALID_CODE_1"
    And the user enters Attribute 2 value as "INVALID_CODE_2"
    And the user executes the billing due program
    Then the system displays an error message indicating invalid values for Attribute 1 and Attribute 2
    And the error message clearly explains the issue with the invalid input values

  @TC-428
  Scenario: Verify successful processing with valid Attribute 1 and Attribute 2 values
    Given the user is logged into the SAP S/4HANA Cloud system with valid credentials
    When the user navigates to the billing due program module
    And the user enters Attribute 1 value as "VALID_CODE_1"
    And the user enters Attribute 2 value as "VALID_CODE_2"
    And the user executes the billing due program
    Then the system processes the billing due program successfully

  @TC-428
  Scenario: Log out of the SAP S/4HANA Cloud system
    Given the user is logged into the SAP S/4HANA Cloud system with valid credentials
    When the user logs out of the system
    Then the user is successfully logged out
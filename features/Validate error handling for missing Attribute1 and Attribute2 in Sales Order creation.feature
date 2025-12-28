Feature: Validate error handling for missing Attribute1 and Attribute2 in Sales Order creation

  @TC-152
  Scenario Outline: Validate Sales Order creation with missing or valid Attribute1 and Attribute2
    Given the user logs into the SAP S/4HANA Cloud system with valid credentials
    And the user navigates to the Sales Order creation screen
    When the user attempts to create a Sales Order of type ZOR with "<Attribute1>" and "<Attribute2>"
    Then the system displays "<ErrorMessage>" and prevents Sales Order creation

    Examples:
      | Attribute1  | Attribute2  | ErrorMessage                                   |
      | <missing>   | <missing>   | Missing Attribute1 and Attribute2             |
      | ValidValue1 | <missing>   | Missing Attribute2                            |
      | <missing>   | ValidValue2 | Missing Attribute1                            |
      | ValidValue1 | ValidValue2 | No error, Sales Order created successfully    |

  @TC-152
  Scenario: Capture error messages for missing Attribute1 and Attribute2
    Given the user attempts to create a Sales Order of type ZOR with missing Attribute1 and Attribute2
    When the system displays error messages indicating the missing attributes
    Then the user captures the displayed error messages successfully

  @TC-152
  Scenario: Verify error log for captured error messages
    Given the user navigates to the error log screen
    When the user verifies the error log for the captured error messages
    Then the error log contains messages indicating missing Attribute1 and Attribute2

  @TC-152
  Scenario: Create and save a Sales Order with valid Attribute1 and Attribute2
    Given the user navigates to the Sales Order creation screen
    When the user creates a Sales Order of type ZOR with valid Attribute1 and Attribute2
    Then the Sales Order is created successfully
    And the user saves the Sales Order and notes the unique Order ID

  @TC-152
  Scenario: Trigger and monitor the billing due program
    Given the user navigates to the billing due program screen
    When the user triggers the billing due program for the created Sales Order
    Then the billing due program starts execution
    And the user monitors the program execution for errors or warnings
    Then the billing due program completes successfully without errors

  @TC-152
  Scenario: Verify billing document creation for the Sales Order
    Given the billing due program completes successfully
    When the user verifies the billing document created for the Sales Order
    Then the billing document is created successfully for the Sales Order
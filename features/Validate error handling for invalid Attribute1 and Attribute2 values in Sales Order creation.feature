Feature: Validate error handling for invalid Attribute1 and Attribute2 values in Sales Order creation

  @TC-153
  Scenario Outline: Validate system behavior when creating a Sales Order with various Attribute1 and Attribute2 values
    Given the user logs into the SAP S/4HANA Cloud system using valid credentials
    And the user navigates to the Sales Order creation screen
    When the user attempts to create a Sales Order of type ZOR with "<Attribute1>" and "<Attribute2>"
    Then the system displays "<ErrorMessage>" and prevents Sales Order creation

    Examples:
      | Attribute1     | Attribute2     | ErrorMessage                                     |
      | InvalidValue   | InvalidValue   | Invalid Attribute1 and Attribute2 values        |
      | ValidValue     | InvalidValue   | Invalid Attribute2 value                        |
      | InvalidValue   | ValidValue     | Invalid Attribute1 value                        |
      | ValidValue     | ValidValue     | Sales Order created successfully                |

  @TC-153
  Scenario: Verify error messages are captured successfully
    Given the user attempts to create a Sales Order of type ZOR with invalid Attribute1 and Attribute2 values
    When the system displays error messages
    Then the user captures the displayed error messages successfully

  @TC-153
  Scenario: Verify error log contains captured error messages
    Given the user navigates to the error log screen
    When the user verifies the error log
    Then the error log contains the captured error messages indicating invalid Attribute1 and Attribute2 values

  @TC-153
  Scenario: Create a Sales Order with valid Attribute1 and Attribute2
    Given the user navigates to the Sales Order creation screen
    When the user attempts to create a Sales Order of type ZOR with valid Attribute1 and Attribute2
    Then the Sales Order is created successfully
    And the user saves the Sales Order and notes the Order ID

  @TC-153
  Scenario: Trigger the billing due program for the created Sales Order
    Given the user navigates to the billing due program screen
    When the user triggers the billing due program for the created Sales Order
    Then the billing due program starts execution
    And the user monitors the program execution for errors or warnings
    And the billing due program completes successfully without errors

  @TC-153
  Scenario: Verify billing document is created for the Sales Order
    Given the billing due program completes successfully
    When the user verifies the billing document created for the Sales Order
    Then the billing document is created successfully for the Sales Order
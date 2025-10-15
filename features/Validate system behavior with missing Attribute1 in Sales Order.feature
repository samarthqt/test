Feature: Validate system behavior with missing Attribute1 in Sales Order

  @TC-149
  Scenario Outline: Validate Sales Order creation and billing due program with missing Attribute1
    Given the user logs into the SAP S/4HANA Cloud system using valid credentials
    And the user navigates to the Sales Order creation screen
    When the user creates a Sales Order of type "<SalesOrderType>" with missing Attribute1 and Attribute2 as "<Attribute2>"
    And the user saves the Sales Order
    Then the Sales Order is saved successfully, and a unique Order ID is generated
    And the user navigates to the billing due program screen
    When the user triggers the billing due program for the created Sales Order
    Then the billing due program halts, and an error message stating "<ErrorMessage>" is displayed
    And the user captures the displayed error message
    And the user navigates to the error log screen
    Then the error log contains the captured error message indicating missing Attribute1
    When the user edits the Sales Order and adds Attribute1 as "<Attribute1>"
    And the user re-triggers the billing due program
    Then the billing due program completes successfully without errors

    Examples:
      | SalesOrderType | Attribute2    | ErrorMessage                     | Attribute1    |
      | ZOR            | ValidValue    | Missing Attribute1 error message | ValidAttribute1 |
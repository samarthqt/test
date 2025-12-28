Feature: Validate error handling for changes to orders with invalid or non-existent Unique Order ID

  @TC-341
  Scenario Outline: User attempts to modify an order with invalid or non-existent Unique Order ID
    Given user logs into the SAP S/4HANA system using valid credentials
    And user navigates to the Sales Order processing screen
    When user searches for the order using "<Unique Order ID>"
    Then system displays an error message "<Error Message>"
    When user attempts to modify the order details with "<Updated Order Details>"
    Then system prevents changes and displays an error message "<Modification Error Message>"
    When user checks the system logs for errors related to "<Unique Order ID>"
    Then logs indicate the error "<Log Error>"
    When user attempts to save the changes
    Then system prevents saving and displays an error message "<Save Error Message>"
    And user logs out of the system
    Then user is logged out successfully

    Examples:
      | Unique Order ID                            | Error Message                       | Updated Order Details             | Modification Error Message          | Log Error                              | Save Error Message                     |
      | INVALIDORDERID1234567890123456789          | Order does not exist                | Quantity: 10, Delivery Date: 2023-11-01 | Cannot modify non-existent order   | Invalid or non-existent order ID error | Cannot save changes for non-existent order |
      | BLANK                                      | Order ID cannot be blank            | Quantity: 5, Delivery Date: 2023-10-15 | Cannot modify blank order ID       | Blank order ID error                   | Cannot save changes for blank order ID |
      | VALIDORDERID123456789012345678901234567890 | No error, order exists              | Quantity: 20, Delivery Date: 2023-12-01 | No error, order can be modified    | No error                               | No error, changes saved successfully   |
Feature: Validate edge case for modifying orders with a Unique Order ID at maximum allowable length

  @TC-343
  Scenario Outline: User modifies an order with a 36-character Unique Order ID and validates all updates
    Given the user is logged into the SAP S/4HANA system using valid credentials
    And the user navigates to the Sales Order processing screen
    When the user searches for an order using the Unique Order ID "<Unique_Order_ID>"
    Then the system displays the order details corresponding to the Unique Order ID
    When the user modifies the order details with "<Updated_Quantity>" and "<Updated_Delivery_Date>"
    Then the updated order details are entered successfully
    When the user saves the changes
    Then the changes are saved successfully, and a confirmation message is displayed
    When the user verifies the changes in the order details screen
    Then the updated details "<Updated_Quantity>" and "<Updated_Delivery_Date>" are displayed correctly
    When the user checks the order history
    Then the order history shows the modification details with a timestamp
    When the user validates system logs for any errors or warnings during the update process
    Then no errors or warnings are logged
    When the user generates an order confirmation document
    Then the order confirmation document reflects the updated details "<Updated_Quantity>" and "<Updated_Delivery_Date>"
    When the user logs out of the system
    Then the user is logged out successfully

    Examples:
      | Unique_Order_ID                          | Updated_Quantity | Updated_Delivery_Date |
      | 123456789012345678901234567890123456     | 50               | 2023-12-01            |
      | 123456789012345678901234567890123456     | 100              | 2023-12-15            |
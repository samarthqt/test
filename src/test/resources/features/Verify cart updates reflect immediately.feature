Feature: Verify cart updates reflect immediately

  @TC-4
  Scenario: User sees immediate updates on the shopping cart page
    Given the user has items in the shopping cart
    When the user navigates to the shopping cart page
    Then the shopping cart page is displayed with items listed

  @TC-4
  Scenario Outline: User updates the quantity of a product in the shopping cart
    Given the user is on the shopping cart page with Product ID "<ProductID>"
    When the user updates the quantity of the product to "<NewQuantity>"
    Then the cart page reflects the updated quantity and recalculated total price immediately

    Examples:
      | ProductID | NewQuantity |
      | 101       | 2           |
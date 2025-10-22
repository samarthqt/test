Feature: Order Placement with Out of Stock Item

  @TC-13
  Scenario: User attempts to place an order with an out-of-stock item
    Given the user is logged in
    When the user navigates to the product page for Product ID 54321
    Then the product details page is displayed with stock status as "Out of Stock"
    When the user attempts to add the product to the shopping cart
    Then the system prevents adding the product to the cart and displays an "Out of Stock" message
    When the user proceeds to checkout from the shopping cart
    Then the checkout page does not include the out-of-stock item
    When the user attempts to place an order without the out-of-stock item
    Then the order can be placed only for available items
    And no order confirmation is generated for the out-of-stock item
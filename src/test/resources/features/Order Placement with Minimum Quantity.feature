Feature: Order Placement with Minimum Quantity

  @TC-16
  Scenario: User places an order with the minimum quantity to verify system handling of small orders
    Given the user is logged in with User ID "12345"
    When the user navigates to the product page for Product ID "24680"
    Then the product details page is displayed with stock status as "Available"
    When the user adds 1 unit of the product to the shopping cart
    Then the product is added to the cart, and the cart is updated with the correct quantity and price
    When the user proceeds to checkout from the shopping cart
    Then the checkout page is displayed with the correct order details
    When the user selects "Cash on Delivery" as the payment method
    Then the payment method is accepted, and the user is prompted to confirm the order
    When the user confirms the order
    Then the order is placed successfully, and a confirmation page is displayed with the order details
    When the user verifies the inventory for Product ID "24680"
    Then the inventory is reduced by 1 unit
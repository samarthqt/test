Feature: Order Placement with Invalid Payment Method

  @TC-14
  Scenario Outline: Verify that an order cannot be placed with an invalid payment method
    Given the user is logged in
    When the user navigates to the product page for Product ID <ProductID>
    Then the product details page is displayed with stock status as 'Available'
    When the user adds <Quantity> unit of the product to the shopping cart
    Then the product is added to the cart, and the cart is updated with the correct quantity and price
    When the user proceeds to checkout from the shopping cart
    Then the checkout page is displayed with the correct order details
    When the user selects an invalid payment method and enters payment details
    Then the system rejects the payment details and displays an error message indicating invalid payment method
    When the user attempts to confirm the order
    Then the order cannot be confirmed due to invalid payment method

    Examples:
      | ProductID | Quantity | PaymentMethod  |
      | 67890     | 1        | Invalid Card   |
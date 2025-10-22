Feature: Order Placement with Large Quantity

  @TC-15
  Scenario Outline: User places an order with a large quantity to verify system handling of bulk orders
    Given the user is logged in
    When the user navigates to the product page for Product ID <ProductID>
    Then the product details page is displayed with stock status as 'Available'
    When the user adds <Quantity> units of the product to the shopping cart
    Then the product is added to the cart, and the cart is updated with the correct quantity and price
    When the user proceeds to checkout from the shopping cart
    Then the checkout page is displayed with the correct order details
    When the user selects <PaymentMethod> as the payment method and enters valid payment details
    Then the payment details are accepted, and the user is prompted to confirm the order
    When the user confirms the order
    Then the order is placed successfully, and a confirmation page is displayed with the order details
    Then the inventory for Product ID <ProductID> is reduced by <Quantity> units

  Examples:
    | ProductID | Quantity | PaymentMethod |
    | 13579     | 1000     | Debit Card    |
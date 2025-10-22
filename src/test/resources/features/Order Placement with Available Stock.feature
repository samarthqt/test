Feature: Order Placement with Available Stock

  @TC-12
  Scenario: User places an order successfully when items are in stock
    Given the user is logged in with User ID 12345
    When the user navigates to the product page for Product ID 98765
    Then the product details page is displayed with stock status as 'Available'
    When the user adds 2 units of the product to the shopping cart
    Then the product is added to the cart with the correct quantity and price
    When the user proceeds to checkout from the shopping cart
    Then the checkout page is displayed with the correct order details
    When the user selects Credit Card as the payment method and enters valid payment details
    Then the payment details are accepted and the user is prompted to confirm the order
    When the user confirms the order
    Then the order is placed successfully and a confirmation page is displayed with the order details
    When the user checks their email for a confirmation email
    Then a confirmation email is received with the order summary and order ID
    When the user verifies the inventory for Product ID 98765
    Then the inventory is reduced by 2 units
    When the user checks their account dashboard for the order status
    Then the order status is updated to 'Confirmed'
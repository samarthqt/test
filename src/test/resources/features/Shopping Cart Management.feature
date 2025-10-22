Feature: Shopping Cart Management

  @TC-10
  Scenario: User attempts to remove an item from an empty cart
    Given the user navigates to the shopping cart page
    Then the shopping cart page is displayed indicating the cart is empty
    When the user attempts to remove an item from the cart
    Then the system prevents the action and displays a message indicating the cart is already empty
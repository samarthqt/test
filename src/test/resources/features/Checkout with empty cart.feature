Feature: Checkout with empty cart

  @TC-11
  Scenario: User attempts to proceed to checkout with an empty cart
    Given the user navigates to the shopping cart page
    Then the shopping cart page is displayed indicating the cart is empty
    When the user attempts to proceed to checkout
    Then the system prevents the action and displays a message indicating the cart is empty
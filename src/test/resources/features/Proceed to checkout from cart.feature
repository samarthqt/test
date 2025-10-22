Feature: Proceed to checkout from cart

  @TC-6
  Scenario: User proceeds to checkout directly from the shopping cart
    Given the user has items in the shopping cart
    When the user navigates to the shopping cart page
    Then the shopping cart page is displayed with items listed
    When the user selects the 'Proceed to Checkout' option
    Then the user is redirected to the checkout page
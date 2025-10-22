Feature: Add invalid product to shopping cart

  @TC-8
  Scenario Outline: Verify that invalid products cannot be added to the shopping cart
    Given the user is logged into the application
    When the user attempts to add a product with ID "<ProductID>" to the cart
    Then an error message is displayed indicating the product cannot be added

    Examples:
      | ProductID |
      | 9999      |
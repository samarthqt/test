Feature: Add items to shopping cart

  @TC-1
  Scenario Outline: User adds items to the shopping cart
    Given the user is logged into the application
    When the user navigates to the product detail page for product ID "<ProductID>"
    And the user selects a quantity of "<Quantity>" for the product
    And the user adds the product to the shopping cart
    Then the shopping cart page displays the added product with correct quantity and price

    Examples:
      | ProductID | Quantity |
      | 101       | 1        |
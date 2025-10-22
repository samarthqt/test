Feature: Shopping Cart Quantity Update

  @TC-9
  Scenario Outline: User attempts to update product quantity in the cart
    Given the user has items in the shopping cart
    When the user navigates to the shopping cart page
    Then the shopping cart page is displayed with items listed
    When the user attempts to update the quantity of a product to "<quantity>"
    Then an error message is displayed indicating "<error_message>"

    Examples:
      | quantity | error_message          |
      | -1       | invalid quantity       |
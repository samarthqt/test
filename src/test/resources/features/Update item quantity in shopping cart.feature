Feature: Update item quantity in shopping cart

  @TC-2
  Scenario Outline: User updates the item quantity in the shopping cart
    Given the user has items in the shopping cart
    When the user navigates to the shopping cart page
    Then the shopping cart page is displayed with items listed
    When the user updates the quantity of the product with Product ID "<ProductID>" to "<NewQuantity>"
    Then the quantity field is updated to "<NewQuantity>"
    When the user selects the 'Update Cart' option
    Then the shopping cart is updated with the new quantity and the total price is recalculated

    Examples:
      | ProductID | NewQuantity |
      | 101       | 3           |
Feature: Add to Cart Functionality

  @TC-54
  Scenario Outline: User adds a purchasable item to the cart
    Given the user navigates to "<productName>" product detail page
    Then the product detail page is displayed
    When the user selects the 'Add to Cart' button
    Then the product is added to the cart

    Examples:
      | productName |
      | Laptop Y    |
Feature: Remove item from shopping cart

  @TC-3
  Scenario: User removes an item from the shopping cart
    Given the user has items in the shopping cart
    When the user navigates to the shopping cart page
    Then the shopping cart page is displayed with items listed
    When the user selects the 'Remove' option next to the product
    Then the product is removed from the shopping cart
    And the shopping cart no longer displays the removed item
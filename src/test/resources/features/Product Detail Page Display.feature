Feature: Product Detail Page Display

  @TC-53
  Scenario Outline: User views product details on the product detail page
    Given the product "<productName>" is available in the catalog
    When the user searches for "<productName>" and selects the product from the results
    Then the product detail page is displayed
    And the product image, description, stock status, and price are all displayed correctly

    Examples:
      | productName   |
      | Smartphone X  |
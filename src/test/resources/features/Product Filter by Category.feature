Feature: Product Filter by Category

  @TC-49
  Scenario Outline: User filters products by category
    Given the user navigates to the product search page
    When the user selects "<category>" from the category filter
    Then only products from the "<category>" category are displayed

    Examples:
      | category    |
      | Electronics |
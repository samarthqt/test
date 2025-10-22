Feature: Dynamic Search Result Update

  @TC-50
  Scenario Outline: Ensure search results update dynamically as filters are applied
    Given the product database is populated
    When the user enters "<searchKeyword>" in the search bar
    And the user applies the "<brandFilter>" filter
    Then the search results should update dynamically to show "<brandFilter>" products

    Examples:
      | searchKeyword | brandFilter |
      | phone         | BrandX      |
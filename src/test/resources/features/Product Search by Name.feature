Feature: Product Search by Name

  @TC-48
  Scenario Outline: User searches for products by name
    Given user navigates to the product search page
    When user enters "<searchKeyword>" in the search bar
    And user selects the 'Search' option
    Then relevant products related to "<searchKeyword>" are displayed

    Examples:
      | searchKeyword |
      | laptop        |
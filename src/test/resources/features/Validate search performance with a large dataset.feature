Feature: Validate search performance with a large dataset

  @TC-52
  Scenario Outline: User searches for a product in a large dataset
    Given a large product dataset is available
    When the user enters "<searchKeyword>" in the search bar
    And the user initiates the search
    Then the search results should be displayed promptly without delay

    Examples:
      | searchKeyword |
      | tablet        |
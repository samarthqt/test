Feature: Display 'No Results' Message for Non-Existent Product Searches

  @TC-51
  Scenario Outline: User searches for a non-existent product and sees a 'no results' message
    Given the product database is available
    When the user enters "<searchKeyword>" in the search bar
    And the user selects the 'Search' button
    Then the user should see a 'no results' message

    Examples:
      | searchKeyword            |
      | xyzNonExistentProduct    |
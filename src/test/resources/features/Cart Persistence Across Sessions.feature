Feature: Cart Persistence Across Sessions

  @TC-7
  Scenario: Ensure shopping cart persists across sessions for logged-in users
    Given user is logged into the application
    And user has items in the shopping cart
    When user logs out from the application
    Then user is logged out successfully
    When user logs back into the application
    Then user is logged in successfully
    When user navigates to the shopping cart page
    Then shopping cart displays the items added before logging out
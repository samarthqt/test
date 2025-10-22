Feature: Verify price total calculations in the shopping cart

  @TC-5
  Scenario Outline: User verifies the price total calculation including discounts and taxes
    Given the user has items in the shopping cart
    When the user navigates to the shopping cart page
    Then the shopping cart page is displayed with items listed
    And the applicable discounts and taxes are defined in the system
    When the user verifies the displayed price total
    Then the price total should be calculated correctly, including discounts and taxes

    Examples:
      | Product ID | Quantity | Discount | Tax Rate |
      | 101        | 2        | 10%      | 5%       |
Feature: Verify price total calculations in the shopping cart

  @12 @TC-5
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

  @12
  Scenario: User applies a valid promo code in the shopping cart
    Given the user has items in the shopping cart
    When the user navigates to the shopping cart page
    Then the shopping cart page is displayed with items listed
    And the user sees an input field for entering a promo code
    When the user enters a valid promo code in the input field
    Then the system verifies the promo code's validity and applicability
    And if valid, the discount is immediately displayed in the order summary
    And the final total before payment reflects the applied discount
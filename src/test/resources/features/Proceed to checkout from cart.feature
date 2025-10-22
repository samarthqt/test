Feature: Proceed to checkout from cart

  @TC-6
  Scenario: User proceeds to checkout directly from the shopping cart
    Given the user has items in the shopping cart
    When the user navigates to the shopping cart page
    Then the shopping cart page is displayed with items listed
    When the user selects the 'Proceed to Checkout' option
    Then the user is redirected to the checkout page

  @TC-6
  Scenario: Apply Valid Coupon
    Given the user has items in the shopping cart
    When the user navigates to the shopping cart page
    Then the shopping cart page is displayed with items listed
    And a valid coupon code "SAVE20" is available
    When the user enters the valid coupon code in the coupon field
    And submits the coupon code
    Then the coupon code is accepted
    And the discount is displayed in the order summary, showing the amount or percentage deducted
    When the user proceeds to checkout
    Then the checkout page displays the discounted total

  @TC-7
  Scenario: Expired Coupon
    Given the user has items in the shopping cart
    When the user navigates to the shopping cart page
    Then the shopping cart page is displayed with items listed
    And an expired coupon code "EXPIRED50" is available
    When the user enters the expired coupon code in the coupon field
    And submits the coupon code
    Then an error message is displayed indicating the coupon is expired

  @TC-8
  Scenario: Invalid Coupon
    Given the user has items in the shopping cart
    When the user navigates to the shopping cart page
    Then the shopping cart page is displayed with items listed
    And an invalid coupon code "INVALID123" is available
    When the user enters the invalid coupon code in the coupon field
    And submits the coupon code
    Then an error message is displayed indicating the coupon is invalid
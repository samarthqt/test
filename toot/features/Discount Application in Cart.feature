Feature: Discount Application in Cart
""
Scenario: Automatically apply a percentage discount when applicable
Given a user has items in their cart
And the cart value qualifies for a percentage discount
When the user proceeds to checkout
Then a percentage discount should be automatically applied to the total cart value
And the discount amount should be displayed in the cart summary
""
Scenario: Automatically apply a fixed amount discount when applicable
Given a user has items in their cart
And the cart value qualifies for a fixed amount discount
When the user proceeds to checkout
Then a fixed amount discount should be automatically applied to the total cart value
And the discount amount should be displayed in the cart summary
""
Scenario: No discount applied when cart does not qualify
Given a user has items in their cart
And the cart value does not qualify for any discount
When the user proceeds to checkout
Then no discount should be applied to the total cart value
And the cart summary should display the full price without any discount
""
Scenario: Apply the highest applicable discount
Given a user has items in their cart
And the cart value qualifies for multiple discounts
When the user proceeds to checkout
Then only the highest discount should be automatically applied to the total cart value
And the discount amount should be displayed in the cart summary
""
Scenario: Apply a discount with a coupon code
Given a user has items in their cart
And the user has a valid discount coupon code
When the user enters the coupon code at checkout
Then the discount associated with the coupon should be applied to the total cart value
And the discount amount should be displayed in the cart summary
""
Scenario: Invalidate expired discount coupon code
Given a user has items in their cart
And the user has an expired discount coupon code
When the user enters the coupon code at checkout
Then an error message should be displayed indicating the coupon is invalid
And no discount should be applied to the total cart value
```
```gherkin
TCID:12
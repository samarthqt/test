Feature: Discount Application
Scenario: Automatically apply discounts to eligible products in the cart
Given a user has added eligible products to the cart
When the user proceeds to checkout
Then applicable discounts should be automatically applied to the eligible products
And the user should see the updated total price reflecting the discounts
Scenario: Display discount details for eligible products
Given a user has added eligible products to the cart
When the user views the cart
Then the user should see discount details for each eligible product
And the total savings should be displayed
Scenario: Verify discount removal when products are removed from the cart
Given a user has added eligible products to the cart
And applicable discounts have been applied
When the user removes an eligible product from the cart
Then the discount for that product should be removed
And the updated total price should reflect the removal of the discount
Scenario: Ensure discounts are not applied to ineligible products
Given a user has added ineligible products to the cart
When the user proceeds to checkout
Then no discounts should be applied to the ineligible products
And the total price should be calculated without any discounts
Scenario: Apply multiple discounts to a single eligible product
Given a user has added a product eligible for multiple discounts to the cart
When the user proceeds to checkout
Then all applicable discounts should be applied to the product
And the user should see the updated total price reflecting all discounts
Scenario: Verify discount application during promotional periods
Given a user has added eligible products to the cart during a promotional period
When the user proceeds to checkout
Then promotional discounts should be automatically applied to the eligible products
And the user should see the updated total price reflecting the promotional discounts
Scenario: Validate discount application for returning users
Given a returning user has added eligible products to the cart
When the user proceeds to checkout
Then loyalty discounts should be automatically applied to the eligible products
And the user should see the updated total price reflecting the loyalty discounts
Scenario: Confirm no duplicate discounts are applied
Given a user has added eligible products to the cart
When the user proceeds to checkout
Then no duplicate discounts should be applied to the eligible products
And the total price should accurately reflect the applicable discounts without duplication
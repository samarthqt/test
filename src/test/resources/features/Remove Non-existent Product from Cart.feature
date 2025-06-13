Feature: Remove Non-existent Product from Cart
@WD-REQ-03
Scenario: Attempt to remove a non-existent product from an empty cart
Given the shopping cart is empty
When the user attempts to remove a product not present in the cart
Then the cart should remain empty
And a "NoProduct in Cart" message should be shown
@WD-REQ-03
Scenario: Attempt to remove a non-existent product from a cart with other products
Given the shopping cart contains products
And the product to be removed is not in the cart
When the user attempts to remove the non-existent product
Then the cart should remain unchanged with the existing products
And a "NoProduct in Cart" message should be shown
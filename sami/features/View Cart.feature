Feature: View Cart
""
As an online shopper,
I want to view all products in my shopping cart
So that I can review my selected items before proceeding to checkout.
""
Background:
Given the user is logged into their account
And the user has added products to the shopping cart
""
Scenario: View all products in the shopping cart
When the user navigates to the shopping cart page
Then the user should see all the products they have added to the cart
And each product should display its name, quantity, price, and total price
""
Scenario: View empty shopping cart
Given the shopping cart is empty
When the user navigates to the shopping cart page
Then the user should see a message indicating that the cart is empty
""
Scenario: Update product quantity in the shopping cart
Given the user is on the shopping cart page
And the cart contains products
When the user updates the quantity of a product
Then the cart should reflect the updated quantity
And the total price should be recalculated accordingly
""
Scenario: Remove a product from the shopping cart
Given the user is on the shopping cart page
And the cart contains products
When the user removes a product from the cart
Then the product should no longer appear in the cart
And the total price should be updated accordingly
""
Scenario: Checkout from the shopping cart
Given the user is on the shopping cart page
And the cart contains products
When the user proceeds to checkout
Then the user should be directed to the checkout process
```
```gherkin
TCID:14
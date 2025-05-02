Feature: Add to Cart
Scenario: User adds a product to the shopping cart
Given the user is on the product page
When the user clicks on the "Add to Cart" button
Then the product should be added to the shopping cart
And the shopping cart icon should display the updated number of items
Scenario: User reviews items in the shopping cart
Given the user has added products to the shopping cart
When the user navigates to the shopping cart page
Then the user should see a list of all products added to the cart
And each product should display its name, quantity, price, and total cost
Scenario: User modifies product quantity in the shopping cart
Given the user is on the shopping cart page
And the shopping cart contains products
When the user changes the quantity of a product
And clicks on the "Update Cart" button
Then the product quantity should be updated in the shopping cart
And the total cost should be recalculated and displayed
Scenario: User removes a product from the shopping cart
Given the user is on the shopping cart page
And the shopping cart contains products
When the user clicks on the "Remove" button next to a product
Then the product should be removed from the shopping cart
And the shopping cart should update to reflect the removal
Scenario: User views an empty shopping cart
Given the user has removed all products from the shopping cart
When the user navigates to the shopping cart page
Then the user should see a message indicating the cart is empty
And no products should be displayed in the shopping cart
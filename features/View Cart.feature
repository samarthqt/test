Feature: View Cart
Scenario: User views products in the shopping cart
Given the user is logged into the retail website
And the user has added products to the shopping cart
When the user navigates to the shopping cart page
Then the user should see a list of all products in the shopping cart
And the user should see the total price of all products in the cart
And the user should see an option to proceed to checkout
Scenario: User views an empty shopping cart
Given the user is logged into the retail website
And the shopping cart is empty
When the user navigates to the shopping cart page
Then the user should see a message indicating the cart is empty
And the user should see an option to continue shopping
Scenario: User updates product quantity in the shopping cart
Given the user is logged into the retail website
And the user has products in the shopping cart
When the user changes the quantity of a product in the cart
Then the shopping cart should update to reflect the new quantity
And the total price should adjust accordingly
Scenario: User removes a product from the shopping cart
Given the user is logged into the retail website
And the user has products in the shopping cart
When the user removes a product from the cart
Then the shopping cart should update to exclude the removed product
And the total price should adjust accordingly
Scenario: User proceeds to checkout from the shopping cart
Given the user is logged into the retail website
And the user has products in the shopping cart
When the user clicks on the proceed to checkout button
Then the user should be redirected to the checkout page
And the cart details should be available on the checkout page
Feature: Shopping Cart Functionality
@3
Scenario: Adding products to the shopping cart
Given a user is on the product page
When the user adds a product to the shopping cart
Then the product should appear in the shopping cart
And the cart should display the product's name, price, quantity, and subtotal
@3
Scenario: Updating product quantities in the shopping cart
Given a user has a product in the shopping cart
When the user updates the quantity of the product in the cart
Then the cart should reflect the updated quantity
And the subtotal should be recalculated accordingly
@3
Scenario: Removing products from the shopping cart
Given a user has a product in the shopping cart
When the user removes the product from the cart
Then the product should no longer appear in the shopping cart
@3
Scenario: Real-time update of cart totals
Given a user has multiple products in the shopping cart
When the user updates the quantity or removes a product
Then the cart totals should update in real-time
@3
Scenario: Handling cart errors gracefully
Given a user encounters an error while managing the shopping cart
When the error occurs
Then the system should handle the error gracefully
And provide an appropriate error message to the user
@3
Scenario: Receiving notifications for successful cart updates
Given a user updates the shopping cart successfully
When the update is processed
Then the user should receive a notification confirming the successful update
@3
Scenario: Ensuring cart data is stored securely
Given a user has items in the shopping cart
When the user navigates away from the cart page
Then the cart data should be stored securely
@3
Scenario: Accessing the shopping cart across devices
Given a user has items in the shopping cart on a desktop device
When the user accesses the shopping cart on a mobile device
Then the cart should be accessible with the same items
@3
Scenario: Logging all cart interactions for user tracking
Given a user performs actions on the shopping cart
When the actions are completed
Then the system should log all interactions for user tracking purposes
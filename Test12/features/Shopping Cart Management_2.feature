Feature: Shopping Cart Management
@34
Scenario: Add a product to the shopping cart
Given a user is on the product page
When the user adds a product to the shopping cart
Then the product should be added to the shopping cart
And the user should receive a notification of successful addition
And the system should log the add operation for auditing
@34
Scenario: Remove a product from the shopping cart
Given a product is present in the shopping cart
When the user removes the product from the shopping cart
Then the product should be removed from the shopping cart
And the user should receive a notification of successful removal
And the system should log the remove operation for auditing
@34
Scenario: Modify the quantity of a product in the shopping cart
Given a product is present in the shopping cart
When the user modifies the quantity of the product
Then the quantity should be updated immediately in the shopping cart
And the system should update the subtotal based on the new quantity
And the user should receive a notification of successful modification
And the system should log the modify operation for auditing
@34
Scenario: Prevent negative product quantities
Given a product is present in the shopping cart
When the user attempts to set a negative quantity for the product
Then the system should prevent the negative quantity
And the user should receive an error message that is user-friendly
@34
Scenario: Access cart operations on desktop and mobile platforms
Given a user is on a desktop or mobile platform
When the user performs cart operations
Then the operations should be accessible and function correctly on both platforms
@34
Scenario: Handle errors gracefully
Given a user is performing cart operations
When an error occurs
Then the system should handle the error gracefully
And provide a user-friendly message to the user
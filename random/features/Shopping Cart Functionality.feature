Feature: Shopping Cart Functionality
Scenario: Add products to the shopping cart
Given a user is on the product page
When the user selects a product to add to the shopping cart
Then the product is added to the shopping cart
And the shopping cart displays the product name, price, quantity, and subtotal
And a notification confirms the successful addition
Scenario: Remove products from the shopping cart
Given a user has products in their shopping cart
When the user selects a product to remove from the shopping cart
Then the product is removed from the shopping cart
And the shopping cart updates immediately
And a notification confirms the successful removal
Scenario: Modify product quantities in the shopping cart
Given a user has products in their shopping cart
When the user modifies the quantity of a product in the shopping cart
Then the shopping cart updates the quantity and subtotal immediately
And a notification confirms the successful modification
Scenario: Display shopping cart details
Given a user has products in their shopping cart
When the user views the shopping cart
Then the shopping cart displays each product's name, price, quantity, and subtotal
Scenario: Error message for invalid operations
Given a user is attempting to modify the shopping cart
When the user performs an invalid operation
Then an error message is displayed
Scenario: Logging changes to the shopping cart
Given a user makes changes to their shopping cart
When the changes are saved
Then the changes are logged for tracking purposes
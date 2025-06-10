Feature: Shopping Cart Management
Users should be able to manage their shopping cart, including adding, removing, and updating product quantities.
@12
Scenario: Users can add products to the cart successfully
Given a user is on the product page
When the user adds a product to the cart
Then the product should be added to the cart successfully
@12
Scenario: Users can remove products from the cart without errors
Given a user has products in the cart
When the user removes a product from the cart
Then the product should be removed from the cart without errors
@12
Scenario: Users can update product quantities in the cart
Given a user has products in the cart
When the user updates the quantity of a product
Then the product quantity should be updated in the cart
@12
Scenario: The cart displays product details including name, price, quantity, and subtotal
Given a user has products in the cart
When the user views the cart
Then the cart should display product details including name, price, quantity, and subtotal
@12
Scenario: Changes to the cart are reflected immediately
Given a user has products in the cart
When the user adds, removes, or updates a product
Then the changes should be reflected immediately in the cart
@12
Scenario: Error messages are displayed for invalid cart operations
Given a user attempts an invalid cart operation
When the operation is performed
Then an error message should be displayed to the user
@12
Scenario: The cart is saved across sessions for logged-in users
Given a logged-in user has products in the cart
When the user logs out and logs back in
Then the cart should be saved across sessions
@12
Scenario: The interface is user-friendly and intuitive
Given a user accesses the shopping cart
When the user interacts with the cart interface
Then the interface should be user-friendly and intuitive
@12
Scenario: Cart operations are logged for analytics
Given a user performs operations on the cart
When the operations are completed
Then the cart operations should be logged for analytics
@12
Scenario: Cart complies with data privacy and security standards
Given a user accesses the shopping cart
When the user performs cart operations
Then the cart should comply with data privacy and security standards
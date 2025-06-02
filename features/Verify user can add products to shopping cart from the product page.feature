Feature: Verify user can add products to shopping cart from the product page
@TC-64
Scenario: User can navigate to the product page using the product ID
Given the user is logged into the application
When the user navigates to the product page using the product ID "101"
Then the product page is displayed with product details
And the product must be available in stock
@TC-64
Scenario: Verify 'Add to Cart' button visibility and functionality
Given the user is on the product page
Then the 'Add to Cart' button is visible and enabled
@TC-64
Scenario: Add product to the shopping cart
Given the user is on the product page
When the user clicks on the 'Add to Cart' button
Then the product is added to the shopping cart
And a confirmation message is displayed
@TC-64
Scenario: Navigate to the shopping cart page
Given the product is added to the shopping cart
When the user navigates to the shopping cart page
Then the shopping cart page displays the added product with correct details
@TC-64
Scenario: Verify product details in the shopping cart
Given the product is in the shopping cart
Then the product name, price, and quantity are displayed correctly
And the product details match the selected product
@TC-64
Scenario: Verify total price calculation in the cart
Given the product is in the shopping cart
Then the total price is calculated correctly based on the product price and quantity
@TC-64
Scenario: Verify cart persistence after logout and re-login
Given the product is in the shopping cart
When the user logs out and logs back in
Then the product remains in the cart after re-login
@TC-64
Scenario: Add the same product multiple times
Given the product is in the shopping cart
When the user attempts to add the same product multiple times
Then the product quantity in the cart increases accordingly
@TC-64
Scenario: Add another product from a different product page
Given the user is on a different product page
When the user adds another product to the cart
Then both products are present in the cart with correct details
@TC-64
Scenario: Remove product from the cart
Given the product is in the shopping cart
When the user removes the product from the cart
Then the product is successfully removed from the cart
@TC-64
Scenario: Verify cart is empty after product removal
Given the product is removed from the shopping cart
Then the cart is empty and displays a message indicating no items
@TC-64
Scenario: Check real-time cart updates
Given the user is on the shopping cart page
When a product is added or removed
Then the cart updates in real-time with accurate product details
@TC-64
Scenario: Attempt to add a product when not logged in
Given the user is not logged into the application
When the user attempts to add a product to the cart
Then the user is prompted to log in before adding products to the cart
@TC-64
Scenario: Add a product with a discount applied
Given the user is on the product page with a discount applied
When the user adds the product to the cart
Then the discounted price is reflected correctly in the cart
@TC-64
Scenario: Verify cart icon updates with correct item count
Given products are added to the shopping cart
Then the cart icon displays the correct number of items
Feature: Add Products to Cart from Product Page
@TC-155
Scenario: Verify that users can add products to the shopping cart from the product page
Given the user is logged into the system with username "user123" and password "password123"
When the user navigates to the product page for "Wireless Headphones" with Product ID "98765"
Then the product page is displayed with product details
@TC-155
Scenario: Select product quantity to add to cart
Given the product page for "Wireless Headphones" is accessible
When the user selects the quantity of the product to add to the cart
Then the quantity selection is available and can be adjusted
@TC-155
Scenario: Add product to cart
Given the user has selected the quantity for "Wireless Headphones"
When the user clicks on the "Add to Cart" button
Then the product is added to the shopping cart
@TC-155
Scenario: Verify cart icon updates with correct quantity
Given the product is added to the shopping cart
When the user views the cart icon
Then the cart icon reflects the updated quantity of products
@TC-155
Scenario: Navigate to shopping cart page
Given the product is added to the shopping cart
When the user navigates to the shopping cart page
Then the shopping cart page displays the added product with details
@TC-155
Scenario: Check subtotal and total amounts in the cart
Given the product is in the shopping cart
When the user checks the subtotal and total amounts in the cart
Then the amounts are calculated correctly based on product price and quantity
@TC-155
Scenario: Remove product from cart
Given the product is in the shopping cart
When the user removes the product from the cart
Then the product is removed and the cart updates accordingly
@TC-155
Scenario: Add product to cart again
Given the product was removed from the shopping cart
When the user adds the product to the cart again
Then the product is successfully added back to the cart
@TC-155
Scenario: Proceed to checkout with product in cart
Given the product is in the shopping cart
When the user proceeds to checkout
Then the user is redirected to the checkout page with cart details
@TC-155
Scenario: Log out from the user account
Given the user is on the checkout page
When the user logs out from the account
Then the user is logged out and redirected to the login page
@TC-155
Scenario: Log back into the user account and check the cart
Given the user is logged out
When the user logs back into the account
Then the cart retains the previously added product
@TC-155
Scenario: Attempt to add a product with zero quantity
Given the user is on the product page
When the user attempts to add a product with zero quantity
Then the system displays an error message indicating invalid quantity
@TC-155
Scenario: Add product with maximum available quantity
Given the user is on the product page
When the user adds the product with maximum available quantity
Then the product is added successfully up to the maximum quantity limit
@TC-155
Scenario: Verify cart's performance under high load with multiple products
Given multiple products are added to the cart
When the cart is under high load
Then the cart functions correctly and maintains performance
@TC-155
Scenario: Verify product details are displayed correctly in the cart
Given the product is in the shopping cart
When the user views the product details in the cart
Then the product name, price, and quantity match the selected product
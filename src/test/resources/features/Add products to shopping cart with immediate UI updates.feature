Feature: Add products to shopping cart with immediate UI updates
@TC-1
Scenario: User adds products to the shopping cart and verifies UI updates
Given user has access to the e-commerce website
When user navigates to the product listing page
Then product listing page is displayed with multiple products
@TC-1
Scenario: User adds Product 1 to the shopping cart
Given product 1 is a standard product with unlimited inventory
When user selects Product 1 to view its details
Then Product 1 detail page is displayed with product information, price, and 'Add to Cart' button
When user adds Product 1 to the cart
Then Product 1 is added to the cart with quantity 1
And a confirmation message appears indicating 'Product added to cart successfully'
And the cart icon in the header section shows updated count (1)
@TC-1
Scenario: User adds Product 2 to the shopping cart
Given user navigates back to the product listing page
When user selects Product 2 to view its details
Then Product 2 detail page is displayed with product information, price, and 'Add to Cart' button
When user adds Product 2 to the cart
Then Product 2 is added to the cart with quantity 1
And a confirmation message appears indicating 'Product added to cart successfully'
And the cart icon in the header section shows updated count (2)
@TC-1
Scenario: User views cart contents and verifies subtotal
When user selects the cart icon to view the cart contents
Then shopping cart page opens displaying both Product 1 and Product 2 with quantity 1 each
And the subtotal correctly displays the sum of Product 1 and Product 2 prices
@TC-1
Scenario: User updates Product 1 quantity in the shopping cart
When user adds Product 1 to the cart again from the product listing page using quick add button
Then Product 1 quantity is updated to 2 in the cart
And a confirmation message appears indicating 'Cart updated successfully'
And the cart icon in the header section still shows count (2)
@TC-1
Scenario: User verifies cart contents and subtotal after quantity update
When user selects the cart icon to view the cart contents
Then shopping cart page opens displaying Product 1 with quantity 2 and Product 2 with quantity 1
And the subtotal correctly displays the sum of (Product 1 price × 2) + (Product 2 price × 1)
@TC-1
Scenario: User refreshes the page and verifies cart contents persist
When user refreshes the page
Then cart still displays Product 1 (quantity 2) and Product 2 (quantity 1) with correct subtotal
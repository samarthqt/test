Feature: Verify system enforces maximum inventory constraints when adding products to cart
@TC-6
Scenario: User adds maximum available inventory to cart
Given user has access to the e-commerce website
When user navigates to the product listing page
Then product listing page is displayed with multiple products
And user selects Product 1 with limited inventory of 5 units
Then Product 1 detail page is displayed with product information, price, quantity selector, and 'Add to Cart' button
When user locates the quantity selector field for Product 1
And user enters '5' in the quantity field
Then quantity field displays '5'
When user adds the product to the cart
Then product is successfully added to cart with quantity 5
And a confirmation message appears
@TC-6
Scenario: User tries to add more than the available inventory to cart
Given user is on the Product 1 detail page
When user enters '1' in the quantity field
Then quantity field displays '1'
When user adds the product to the cart
Then system displays an error message: 'Sorry, only 5 units available. You already have 5 units in your cart'
@TC-6
Scenario: User views the cart contents
Given user clicks on the cart icon
Then shopping cart page opens displaying Product 1 with quantity 5
@TC-6
Scenario Outline: User tries to update cart quantity beyond available inventory
Given user locates the quantity field for Product 1 in the cart
When user enters '<quantity>' in the quantity field and updates
Then system prevents updating the quantity and displays an error message: 'Sorry, only 5 units available'
And quantity field reverts to the previous valid value (5)
Examples:
| quantity |
| 6        |
| 10       |
@TC-6
Scenario: User decreases the quantity in the cart
Given user locates the quantity field for Product 1 in the cart
When user decreases the quantity to '3' and updates
Then quantity is successfully updated to 3
And a confirmation message appears indicating 'Cart updated successfully'
@TC-6
Scenario: User tries to add more units than available after cart update
Given user navigates back to Product 1 detail page
When user enters '3' in the quantity field
Then quantity field displays '3'
When user adds the product to the cart
Then system displays an error message: 'Sorry, only 2 more units available. You already have 3 units in your cart'
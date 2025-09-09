Feature: Verify system prevents adding products with negative quantity to cart
@TC-5
Scenario Outline: User attempts to add a product with negative quantity to the shopping cart
Given user navigates to the product listing page
When user selects Product 1 to view its details
And user locates the quantity selector field for Product 1
And user enters "<quantity>" in the quantity field
Then system prevents adding the product to cart and displays an error message: 'Please enter a valid quantity greater than zero'
And the cart icon remains unchanged
And user views the cart contents
Then Product 1 is not added to the cart
Examples:
| quantity |
| -1       |
| -100     |
@TC-5
Scenario: User adds a product with valid quantity to the shopping cart
Given user is on the Product 1 detail page
When user enters '1' in the quantity field
And user selects 'Add to Cart' button
Then Product 1 is successfully added to the cart with quantity 1
And a confirmation message appears
And user views the cart contents
Then the shopping cart displays Product 1 with quantity 1
@TC-5
Scenario: User attempts to update product quantity to a negative value in the cart
Given user views the cart contents with Product 1 added
When user locates the quantity field for Product 1 in the cart
And user enters '-5' in the quantity field and updates
Then system prevents updating the quantity to a negative value and displays an error message: 'Please enter a valid quantity greater than zero'
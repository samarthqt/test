Feature: Prevent adding products with zero quantity to cart
@TC-4
Scenario Outline: User attempts to add a product with zero quantity to the cart
Given user has access to the e-commerce website
When user navigates to the product listing page
And user selects Product 1 to view its details
Then user is on the product detail page
When user locates the quantity selector field for Product 1
And user clears the quantity field and enters "<quantity>"
And user selects the 'Add to Cart' button
Then system displays an error message: 'Please select a valid quantity greater than zero'
And the cart icon remains unchanged, showing previous count or zero if cart was empty
When user selects the cart icon to view the cart contents
Then shopping cart page opens displaying previous contents (if any) or empty cart message. Product 1 is not added to the cart
When user navigates back to Product 1 detail page
Then user verifies if the quantity field is reset to default value or still shows "<quantity>"
When user enters "<valid_quantity>" in the quantity field
And user selects the 'Add to Cart' button
Then product is successfully added to cart with quantity "<valid_quantity>". A confirmation message appears
When user selects the cart icon to view the cart contents
Then shopping cart page opens displaying Product 1 with quantity "<valid_quantity>"
When user locates the quantity field for Product 1 in the cart
And user clears the quantity field and enters "<quantity>", then updates
Then system displays an error message: 'Please enter a valid quantity greater than zero'
And the quantity field reverts to the previous valid value "<valid_quantity>"
Examples:
| quantity | valid_quantity |
| 0        | 1              |
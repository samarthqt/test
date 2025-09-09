Feature: Proper handling of duplicate product additions to the shopping cart
@TC-10
Scenario: Verify single product addition to the shopping cart
Given the user opens the web application in Safari browser
When the user navigates to the 'Sports & Outdoors' category
And the user selects 'Running Shoes' product
And the user adds the product to the cart
And the user views the shopping cart
Then the product 'Running Shoes' is displayed in the cart with quantity 1
@TC-10
Scenario: Verify updating product quantity in the shopping cart
Given the user has 'Running Shoes' in the cart with quantity 1
When the user navigates back to the 'Sports & Outdoors' category
And the user selects the same 'Running Shoes' product
And the user adds the product to the cart again
And the user views the shopping cart
Then there is only one entry for 'Running Shoes' in the cart
And the quantity of 'Running Shoes' is updated to 2
@TC-10
Scenario: Verify further updating product quantity in the shopping cart
Given the user has 'Running Shoes' in the cart with quantity 2
When the user adds the same product once more by returning to the product page
And the user views the shopping cart
Then the quantity of 'Running Shoes' is updated to 3
And the subtotal is correctly calculated as $239.97 (3 × $79.99)
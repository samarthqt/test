Feature: Add to Cart Functionality
""
As a user
I want to add products to my shopping cart
So that I can purchase them later
""
Background:
Given the user is on the product page
""
Scenario: Successfully add a product to the cart
When the user selects a product
"    And the user clicks on the ""Add to Cart"" button"
Then the product should be added to the shopping cart
And the cart icon should display the correct number of items
""
Scenario: Add multiple products to the cart
When the user selects multiple products
"    And the user clicks on the ""Add to Cart"" button for each product"
Then all selected products should be added to the shopping cart
And the cart icon should display the correct total number of items
""
Scenario: Add a product to the cart without selecting options
Given the product has multiple options (e.g., size, color)
When the user tries to add the product to the cart without selecting options
Then the user should be prompted to select the required options
""
Scenario: View cart after adding a product
When the user adds a product to the cart
"    And the user clicks on the ""View Cart"" button"
Then the user should be navigated to the shopping cart page
And the added product should be displayed in the cart
""
Scenario: Add out-of-stock product to the cart
Given the product is out of stock
When the user tries to add the product to the cart
Then the user should receive a notification that the product is out of stock
And the product should not be added to the cart
""
Scenario: Remove a product from the cart
Given the user has products in the cart
When the user decides to remove a product
"    And the user clicks on the ""Remove"" button next to the product"
Then the product should be removed from the shopping cart
And the cart icon should update to reflect the correct number of items
""
Scenario: Update product quantity in the cart
Given the user has a product in the cart
When the user updates the quantity of the product
Then the cart should reflect the updated quantity
And the total price should be recalculated based on the updated quantity
```
```gherkin
TCID:4
Feature: Add to Cart
""
As a user,
I want to be able to add products to my shopping cart
So that I can purchase them later.
""
Background:
Given the user is on the product listing page
""
Scenario: Add a single product to the cart
When the user selects a product
"    And the user clicks on the ""Add to Cart"" button"
Then the product should be added to the shopping cart
And the cart should display the added product
""
Scenario: Add multiple products to the cart
When the user selects multiple products
"    And the user clicks on the ""Add to Cart"" button for each product"
Then all selected products should be added to the shopping cart
And the cart should display all the added products
""
Scenario: Add the same product multiple times
When the user selects a product
"    And the user clicks on the ""Add to Cart"" button multiple times"
Then the cart should reflect the correct quantity of the product
""
Scenario: View cart after adding products
When the user adds a product to the cart
And the user navigates to the shopping cart page
Then the cart should list all products added
And the total cost should be correctly calculated
""
Scenario: Add a product to the cart without logging in
Given the user is not logged in
When the user selects a product
"    And the user clicks on the ""Add to Cart"" button"
Then the product should be added to the shopping cart
And the user should be prompted to log in or register
""
Scenario: Add an out-of-stock product to the cart
Given the product is out of stock
When the user selects the out-of-stock product
"    And the user clicks on the ""Add to Cart"" button"
Then the user should be notified that the product is out of stock
And the product should not be added to the cart
```
```gherkin
TCID:69
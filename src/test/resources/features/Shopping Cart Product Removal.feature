Feature: Shopping Cart Product Removal
@TC-2
Scenario: User removes a product from the shopping cart with immediate UI updates
Given user has access to the e-commerce website
When user navigates to the product listing page
And user adds Product 1 to the shopping cart
And user adds Product 2 to the shopping cart
And user adds Product 3 to the shopping cart
And user views the cart contents
Then the cart displays all three products with quantity 1 each
And the subtotal displays $99.97
When user removes Product 2 from the cart
Then a confirmation dialog appears
And user confirms the removal
Then Product 2 is removed from the cart
And the cart displays only Product 1 and Product 3 with quantity 1 each
And the subtotal displays $69.98
And the cart icon shows count 2
@TC-2
Scenario: User removes all products from the shopping cart
Given user has Product 1 and Product 3 in the cart
When user removes Product 1 from the cart
And user removes Product 3 from the cart
Then confirmation dialogs appear for each removal
And user confirms removal for both products
Then both products are removed from the cart
And the cart displays an empty state message
And the cart icon shows count 0
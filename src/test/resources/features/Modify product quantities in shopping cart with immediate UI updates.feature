Feature: Modify product quantities in shopping cart with immediate UI updates
@TC-3
Scenario: User modifies product quantities in the shopping cart
Given user has access to the e-commerce website
When user navigates to the product listing page
Then product listing page is displayed with multiple products
When user adds Product 1 to the shopping cart
Then Product 1 is added to the cart with quantity 1 and a confirmation message appears
When user adds Product 2 to the shopping cart
Then Product 2 is added to the cart with quantity 1 and a confirmation message appears
When user navigates to the shopping cart page
Then shopping cart page opens displaying both products with quantity 1 each
Then the initial subtotal calculation in the cart correctly displays $75.00
When user locates the quantity field for Product 1
Then quantity field is displayed with current value of 1
When user increases Product 1 quantity to 3
Then quantity field updates to 3 and a confirmation message appears indicating 'Cart updated successfully'
Then the updated line item price for Product 1 displays $150.00
And the updated subtotal calculation correctly displays $175.00
When user locates the quantity field for Product 2
Then quantity field is displayed with current value of 1
When user manually enters '5' in the quantity field for Product 2 and updates
Then quantity field updates to 5 and a confirmation message appears indicating 'Cart updated successfully'
Then the updated line item price for Product 2 displays $125.00
And the final updated subtotal calculation correctly displays $275.00
When user decreases Product 1 quantity to 2
Then quantity field updates to 2 with confirmation message and line item price updates to $100.00
Then the final updated subtotal after decrement correctly displays $225.00